package com.easylife.mooddiary.ui.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.easylife.mooddiary.entity.SingleDatePoint
import com.easylife.mooddiary.ui.theme.Gray
import com.easylife.mooddiary.ui.theme.Green
import com.easylife.mooddiary.ui.theme.LightWhite

/**
 * Created by erenalpaslan on 14.09.2022
 */
@Composable
fun DateItem(
    date: SingleDatePoint,
    index: Int,
    month: String?,
    itemWidth: Int,
    selected: Boolean,
    onDateSelected: (Int) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(width = itemWidth.dp)
    ) {
        Text(text = date.dayName ?: "", color = Gray)
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .size((itemWidth - 10).dp)
                .background(if (selected) Green else Color.Transparent)
                .clickable {
                    onDateSelected(index)
                }
        ) {
            Text(
                text = date.day ?: "",
                style = MaterialTheme.typography.bodyLarge,
                color = if (!month.isNullOrEmpty() && date.month != month) Gray else Color.Black
            )
        }


    }
}