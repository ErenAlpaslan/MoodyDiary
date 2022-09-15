package com.easylife.mooddiary.ui.view

import android.graphics.Paint.Align
import android.widget.Space
import androidx.compose.animation.animateContentSize
import com.easylife.mooddiary.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.easylife.mooddiary.common.enums.EmotionTypes
import com.easylife.mooddiary.common.enums.MoodTypes
import com.easylife.mooddiary.entity.MoodItem
import com.easylife.mooddiary.ui.theme.*
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/**
 * Created by erenalpaslan on 15.09.2022
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewDiaryBottomSheet(
    onDismissRequest: () -> Unit
) {
    val x = remember {
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .animateContentSize()
    }
    val y = remember {
        Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .animateContentSize()
    }
    var isAnimate by remember {
        mutableStateOf(false)
    }
    var selectedMoodIndex by remember {
        mutableStateOf(-1)
    }
    var selectedEmotionIndex by remember {
        mutableStateOf(-1)
    }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.6f))
    ) {
        Card(
            shape = if (isAnimate) RoundedCornerShape(0.dp) else RoundedCornerShape(30.dp),
            modifier = Modifier
                .padding(horizontal = if (isAnimate) 0.dp else 16.dp)
                .then(if (isAnimate) y else x),
        ) {
            Column(modifier = Modifier.padding(top = if (isAnimate) 16.dp else 0.dp)) {
                if (isAnimate) {
                    Text(
                        text = "What is your mood?",
                        style = MaterialTheme.typography.headlineSmall,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        color = Color.Black
                    )
                }

                LazyVerticalGrid(
                    columns = GridCells.Fixed(5),
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = if (isAnimate) 0.dp else 16.dp),
                    verticalArrangement = if (isAnimate) Arrangement.Top else Arrangement.Center
                ) {
                    itemsIndexed(MoodTypes.values()) { index, item ->
                        Box(contentAlignment = Alignment.Center) {
                            Button(
                                onClick = {
                                    selectedMoodIndex = index
                                    isAnimate = true
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = if (selectedMoodIndex == index) Green else Color.Transparent),
                                shape = RoundedCornerShape(16.dp),
                                contentPadding = PaddingValues(6.dp),
                                modifier = Modifier.wrapContentWidth()
                            ) {
                                Image(
                                    painter = painterResource(id = item.moodIcon),
                                    contentDescription = stringResource(id = item.mood),
                                    modifier = Modifier.size(if (selectedMoodIndex == index) 30.dp else 40.dp)
                                )
                            }
                        }
                    }
                }

                if (isAnimate) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Emotions",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.Black
                    )

                    FlowRow(
                        mainAxisSpacing = 3.dp,
                        crossAxisSpacing = 3.dp,
                        modifier = Modifier.padding(16.dp),
                        mainAxisAlignment = FlowMainAxisAlignment.Center
                    ) {
                        EmotionTypes.values().forEachIndexed { index, emotionTypes ->
                            AssistChip(
                                onClick = { selectedEmotionIndex = index },
                                label = {
                                    Text(text = stringResource(id = emotionTypes.emotionName))
                                },
                                colors = AssistChipDefaults.assistChipColors(
                                    containerColor = if (selectedEmotionIndex == index) Green else LightGray,
                                    labelColor = if (selectedEmotionIndex == index) DarkWhite else Color.Black
                                ),
                                border = null,
                                shape = CircleShape
                            )
                        }
                    }

                }

            }

        }
        FloatingActionButton(
            onClick = {
                onDismissRequest()
            },
            modifier = Modifier
                .padding(top = 10.dp, bottom = 16.dp)
                .systemBarsPadding()
        ) {
            Icon(
                imageVector = Icons.Rounded.Close,
                contentDescription = "Close Icon"
            )
        }
    }
}