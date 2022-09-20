package com.easylife.mooddiary.ui.view.monthlyLineChart

import android.graphics.PointF
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.easylife.mooddiary.R
import com.easylife.mooddiary.ui.theme.DarkWhite
import com.easylife.mooddiary.ui.theme.Gray
import com.easylife.mooddiary.ui.theme.Green
import com.easylife.mooddiary.ui.theme.Orange
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
                R.drawable.ic_happy,
                R.drawable.ic_smile,
                R.drawable.ic_normal,
                R.drawable.ic_disappointed,
                R.drawable.ic_crying
            )
        )
    }
    val icon = ImageBitmap.imageResource(id = R.drawable.ic_happy)

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
                        strokeWidth = 3f
                    )
                }
                for (i in values.indices) {
                    val x1 = (lineSize * i) + 44.dp.toPx()
                    val y1 = (size.height - (itemSize * values[i])) +8.dp.toPx()
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
            Spacer(modifier = Modifier.height(54.dp))
        }
    }
}

fun Int.getColorByPoint(): Color {
    return when (this) {
        1 -> Orange
        2 -> Color.Yellow
        3 -> Color.Cyan
        4 -> Color.Green
        5 -> Green
        else -> Color.Red
    }
}

@Composable
fun Icons(icon: Int) {
    ImageBitmap.imageResource(id = icon)
}