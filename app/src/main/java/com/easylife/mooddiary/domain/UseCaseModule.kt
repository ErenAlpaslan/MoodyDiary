package com.easylife.mooddiary.domain

import com.easylife.mooddiary.domain.usecases.GetDatesUseCase
import org.koin.dsl.module

/**
 * Created by erenalpaslan on 14.09.2022
 */
val useCaseModule = module {
    factory { GetDatesUseCase(get(), get()) }
}