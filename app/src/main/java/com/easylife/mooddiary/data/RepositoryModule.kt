package com.easylife.mooddiary.data

import com.easylife.mooddiary.data.repository.DateRepositoryImpl
import com.easylife.mooddiary.data.repository.DiaryRepositoryImpl
import com.easylife.mooddiary.domain.repository.DateRepository
import com.easylife.mooddiary.domain.repository.DiaryRepository
import org.koin.dsl.module

/**
 * Created by erenalpaslan on 14.09.2022
 */
val repositoryModule = module {
    factory<DateRepository> { DateRepositoryImpl() }
    factory<DiaryRepository> { DiaryRepositoryImpl(get()) }
}