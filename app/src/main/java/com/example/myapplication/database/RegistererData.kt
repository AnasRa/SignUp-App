package com.example.myapplication.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "registerer_table")
data class RegistererData(
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "password")
    val password: String,
    @ColumnInfo(name = "first_name")
    val firstName: String,
    @ColumnInfo(name = "last_name")
    val lastName: String,
    @PrimaryKey(autoGenerate = true)
    var registererId: Long = 0L,
    @ColumnInfo(name = "registration_time")
    val registrationTime: Long = System.currentTimeMillis(),
    )