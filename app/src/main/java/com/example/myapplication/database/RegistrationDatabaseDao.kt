package com.example.myapplication.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RegistrationDatabaseDao {

    @Insert
    fun insert(registerer: RegistererData)

    @Query("SELECT * FROM registerer_table WHERE registererId = :key ")
    fun get(key: Long): RegistererData

    @Query("DELETE FROM registerer_table")
    fun clear()

    @Query("SELECT * FROM registerer_table ORDER BY registererId DESC")
    fun getAllRegisterer(): LiveData<List<RegistererData>>
}