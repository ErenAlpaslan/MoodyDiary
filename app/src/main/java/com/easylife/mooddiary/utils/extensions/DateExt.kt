package com.easylife.mooddiary.utils.extensions

import androidx.compose.ui.text.toLowerCase
import com.easylife.mooddiary.entity.SingleDatePoint
import java.text.SimpleDateFormat
import java.util.*
import kotlin.time.Duration.Companion.days

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

fun Long.toFormattedDate(): String {
    return try {
        val date = Date(this)
        val today = Calendar.getInstance().time
        val formatter = SimpleDateFormat("hh:mm aa")
        val formatted = formatter.format(Date(this)).lowercase()
        if (today.day == date.day) {
            "Today, $formatted"
        }else if (date.day == (today.day - 1)) {
            "Yesterday, $formatted"
        }else {
            formatted
        }
    }catch (e: Exception) {
        ""
    }
}