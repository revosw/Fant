package ntnu.simenwii.fant.presentation.ui.account

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ntnu.simenwii.fant.network.LoginService
import org.w3c.dom.Text
import javax.inject.Inject

/**
 * This viewmodel saves the fields in the login and new user screens,
 * as well as communicates with the login service
 */
@HiltViewModel
class LoginViewModel @Inject constructor(
    val loginService: LoginService
) : ViewModel() {

    var fields = mutableStateOf(LoginFields())

    fun onFieldChange(fields: LoginFields) {

    }

    fun onUsernameChange(newUsername: String) {
        username.value = newUsername
        println("UASEASME CHANGED: ${username.value}")
    }

    fun onPasswordChange(newPassword: String) {
        password.value = newPassword
        println("PASSWORD CHANGED: ${password.value}")
    }

    fun onLogin(navOnLogin: () -> Unit) {
//        navOnLogin(username, password)
    }
}

data class LoginFields(
    val username: TextFieldValue,
    val password: TextFieldValue,
    val firstName: TextFieldValue,
    val lastName: TextFieldValue,
    val streetAddress: TextFieldValue,
    val city: TextFieldValue,
    val postalCode: TextFieldValue,
    val email: TextFieldValue
)