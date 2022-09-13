package com.easylife.mooddiary.ui.screen.splash

import androidx.lifecycle.viewModelScope
import com.easylife.mooddiary.base.BaseViewModel
import com.easylife.mooddiary.utils.preferences.PreferencesKeys
import com.easylife.mooddiary.utils.preferences.PreferencesManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Created by erenalpaslan on 12.09.2022
 */
class SplashViewModel(
    private val preferencesManager: PreferencesManager
) : BaseViewModel() {

    private val _uiState: MutableStateFlow<SplashUiState> = MutableStateFlow(SplashUiState())
    val uiState: StateFlow<SplashUiState> = _uiState

    init {
        handleUserNavigation()
    }

    private fun handleUserNavigation() {
        viewModelScope.launch {
            val isFirstEnter = preferencesManager.getBoolean(PreferencesKeys.IS_FIRST_ENTER)
            _uiState.update {
                it.copy(
                    navigateToOnBoarding = isFirstEnter,
                    navigateToMain = !isFirstEnter
                )
            }
        }
    }

}