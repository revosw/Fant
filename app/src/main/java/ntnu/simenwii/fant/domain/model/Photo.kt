package ntnu.simenwii.fant.domain.model

import java.sql.Timestamp
import java.util.*

data class Photo(
    val id: Int = 0,
    val subpath: String = "http://simen:8080/fant/25c5d3a3-bc18-4a09-87f7-aec6d54929e4",
    val version: Timestamp = Timestamp(Date().time),
    val created: Date = Date(),
)
