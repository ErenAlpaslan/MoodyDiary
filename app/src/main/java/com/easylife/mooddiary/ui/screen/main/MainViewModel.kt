package com.easylife.mooddiary.ui.screen.main

import androidx.lifecycle.viewModelScope
import com.easylife.mooddiary.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Created by erenalpaslan on 12.09.2022
 */
class MainViewModel: BaseViewModel() {

    private val _uiState: MutableStateFlow<MainUiState> = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState

    fun onMonthChanged(month: String?) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(month)
            }
        }
    }


}