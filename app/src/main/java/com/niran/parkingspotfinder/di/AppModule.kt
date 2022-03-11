package com.niran.parkingspotfinder.di

import android.app.Application
import androidx.room.Room
import com.niran.parkingspotfinder.data.local.AppDatabase
import com.niran.parkingspotfinder.data.local.dao.ParkingSpotDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        app: Application
    ): AppDatabase = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        "app.db"
    )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideParkingSpotDao(
        db: AppDatabase
    ): ParkingSpotDao = db.parkingSpotDao()
}