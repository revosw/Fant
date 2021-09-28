package ntnu.simenwii.fant.domain.model

import java.util.*

data class Sellable(
    val id: Int = 0,
    val created: Date = Date(),
    val title: String = "",
    val description: String = "",
    val price: Int = 0,
    val photos: List<Photo> = listOf(Photo()),
    val seller: Seller = Seller(),
    val version: String = ""
)