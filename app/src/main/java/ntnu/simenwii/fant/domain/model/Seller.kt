package ntnu.simenwii.fant.domain.model

data class Seller(
    val created : String = "",
    val currentState : String = "",
    val groups : List<Group> = listOf(),
    val userid : String = "",
    val version : String = ""
)
