package com.example.nahockeyapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.nahockeyapp.ui.theme.NAHockeyAppTheme

@Composable
fun HomeScreen(navController: NavController) {
    NAHockeyAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hockey_logo),
                    contentDescription = "Namibia Hockey Union Logo",
                    modifier = Modifier.size(120.dp)
                )
                Text(
                    "Namibia Hockey Union",
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.primary
                )
                HomeButton(text = "Team Registration", onClick = { navController.navigate("team_registration") })
                HomeButton(text = "Player Management", onClick = { navController.navigate("player_management") })
                HomeButton(text = "Event Entries", onClick = { navController.navigate("event_entries") })
                HomeButton(text = "Real-Time Info", onClick = { navController.navigate("realtime_info") })
            }
        }
    }
}

@Composable
fun HomeButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
    ) {
        Text(text, style = MaterialTheme.typography.button)
    }
}