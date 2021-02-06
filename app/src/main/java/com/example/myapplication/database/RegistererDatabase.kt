package com.example.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RegistererData::class], version = 1, exportSchema = false)
abstract class RegistererDatabase : RoomDatabase() {

    abstract val registrationDatabaseDao: RegistrationDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: RegistererDatabase? = null
        fun getInstance(context: Context): RegistererDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RegistererDatabase::class.java,
                        "registration_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}