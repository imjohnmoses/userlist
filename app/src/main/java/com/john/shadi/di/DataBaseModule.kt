package com.john.shadi.di

import android.app.Application
import androidx.room.Room
import com.john.shadi.data.source.db.AppDatabase
import com.john.shadi.data.source.db.UserDataDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(application: Application): AppDatabase {
        return Room
                .databaseBuilder(application, AppDatabase::class.java, AppDatabase.DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    fun provideUserDao(appDataBase: AppDatabase): UserDataDao {
        return appDataBase.userDao()
    }
}