package com.example.myapplication.Registerers

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.database.RegistrationDatabaseDao

class RegistererViewModelFactory(
    private val dataSource: RegistrationDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegistererViewModel::class.java)) {
            return RegistererViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }

}