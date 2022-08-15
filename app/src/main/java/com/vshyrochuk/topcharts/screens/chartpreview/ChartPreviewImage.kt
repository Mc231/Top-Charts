package com.vshyrochuk.topcharts.screens.chartpreview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.vshyrochuk.topcharts.R
import com.vshyrochuk.topcharts.domain.model.ChartEntity

@Composable
fun ChartPreviewImage(entity: ChartEntity, onBackClicked: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.0f)
    ) {
        AsyncImage(
            model = entity.getResizedImageThumbnail(),
            contentDescription = entity.albumName,
            modifier = Modifier.fillMaxSize()
        )
        Column {
            Spacer(modifier = Modifier.height(42.dp))
            IconButton(onClick = onBackClicked) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = stringResource(
                        id = R.string.back
                    ),
                    modifier = Modifier
                        .width(32.dp)
                        .height(32.dp)
                )
            }
        }
    }
}
