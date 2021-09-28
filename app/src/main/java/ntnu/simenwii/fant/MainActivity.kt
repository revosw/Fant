package ntnu.simenwii.fant

import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.core.content.ContextCompat
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ntnu.simenwii.fant.presentation.ui.component.BottomBar
import ntnu.simenwii.fant.presentation.ui.navigation.screen.MarketplaceViewModel
import ntnu.simenwii.fant.presentation.ui.theme.FantTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val mdl: MarketplaceViewModel by viewModels()

    @Inject
    lateinit var app: BaseApplication

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // https://stackoverflow.com/a/64053897
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        window.statusBarColor = ContextCompat.getColor(this, R.color.gray)

        setContent {
            val navController = rememberNavController()

            FantTheme {
                Scaffold(
                    bottomBar = { BottomBar(navController) },
                    floatingActionButton = {
                        FloatingActionButton(onClick = {
                            navController.navigate("sell")
                        }) {
                            Text("NY")
                        }
                    }
                ) {
                    Navigation(navController)
                }
            }
        }
    }
}