package com.easylife.mooddiary.ui.screen.onboarding

import androidx.navigation.NavController
import com.easylife.mooddiary.base.BaseActions
import com.easylife.mooddiary.ui.navigation.Screen

/**
 * Created by erenalpaslan on 12.09.2022
 */
class OnboardingNavigationActions(navController: NavController): BaseActions() {

    val navigateToMain: () -> Unit = {
        navController.navigate(Screen.Main.route) {
            this.popUpTo(Screen.Onboarding.route) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }

}