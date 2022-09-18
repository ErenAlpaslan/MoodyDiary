package com.easylife.mooddiary.ui.screen.main

import com.easylife.mooddiary.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.easylife.mooddiary.ui.MainActivity
import com.easylife.mooddiary.ui.theme.Green
import com.easylife.mooddiary.utils.helper.share.ShareAppHelper
import com.easylife.mooddiary.utils.helper.review.ReviewManager

/**
 * Created by erenalpaslan on 14.09.2022
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainDrawerContent(
    navigationActions: MainNavigationActions,
    onFeedbackClicked: () -> Unit
) {
    val activity = LocalContext.current as MainActivity

    ModalDrawerSheet(
        Modifier.windowInsetsPadding(insets = WindowInsets(right = 120.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            DrawerHeader()
            Spacer(modifier = Modifier.height(6.dp))
            NavigationDrawerItem(
                selected = false,
                onClick = {
                    navigationActions.navigateToAbout()
                },
                icon = { Icon(painter = painterResource(id = R.drawable.ic_help), "") },
                label = { Text(text = stringResource(id = R.string.drawer_about)) },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Divider(thickness = 1.dp, color = Green)
            Spacer(modifier = Modifier.height(6.dp))
            NavigationDrawerItem(
                selected = false,
                onClick = {
                    //ReviewManager.showReviewDialog(activity)
                },
                icon = { Icon(painter = painterResource(id = R.drawable.ic_star), "") },
                label = { Text(text = stringResource(id = R.string.drawer_rate_app)) },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))
            NavigationDrawerItem(
                selected = false,
                onClick = { ShareAppHelper.openShareApp(activity) },
                icon = { Icon(painter = painterResource(id = R.drawable.ic_share), "") },
                label = { Text(text = stringResource(id = R.string.drawer_share_app)) },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))
            NavigationDrawerItem(
                selected = false,
                onClick = { onFeedbackClicked() },
                icon = { Icon(painter = painterResource(id = R.drawable.ic_mail), "") },
                label = { Text(text = stringResource(id = R.string.drawer_feedback)) },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))
        }
    }
}

@Composable
fun DrawerHeader() {
    Column(
        modifier = Modifier
            .fillMaxHeight(0.2f)
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        /*Button(onClick = { onLoginClicked() },
            modifier = Modifier.wrapContentSize(),
            colors = ButtonDefaults.buttonColors(containerColor = Gray)
        ) {
            Icon(imageVector = Icons.Rounded.Warning, contentDescription = "")
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = stringResource(id = R.string.app_name))
        }*/
    }
}