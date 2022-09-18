package com.easylife.mooddiary.ui.screen.main

import com.easylife.mooddiary.R
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.easylife.mooddiary.base.BaseScreen
import com.easylife.mooddiary.ui.navigation.BottomNavGraph
import com.easylife.mooddiary.ui.navigation.Screen
import com.easylife.mooddiary.ui.screen.diary.DiaryScreen
import com.easylife.mooddiary.ui.view.newdiary.NewDiaryBottomSheet
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

/**
 * Created by erenalpaslan on 12.09.2022
 */
class MainScreen : BaseScreen<MainViewModel, MainNavigationActions>() {

    private val items = listOf(
        NavigationItem(
            R.string.navigation_item_diary,
            R.drawable.ic_book,
            Screen.Diary.route
        ),
        NavigationItem(
            R.string.navigation_item_analytics,
            R.drawable.ic_bar_chart,
            Screen.Analytics.route,
            true
        ),
        NavigationItem(
            R.string.navigation_item_analytics,
            R.drawable.ic_bar_chart,
            Screen.Analytics.route
        )
    )

    @OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class,
        ExperimentalMaterialApi::class
    )
    @Composable
    override fun Content() {
        val bottomNavController = rememberAnimatedNavController()
        val navigateTo: (String) -> Unit = {
            bottomNavController.navigate(it) {
                popUpTo(bottomNavController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
        val uiState by viewModel.uiState.collectAsState()
        val scaffoldState = rememberBottomSheetScaffoldState()
        var isNewDiaryDialogVisible by remember {
            mutableStateOf(false)
        }

        ModalNavigationDrawer(
            drawerState = DiaryScreen.drawerState,
            drawerContent = {
                MainDrawerContent(navigationActions) {

                }
            }
        ) {
            BottomSheetScaffold(
                sheetContent = {

                },
                scaffoldState = scaffoldState,
                sheetPeekHeight = 0.dp
            ) {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it),
                    bottomBar = {
                        NavigationBar() {
                            val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination
                            items.forEachIndexed { index, item ->
                                if (item.isFab) {
                                    FloatingActionButton(
                                        onClick = {
                                            isNewDiaryDialogVisible = true
                                        },
                                        modifier = Modifier.padding(top = 10.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Rounded.Add,
                                            contentDescription = "Add Icon"
                                        )
                                    }
                                } else {
                                    NavigationBarItem(
                                        selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                                        onClick = {
                                            navigateTo(item.route)
                                        },
                                        icon = {
                                            Icon(
                                                painter = painterResource(id = item.icon),
                                                contentDescription = ""
                                            )
                                        },
                                        label = {
                                            Text(text = stringResource(id = item.screen))
                                        }
                                    )
                                }
                            }
                        }
                    }
                ) {
                    BottomNavGraph(
                        navController = bottomNavController,
                        paddingValues = it
                    )
                }
            }
        }

        if (isNewDiaryDialogVisible) {
            NewDiaryBottomSheet(
                onDismissRequest = {
                    isNewDiaryDialogVisible = false
                },
                onSaveClicked = {userDiaryInput ->
                    isNewDiaryDialogVisible = false
                    DiaryScreen.userInput.value = userDiaryInput
                }
            )
        }
    }
}
