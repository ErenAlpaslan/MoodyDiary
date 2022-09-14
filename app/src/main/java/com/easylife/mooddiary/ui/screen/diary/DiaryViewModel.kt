package com.easylife.mooddiary.ui.screen.diary

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.easylife.mooddiary.base.BaseViewModel
import com.easylife.mooddiary.domain.usecases.GetDatesUseCase
import com.easylife.mooddiary.entity.SingleDatePoint
import com.easylife.mooddiary.utils.extensions.getErrorMessage
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
    private val getDatesUseCase: GetDatesUseCase
): BaseViewModel() {

    private val _uiState: MutableStateFlow<DiaryScreenUiModel> = MutableStateFlow(DiaryScreenUiModel())
    val uiState: StateFlow<DiaryScreenUiModel> = _uiState

    fun getDates() = viewModelScope.launch{
        getDatesUseCase.execute(GetDatesUseCase.Param("")).collect { result ->
            when(result) {
                is AppResult.Error -> _error.postValue(getErrorMessage(result))
                is AppResult.Success -> {
                    result.data?.let { list ->
                        _uiState.update {
                            it.copy(dates = list)
                        }
                    }
                }
            }
        }
    }

}