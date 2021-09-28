package ntnu.simenwii.fant.network.response

import com.google.gson.annotations.SerializedName
import ntnu.simenwii.fant.network.model.SellableDto

data class SellableSearchResponse(
    @SerializedName("count") var count: Int,
    @SerializedName("results") var sellables: List<SellableDto>
)