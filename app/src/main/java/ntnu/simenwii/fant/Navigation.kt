package ntnu.simenwii.fant

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import ntnu.simenwii.fant.screen.Login
import ntnu.simenwii.fant.screen.Marketplace
import ntnu.simenwii.fant.screen.NewUser

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable(route = "login") {
            Login(navController)
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
            NewUser(
                navController = navController,
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
            Marketplace(navController)
        }
    }
}