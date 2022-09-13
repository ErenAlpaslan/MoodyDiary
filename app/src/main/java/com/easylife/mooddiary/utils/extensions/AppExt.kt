package com.easylife.mooddiary.utils.extensions

import com.easylife.mooddiary.MoodyApplication
import com.easylife.mooddiary.R
import com.easylife.wallpaperapp.utils.AppResult

/**
 * Created by erenalpaslan on 3.09.2022
 */
fun <T> getErrorMessage(error: AppResult.Error<T>): String? {
    return if (!error.message.isNullOrEmpty()) {
        error.message
    }else {
        MoodyApplication.instance.getString(error.messageId ?: R.string.app_name)
    }
}