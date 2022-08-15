package com.vshyrochuk.topcharts.screens.chartpreview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vshyrochuk.topcharts.domain.model.ChartEntity

@Composable
fun ChartPreviewDescription(entity: ChartEntity) {
    Column(Modifier.padding(PaddingValues(start = 16.dp, end = 16.dp, top = 12.dp))) {
        Text(
            text = entity.artistName,
            style = MaterialTheme.typography.body2,
            maxLines = 2,
            modifier = Modifier.padding(
                PaddingValues(top = 12.dp)
            )
        )
        Text(text = entity.albumName, style = MaterialTheme.typography.h1, maxLines = 2)
        Spacer(modifier = Modifier.height(8.dp))
        ChartPreviewGenres(genres = entity.genres)
    }
}
