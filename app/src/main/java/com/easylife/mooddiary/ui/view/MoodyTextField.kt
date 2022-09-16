package com.easylife.mooddiary.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.easylife.mooddiary.R
import com.easylife.mooddiary.ui.theme.Green

/**
 * Created by erenalpaslan on 16.09.2022
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoodyTextField(
    modifier: Modifier = Modifier,
    placeholder: String,
    onTextChanged: (String?) -> Unit,
    maxCount: Int = 0,
    singleLine: Boolean = false,
    minSize: Dp? = null
) {
    var text by remember {
        mutableStateOf("")
    }

    val updateText: (String) -> Unit = {
        text = it
        onTextChanged(text)
    }

    ConstraintLayout(modifier = modifier) {
        val (textFieldRef, counterRef) = createRefs()
        TextField(
            value = text,
            onValueChange = {
                if (maxCount > 0) {
                    if (it.length < maxCount + 1) {
                        updateText(it)
                    }
                } else {
                    updateText(it)
                }
            },
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .constrainAs(textFieldRef) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top, 16.dp)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                    height =
                        if (minSize != null) Dimension.value(minSize) else Dimension.preferredWrapContent
                },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            placeholder = {
                Text(text = placeholder)
            },
            singleLine = singleLine
        )

        if (maxCount > 0) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .constrainAs(counterRef) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                    }
            ) {
                Text(
                    text = "${text.length}/$maxCount",
                    modifier = Modifier
                        .padding(6.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(Green)
                )
            }
        }

    }
}