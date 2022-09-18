package com.easylife.mooddiary.common.enums

import androidx.annotation.ColorRes
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
    @ColorRes val color: Int
) {
    WORK(0, R.string.new_diary_sphere_work, R.drawable.ic_suitcase, R.color.work_background_color),
    FRIENDS(1, R.string.new_diary_sphere_friends, R.drawable.ic_friends, R.color.friends_background_color),
    LOVE(2, R.string.new_diary_sphere_love, R.drawable.ic_love, R.color.love_background_color),
    FAMILY(3, R.string.new_diary_sphere_family, R.drawable.ic_family, R.color.family_background_color),
    PERSONAL(4, R.string.new_diary_sphere_personal, R.drawable.ic_lock, R.color.personal_background_color),
    HEALTH(5, R.string.new_diary_sphere_health, R.drawable.ic_health, R.color.health_background_color),
    FINANCE(6, R.string.new_diary_sphere_finance, R.drawable.ic_money, R.color.finance_background_color),
    LEISURE(7, R.string.new_diary_sphere_leisure, R.drawable.ic_leisure, R.color.leisure_background_color)
}

fun getSphereOfLife(id: Int?): SphereTypes? {
    return SphereTypes.values().find { it.id == id}
}