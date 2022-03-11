package com.niran.parkingspotfinder.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "parking_spot_table")
data class ParkingSpotEntity(
    val lat: Double,
    val lng: Double,
    @PrimaryKey(autoGenerate = true) val id: Int? = null
)
