package com.vshyrochuk.topcharts.screens.chartslist

import androidx.annotation.StringRes
import com.vshyrochuk.topcharts.domain.model.ChartEntity

sealed class ChartListUIState {
    object Initial : ChartListUIState()
    object Loading : ChartListUIState()
    class ChartsLoaded(val charts: List<ChartEntity>) : ChartListUIState()
    class Error(@StringRes val message: Int) : ChartListUIState()
}