package com.example.myapplication.Name

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Registerer

class NameViewModel(args: Registerer) : ViewModel() {

    private val _title: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val title: LiveData<String>
        get() = _title

    private val _errorName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val errorName: LiveData<String>
        get() = _errorName

    private val _registerer: MutableLiveData<Registerer> by lazy {
        MutableLiveData<Registerer>()
    }
    val registerer: LiveData<Registerer>
        get() = _registerer

    init {
        _errorName.value = "Please Enter a Valid Name!"
        _registerer.value = args
        _title.value = "Name Registration"
    }

    override fun onCleared() {
        super.onCleared()
    }
}