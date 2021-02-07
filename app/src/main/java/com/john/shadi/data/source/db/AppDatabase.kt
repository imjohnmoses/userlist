package com.john.shadi.data.source.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.john.shadi.domain.model.UserData

@Database(entities = [UserData::class], version = AppDatabase.VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "user1.db"
        const val VERSION = 1
    }
    abstract fun userDao(): UserDataDao
}