package com.easylife.mooddiary.ui.screen.diary

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.easylife.mooddiary.base.BaseViewModel
import com.easylife.mooddiary.domain.usecases.GetDatesUseCase
import com.easylife.mooddiary.domain.usecases.GetDiaryByDateUseCase
import com.easylife.mooddiary.domain.usecases.SaveDiaryNoteUseCase
import com.easylife.mooddiary.entity.SingleDatePoint
import com.easylife.mooddiary.entity.UserDiaryInput
import com.easylife.mooddiary.utils.extensions.getErrorMessage
import com.easylife.mooddiary.utils.extensions.getTodayIndex
import com.easylife.wallpaperapp.utils.AppResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.temporal.WeekFields
import java.util.*

/**
 * Created by erenalpaslan on 13.09.2022
 */
class DiaryViewModel(
    private val getDatesUseCase: GetDatesUseCase,
    private val saveDiaryUseCase: SaveDiaryNoteUseCase,
    private val getDiaryByDateUseCase: GetDiaryByDateUseCase
) : BaseViewModel() {

    private val _uiState: MutableStateFlow<DiaryScreenUiModel> =
        MutableStateFlow(DiaryScreenUiModel())
    val uiState: StateFlow<DiaryScreenUiModel> = _uiState

    fun getDates(
        year: Int? = null,
        scrollTo: Boolean = false
    ) = viewModelScope.launch {
        if (year != null) {
            _uiState.update {
                it.copy(year = year)
            }
        }
        getDatesUseCase.execute(GetDatesUseCase.Param(year)).collect { result ->
            when (result) {
                is AppResult.Error -> _error.postValue(getErrorMessage(result))
                is AppResult.Success -> {
                    result.data?.let { list ->
                        if (scrollTo) {
                            val todayIndex = list.getTodayIndex()
                            val selectedDate = list[todayIndex]
                            _uiState.update {
                                it.copy(
                                    dates = list,
                                    selectedIndex = todayIndex
                                )
                            }
                            onDateSelected(selectedDate)
                        } else {
                            val selected = _uiState.value.selectedDate
                            val selectedIndex =
                                list.indexOfFirst { it.month == selected?.month && it.day == selected?.day }
                            if (selectedIndex >= 0) {
                                getDiaryNotesByDate(list[selectedIndex])
                            }
                            _uiState.update {
                                it.copy(
                                    dates = list
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    fun onYearChanged(year: Int) {
        getDates(year, false)
    }

    fun onMonthChanged(month: String?) = viewModelScope.launch {
        _uiState.update {
            it.copy(month = month)
        }
    }

    fun onDateSelected(date: SingleDatePoint) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(selectedDate = date)
            }
            getDiaryNotesByDate(date)
        }
    }

    fun onSaveClicked(input: UserDiaryInput) {
        viewModelScope.launch {
            saveDiaryUseCase.execute(
                SaveDiaryNoteUseCase.Param(
                    input = input,
                    date = _uiState.value.selectedDate?.date ?: ""
                )
            ).collect { result ->
                when (result) {
                    is AppResult.Error -> _error.postValue(getErrorMessage(result))
                    is AppResult.Success -> {
                        getDiaryNotesByDate(_uiState.value.selectedDate)
                    }
                }
            }
        }
    }

    private suspend fun getDiaryNotesByDate(date: SingleDatePoint?) {
        date?.let {
            getDiaryByDateUseCase.execute(GetDiaryByDateUseCase.Param(it.date)).collect { result ->
                when (result) {
                    is AppResult.Error -> _error.postValue(getErrorMessage(result))
                    is AppResult.Success -> {
                        result.data?.let { list ->
                            val dates = _uiState.value.dates.apply {
                                find { old -> old.date == it.date }?.let { oldDate ->
                                    oldDate.count = list.size
                                }
                            }

                            _uiState.update { uiModel ->
                                uiModel.copy(
                                    dates = dates,
                                    diaryNotes = list
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}