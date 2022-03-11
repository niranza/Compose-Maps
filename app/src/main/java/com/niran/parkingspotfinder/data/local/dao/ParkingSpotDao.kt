package com.niran.parkingspotfinder.data.local.dao

import androidx.room.*
import com.niran.parkingspotfinder.data.local.entities.ParkingSpotEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ParkingSpotDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertParkingSpot(spot: ParkingSpotEntity)

    @Delete
    suspend fun deleteParkingSpot(spot: ParkingSpotEntity)

    @Query("SELECT * from parking_spot_table")
    fun collectParkingSpots(): Flow<List<ParkingSpotEntity>>
}