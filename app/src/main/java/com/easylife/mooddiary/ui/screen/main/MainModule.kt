package com.easylife.mooddiary.ui.screen.main

import androidx.navigation.NavController
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by erenalpaslan on 12.09.2022
 */
val mainModule = module {
    factory { MainScreen() }
    viewModel { MainViewModel() }
    factory { (navController: NavController) -> MainNavigationActions(navController) }
}