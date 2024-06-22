package data.dataSource.tenor.remoteDataSource

import data.network.models.TrendingTermsModels

interface RemoteDataSource {
    suspend fun getTrendingTerms(): TrendingTermsModels
}