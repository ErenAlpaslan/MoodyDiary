package com.easylife.mooddiary.common.enums

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.easylife.mooddiary.R

/**
 * Created by erenalpaslan on 16.09.2022
 */
enum class SphereTypes(
    @StringRes val sphereName: Int,
    @DrawableRes val sphereIcon: Int,
    color: Color = Color.Transparent
) {
    WORK(R.string.new_diary_sphere_work, R.drawable.ic_suitcase),
    FRIENDS(R.string.new_diary_sphere_friends, R.drawable.ic_friends),
    LOVE(R.string.new_diary_sphere_love, R.drawable.ic_love),
    FAMILY(R.string.new_diary_sphere_family, R.drawable.ic_family),
    PERSONAL(R.string.new_diary_sphere_personal, R.drawable.ic_lock),
    HEALTH(R.string.new_diary_sphere_health, R.drawable.ic_health),
    FINANCE(R.string.new_diary_sphere_finance, R.drawable.ic_money),
    LEISURE(R.string.new_diary_sphere_leisure, R.drawable.ic_leisure)
}