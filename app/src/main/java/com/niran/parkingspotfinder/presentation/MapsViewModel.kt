package com.niran.parkingspotfinder.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.niran.parkingspotfinder.domain.model.ParkingSpot
import com.niran.parkingspotfinder.domain.repositories.ParkingSpotRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
    private val repository: ParkingSpotRepository
) : ViewModel() {

    var state by mutableStateOf(MapState())

    init {
        collectParkingSpots()
    }

    fun onEvent(event: MapEvent) {
        when (event) {
            MapEvent.ToggleFalloutMap -> onToggleFalloutMapEvent()
            is MapEvent.OnMapLongClick -> onInfoWindowLongClick(event.latLng)
            is MapEvent.OnInfoWindowLongClick -> onInfoWindowLongClick(event.spot)
        }
    }

    private fun onToggleFalloutMapEvent() {
        state = state.copy(
            properties = state.properties.copy(
                mapStyleOptions = if (state.isFalloutMap) null else MapStyleOptions(MapStyle.json)
            ),
            isFalloutMap = !state.isFalloutMap
        )
    }

    private fun onInfoWindowLongClick(latLng: LatLng) = viewModelScope.launch {
        repository.insertParkingSpot(ParkingSpot(latLng.latitude, latLng.longitude))
    }

    private fun onInfoWindowLongClick(spot: ParkingSpot) = viewModelScope.launch {
        repository.deleteParkingSpot(spot)
    }

    private fun collectParkingSpots() = viewModelScope.launch {
        repository.collectParkingSpots().collectLatest { spots ->
            state = state.copy(parkingSpots = spots)
        }
    }
}