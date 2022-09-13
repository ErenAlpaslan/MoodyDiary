package com.easylife.mooddiary.ui.screen.onboarding

import androidx.lifecycle.viewModelScope
import com.easylife.mooddiary.base.BaseViewModel
import com.easylife.mooddiary.utils.preferences.PreferencesKeys
import com.easylife.mooddiary.utils.preferences.PreferencesManager
import kotlinx.coroutines.launch

/**
 * Created by erenalpaslan on 12.09.2022
 */
class OnboardingViewModel(
    private val preferencesManager: PreferencesManager
): BaseViewModel() {

    fun onGetStartedClicked() = viewModelScope.launch {
        preferencesManager.setBoolean(PreferencesKeys.IS_FIRST_ENTER, false)
    }
}