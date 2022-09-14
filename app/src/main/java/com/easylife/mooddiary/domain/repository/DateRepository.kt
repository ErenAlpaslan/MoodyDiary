package com.easylife.mooddiary.domain.repository

import com.easylife.mooddiary.entity.SingleDatePoint

/**
 * Created by erenalpaslan on 14.09.2022
 */
interface DateRepository {

    suspend fun createDatesOfTheYear(): List<SingleDatePoint>

}