package ntnu.simenwii.fant.presentation.ui.navigation.screen

import android.graphics.Bitmap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import com.skydoves.landscapist.glide.GlideImage
import ntnu.simenwii.fant.domain.model.Photo
import ntnu.simenwii.fant.domain.model.Sellable


class SellViewModel : ViewModel() {
    var sellable = mutableStateOf(Sellable())
        private set

    fun onChanged(newSellable: Sellable) {
        this.sellable.value = newSellable
    }
}

@Composable
fun Sell(sellViewModel: SellViewModel, onClick: (String) -> Unit) {
    val result = remember { mutableStateOf<Bitmap?>(null) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) {
        val newPhoto = Photo()
        sellViewModel.sellable.value = sellViewModel.sellable.value.copy(photos = listOf(Photo()))
    }

    _Sell(
        sellable = sellViewModel.sellable.value,
        onChange = {
            sellViewModel.sellable.value = it
        },
        onTakePicture = { launcher.launch() }
    )
}

@Composable
private fun _Sell(sellable: Sellable, onChange: (Sellable) -> Unit, onTakePicture: () -> Unit) {

    Column {
        TextField(value = sellable.title, onValueChange = { onChange(sellable.copy(title = it)) })
        TextField(value = sellable.description, onValueChange = { onChange(sellable.copy(description = it)) })
        TextField(value = sellable.price.toString(), onValueChange = { onChange(sellable.copy(price = Integer.parseInt(it))) })
        Button(onClick = onTakePicture) {
            Text("Take picture")

        }
        sellable.photos.forEach {
            GlideImage(imageModel = it)
        }
    }
}