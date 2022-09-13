package com.easylife.mooddiary.common

import com.easylife.mooddiary.utils.dispatchers.MoodyDispatchers
import com.easylife.mooddiary.utils.preferences.PreferencesManager
import com.google.gson.Gson
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Created by erenalpaslan on 30.08.2022
 */
val appModule = module {
    factory { PreferencesManager(androidContext()) }
    single { MoodyDispatchers() }
    factory { Gson() }
}