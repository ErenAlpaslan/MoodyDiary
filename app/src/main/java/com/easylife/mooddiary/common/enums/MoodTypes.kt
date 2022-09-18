package com.easylife.mooddiary.common.enums

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.easylife.mooddiary.R

/**
 * Created by erenalpaslan on 15.09.2022
 */
enum class MoodTypes(val id: Int, @StringRes val mood: Int, @DrawableRes val moodIcon: Int) {
    HAPPY(0, R.string.new_diary_happy, R.drawable.ic_happy),
    SMILE(1, R.string.new_diary_excited, R.drawable.ic_smile),
    NORMAL(2, R.string.new_diary_normal, R.drawable.ic_normal),
    DISAPPOINTED(3, R.string.new_diary_bad, R.drawable.ic_disappointed),
    CRYING(4, R.string.new_diary_very_sad, R.drawable.ic_crying)
}

fun getMood(id: Int?): MoodTypes? {
    return MoodTypes.values().find { it.id == id}
}