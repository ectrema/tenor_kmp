package data.repository

import domain.entities.TrendingTerms

interface TenorRepository {
    suspend fun getTrendingTerms(): TrendingTerms
}