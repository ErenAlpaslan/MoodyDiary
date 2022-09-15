package com.easylife.mooddiary.ui.view

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.easylife.mooddiary.entity.SingleDatePoint
import com.easylife.mooddiary.utils.extensions.getMonth

/**
 * Created by erenalpaslan on 14.09.2022
 */
@Composable
fun DateSelector(
    state: LazyListState,
    list: List<SingleDatePoint>,
    selected: Int? = null,
    onMonthChanged: (String?) -> Unit,
    onDateSelected: (SingleDatePoint) -> Unit
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val coroutineScope = rememberCoroutineScope()
    var selectedIndex by remember {
        mutableStateOf(-1)
    }
    var month by remember {
        mutableStateOf<String?>(null)
    }

    if (state.firstVisibleItemIndex > 0) {
        month = list[list.getMonth(state.firstVisibleItemIndex)].month
        onMonthChanged(month)
    }

    LaunchedEffect(key1 = selected) {
        selected?.let {
            selectedIndex = it
        }
    }

    Column{
        LazyRow (
            state = state,
            horizontalArrangement = Arrangement.SpaceAround
        ){
            itemsIndexed(list) {index, date ->
                DateItem(
                    date = date,
                    index = index,
                    month = month,
                    itemWidth = (screenWidth / 7),
                    selected = selectedIndex == index
                ) {
                    onDateSelected(date)
                    selectedIndex = it
                }
            }
        }
        Spacer(modifier = Modifier.height(6.dp))
        Divider()
    }
}
