package com.niran.parkingspotfinder.di

import com.niran.parkingspotfinder.data.repositories.ParkingSpotRepositoryImpl
import com.niran.parkingspotfinder.domain.repositories.ParkingSpotRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModuleBinds {

    @Binds
    abstract fun provideParkingSpotRepository(
        bind: ParkingSpotRepositoryImpl
    ): ParkingSpotRepository
}