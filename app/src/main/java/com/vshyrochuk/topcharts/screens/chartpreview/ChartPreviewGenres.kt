package com.vshyrochuk.topcharts.screens.chartpreview

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.vshyrochuk.topcharts.domain.model.ChartEntity
import com.vshyrochuk.topcharts.ui.theme.Blue

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChartPreviewGenres(genres: List<ChartEntity.Genre>) {
    FlowRow(
        mainAxisSpacing = 8.dp,
        crossAxisSpacing = 8.dp,
    ) {
        genres.forEach { genre ->
            Chip(
                onClick = {},
                border = BorderStroke(
                    ChipDefaults.OutlinedBorderSize,
                    Blue
                ),
                colors = ChipDefaults.chipColors(
                    backgroundColor = Color.White,
                    contentColor = Blue
                ),
                modifier = Modifier.height(22.dp)
            ) {
                Text(text = genre.name, style = MaterialTheme.typography.caption, color = Blue)
            }
        }
    }
}
