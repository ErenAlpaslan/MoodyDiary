package com.easylife.mooddiary.ui.view.monthlyLineChart

import android.graphics.PointF
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.easylife.mooddiary.R
import com.easylife.mooddiary.ui.theme.*
import com.easylife.mooddiary.ui.view.MonthAndYearSelector
import com.easylife.mooddiary.utils.extensions.hasNext
import kotlin.math.abs

/**
 * Created by erenalpaslan on 19.09.2022
 */
@Composable
fun MonthlyLineChart(
    values: List<Int> = listOf(
        1,
        2,
        3,
        2,
        5,
        4,
        3,
        4,
        0,
        1,
        3,
        4,
        2,
        3,
        4,
        5,
        4,
        3,
        2,
        2,
        1,
        1,
        3,
        4,
        2,
        3,
        4,
        5,
        4,
        3,
        2,
        2,
        1,
        0
    )
) {
    val icons by remember {
        mutableStateOf(

            listOf(
                R.drawable.ic_cool_outlined,
                R.drawable.ic_happy_outlined,
                R.drawable.ic_normal_outlined,
                R.drawable.ic_sad_outlined,
                R.drawable.ic_very_bad_outlined
            )
        )
    }

    val cool = ImageBitmap.imageResource(id = R.drawable.ic_cool_outlined)
    val happy = ImageBitmap.imageResource(id = R.drawable.ic_happy_outlined)
    val normal = ImageBitmap.imageResource(id = R.drawable.ic_normal_outlined)
    val sad = ImageBitmap.imageResource(id = R.drawable.ic_sad_outlined)
    val verySad = ImageBitmap.imageResource(id = R.drawable.ic_very_bad_outlined)

    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(DarkWhite)
        ) {
            MonthAndYearSelector(modifier = Modifier.fillMaxWidth())
            Canvas(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            ) {
                val itemSize = (size.height / 5)
                (0..4).map {
                    val icon = when (it) {
                        0 -> cool
                        1 -> happy
                        2 -> normal
                        3 -> sad
                        else -> verySad
                    }
                    drawImage(
                        image = icon,
                        dstOffset = IntOffset(
                            16.dp.toPx().toInt(),
                            (it * itemSize).toInt()
                        ),
                        dstSize = IntSize(16.dp.toPx().toInt(), 16.dp.toPx().toInt())
                    )
                }
                drawLine(
                    Gray,
                    start = Offset(36.dp.toPx(), 0f),
                    end = Offset(36.dp.toPx(), size.height + 12.dp.roundToPx()),
                    strokeWidth = 2f
                )
                drawLine(
                    Gray,
                    start = Offset(36.dp.toPx(), size.height + 12.dp.roundToPx()),
                    end = Offset(size.width - 36.dp.toPx(), size.height + 12.dp.roundToPx()),
                    strokeWidth = 2f
                )
                val lineSize = ((size.width - (36.dp.toPx() * 2)) / values.size)
                for (i in 1 until values.size) {
                    val x = (lineSize * i) + 44.dp.toPx()
                    val y = (size.height - (itemSize * values[i])) + 8.dp.toPx()
                    /*if (values.hasNext(i)) {
                        val diff = abs(values[i] - values[i + 1])
                        for (z in 0 until diff) {

                        }
                    }*/
                    drawLine(
                        values[i].getColorByPoint(),
                        start = Offset(
                            (lineSize * (i - 1)) + 44.dp.toPx(),
                            (size.height - (itemSize * values[i - 1])) + 8.dp.toPx()
                        ),
                        end = Offset(x, y),
                        strokeWidth = 8f
                    )
                }
                for (i in values.indices) {
                    val x1 = (lineSize * i) + 44.dp.toPx()
                    val y1 = (size.height - (itemSize * values[i])) + 8.dp.toPx()
                    drawCircle(
                        color = values[i].getColorByPoint(),
                        radius = 10f,
                        center = Offset(x1, y1)
                    )
                    drawCircle(
                        color = Color.White,
                        radius = 5f,
                        center = Offset(x1, y1)
                    )
                }
            }
            Box(modifier = Modifier.padding(start = 16.dp, top = 24.dp)) {
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .width(100.dp)
                        .height(24.dp)
                        .border((0.5).dp, Gray, CircleShape)
                        .clip(CircleShape)
                ) {
                    IconButton(
                        onClick = { /*TODO*/ },
                    ) {
                        Icon(imageVector = Icons.Rounded.Add, contentDescription = "")
                    }
                    Divider(modifier = Modifier
                        .width(1.dp)
                        .fillMaxHeight())
                    IconButton(
                        onClick = { /*TODO*/ },
                    ) {
                        Icon(imageVector = Icons.Rounded.Add, contentDescription = "")
                    }
                }
            }
            Spacer(modifier = Modifier.height(54.dp))
        }
    }
}

fun Int.getColorByPoint(): Color {
    return when (this) {
        1 -> Red
        2 -> LightOrange
        3 -> LightGreen
        4 -> Blue
        5 -> Purple
        else -> Color.White
    }
}