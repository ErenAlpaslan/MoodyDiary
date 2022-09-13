package com.easylife.mooddiary.ui.screen.analytics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.easylife.mooddiary.base.BaseScreen

/**
 * Created by erenalpaslan on 13.09.2022
 */
class AnalyticsScreen: BaseScreen<AnalyticsViewModel, AnalyticsNavigationActions>() {
    @Composable
    override fun Content() {
        Box(modifier = Modifier.fillMaxSize().background(Color.Red))
    }
}