import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nahockeyapp.TeamRegistrationViewModel
import com.example.nahockeyapp.data.Team

@Composable
fun TeamRegistrationScreen(viewModel: TeamRegistrationViewModel = viewModel()) {
    var teamName by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Register a New Team")
        TextField(
            value = teamName,
            onValueChange = { teamName = it },
            label = { Text("Team Name") }
        )
        Button(
            onClick = {
                val team = Team(id = generateTeamId(), name = teamName)
                viewModel.registerTeam(team.toString())
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Register Team")
        }
    }
}

fun generateTeamId(): String {
    // Generate a unique ID for the team
    return java.util.UUID.randomUUID().toString()
}