package com.easylife.mooddiary.ui.view

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.easylife.mooddiary.entity.SingleDatePoint
import com.easylife.mooddiary.utils.extensions.getMonth
import com.easylife.mooddiary.utils.extensions.isHalfPastItemLeft
import com.easylife.mooddiary.utils.extensions.isHalfPastItemRight
import com.easylife.mooddiary.utils.extensions.scrollBasic

/**
 * Created by erenalpaslan on 14.09.2022
 */
@Composable
fun DateSelector(
    list: List<SingleDatePoint>,
    onMonthChanged: (String?) -> Unit
) {

    val screenWidth = LocalConfiguration.current.screenWidthDp
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var selectedIndex by remember {
        mutableStateOf(-1)
    }
    var month by remember {
        mutableStateOf<String?>(null)
    }

    if (listState.firstVisibleItemIndex > 0) {
        month = list[list.getMonth(listState.firstVisibleItemIndex)].month
        onMonthChanged(month)
    }

    Column(modifier = Modifier.padding(top = 76.dp)){
        LazyRow (
            state = listState,
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
                    selectedIndex = it
                }
            }
        }
        Spacer(modifier = Modifier.height(6.dp))
        Divider()
    }
}
