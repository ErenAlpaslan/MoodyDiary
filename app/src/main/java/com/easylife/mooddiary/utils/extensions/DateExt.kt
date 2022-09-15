package com.easylife.mooddiary.utils.extensions

import com.easylife.mooddiary.entity.SingleDatePoint
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by erenalpaslan on 14.09.2022
 */
fun List<SingleDatePoint>.getMonth(firstVisible: Int): Int {
    val index = firstVisible + 3
    return if (index < this.size) {
        index
    }else {
        firstVisible
    }
}

fun getCurrentYear(): Int {
    val cal = Calendar.getInstance()
    return cal.get(Calendar.YEAR)
}

fun getCurrentMonth(): String? {
    val cal = Calendar.getInstance()
    return cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())
}

fun List<SingleDatePoint>.getTodayIndex(): Int {
    val formatter = SimpleDateFormat("dd.MMM.yyyy")
    val cal = Calendar.getInstance()
    return try {
        this.indexOfFirst { it.date == formatter.format(cal.time) }
    }catch(e: Exception) {
        0
    }
}