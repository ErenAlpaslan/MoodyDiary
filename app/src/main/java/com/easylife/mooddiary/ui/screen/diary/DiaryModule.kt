package com.easylife.mooddiary.ui.screen.diary

import androidx.navigation.NavController
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by erenalpaslan on 13.09.2022
 */
val diaryModule = module {
    factory { DiaryScreen() }
    viewModel { DiaryViewModel() }
    factory {(navController: NavController) -> DiaryNavigationActions(navController) }
}