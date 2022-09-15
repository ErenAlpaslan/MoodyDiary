package com.easylife.mooddiary.data.repository

import com.easylife.mooddiary.domain.repository.DateRepository
import com.easylife.mooddiary.entity.SingleDatePoint
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by erenalpaslan on 14.09.2022
 */
class DateRepositoryImpl: DateRepository {

    override suspend fun createDatesOfTheYear(year: Int): List<SingleDatePoint> {
        val formatter = SimpleDateFormat("dd.MMM.yyyy")
        val list = arrayListOf<SingleDatePoint>()
        val cal = Calendar.getInstance()
        cal.set(Calendar.YEAR, year)

        Calendar.getInstance().let { calendar ->
            calendar.add(Calendar.MONTH, -11)
            for (i in 0 until 12) {
                val maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
                for (x in 0 until maxDay) {
                    cal.set(Calendar.DAY_OF_MONTH, (x + 1))
                    cal.set(Calendar.MONTH, i)
                    val formatted = formatter.format(cal.time)
                    list.add(SingleDatePoint(
                        date = formatted,
                        day = cal.get(Calendar.DAY_OF_MONTH).toString(),
                        dayName = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault()),
                        month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())
                    ))
                }
            }
        }

        return list
    }

}