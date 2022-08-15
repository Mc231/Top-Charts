package com.vshyrochuk.topcharts.screens.common

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.vshyrochuk.topcharts.R

@Composable
fun ErrorComponent(@StringRes message: Int, onRetryClicked: (() -> Unit)) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(PaddingValues(horizontal = 16.dp))
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = stringResource(id = message), style = MaterialTheme.typography.caption)
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = onRetryClicked,
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    backgroundColor = Color.Blue
                ),
                modifier = Modifier.height(45.dp)
            ) {
                Text(
                    text = stringResource(R.string.retry),
                    style = MaterialTheme.typography.body1,
                    color = Color.White
                )
            }
        }
    }
}

