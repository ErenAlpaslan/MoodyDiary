package com.easylife.mooddiary.ui.view.newdiary

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.easylife.mooddiary.common.enums.MoodTypes
import com.easylife.mooddiary.ui.theme.Green

/**
 * Created by erenalpaslan on 16.09.2022
 */
@Composable
fun MoodButton(
    item: MoodTypes,
    selected: Boolean = false,
    onClicked: () -> Unit
) {
    Box(contentAlignment = Alignment.Center) {
        Button(
            onClick = {
                onClicked()
            },
            colors = ButtonDefaults.buttonColors(containerColor = if (selected) Green else Color.Transparent),
            shape = RoundedCornerShape(16.dp),
            contentPadding = PaddingValues(6.dp),
            modifier = Modifier.wrapContentWidth()
        ) {
            Image(
                painter = painterResource(id = item.moodIcon),
                contentDescription = stringResource(id = item.mood),
                modifier = Modifier.size(if (selected) 30.dp else 40.dp)
            )
        }
    }
}