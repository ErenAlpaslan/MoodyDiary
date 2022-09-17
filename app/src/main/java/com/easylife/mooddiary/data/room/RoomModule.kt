package com.easylife.mooddiary.data.room

import androidx.room.Room
import com.easylife.mooddiary.common.AppConstant
import com.google.gson.Gson
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val roomModule = module {
    single { Gson() }
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            AppConstant.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<AppDatabase>().diaryDao() }
}