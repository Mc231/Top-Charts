package com.vshyrochuk.topcharts.screens.chartslist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.vshyrochuk.topcharts.BuildConfig
import com.vshyrochuk.topcharts.R

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ChartsListAppBar(isScrolling: Boolean) {
    Column {
        Spacer(modifier = Modifier.height(32.dp))
        TopAppBar(
            title = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = pluralStringResource(
                        id = R.plurals.top_n_albums,
                        count = BuildConfig.LOAD_LIMIT,
                        BuildConfig.LOAD_LIMIT
                    ),
                    style = if (isScrolling) MaterialTheme.typography.h1 else MaterialTheme.typography.subtitle1,
                    textAlign = if (isScrolling) TextAlign.Left else TextAlign.Center
                )
            },
            backgroundColor = Color.White.copy(alpha = 0.85f),
            elevation = 0.dp,
        )
    }
}
