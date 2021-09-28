package ntnu.simenwii.fant

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import ntnu.simenwii.fant.presentation.ui.account.LoginScreen
import ntnu.simenwii.fant.presentation.ui.account.LoginViewModel
import ntnu.simenwii.fant.presentation.ui.navigation.screen.*

@ExperimentalMaterialApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "marketplace") {
        composable(route = "login") {
            val loginViewModel: LoginViewModel = hiltViewModel()
            LoginScreen(
                model = loginViewModel,
                onLogin = {un, pw -> /* LOG IN, MEANING GET TOKEN FROM SERVER AND STORE IN DATA STORE */ },
                onStartUserRegistration = { un: String, pw: String -> navController.navigate("newuser?username=$un&password=$pw") }
            )
        }
        composable(
            route = "newuser?username={username}&password={password}",
            arguments = listOf(
                navArgument("username") {
                    type = NavType.StringType
                    defaultValue = ""
                },
                navArgument("password") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            val loginViewModel: LoginViewModel = hiltViewModel()
            loginViewModel.
            NewUser(
                loginViewModel = loginViewModel,
                onFieldChange = { it },
                onCreateUser = { it },
                username = it.arguments?.getString("username"),
                password = it.arguments?.getString("password")
            )
        }
        composable(
            route = "marketplace",
//            arguments = listOf(
//                navArgument("username") {
//                    type = NavType.StringType
//                    defaultValue = ""
//                    nullable = true
//                }
//            )
        ) {
            val marketplaceViewModel: MarketplaceViewModel = hiltViewModel()
            Marketplace(marketplaceViewModel) {
                navController.navigate(route = "item/$it")
            }
        }
        composable(
            route = "item/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) {
            val sellableId = it.arguments?.getInt("id")
            sellableId?.let { id ->
                SellableDetails(DataProvider.productList[id-1])
            }
        }
        composable("home") {
            Home()
        }
        composable("sell") {
            val sellViewModel: SellViewModel = hiltViewModel()
            Sell(sellViewModel, onClick = {})
        }
    }
}