package com.easylife.mooddiary.ui.screen.drawer.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.easylife.mooddiary.BuildConfig
import com.easylife.mooddiary.R
import com.easylife.mooddiary.base.BaseScreen
import com.easylife.mooddiary.ui.MainActivity
import com.easylife.mooddiary.ui.theme.DarkWhite
import com.easylife.mooddiary.ui.theme.Gray
import com.easylife.mooddiary.utils.helper.share.ShareAppHelper

/**
 * Created by erenalpaslan on 3.09.2022
 */
class AboutScreen : BaseScreen<AboutViewModel, AboutNavigationActions>() {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val activity = LocalContext.current as MainActivity
        val scrollableState = rememberScrollableState(consumeScrollDelta = { 0f })
        var openFeedbackDialog by remember {
            mutableStateOf(false)
        }
        val isFeedbackSucceeded by viewModel.isFeedbackSucceeded.collectAsState()
        LaunchedEffect(key1 = isFeedbackSucceeded) {
            if (isFeedbackSucceeded) {
                openFeedbackDialog = false
            }
        }

        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.about_title))
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.Rounded.ArrowBack,
                                contentDescription = "ArrowBack Icon"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.largeTopAppBarColors(scrolledContainerColor = MaterialTheme.colorScheme.secondary)
                )
            },
            content = {
                Column(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize()
                        .scrollable(scrollableState, Orientation.Vertical)
                        .padding(horizontal = 32.dp)
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(DarkWhite),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(24.dp))
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "",
                            modifier = Modifier
                                .size(50.dp)
                                .clip(RoundedCornerShape(16.dp))
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = stringResource(id = R.string.full_app_name))
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = stringResource(
                                id = R.string.app_version,
                                BuildConfig.VERSION_NAME
                            )
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(DarkWhite),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(24.dp))
                        Text(text = stringResource(id = R.string.about_support_and_development))
                        Spacer(modifier = Modifier.height(10.dp))
                        Button(
                            onClick = { /*TODO about*/ },
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .fillMaxWidth(),
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_star),
                                contentDescription = "Rate Icon"
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = stringResource(id = R.string.drawer_rate_app))
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Button(
                            onClick = { ShareAppHelper.openShareApp(activity) },
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .fillMaxWidth(),
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_share),
                                contentDescription = "Share Icon"
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = stringResource(id = R.string.drawer_share_app))
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Button(
                            onClick = { openFeedbackDialog = true },
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .fillMaxWidth(),
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_mail),
                                contentDescription = "Feedback Icon"
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = stringResource(id = R.string.drawer_feedback))
                        }
                        Spacer(modifier = Modifier.height(24.dp))
                    }
                }
            }
        )

        if (openFeedbackDialog) {
            /*FeedbackComposable(
                onDismiss = {
                    openFeedbackDialog = false
                },
                onSendClicked = {
                    viewModel.onFeedback(it)
                }
            )*/
        }
    }
}