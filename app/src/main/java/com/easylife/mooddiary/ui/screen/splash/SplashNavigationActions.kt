package com.easylife.mooddiary.ui.screen.splash

import androidx.navigation.NavController
import com.easylife.mooddiary.base.BaseActions
import com.easylife.mooddiary.ui.navigation.Screen

/**
 * Created by erenalpaslan on 12.09.2022
 */
class SplashNavigationActions(navController: NavController): BaseActions() {

    val navigateToOnboarding: () -> Unit = {
        navController.navigate(Screen.Onboarding.route) {
            this.popUpTo(Screen.Splash.route) {
                this.inclusive = true
            }
        }
    }

    val navigateToMain: () -> Unit = {
        navController.navigate(Screen.Main.route) {
            this.popUpTo(Screen.Splash.route) {
                this.inclusive = true
            }
            this.launchSingleTop = true
        }
    }


}