package com.example.examples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.examples.ui.theme.ExamplesTheme
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val scheduler = AndroidAlarmScheduler(this)
        var alarmItem: AlarmItem? = null
        setContent {
            ExamplesTheme {
                var secondsText by remember {
                    mutableStateOf("")
                }
                var message by remember {
                    mutableStateOf("")
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    OutlinedTextField(
                        value = secondsText,
                        onValueChange = { secondsText = it },
                        placeholder = {
                            Text(text = "trigger alarm in seconds")
                        })
                    OutlinedTextField(
                        value = message,
                        onValueChange = { message = it },
                        placeholder = {
                            Text(text = "message")
                        })
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(onClick = {
                            alarmItem = AlarmItem(
                                time = LocalDateTime.now().plusSeconds(secondsText.toLong()),
                                message = message
                            )
                            alarmItem?.let(scheduler::schedule)
                        }) {
                            Text(text = "Schedule")
                        }
                        Button(onClick = { alarmItem?.let(scheduler::cancel) }) {
                            Text(text = "Cancel")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExamplesTheme {
        Greeting("Android")
    }
}