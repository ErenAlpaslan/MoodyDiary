package com.easylife.mooddiary.ui.screen.splash

import androidx.navigation.NavController
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by erenalpaslan on 12.09.2022
 */
val splashModule = module {
    factory { SplashScreen() }
    viewModel { SplashViewModel(get()) }
    factory { (navController: NavController) -> SplashNavigationActions(navController) }
}