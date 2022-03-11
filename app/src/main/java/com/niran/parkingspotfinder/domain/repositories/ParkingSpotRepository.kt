package com.niran.parkingspotfinder.domain.repositories

import com.niran.parkingspotfinder.domain.model.ParkingSpot
import kotlinx.coroutines.flow.Flow

interface ParkingSpotRepository {

    suspend fun insertParkingSpot(spot: ParkingSpot)

    suspend fun deleteParkingSpot(spot: ParkingSpot)

    fun collectParkingSpots(): Flow<List<ParkingSpot>>
}