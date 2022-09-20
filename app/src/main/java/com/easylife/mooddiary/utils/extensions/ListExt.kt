package com.easylife.mooddiary.utils.extensions

/**
 * Created by erenalpaslan on 20.09.2022
 */
fun List<*>.hasNext(i: Int): Boolean {
    return i != this.size - 1
}