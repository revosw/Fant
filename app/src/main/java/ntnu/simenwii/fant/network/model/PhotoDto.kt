package ntnu.simenwii.fant.network.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.sql.Timestamp
import java.util.*

@Parcelize
data class PhotoDto(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("subpath") val subpath: String = "http://simen:8080/fant/25c5d3a3-bc18-4a09-87f7-aec6d54929e4",
    @SerializedName("version") val version: String = Timestamp(Date().time).toString(),
    @SerializedName("created") val created: String = Date().toString(),
) : Parcelable