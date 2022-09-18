package com.easylife.mooddiary.entity

/**
 * Created by erenalpaslan on 14.09.2022
 */
data class SingleDatePoint(
    val date: String,
    val day: String?,
    val dayName: String?,
    val month: String?,
    var count: Int
)