package com.easylife.mooddiary.ui.screen.drawer.about

import com.easylife.mooddiary.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * Created by erenalpaslan on 3.09.2022
 */
class AboutViewModel(
    //private val feedbackUseCase: FeedbackUseCase
) : BaseViewModel() {

    private val _isFeedbackSucceeded: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isFeedbackSucceeded: StateFlow<Boolean> = _isFeedbackSucceeded

    /*fun onFeedback(feedback: String) {
        viewModelScope.launch {
            _isFeedbackSucceeded.value = false
            showProgress()
            feedbackUseCase.execute(FeedbackUseCase.Param(feedback)).collect{result ->
                when(result) {
                    is AppResult.Error -> _error.postValue(getErrorMessage(result))
                    is AppResult.Success -> {
                        _isFeedbackSucceeded.value = result.data ?: false
                    }
                }
            }
            hideProgress()
        }
    }*/

}