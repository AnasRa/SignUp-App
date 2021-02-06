package com.example.myapplication.Name

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Registerer

class NameViewModelFactory(
    private val args: Registerer
) : ViewModelProvider.Factory {
    @Suppress("unchecked cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NameViewModel::class.java)) {
            return NameViewModel(args) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }

}