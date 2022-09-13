package com.easylife.mooddiary.utils.dispatchers

import com.easylife.mooddiary.utils.dispatchers.IMoodyDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class MoodyDispatchers: IMoodyDispatchers() {
    override val main: CoroutineDispatcher
        get() = Dispatchers.Main

    override val io: CoroutineDispatcher
        get() = Dispatchers.IO

    override val default: CoroutineDispatcher
        get() = Dispatchers.Default
}