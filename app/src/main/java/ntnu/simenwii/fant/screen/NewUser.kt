package ntnu.simenwii.fant.screen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun NewUser(username: String? = "", password: String? = "", navController: NavController) {
Column(
    modifier = Modifier.fillMaxSize().verticalScroll(ScrollState(0)),
    verticalArrangement = Arrangement.spacedBy(15.dp),
    horizontalAlignment = Alignment.CenterHorizontally
) {
    val firstname = remember { mutableStateOf(TextFieldValue("")) }
    val firstnameFocus = remember { FocusRequester() }

    val lastname = remember { mutableStateOf(TextFieldValue("")) }
    val lastnameFocus = remember { FocusRequester() }

    val streetAddress = remember { mutableStateOf(TextFieldValue("")) }
    val streetAddressFocus = remember { FocusRequester() }

    val city = remember { mutableStateOf(TextFieldValue("")) }
    val cityFocus = remember { FocusRequester() }

    val postalCode = remember { mutableStateOf(TextFieldValue("")) }
    val postalCodeFocus = remember { FocusRequester() }

    val email = remember { mutableStateOf(TextFieldValue("")) }
    val emailFocus = remember { FocusRequester() }

    val username = remember { mutableStateOf(TextFieldValue(username!!)) }
    val usernameFocus = remember { FocusRequester() }

    val password = remember { mutableStateOf(TextFieldValue(password!!)) }
    val passwordFocus = remember { FocusRequester() }

    TextField(firstname.value, isError = true, label = { Text("First Name") },
        modifier = Modifier.focusRequester(firstnameFocus),
        onValueChange = {
            when {
                it.text.contains('\n') -> lastnameFocus.requestFocus()
                else -> {
                    firstname.value = it
                }
            }
        }
    )
    TextField(lastname.value, label = { Text("Last Name") },
        modifier = Modifier.focusRequester(lastnameFocus),
        onValueChange = {
            when {
                it.text.contains('\n') -> streetAddressFocus.requestFocus()
                else -> {
                    lastname.value = it
                }
            }
        }
    )
    TextField(streetAddress.value, label = { Text("Street address") },
        modifier = Modifier.focusRequester(streetAddressFocus),
        onValueChange = {
            when {
                it.text.contains('\n') -> cityFocus.requestFocus()
                else -> {
                    streetAddress.value = it
                }
            }
        }
    )
    TextField(city.value, label = { Text("City") },
        modifier = Modifier.focusRequester(cityFocus),
        onValueChange = {
            when {
                it.text.contains('\n') -> postalCodeFocus.requestFocus()
                else -> {
                    city.value = it
                }
            }
        }
    )
    TextField(postalCode.value, label = { Text("Postal code") },
        modifier = Modifier.focusRequester(postalCodeFocus),
        onValueChange = {
            when {
                it.text.contains('\n') -> emailFocus.requestFocus()
                else -> {
                    postalCode.value = it
                }
            }
        }
    )
    TextField(email.value, label = { Text("Email address") },
        modifier = Modifier.focusRequester(emailFocus),
        onValueChange = {
            when {
                it.text.contains('\n') -> usernameFocus.requestFocus()
                else -> {
                    email.value = it
                }
            }
        }
    )
    TextField(username.value, label = { Text("Username") },
        modifier = Modifier.focusRequester(usernameFocus),
        onValueChange = {
            when {
                it.text.contains('\n') -> passwordFocus.requestFocus()
                else -> {
                    username.value = it
                }
            }
        }
    )
    TextField(password.value, label = { Text("Password") }, visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier.focusRequester(passwordFocus),
        onValueChange = {
            when {
                it.text.contains('\n') -> passwordFocus.freeFocus()
                else -> {
                    password.value = it
                }
            }
        }
    )

    OutlinedButton({ navController.navigate("") }, Modifier.padding(all = 4.dp)) {
        Text("Register User")
    }
}
}