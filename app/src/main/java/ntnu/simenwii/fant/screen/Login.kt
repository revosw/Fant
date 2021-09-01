package ntnu.simenwii.fant.screen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Login(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val username = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf("") }

        Text("Fant", fontSize = 130.sp, modifier = Modifier.padding(bottom = 60.dp))

        TextField(username.value, label = { Text("Username") }, onValueChange = { username.value = it })
        TextField(password.value, label = { Text("Password") }, visualTransformation = PasswordVisualTransformation(), onValueChange = { password.value = it })

        OutlinedButton({ navController.navigate("marketplace") }, Modifier.padding(all = 4.dp)) {
            Text("Log In")
        }
        TextButton({ navController.navigate("newuser?username=${username.value.text}&password=${password.value}") }) {
            Text("New user? Register here")
        }
    }
}