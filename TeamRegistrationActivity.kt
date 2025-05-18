package com.example.nahockeyapp

import TeamRegistrationScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider

class TeamRegistrationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = TeamRegistrationViewModelFactory("someParameter")
        val viewModel = ViewModelProvider(this, factory).get(TeamRegistrationViewModel::class.java)

        setContent {
            TeamRegistrationScreen(viewModel)
        }
    }
}