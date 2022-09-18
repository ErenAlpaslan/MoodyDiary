package com.easylife.mooddiary.ui.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.easylife.mooddiary.R
import com.easylife.mooddiary.common.enums.*
import com.easylife.mooddiary.entity.DiaryNote
import com.easylife.mooddiary.ui.theme.DarkWhite
import com.easylife.mooddiary.ui.theme.Orange

/**
 * Created by erenalpaslan on 15.09.2022
 */
@Composable
fun DiaryItem(diaryNote: DiaryNote) {

    Card(
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
            val (moodIconRef, emotionsRef, dateRef, categoryRef, titleRef, descriptionRef) = createRefs()
            getMood(diaryNote.moodId)?.let {
                Image(
                    painter = painterResource(
                        id = it.moodIcon
                    ),
                    contentDescription = "",
                    modifier = Modifier
                        .size(44.dp)
                        .constrainAs(moodIconRef) {
                            top.linkTo(parent.top, 16.dp)
                            start.linkTo(parent.start, 16.dp)
                        }
                )
            }

            getEmotion(diaryNote.emotionId)?.let {
                Text(
                    text = stringResource(id = it.emotionName),
                    modifier = Modifier.constrainAs(emotionsRef) {
                        top.linkTo(moodIconRef.top)
                        start.linkTo(moodIconRef.end, 10.dp)
                    })
            }
            Text(
                text = diaryNote.createdAt.toString(),
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.constrainAs(dateRef) {
                    top.linkTo(emotionsRef.bottom)
                    start.linkTo(moodIconRef.end, 10.dp)
                    bottom.linkTo(moodIconRef.bottom, 0.dp)
                })

            getSphereOfLife(diaryNote.sphereOfLifeId)?.let {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(colorResource(id = it.color))
                        .constrainAs(categoryRef) {
                            top.linkTo(moodIconRef.top)
                            bottom.linkTo(moodIconRef.bottom)
                            end.linkTo(parent.end, 16.dp)
                        }
                ) {
                    Text(
                        text = stringResource(id = it.sphereName),
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                }
            }

            Text(
                text = diaryNote.title ?: "",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.constrainAs(titleRef) {
                    top.linkTo(moodIconRef.bottom, 16.dp)
                    start.linkTo(parent.start, 16.dp)
                },
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = diaryNote.description ?: "",
                modifier = Modifier
                    .constrainAs(descriptionRef) {
                        top.linkTo(titleRef.bottom, 8.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom, 16.dp)
                        width = Dimension.fillToConstraints
                    }
                    .padding(horizontal = 16.dp),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}