package com.niran.parkingspotfinder.data.mappers

import com.niran.parkingspotfinder.data.local.entities.ParkingSpotEntity
import com.niran.parkingspotfinder.domain.model.ParkingSpot

fun ParkingSpotEntity.toParkingSpot() = ParkingSpot(
    lat = lat,
    lng = lng,
    id = id,
)

fun ParkingSpot.toParkingSpotEntity() = ParkingSpotEntity(
    lat = lat,
    lng = lng,
    id = id,
)