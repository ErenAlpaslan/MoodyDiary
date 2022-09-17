package com.easylife.mooddiary.entity

import android.os.Parcelable
import com.easylife.mooddiary.common.enums.EmotionTypes
import com.easylife.mooddiary.common.enums.MoodTypes
import com.easylife.mooddiary.common.enums.SphereTypes
import kotlinx.parcelize.Parcelize

/**
 * Created by erenalpaslan on 17.09.2022
 */
@Parcelize
data class UserDiaryInput(
    val mood: MoodTypes?,
    val emotion: EmotionTypes?,
    val sphereOfLife: SphereTypes?,
    val title: String?,
    val description: String?,
): Parcelable
