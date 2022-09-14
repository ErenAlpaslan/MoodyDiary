package com.easylife.mooddiary.ui.screen.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Created by erenalpaslan on 13.09.2022
 */
data class NavigationItem(
    @StringRes val screen: Int,
    @DrawableRes val icon: Int,
    val route: String,
    val isFab: Boolean = false
)
