package com.example.myapplication.Info

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Registerer
import com.example.myapplication.database.RegistrationDatabaseDao

class InfoViewModelFactory(
    private val dataSource: RegistrationDatabaseDao,
    private val application: Application,
    private val args: Registerer
) : ViewModelProvider.Factory {
    @Suppress("unchecked cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InfoViewModel::class.java)) {
            return InfoViewModel(dataSource,application,args) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }

}