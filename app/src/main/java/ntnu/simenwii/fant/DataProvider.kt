package ntnu.simenwii.fant

import ntnu.simenwii.fant.domain.model.Sellable
import ntnu.simenwii.fant.domain.model.Seller
import java.util.*

object DataProvider {
    val productList =
        listOf(
            Sellable(
                id = 1,
                title = "Jakke",
                description = "Har ikkje bruk for denna lengre",
                price = 800,
                created = Date(),
                seller = Seller()
            ),
            Sellable(
                id = 2,
                title = "Moderna vaksine",
                description = "Etter besten daua så donerer eg denne",
                price = 0,
                created = Date()
            ),
            Sellable(
                id = 3,
                title = "Mjøsa",
                description = "Eg var feit av peng en gang i tida, men no begynner det å gå tomt. Pris kan ikkje diskuteres",
                price = 43000000,
                created = Date()
            ),
            Sellable(
                id = 4,
                title = "iPhone 12 Max Pro",
                description = "iPhone 12 Max Pro",
                price = 5400,
                created = Date()
            ),
            Sellable(
                id = 5,
                title = "Nvidia GTX 970",
                description = "Ingen problemer, kjøpt 2015",
                price = 1000,
                created = Date()
            ),
        )
}