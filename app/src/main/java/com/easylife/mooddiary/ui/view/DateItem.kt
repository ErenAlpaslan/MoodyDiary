package com.easylife.mooddiary.ui.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easylife.mooddiary.entity.SingleDatePoint
import com.easylife.mooddiary.ui.theme.Gray
import com.easylife.mooddiary.ui.theme.Green
import com.easylife.mooddiary.ui.theme.LightWhite
import com.easylife.mooddiary.ui.theme.Orange

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
        Text(text = date.dayName ?: "", color = Gray, modifier = Modifier.padding(end = 6.dp))
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier,
            contentAlignment = Alignment.TopEnd
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(top = 6.dp, end = 6.dp)
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
                    color = if (selected) Color.White else if (!month.isNullOrEmpty() && date.month != month) Gray else Color.Black
                )
            }
            if (date.count > 0) {
                Text(
                    text = date.count.toString(),
                    color = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Orange, CircleShape)
                        .padding(vertical = 2.dp, horizontal = 6.dp),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            }
        }


    }
}