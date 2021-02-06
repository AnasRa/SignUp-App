package com.example.myapplication.Info

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.Registerer
import com.example.myapplication.database.RegistererData
import com.example.myapplication.database.RegistrationDatabaseDao
import kotlinx.coroutines.*

class InfoViewModel(
    val database: RegistrationDatabaseDao,
    application: Application, private val args: Registerer
) : AndroidViewModel(application) {

    private val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
//    init {
//        initializeNew()
//    }

    fun initializeNew() {
        uiScope.launch {
            val newRg = RegistererData(args.email, args.password, args.firstName, args.lastName)
            insert(newRg)
        }
    }

    private suspend fun insert(new: RegistererData) {
        return withContext(Dispatchers.IO) {
            database.insert(new)
        }
    }


    private val _title: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val title: LiveData<String>
        get() = _title
    private val _registerer: MutableLiveData<Registerer> by lazy {
        MutableLiveData<Registerer>()
    }
    val registerer: LiveData<Registerer>
        get() = _registerer

    init {
        _registerer.value = args
        _title.value = "Confirmation"
    }

    override fun onCleared() {
        super.onCleared()
    }
}