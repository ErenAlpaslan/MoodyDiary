package com.easylife.mooddiary.ui.screen.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.easylife.mooddiary.R
import com.easylife.mooddiary.base.BaseScreen
import com.google.accompanist.insets.systemBarsPadding
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/**
 * Created by erenalpaslan on 12.09.2022
 */
class OnboardingScreen : BaseScreen<OnboardingViewModel, OnboardingNavigationActions>() {
    @Composable
    override fun Content() {
        val systemUiController = rememberSystemUiController()
        val scrollState = rememberScrollState()
        val titleTransitionState = remember {
            MutableTransitionState(false).apply {
                targetState = true
            }
        }
        val descriptionTransitionState = remember {
            MutableTransitionState(false).apply {
                targetState = true
            }
        }

        LaunchedEffect(key1 = "") {
            systemUiController.setSystemBarsColor(color = Color.Transparent)
        }

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            val (headerRef, titleRef, descriptionRef, btnRef) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.bg_onboarding),
                contentDescription = "",
                modifier = Modifier.constrainAs(headerRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )
            AnimatedVisibility(
                visibleState = titleTransitionState,
                enter = fadeIn(animationSpec = tween(2000, 300)),
                modifier = Modifier.constrainAs(titleRef) {
                    top.linkTo(headerRef.bottom, 16.dp)
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                    width = Dimension.matchParent
                }
            ) {
                Text(
                    text = stringResource(id = R.string.onboarding_title),
                    style = MaterialTheme.typography.headlineLarge
                )
            }
            AnimatedVisibility(
                visibleState = descriptionTransitionState,
                enter = fadeIn(animationSpec = tween(2000, 700)),
                modifier = Modifier.constrainAs(descriptionRef) {
                    top.linkTo(titleRef.bottom, 16.dp)
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                    width = Dimension.matchParent
                }
            ) {
                Text(
                    text = stringResource(id = R.string.onboarding_description),
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Button(onClick = {
                viewModel.onGetStartedClicked()
                navigationActions.navigateToMain()
            }, modifier = Modifier.constrainAs(btnRef) {
                linkTo(descriptionRef.bottom, parent.bottom, 20.dp, 20.dp, bias = 0.9f)
                start.linkTo(parent.start, 52.dp)
                end.linkTo(parent.end, 52.dp)
                width = Dimension.fillToConstraints
            }) {
                Text(text = stringResource(id = R.string.button_get_started))
            }
        }

    }
}