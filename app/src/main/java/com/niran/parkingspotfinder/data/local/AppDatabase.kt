package com.niran.parkingspotfinder.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.niran.parkingspotfinder.data.local.dao.ParkingSpotDao
import com.niran.parkingspotfinder.data.local.entities.ParkingSpotEntity

@Database(
    entities = [ParkingSpotEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun parkingSpotDao(): ParkingSpotDao
}