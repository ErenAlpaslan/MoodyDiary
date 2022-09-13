package com.easylife.mooddiary.ui.screen.onboarding

import androidx.navigation.NavController
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by erenalpaslan on 12.09.2022
 */
val onboardingModule = module {
    factory { OnboardingScreen() }
    viewModel { OnboardingViewModel(get()) }
    factory { (navController: NavController) -> OnboardingNavigationActions(navController) }
}