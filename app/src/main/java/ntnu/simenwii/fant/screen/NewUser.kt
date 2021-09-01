package ntnu.simenwii.fant.screen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.navigation.NavController

@Composable
fun NewUser(username: String? = "", password: String? = "", navController: NavController) {
    Column(
        Modifier.fillMaxSize().verticalScroll(ScrollState(0)),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val firstname = remember { mutableStateOf(TextFieldValue("")) }
        val lastname = remember { mutableStateOf(TextFieldValue("")) }
        val streetAddress = remember { mutableStateOf(TextFieldValue("")) }
        val city = remember { mutableStateOf(TextFieldValue("")) }
        val postalCode = remember { mutableStateOf(TextFieldValue("")) }
        val email = remember { mutableStateOf(TextFieldValue("")) }
        val username = remember { mutableStateOf(TextFieldValue(username!!)) }
        val password = remember { mutableStateOf(TextFieldValue(password!!)) }

        TextField(firstname.value, label = { Text("First Name") }, onValueChange = { firstname.value = it })
        TextField(lastname.value, label = { Text("Last Name") }, onValueChange = { lastname.value = it })
        TextField(streetAddress.value, label = { Text("Street address") }, onValueChange = { streetAddress.value = it })
        TextField(city.value, label = { Text("City") }, onValueChange = { city.value = it })
        TextField(postalCode.value, label = { Text("Postal code") }, onValueChange = { postalCode.value = it })
        TextField(email.value, label = { Text("Email address") }, onValueChange = { email.value = it })
        TextField(username.value, label = { Text("Username") }, onValueChange = { username.value = it })
        TextField(password.value, label = { Text("Password") }, visualTransformation = PasswordVisualTransformation(), onValueChange = { password.value = it })

        OutlinedButton({ navController.navigate("") }, Modifier.padding(all = 4.dp)) {
            Text("Register User")
        }
    }
}