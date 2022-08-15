package com.vshyrochuk.topcharts.screens.chartpreview

import androidx.annotation.StringRes
import com.vshyrochuk.topcharts.domain.model.ChartEntity

sealed class ChartPreviewUIState {
    object Initial : ChartPreviewUIState()
    object Loading : ChartPreviewUIState()
    class ChartLoaded(val entity: ChartEntity) : ChartPreviewUIState()
    class Error(@StringRes val message: Int) : ChartPreviewUIState()
}