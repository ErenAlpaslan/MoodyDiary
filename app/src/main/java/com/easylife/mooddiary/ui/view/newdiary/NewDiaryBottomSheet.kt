package com.easylife.mooddiary.ui.view.newdiary

import android.graphics.Paint.Align
import android.widget.Space
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import com.easylife.mooddiary.R
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ChipDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.easylife.mooddiary.common.enums.EmotionTypes
import com.easylife.mooddiary.common.enums.MoodTypes
import com.easylife.mooddiary.common.enums.SphereTypes
import com.easylife.mooddiary.entity.MoodItem
import com.easylife.mooddiary.ui.theme.*
import com.easylife.mooddiary.ui.view.newdiary.EmotionList
import com.easylife.mooddiary.ui.view.newdiary.MoodButton
import com.easylife.mooddiary.ui.view.newdiary.SphereOfLifeButton
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

/**
 * Created by erenalpaslan on 15.09.2022
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun NewDiaryBottomSheet(
    onDismissRequest: () -> Unit
) {
    val pagerState = rememberPagerState()
    val isExpanded = remember {
        mutableStateOf(false)
    }
    val coroutineScope = rememberCoroutineScope()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.6f))
            .systemBarsPadding()
    ) {
        HorizontalPager(
            count = 2,
            state = pagerState,
            userScrollEnabled = false
        ) {
            when(it) {
                0 -> NewDiaryFirstPage(
                    isExpanded = isExpanded,
                    onDismissRequest = { onDismissRequest() },
                    onMoodSelected = {

                    },
                    onEmotionSelected = {

                    },
                    onSphereOfLifeSelected = {

                    },
                    onNextClicked = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(1)
                        }
                    }
                )

                1 -> NewDiarySecondPage(
                    isExpanded = isExpanded,
                ) { _, _ ->

                }
            }
        }
    }
}