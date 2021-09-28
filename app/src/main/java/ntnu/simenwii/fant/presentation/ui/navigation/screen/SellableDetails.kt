package ntnu.simenwii.fant.presentation.ui.navigation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import ntnu.simenwii.fant.presentation.ui.component.Details
import ntnu.simenwii.fant.domain.model.Sellable
import ntnu.simenwii.fant.util.formatNOK

@Composable
fun SellableDetails(sellable: Sellable) {
    Column {
        // IMAGE
        Details(sellable)
        Text(sellable.title, fontSize = 25.sp)
        Text(sellable.description)
        Text(formatNOK(sellable.price))
    }
}