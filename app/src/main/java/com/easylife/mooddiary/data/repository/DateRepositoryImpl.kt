package com.easylife.mooddiary.data.repository

import android.util.Log
import com.easylife.mooddiary.domain.repository.DateRepository
import com.easylife.mooddiary.domain.repository.DiaryRepository
import com.easylife.mooddiary.entity.SingleDatePoint
import okhttp3.internal.format
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by erenalpaslan on 14.09.2022
 */
class DateRepositoryImpl(
    private val diaryRepository: DiaryRepository
): DateRepository {

    override suspend fun createDatesOfTheYear(year: Int): List<SingleDatePoint> {
        val formatter = SimpleDateFormat("dd.MMM.yyyy")
        val list = arrayListOf<SingleDatePoint>()
        val cal = Calendar.getInstance()
        cal.set(Calendar.YEAR, year)

        Calendar.getInstance().let { calendar ->
            calendar.set(Calendar.MONTH, 0)
            calendar.set(Calendar.YEAR, year)
            for (i in 0 until 12) {
                val maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
                for (x in 0 until maxDay) {
                    cal.set(Calendar.DAY_OF_MONTH, (x + 1))
                    cal.set(Calendar.MONTH, i)
                    val formatted = formatter.format(cal.time)
                    val month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())
                    if (x > 0 && list.isNotEmpty() && month != list.last().month) {
                        break
                    }
                    val count = diaryRepository.getDiaryNoteCountByDate(formatted)
                    list.add(SingleDatePoint(
                        date = formatted,
                        day = cal.get(Calendar.DAY_OF_MONTH).toString(),
                        dayName = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault()),
                        month = month,
                        count = count
                    ))
                }
                calendar.add(Calendar.MONTH, 1)
            }
        }

        return list
    }

}