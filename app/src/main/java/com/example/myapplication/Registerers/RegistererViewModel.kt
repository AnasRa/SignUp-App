package com.example.myapplication.Registerers

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.myapplication.database.RegistererData
import com.example.myapplication.database.RegistrationDatabaseDao
import kotlinx.coroutines.*

class RegistererViewModel(
    val database: RegistrationDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    private val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    var all = database.getAllRegisterer()


    fun onClear() {
        uiScope.launch {
            clear()
        }
    }

    private suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}