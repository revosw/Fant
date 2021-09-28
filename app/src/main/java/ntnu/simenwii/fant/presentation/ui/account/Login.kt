package ntnu.simenwii.fant.presentation.ui.account

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

//suspend fun readStore(token: DataStore<Preferences>) {
//    token.edit {
//        it[stringPreferencesKey("jwtToken")] = "hew"
//    }
//}

suspend fun writeStore(store: DataStore<Preferences>, key: String, newValue: String) {
    store.edit {
        it[stringPreferencesKey(key)] = newValue
    }
}



@Composable
fun LoginScreen(
    model: LoginViewModel = viewModel(),
    onLogin: (username: String, password: String) -> Unit,
    onStartUserRegistration: (username: String, password: String) -> Unit) {
//    if (model.token.value.isNullOrBlank()) {
//
//    }
    Login(model,
        onLogin = { onLogin(model.username.value, model.password.value) },
        onStartUserRegistration = { onStartUserRegistration(model.username.value, model.password.value) })
}

/**
 * This screen is where you log in to your profile. You reach
 * it by pressing the rightmost button in the BottomNav.
 */
@Composable
fun Login(model: LoginViewModel, onLogin: () -> Unit, onStartUserRegistration: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Fant", fontSize = 130.sp, modifier = Modifier.padding(bottom = 60.dp))

        TextField(value = model.username.value, label = { Text("Username") }, onValueChange = { model.onUsernameChange(it) })
        TextField(value = model.password.value, label = { Text("Password") }, visualTransformation = PasswordVisualTransformation(), onValueChange = { model.onPasswordChange(it) })

        OutlinedButton(onClick = onLogin, Modifier.padding(all = 4.dp)) {
            Text("Log In")
        }
        TextButton(onClick = onStartUserRegistration) {
            Text("New user? Register here")
        }
    }
}

@Composable
fun logInHandler(username: String, password: String, navController: NavController, context: Context) {
    navController.navigate("marketplace")
}

//@Composable
//suspend fun loginServerRequest() {
//    val key = stringPreferencesKey("token")
//    val client = OkHttpClient.Builder().build()
//}