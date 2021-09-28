package ntnu.simenwii.fant.network.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SellerDto (
    @SerializedName("created") val created : String,
    @SerializedName("currentState") val currentState : String,
    @SerializedName("groups") val groups : List<GroupDto>,
    @SerializedName("userid") val userid : String,
    @SerializedName("version") val version : String
) : Parcelable