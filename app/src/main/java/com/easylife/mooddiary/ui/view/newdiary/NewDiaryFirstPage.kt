package com.easylife.mooddiary.ui.view.newdiary

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.easylife.mooddiary.R
import com.easylife.mooddiary.common.enums.EmotionTypes
import com.easylife.mooddiary.common.enums.MoodTypes
import com.easylife.mooddiary.common.enums.SphereTypes

/**
 * Created by erenalpaslan on 16.09.2022
 */
@Composable
fun NewDiaryFirstPage(
    isExpanded: MutableState<Boolean>,
    onDismissRequest: () -> Unit,
    onMoodSelected: (MoodTypes) -> Unit,
    onEmotionSelected: (EmotionTypes) -> Unit,
    onSphereOfLifeSelected: (SphereTypes) -> Unit,
    onNextClicked: () -> Unit,
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
    var selectedMoodIndex by remember {
        mutableStateOf(-1)
    }
    var selectedSphereOfLifeIndex by remember {
        mutableStateOf(-1)
    }
    var selectedEmotion by remember {
        mutableStateOf<EmotionTypes?>(null)
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Card(
            shape = if (isExpanded.value) RoundedCornerShape(0.dp) else RoundedCornerShape(30.dp),
            modifier = Modifier
                .padding(horizontal = if (isExpanded.value) 0.dp else 16.dp)
                .then(if (isExpanded.value) y else x),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(5),
                modifier = Modifier.padding(top = if (isExpanded.value) 16.dp else 0.dp)
            ) {
                item(span = { GridItemSpan(5) }) {
                    Text(
                        text = stringResource(id = R.string.new_diary_what_is_your_mood),
                        style = MaterialTheme.typography.headlineSmall,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        color = Color.Black
                    )
                }

                itemsIndexed(MoodTypes.values()) { index, item ->
                    MoodButton(item = item, selected = selectedMoodIndex == index) {
                        selectedMoodIndex = index
                        isExpanded.value = true
                        onMoodSelected(item)
                    }
                }

                if (isExpanded.value) {
                    item(span = { GridItemSpan(5) }) {
                        Text(
                            text = stringResource(id = R.string.new_diary_emotions_title),
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            color = Color.Black
                        )
                    }

                    item(span = { GridItemSpan(5) }) {
                        EmotionList(onEmotionSelected = {
                            selectedEmotion = it
                            onEmotionSelected(it)
                        })
                    }

                    item(span = { GridItemSpan(5) }) {
                        Text(
                            text = stringResource(id = R.string.new_diary_sphere_of_life_title),
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp, bottom = 10.dp),
                            color = Color.Black
                        )
                    }

                    itemsIndexed(SphereTypes.values()) { index, item ->
                        SphereOfLifeButton(
                            item = item,
                            selected = selectedSphereOfLifeIndex == index
                        ) {
                            selectedSphereOfLifeIndex = index
                            onSphereOfLifeSelected(item)
                        }
                    }

                    item(span = { GridItemSpan(5) }) {
                        Button(
                            onClick = {
                                onNextClicked()
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            enabled = selectedMoodIndex >= 0 && selectedSphereOfLifeIndex >= 0 && selectedEmotion != null
                        ) {
                            Text(text = stringResource(id = R.string.button_next))
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
