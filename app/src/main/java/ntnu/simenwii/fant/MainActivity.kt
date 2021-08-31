package ntnu.simenwii.fant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ntnu.simenwii.fant.ui.theme.FantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FantTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    FantViewLogin()
                }
            }
        }
    }
}

@Composable
fun FantViewLogin() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val username = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf("") }

        Text("Fant", fontSize = 130.sp, modifier = Modifier.padding(bottom = 60.dp))

        TextField(username.value, label = { Text("Username") }, onValueChange = { username.value = it })
        TextField(password.value, label = { Text("Password") }, visualTransformation = PasswordVisualTransformation(), onValueChange = { password.value = it })

        OutlinedButton({ System.out.println("halloen 2") }, Modifier.padding(all = 4.dp)) {
            Text("Log In")
        }
        TextButton({ System.out.println("halloen") }) {
            Text("New user? Register here")
        }
    }
}