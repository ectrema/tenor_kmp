package domain.entities

import data.network.models.TrendingTermsModels

sealed class TrendingTerms(
    val locale: String?,
    val results: List<String>?,
) {
    class FromRemote(private val trendingTermsModels: TrendingTermsModels) : TrendingTerms(
        locale = trendingTermsModels.locale, results = trendingTermsModels.results,
    )
}
