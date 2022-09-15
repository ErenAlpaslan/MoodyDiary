package com.easylife.mooddiary.entity

import androidx.annotation.DrawableRes

/**
 * Created by erenalpaslan on 15.09.2022
 */
data class MoodItem(
    val mood: String?,
    @DrawableRes val icon: Int,
)
