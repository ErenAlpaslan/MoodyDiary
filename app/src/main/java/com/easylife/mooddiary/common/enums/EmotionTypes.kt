package com.easylife.mooddiary.common.enums

import androidx.annotation.StringRes
import com.easylife.mooddiary.R

/**
 * Created by erenalpaslan on 15.09.2022
 */
enum class EmotionTypes(val id: Int, @StringRes val emotionName: Int) {
    EXCITED(0, R.string.new_diary_emotion_excited),
    RELAXED(1, R.string.new_diary_emotion_relaxed),
    PROUD(2, R.string.new_diary_emotion_proud),
    HOPEFUL(3, R.string.new_diary_emotion_hopeful),
    HAPPY(4, R.string.new_diary_emotion_happy),
    ENTHUSIATIC(5, R.string.new_diary_emotion_enthusiastic),
    REFRESHED(6, R.string.new_diary_emotion_refreshed),
    GLOOMY(7, R.string.new_diary_emotion_gloomy),
    LONELY(8, R.string.new_diary_emotion_lonely),
    ANXIOUS(9, R.string.new_diary_emotion_anxious),
    SAD(10, R.string.new_diary_emotion_sad),
    ANGRY(11, R.string.new_diary_emotion_angry),
    TIRED(12, R.string.new_diary_emotion_tired),
    ANNOYED(13, R.string.new_diary_emotion_annoyed),
    BURDENSOME(14, R.string.new_diary_emotion_burdensome),
    BORED(14, R.string.new_diary_emotion_bored),
    STRESSED(14, R.string.new_diary_emotion_stressed)
}

fun getEmotion(id: Int?): EmotionTypes? {
    return EmotionTypes.values().find { it.id == id}
}