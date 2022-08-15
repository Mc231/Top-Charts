package com.vshyrochuk.topcharts.screens.chartpreview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.vshyrochuk.topcharts.R
import com.vshyrochuk.topcharts.domain.model.ChartEntity

@Composable
fun ChartPreviewFooter(entity: ChartEntity, dateFormatter: ReleaseDateFormatter, uriHandler: UriHandler) {
    Column(
        Modifier
            .padding(PaddingValues(start = 16.dp, end = 16.dp, bottom = 47.dp))
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        val releaseDate = dateFormatter.format(entity.releaseData)
        Text(
            text = stringResource(
                id = R.string.release_date_and_copyright,
                releaseDate,
                entity.copyright
            ), style = MaterialTheme.typography.caption,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { uriHandler.openUri(entity.url) },
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = Color.Blue
            ),
            modifier = Modifier.height(45.dp)
        ) {
            Text(
                text = stringResource(id = R.string.visit_the_album),
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
        }
    }
}
