package com.easylife.mooddiary.ui.screen.analytics

import androidx.navigation.NavController
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by erenalpaslan on 13.09.2022
 */
val analyticsModule = module {
    factory { AnalyticsScreen() }
    viewModel { AnalyticsViewModel() }
    factory {(navController: NavController) ->  AnalyticsNavigationActions(navController) }
}