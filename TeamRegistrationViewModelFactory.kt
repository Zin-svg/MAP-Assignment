package com.example.nahockeyapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TeamRegistrationViewModelFactory(private val someParameter: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TeamRegistrationViewModel::class.java)) {
            return TeamRegistrationViewModel(someParameter) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}