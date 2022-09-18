package com.easylife.mooddiary.ui.screen.main

import androidx.navigation.NavController
import com.easylife.mooddiary.base.BaseActions
import com.easylife.mooddiary.ui.navigation.Screen

/**
 * Created by erenalpaslan on 12.09.2022
 */
class MainNavigationActions(navController: NavController): BaseActions() {

    val navigateToAbout: () -> Unit = {
        navController.navigate(Screen.About.route)
    }

}