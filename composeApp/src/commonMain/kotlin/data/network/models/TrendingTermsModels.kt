package data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrendingTermsModels(
    @SerialName("locale")
    val locale: String? = null,
    @SerialName("results")
    val results: List<String>? = null,
)