package ntnu.simenwii.fant.network.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class SellableDto(
    @SerializedName("id") val id : Int = 0,
    @SerializedName("created") val created : Date = Date(),
    @SerializedName("title") val title : String = "",
    @SerializedName("description") val description: String = "",
    @SerializedName("price") val price : Int = 0,
    @SerializedName("photos") val photos : List<PhotoDto> = listOf(PhotoDto()),
    @SerializedName("seller") val seller : SellerDto,
    @SerializedName("version") val version : String
) : Parcelable


