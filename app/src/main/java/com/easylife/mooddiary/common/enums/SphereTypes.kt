package com.easylife.mooddiary.common.enums

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.easylife.mooddiary.R

/**
 * Created by erenalpaslan on 16.09.2022
 */
enum class SphereTypes(
    val id: Int,
    @StringRes val sphereName: Int,
    @DrawableRes val sphereIcon: Int,
    color: Color = Color.Transparent
) {
    WORK(0, R.string.new_diary_sphere_work, R.drawable.ic_suitcase),
    FRIENDS(1, R.string.new_diary_sphere_friends, R.drawable.ic_friends),
    LOVE(2, R.string.new_diary_sphere_love, R.drawable.ic_love),
    FAMILY(3, R.string.new_diary_sphere_family, R.drawable.ic_family),
    PERSONAL(4, R.string.new_diary_sphere_personal, R.drawable.ic_lock),
    HEALTH(5, R.string.new_diary_sphere_health, R.drawable.ic_health),
    FINANCE(6, R.string.new_diary_sphere_finance, R.drawable.ic_money),
    LEISURE(7, R.string.new_diary_sphere_leisure, R.drawable.ic_leisure)
}