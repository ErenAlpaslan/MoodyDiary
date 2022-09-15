package com.easylife.mooddiary.ui.screen.diary

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.easylife.mooddiary.base.BaseScreen
import com.easylife.mooddiary.common.AppConstant
import com.easylife.mooddiary.ui.view.DateItem
import com.easylife.mooddiary.ui.view.DateSelector
import com.easylife.mooddiary.ui.view.DiaryItem
import com.easylife.mooddiary.utils.extensions.getCurrentYear
import com.google.accompanist.insets.systemBarsPadding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import kotlinx.coroutines.launch

/**
 * Created by erenalpaslan on 13.09.2022
 */
class DiaryScreen : BaseScreen<DiaryViewModel, DiaryNavigationActions>() {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
    @Composable
    override fun Content() {
        val uiState by viewModel.uiState.collectAsState()
        LaunchedEffect(key1 = "") {
            viewModel.getDates(null, true)
        }

        val coroutineScope = rememberCoroutineScope()
        var dropdownExpanded by remember {
            mutableStateOf(false)
        }
        val listState = rememberLazyListState()

        LaunchedEffect(
            key1 = uiState.selectedIndex
        ) {
            uiState.selectedIndex?.let {
                launch {
                    listState.scrollToItem(it)
                }
            }
        }

        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "Moody", style = MaterialTheme.typography.bodyLarge)
                            Text(
                                text = uiState.month?.lowercase() ?: "",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Rounded.Menu,
                                contentDescription = "Hamburger Menu"
                            )
                        }
                    },
                    actions = {
                        Button(
                            onClick = { dropdownExpanded = true },
                            contentPadding = PaddingValues(vertical = 4.dp, horizontal = 8.dp)
                        ) {
                            Text(text = uiState.year.toString())
                            Icon(
                                imageVector = Icons.Rounded.ArrowDropDown,
                                "",
                            )
                        }
                        DropdownMenu(
                            expanded = dropdownExpanded,
                            onDismissRequest = { dropdownExpanded = false }
                        ) {
                            (AppConstant.MIN_YEAR..getCurrentYear()).reversed().forEach {
                                DropdownMenuItem(
                                    text = {
                                        Text(text = it.toString())
                                    },
                                    onClick = {
                                        dropdownExpanded = false
                                        viewModel.onYearChanged(it)
                                    }
                                )
                            }
                        }
                    }
                )
            },
            content = {
                Column(modifier = Modifier.padding(it)) {
                    DateSelector(
                        state = listState,
                        list = uiState.dates,
                        selected = uiState.selectedIndex,
                        onMonthChanged = {
                            viewModel.onMonthChanged(it)
                        },
                        onDateSelected = {
                            viewModel.onDateSelected(it)
                        }
                    )
                    LazyColumn(modifier = Modifier.padding(bottom = 76.dp, start = 16.dp, end = 16.dp)) {
                        item {
                            Spacer(modifier = Modifier.height(10.dp))
                        }
                        if (uiState.selectedDate != null) {
                            item {
                                Text(
                                    text = "${uiState.selectedDate?.month} ${uiState.year}",
                                    style = MaterialTheme.typography.headlineMedium
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                            }
                        }

                        items(3) {
                            DiaryItem()
                        }
                    }
                }
            }
        )
    }

    companion object {
        @OptIn(ExperimentalMaterial3Api::class)
        val drawerState = DrawerState(initialValue = DrawerValue.Closed)
    }

}