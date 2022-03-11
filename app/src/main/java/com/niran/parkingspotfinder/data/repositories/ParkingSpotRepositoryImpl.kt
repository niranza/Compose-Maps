package com.niran.parkingspotfinder.data.repositories

import com.niran.parkingspotfinder.data.local.dao.ParkingSpotDao
import com.niran.parkingspotfinder.data.mappers.toParkingSpot
import com.niran.parkingspotfinder.data.mappers.toParkingSpotEntity
import com.niran.parkingspotfinder.domain.model.ParkingSpot
import com.niran.parkingspotfinder.domain.repositories.ParkingSpotRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ParkingSpotRepositoryImpl @Inject constructor(
    private val dao: ParkingSpotDao
) : ParkingSpotRepository {

    override suspend fun insertParkingSpot(spot: ParkingSpot) {
        dao.insertParkingSpot(spot.toParkingSpotEntity())
    }

    override suspend fun deleteParkingSpot(spot: ParkingSpot) {

        dao.deleteParkingSpot(spot.toParkingSpotEntity())
    }

    override fun collectParkingSpots(): Flow<List<ParkingSpot>> {
        return dao.collectParkingSpots().map { spot -> spot.map { it.toParkingSpot() } }
    }
}