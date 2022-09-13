package com.easylife.mooddiary

import android.app.Application
import com.easylife.mooddiary.common.appModule
import com.easylife.mooddiary.ui.screen.analytics.analyticsModule
import com.easylife.mooddiary.ui.screen.diary.diaryModule
import com.easylife.mooddiary.ui.screen.main.mainModule
import com.easylife.mooddiary.ui.screen.onboarding.onboardingModule
import com.easylife.mooddiary.ui.screen.splash.splashModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by erenalpaslan on 12.09.2022
 */
class MoodyApplication: Application() {

    val moduleList = listOf(
        appModule,
        splashModule,
        onboardingModule,
        mainModule,
        diaryModule,
        analyticsModule,
    )

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            androidContext(this@MoodyApplication)
            modules(moduleList)
        }
    }

    companion object {
        lateinit var instance: MoodyApplication
    }

}