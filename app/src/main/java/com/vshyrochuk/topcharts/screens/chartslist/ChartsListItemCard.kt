package com.vshyrochuk.topcharts.screens.chartslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.vshyrochuk.topcharts.domain.model.ChartEntity

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChartItemCard(entity: ChartEntity, onChartClick: (ChartEntity) -> Unit) {
    Card(
        onClick = {
            onChartClick.invoke(entity)
        },
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .aspectRatio(1.0f)
            .padding(6.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = entity.getResizedImageThumbnail(),
                contentDescription = entity.albumName,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(12.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = entity.albumName,
                    style = MaterialTheme.typography.body1,
                    maxLines = 2
                )
                Text(
                    text = entity.artistName,
                    style = MaterialTheme.typography.caption,
                    maxLines = 2
                )
            }
        }
    }
}
