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
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_left_ios),
                                    contentDescription = "",
                                    tint = Green
                                )
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "January 2020",
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_right_ios),
                                    contentDescription = "",
                                    tint = DarkWhite
                                )
                            }
                        }
                    }
                )
            },
            content = {
                Column(modifier = Modifier.padding(it).padding(16.dp)) {
                    Box(modifier = Modifier.fillMaxWidth().height(250.dp).background(DarkWhite))
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(modifier = Modifier.fillMaxWidth().height(250.dp).background(DarkWhite))
                }
            }
        )
    }
}