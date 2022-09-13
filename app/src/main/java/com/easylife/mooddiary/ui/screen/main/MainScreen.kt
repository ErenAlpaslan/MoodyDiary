package com.easylife.mooddiary.ui.screen.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.easylife.mooddiary.base.BaseScreen
import com.easylife.mooddiary.ui.navigation.BottomNavGraph
import com.easylife.mooddiary.ui.theme.Orange
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

/**
 * Created by erenalpaslan on 12.09.2022
 */
class MainScreen: BaseScreen<MainViewModel, MainNavigationActions>() {
    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    override fun Content() {
        val navController = rememberAnimatedNavController()

        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            BottomNavGraph(navController = navController)
        }
    }
}