package ntnu.simenwii.fant.presentation.ui.navigation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.airbnb.lottie.compose.*
import ntnu.simenwii.fant.DataProvider
import ntnu.simenwii.fant.R
import ntnu.simenwii.fant.domain.model.Sellable

class MarketplaceViewModel : ViewModel() {

}

@ExperimentalMaterialApi
@Composable
fun Marketplace(marketplaceViewModel: MarketplaceViewModel, onClick: (Int) -> Unit) {
    _Marketplace(DataProvider.productList, onClick)
    _Marketplace(products = listOf(Sellable()), onClick = {})
}

@ExperimentalMaterialApi
@Composable
fun _Marketplace(products: List<Sellable>, onClick: (Int) -> Unit) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.error404))

    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
//    val scrollpos = rememberScrollState()
    val sellables = remember { DataProvider.productList }
    LazyColumn(
//        Modifier.verticalScroll(scrollpos),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            LottieAnimation(composition = composition, progress = progress)
        }
//        items(items = sellables) {
//            MarketListItem(
//                toSell = it,
//                onClick = { onClick(it.id) })
//        }
    }
}