package com.easylife.mooddiary.ui.view.newdiary

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.easylife.mooddiary.common.enums.EmotionTypes
import com.easylife.mooddiary.ui.theme.DarkWhite
import com.easylife.mooddiary.ui.theme.Green
import com.easylife.mooddiary.ui.theme.LightGray
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow

/**
 * Created by erenalpaslan on 16.09.2022
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmotionList(
    onEmotionSelected: (EmotionTypes) -> Unit
) {
    var selectedEmotionIndex by remember {
        mutableStateOf(-1)
    }

    FlowRow(
        mainAxisSpacing = 3.dp,
        crossAxisSpacing = 3.dp,
        modifier = Modifier.padding(16.dp),
        mainAxisAlignment = FlowMainAxisAlignment.Center
    ) {
        EmotionTypes.values().forEachIndexed { index, emotionTypes ->
            AssistChip(
                onClick = {
                    selectedEmotionIndex = index
                    onEmotionSelected(emotionTypes)
                },
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