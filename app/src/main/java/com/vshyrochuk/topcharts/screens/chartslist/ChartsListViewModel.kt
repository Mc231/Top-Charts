package com.vshyrochuk.topcharts.screens.chartslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vshyrochuk.topcharts.BuildConfig
import com.vshyrochuk.topcharts.R
import com.vshyrochuk.topcharts.data.ChartsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChartsListViewModel @Inject constructor(private val repository: ChartsRepository) :
    ViewModel() {

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> get() = _isRefreshing

    private val _state =
        MutableStateFlow<ChartListUIState>(ChartListUIState.Initial)
    val state: StateFlow<ChartListUIState> get() = _state

    fun load(isRefreshing: Boolean = false) {
        viewModelScope.launch {
            try {
                if (!isRefreshing) {
                    _state.value = ChartListUIState.Loading
                }
                val localCharts = repository.loadLocal().take(BuildConfig.LOAD_LIMIT)
                if (localCharts.isEmpty() || isRefreshing) {
                    val remoteCharts = repository.loadRemote().take(BuildConfig.LOAD_LIMIT)
                    repository.saveCharts(remoteCharts)
                    _state.value = ChartListUIState.ChartsLoaded(remoteCharts)
                } else {
                    _state.value = ChartListUIState.ChartsLoaded(localCharts)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _state.value = ChartListUIState.Error(R.string.failed_to_load_charts)
            } finally {
                if (isRefreshing) {
                    _isRefreshing.value = false
                }
            }
        }
    }

    fun refresh() {
        _isRefreshing.value = true
        load(true)
    }
}