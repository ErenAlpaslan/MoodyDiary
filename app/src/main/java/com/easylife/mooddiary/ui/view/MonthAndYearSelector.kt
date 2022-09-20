package com.easylife.mooddiary.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.easylife.mooddiary.R
import com.easylife.mooddiary.common.AppConstant
import com.easylife.mooddiary.ui.theme.DarkWhite
import com.easylife.mooddiary.ui.theme.Gray
import com.easylife.mooddiary.ui.theme.Green
import com.easylife.mooddiary.ui.theme.LightGray
import com.easylife.mooddiary.utils.extensions.getCurrentMonth
import com.easylife.mooddiary.utils.extensions.getCurrentYear
import com.easylife.mooddiary.utils.extensions.getMonthList
import java.util.Calendar

/**
 * Created by erenalpaslan on 19.09.2022
 */
@Composable
fun MonthAndYearSelector(
    modifier: Modifier = Modifier
) {
    val months by remember {
        mutableStateOf(Calendar.getInstance().getMonthList(getCurrentYear()))
    }

    val years by remember {
        mutableStateOf((AppConstant.MIN_YEAR..getCurrentYear()))
    }

    var selectedMonthIndex by remember {
        mutableStateOf(months.indexOfFirst { it == getCurrentMonth() })
    }

    val selectedYear by remember {
        mutableStateOf(getCurrentYear())
    }
    var dropdownExpanded by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = {
                selectedMonthIndex -= 1
            },
            enabled = selectedMonthIndex != 0,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_left_ios),
                contentDescription = "",
                tint = if (selectedMonthIndex != 0) Green else LightGray
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "${months[selectedMonthIndex]} $selectedYear",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.clickable {
                dropdownExpanded = true
            }
        )
        DropdownMenu(
            expanded = dropdownExpanded,
            onDismissRequest = { dropdownExpanded = false }
        ) {
            years.reversed().forEach {
                DropdownMenuItem(
                    text = {
                        Text(text = it.toString())
                    },
                    onClick = {
                        dropdownExpanded = false
                    }
                )
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        IconButton(
            onClick = {
                selectedMonthIndex += 1
            },
            enabled = selectedMonthIndex != (months.size - 1)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_right_ios),
                contentDescription = "",
                tint = if (selectedMonthIndex != (months.size - 1)) Green else LightGray
            )
        }
    }
}