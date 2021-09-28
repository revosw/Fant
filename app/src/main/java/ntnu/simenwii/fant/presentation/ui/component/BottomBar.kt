package ntnu.simenwii.fant.presentation.ui.component

import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ntnu.simenwii.fant.R

/**
 * Bottom navigation bar of the app.
 * Controls which part of the app is active.
 */
@Composable
fun BottomBar(navController: NavController) {
    val selectedItem = remember { mutableStateOf("marketplace") }
    BottomNavigation() {
        BottomNavigationItem(
            label = { Text("Home") },
            icon = {
                Icon(
                    modifier = Modifier.height(25.dp),
                    painter = painterResource(R.drawable.ic_house),
                    contentDescription = "House"
                )
            },
            selected = selectedItem.value == "home",
            onClick = {
                if (selectedItem.value != "home") {
                    selectedItem.value = "home"
                    navController.navigate("home")
                }
            },

        )
        BottomNavigationItem(
            label = { Text("Marketplace") },
            icon = {
                Icon(
                    modifier = Modifier.height(25.dp),
                    painter = painterResource(R.drawable.ic_marketplace),
                    contentDescription = "Marketplace"
                )
            },
            selected = selectedItem.value == "marketplace",
            onClick = {
                if (selectedItem.value != "marketplace") {
                    selectedItem.value = "marketplace"
                    navController.navigate("marketplace")
                }
            }
        )
        BottomNavigationItem(
            label = { Text("Profile") },
            icon = {
                Icon(
                    modifier = Modifier.height(25.dp),
                    painter = painterResource(R.drawable.ic_profile),
                    contentDescription = "Profile"
                )
            },
            selected = selectedItem.value == "profile",
            onClick = {
                if (selectedItem.value != "profile") {
                    selectedItem.value = "profile"
                    navController.navigate("login")
                }
            }
        )
    }
}