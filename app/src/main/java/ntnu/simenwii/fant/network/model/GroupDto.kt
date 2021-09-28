package ntnu.simenwii.fant.network.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GroupDto (
    @SerializedName("name") val name : String
) : Parcelable