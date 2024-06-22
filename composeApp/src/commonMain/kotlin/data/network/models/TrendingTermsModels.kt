package data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrendingTermsModels(
    @SerialName("locale")
    val locale: String?,
    @SerialName("results")
    val results: List<String>?,
)