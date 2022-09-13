package com.easylife.mooddiary.utils.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

abstract class IMoodyDispatchers {

    abstract val main: CoroutineDispatcher

    abstract val io: CoroutineDispatcher

    abstract val default: CoroutineDispatcher
}