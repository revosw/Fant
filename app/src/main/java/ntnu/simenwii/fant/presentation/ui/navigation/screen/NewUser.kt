package ntnu.simenwii.fant.presentation.ui.navigation.screen

import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ntnu.simenwii.fant.presentation.ui.account.LoginFields
import ntnu.simenwii.fant.presentation.ui.account.LoginViewModel

@Composable
fun NewUser(
    fields: LoginFields,
    onCreateUser: () -> Unit,
    onFieldChange: () -> Unit,
) {
    val focusManager = LocalFocusManager.current;

    /**
     * Depending on which key is pressed, handle it.
     *
     * On enter: go to next field
     * On any alphanumeric or symbolic key: insert character
     */
    fun handleTextField(field: MutableState<TextFieldValue>, it: TextFieldValue) {
        when {
            it.text.contains('\n') -> focusManager.moveFocus(FocusDirection.Down)
            else -> {
                field.value = it
            }
        }
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp)
    ) {
        val firstname = remember { mutableStateOf(TextFieldValue("")) }
        val lastname = remember { mutableStateOf(TextFieldValue("")) }
        val streetAddress = remember { mutableStateOf(TextFieldValue("")) }
        val city = remember { mutableStateOf(TextFieldValue("")) }
        val postalCode = remember { mutableStateOf(TextFieldValue("")) }
        val email = remember { mutableStateOf(TextFieldValue("")) }
        val username = remember { mutableStateOf(TextFieldValue(username!!)) }
        val password = remember { mutableStateOf(TextFieldValue(password!!)) }

        TextField(firstname.value, isError = true, label = { Text("First Name") },
            onValueChange = { handleTextField(firstname, it) }
        )
        TextField(lastname.value, label = { Text("Last Name") },
            onValueChange = { handleTextField(lastname, it) }
        )
        TextField(streetAddress.value, label = { Text("Street address") },
            onValueChange = { handleTextField(streetAddress, it) }
        )
        TextField(city.value, label = { Text("City") },
            onValueChange = { handleTextField(city, it) }
        )
        TextField(postalCode.value, label = { Text("Postal code") },
            onValueChange = { handleTextField(postalCode, it) }
        )
        TextField(email.value, label = { Text("Email address") },
            onValueChange = { handleTextField(email, it) }
        )
        TextField(username.value, label = { Text("Username") },
            onValueChange = { handleTextField(username, it) }
        )
        TextField(password.value, label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = { handleTextField(password, it) }
        )

        // Outlined button is normally not focusable. That means pressing
        // enter when the last field is focused doesn't hide the virtual keyboard.
        // .focusable() fixes that
        OutlinedButton({ navController.navigate("newuser?username=$username&password=$password") },
            Modifier
                .padding(all = 4.dp)
                .focusable()
        ) {
            Text("Register User")
        }
    }
}