package ntnu.simenwii.fant.presentation.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ntnu.simenwii.fant.domain.model.Sellable
import ntnu.simenwii.fant.network.model.SellableDto
import ntnu.simenwii.fant.util.formatNOK

@ExperimentalMaterialApi
@Composable
fun MarketListItem(toSell: Sellable, onClick: () -> Unit) {
    Card(onClick = onClick, modifier = Modifier.fillMaxWidth()) {
        Row(Modifier.padding(8.dp)) {
            Details(toSell)
            Column {
                Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = toSell.title, fontSize = 25.sp)
                    Text(formatNOK(toSell.price))
                }
                Text(toSell.description)
            }
        }
    }
}