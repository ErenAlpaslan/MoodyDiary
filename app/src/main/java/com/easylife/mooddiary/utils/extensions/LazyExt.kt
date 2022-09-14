package com.easylife.mooddiary.utils.extensions

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Created by erenalpaslan on 14.09.2022
 */
fun CoroutineScope.scrollBasic(listState: LazyListState, left: Boolean = false){
    launch {
        val pos = if(left) listState.firstVisibleItemIndex else listState.firstVisibleItemIndex+1
        listState.animateScrollToItem(pos)
    }
}

@Composable
fun LazyListState.isHalfPastItemRight(): Boolean {
    return firstVisibleItemScrollOffset > 500
}

@Composable
fun LazyListState.isHalfPastItemLeft(): Boolean {
    return firstVisibleItemScrollOffset <= 500
}