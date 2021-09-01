package ntnu.simenwii.fant

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Bottom navigation bar of the app.
 * Controls which part of the app is active.
 */
@Preview
@Composable
fun BottomBar() {
    val selectedItem = remember { mutableStateOf("marketplace") }
    BottomNavigation() {
        BottomNavigationItem(
            label = {
                Text("Marketplace")
            },
            icon = {
                Icon(
                    modifier = Modifier.height(25.dp),
                    painter = painterResource(R.drawable.ic_house),
                    contentDescription = "House"
                )
            },
            selected = selectedItem.value == "marketplace",
            onClick = {
                selectedItem.value = "marketplace"
                println("Clicked nav item")
            }
        )
        BottomNavigationItem(
            label = {
                Text("Home")
            },
            icon = {
                Icon(
                    modifier = Modifier.height(25.dp),
                    painter = painterResource(R.drawable.ic_house),
                    contentDescription = "House"
                )
            },
            selected = selectedItem.value == "marketplace",
            onClick = {
                selectedItem.value = "marketplace"
                println("Clicked nav item")
            }
        )
        BottomNavigationItem(
            label = {
                Text("Profile")
            },
            icon = {
                Icon(
                    modifier = Modifier.height(25.dp),
                    painter = painterResource(R.drawable.ic_house),
                    contentDescription = "House"
                )
            },
            selected = selectedItem.value == "profile",
            onClick = {
                selectedItem.value = "profile"
                println("Clicked nav item")
            }
        )
    }
}