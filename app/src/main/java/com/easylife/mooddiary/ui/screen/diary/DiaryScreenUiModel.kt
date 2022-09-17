package com.easylife.mooddiary.ui.screen.diary

import com.easylife.mooddiary.entity.DiaryNote
import com.easylife.mooddiary.entity.SingleDatePoint
import com.easylife.mooddiary.utils.extensions.getCurrentMonth
import com.easylife.mooddiary.utils.extensions.getCurrentYear

/**
 * Created by erenalpaslan on 14.09.2022
 */
data class DiaryScreenUiModel(
    val dates: List<SingleDatePoint> = listOf(),
    val year: Int = getCurrentYear(),
    val month: String? = getCurrentMonth(),
    val selectedDate: SingleDatePoint? = null,
    val selectedIndex: Int? = null,
    val diaryNotes: List<DiaryNote> = listOf()
)
