package com.example.nahockeyapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TeamRegistrationViewModel(val someParameter: String) : ViewModel() {

    // LiveData to hold the list of registered teams
    private val _teams = MutableLiveData<List<String>>()
    val teams: LiveData<List<String>> get() = _teams

    // LiveData to hold the registration status
    private val _registrationStatus = MutableLiveData<Boolean>()
    val registrationStatus: LiveData<Boolean> get() = _registrationStatus

    init {
        // Initialize with an empty list of teams
        _teams.value = emptyList()
    }

    /**
     * Registers a new team.
     * @param teamName The name of the team to register.
     */
    fun registerTeam(teamName: String) {
        // Get the current list of teams
        val currentTeams = _teams.value ?: emptyList()

        // Add the new team to the list
        val updatedTeams = currentTeams + teamName

        // Update the LiveData with the new list
        _teams.value = updatedTeams

        // Update the registration status
        _registrationStatus.value = true
    }

    /**
     * Resets the registration status.
     */
    fun resetRegistrationStatus() {
        _registrationStatus.value = false
    }
}