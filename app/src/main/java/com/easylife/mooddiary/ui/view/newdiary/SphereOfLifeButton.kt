package com.easylife.mooddiary.ui.view.newdiary

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.easylife.mooddiary.common.enums.SphereTypes
import com.easylife.mooddiary.ui.theme.Green

/**
 * Created by erenalpaslan on 16.09.2022
 */
@Composable
fun SphereOfLifeButton(
    item: SphereTypes,
    selected: Boolean,
    onClicked: () -> Unit
) {
    Box(contentAlignment = Alignment.Center) {
        Button(
            onClick = {
                onClicked()
            },
            colors = ButtonDefaults.buttonColors(containerColor = if (selected) Green else Color.Transparent),
            shape = RoundedCornerShape(16.dp),
            contentPadding = PaddingValues(6.dp),
            modifier = Modifier
                .wrapContentWidth()
                .padding(vertical = 3.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = item.sphereIcon),
                    contentDescription = stringResource(id = item.sphereName),
                    modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = stringResource(id = item.sphereName),
                    color = if (selected) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}
