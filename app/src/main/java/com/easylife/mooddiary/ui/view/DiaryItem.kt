package com.easylife.mooddiary.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.easylife.mooddiary.ui.theme.DarkWhite
import com.easylife.mooddiary.ui.theme.Orange

/**
 * Created by erenalpaslan on 15.09.2022
 */
@Composable
fun DiaryItem() {

    Card(
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier.padding(bottom = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        ConstraintLayout() {
            val (moodIconRef, emotionsRef, dateRef, categoryRef, titleRef, descriptionRef) = createRefs()
            Image(
                imageVector = Icons.Rounded.Warning,
                contentDescription = "",
                modifier = Modifier
                    .size(44.dp)
                    .constrainAs(moodIconRef) {
                        top.linkTo(parent.top, 16.dp)
                        start.linkTo(parent.start, 16.dp)
                    }
            )
            Text(text = "Sad", modifier = Modifier.constrainAs(emotionsRef) {
                top.linkTo(moodIconRef.top)
                start.linkTo(moodIconRef.end, 10.dp)
            })
            Text(
                text = "Today, 10:43 am",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.constrainAs(dateRef) {
                    top.linkTo(emotionsRef.bottom)
                    start.linkTo(moodIconRef.end, 10.dp)
                    bottom.linkTo(moodIconRef.bottom, 0.dp)
                })

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Orange)
                    .constrainAs(categoryRef) {
                        top.linkTo(moodIconRef.top)
                        bottom.linkTo(moodIconRef.bottom)
                        end.linkTo(parent.end, 16.dp)
                    }
            ) {
                Text(
                    text = "Personal",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                )
            }

            Text(
                text = "I'm Sad",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.constrainAs(titleRef) {
                    top.linkTo(moodIconRef.bottom, 16.dp)
                    start.linkTo(parent.start, 16.dp)
                })

            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                modifier = Modifier
                    .constrainAs(descriptionRef) {
                        top.linkTo(titleRef.bottom, 8.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom, 16.dp)
                    }
                    .padding(horizontal = 16.dp),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )

        }
    }
}