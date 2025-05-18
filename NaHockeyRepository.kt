package com.example.nahockeyapp.repository
import com.example.nahockeyapp.data.AppDatabase
import com.example.nahockeyapp.data.Team

class NaHockeyRepository(private val appDatabase: AppDatabase) {
    private val teamDao = appDatabase.teamDao()

    // Add a new team
    suspend fun addTeam(team: Team) {
        teamDao.insertTeam(team)
    }

    // Get all teams
    suspend fun getAllTeams(): List<Team> {
        return teamDao.getAllTeams()
    }

    // Get a team by ID
    suspend fun getTeamById(id: String): Team? {
        return teamDao.getTeamById(id)
    }

    // Update an existing team
    suspend fun updateTeam(team: Team) {
        teamDao.updateTeam(team)
    }

    // Delete a team
    suspend fun deleteTeam(team: Team) {
        teamDao.deleteTeam(team)
    }
}