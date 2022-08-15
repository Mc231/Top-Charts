package com.vshyrochuk.topcharts.screens.chartpreview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.UriHandler
import com.vshyrochuk.topcharts.domain.model.ChartEntity

@Composable
fun ChartPreviewContent(
    entity: ChartEntity,
    onBackClicked: () -> Unit,
    dateFormatter: ReleaseDateFormatter,
    uriHandler: UriHandler
) {
    Column(modifier = Modifier.fillMaxSize()) {
        ChartPreviewImage(entity = entity, onBackClicked = onBackClicked)
        ChartPreviewDescription(entity = entity)
        ChartPreviewFooter(entity, dateFormatter, uriHandler)
    }
}
