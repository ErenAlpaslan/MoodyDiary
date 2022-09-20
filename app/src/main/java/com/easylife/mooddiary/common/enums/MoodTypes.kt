package com.easylife.mooddiary.common.enums

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.easylife.mooddiary.R

/**
 * Created by erenalpaslan on 15.09.2022
 */
enum class MoodTypes(val id: Int, @StringRes val mood: Int, @DrawableRes val moodIcon: Int) {
    HAPPY(0, R.string.new_diary_happy, R.drawable.ic_cool_filled),
    SMILE(1, R.string.new_diary_excited, R.drawable.ic_happy_filled),
    NORMAL(2, R.string.new_diary_normal, R.drawable.ic_normal_filled),
    DISAPPOINTED(3, R.string.new_diary_bad, R.drawable.ic_sad_filled),
    CRYING(4, R.string.new_diary_very_sad, R.drawable.ic_very_sad_filled)
}

fun getMood(id: Int?): MoodTypes? {
    return MoodTypes.values().find { it.id == id}
}