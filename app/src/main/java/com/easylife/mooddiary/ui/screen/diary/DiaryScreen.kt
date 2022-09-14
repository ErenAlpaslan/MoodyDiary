package com.easylife.mooddiary.ui.screen.diary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.easylife.mooddiary.base.BaseScreen
import com.easylife.mooddiary.ui.view.DateItem
import com.easylife.mooddiary.ui.view.DateSelector
import com.google.accompanist.insets.systemBarsPadding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

/**
 * Created by erenalpaslan on 13.09.2022
 */
class DiaryScreen : BaseScreen<DiaryViewModel, DiaryNavigationActions>() {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
    @Composable
    override fun Content() {
        val uiState by viewModel.uiState.collectAsState()
        LaunchedEffect(key1 = "") {
            viewModel.getDates()
        }

        Scaffold(
            content = {
                Column {
                    DateSelector(list = uiState.dates) {
                        month.value = it
                    }
                }
            }
        )
    }

    companion object {
        val month: MutableState<String?> = mutableStateOf("")
    }

}