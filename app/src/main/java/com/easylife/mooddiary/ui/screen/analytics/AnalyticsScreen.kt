package com.easylife.mooddiary.ui.screen.analytics

import com.easylife.mooddiary.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.easylife.mooddiary.base.BaseScreen
import com.easylife.mooddiary.ui.theme.DarkWhite
import com.easylife.mooddiary.ui.theme.Green
import com.easylife.mooddiary.ui.view.MonthAndYearSelector
import com.easylife.mooddiary.ui.view.monthlyLineChart.MonthlyLineChart

/**
 * Created by erenalpaslan on 13.09.2022
 */
class AnalyticsScreen: BaseScreen<AnalyticsViewModel, AnalyticsNavigationActions>() {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {

                    }
                )
            },
            content = {
                Column(modifier = Modifier
                    .padding(it)
                    .padding(16.dp)) {
                    MonthlyLineChart()
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .background(DarkWhite))
                }
            }
        )
    }
}