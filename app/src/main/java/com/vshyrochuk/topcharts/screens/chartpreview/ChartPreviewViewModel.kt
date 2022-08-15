package com.vshyrochuk.topcharts.screens.chartpreview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vshyrochuk.topcharts.R
import com.vshyrochuk.topcharts.data.ChartsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChartPreviewViewModel @Inject constructor(private val repository: ChartsRepository) :
    ViewModel() {

    private val _state = MutableStateFlow<ChartPreviewUIState>(ChartPreviewUIState.Initial)
    val state: StateFlow<ChartPreviewUIState> get() = _state

    fun load(entityId: String?) {
        _state.value = ChartPreviewUIState.Loading
        if (entityId == null) {
            _state.value = ChartPreviewUIState.Error(R.string.entity_id_not_passed)
        } else {
            loadEntity(entityId)
        }
    }

    private fun loadEntity(entityId: String) {
        val entity = repository.entities.firstOrNull { it.remoteId == entityId }
        if (entity != null) {
            _state.value = ChartPreviewUIState.ChartLoaded(entity)
        } else {
            tryToReloadEntity(entityId)
        }
    }

    private fun tryToReloadEntity(entityId: String) {
        viewModelScope.launch {
            try {
                val entity = repository.loadLocal().firstOrNull { it.remoteId == entityId }
                if (entity != null) {
                    _state.value = ChartPreviewUIState.ChartLoaded(entity)
                } else {
                    _state.value = ChartPreviewUIState.Error(R.string.failed_to_load_chart_entity)
                }
            } catch (e: Exception) {
                _state.value = ChartPreviewUIState.Error(R.string.failed_to_load_chart)
            }
        }
    }
}