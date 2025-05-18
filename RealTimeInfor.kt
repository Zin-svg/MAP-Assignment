
package com.example.nahockeyapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

@Composable
fun RealTimeInfoScreen() {
    var message by remember { mutableStateOf("") }
    val messages = remember { mutableStateListOf<String>() }
    val database = Firebase.database
    val messagesRef = database.getReference("messages")

    LaunchedEffect(Unit) {
        messagesRef.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                snapshot.getValue(String::class.java)?.let { messages.add(it) }
            }
            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onChildRemoved(snapshot: DataSnapshot) {}
            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onCancelled(error: DatabaseError) {}
        })
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Live Updates", style = MaterialTheme.typography.h6)
        LazyColumn(modifier = Modifier.weight(1f).fillMaxWidth()) {
            items(messages) { msg -> Text(msg) }
        }
        OutlinedTextField(
            value = message,
            onValueChange = { message = it },
            label = { Text("New Message") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                if (message.isNotBlank()) {
                    messagesRef.push().setValue(message)
                    message = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Send")
        }
    }
}