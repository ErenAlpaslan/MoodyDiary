package com.easylife.mooddiary.ui.screen.diary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.easylife.mooddiary.base.BaseScreen
import com.google.accompanist.insets.systemBarsPadding

/**
 * Created by erenalpaslan on 13.09.2022
 */
class DiaryScreen : BaseScreen<DiaryViewModel, DiaryNavigationActions>() {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {

            }
        ) {
            Scaffold(
                modifier = Modifier.systemBarsPadding(),
                topBar = {
                    SmallTopAppBar(
                        title = {
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(text = "Moody")
                                Text(text = "August")
                            }
                        },
                        navigationIcon = {
                            IconButton(onClick = {

                            }) {
                                Icon(imageVector = Icons.Rounded.Menu, contentDescription = "Hamburger Menu")
                            }
                        }
                    )
                },
                content = {

                }
            )
        }
    }

}