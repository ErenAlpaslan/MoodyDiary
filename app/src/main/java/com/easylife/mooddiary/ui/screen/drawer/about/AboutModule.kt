package com.easylife.mooddiary.ui.screen.drawer.about

import androidx.navigation.NavController
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by erenalpaslan on 3.09.2022
 */
val aboutModule = module {
    factory { AboutScreen() }
    viewModel { AboutViewModel() }
    factory { (navController: NavController) -> AboutNavigationActions(navController) }
}