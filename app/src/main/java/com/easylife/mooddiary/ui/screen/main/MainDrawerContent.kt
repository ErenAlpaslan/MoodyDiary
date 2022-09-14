package com.easylife.mooddiary.ui.screen.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by erenalpaslan on 14.09.2022
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainDrawerContent() {
    ModalDrawerSheet(
        Modifier.windowInsetsPadding(insets = WindowInsets(right = 120.dp))
    ) {
        Box(modifier = Modifier.fillMaxSize())
    }
}