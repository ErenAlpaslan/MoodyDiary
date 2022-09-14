package com.easylife.mooddiary.utils.extensions

import com.easylife.mooddiary.entity.SingleDatePoint

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