
package com.example.nahockeyapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teams")
data class Team(
    @PrimaryKey val id: String = "",
    val name: String = "",
    val coach: String = ""
)

@Entity(tableName = "players")
data class Player(
    @PrimaryKey val id: String = "",
    val name: String = "",
    val teamId: String = "",
    val position: String = ""
)

@Entity(tableName = "events")
data class Event(
    @PrimaryKey val id: String = "",
    val name: String = "",
    val date: String = "",
    val location: String = ""
)

