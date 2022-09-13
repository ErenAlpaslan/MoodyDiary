package com.easylife.mooddiary.ui.screen.splash

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.easylife.mooddiary.R
import com.easylife.mooddiary.base.BaseScreen

/**
 * Created by erenalpaslan on 12.09.2022
 */
class SplashScreen : BaseScreen<SplashViewModel, SplashNavigationActions>() {
    @Composable
    override fun Content() {

        val uiState by viewModel.uiState.collectAsState()

        when {
            uiState.navigateToOnBoarding -> navigationActions.navigateToOnboarding()
            uiState.navigateToMain -> navigationActions.navigateToMain()
            else -> {}
        }

        Box(contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                modifier = Modifier.clip(RoundedCornerShape(12.dp))
            )
        }
    }
}