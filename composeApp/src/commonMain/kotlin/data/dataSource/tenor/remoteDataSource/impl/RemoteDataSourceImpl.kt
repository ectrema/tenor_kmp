package data.dataSource.tenor.remoteDataSource.impl

import data.dataSource.tenor.remoteDataSource.RemoteDataSource
import data.network.client.TenorClient
import data.network.models.TrendingTermsModels

class RemoteDataSourceImpl(val client: TenorClient) : RemoteDataSource {
    override suspend fun getTrendingTerms(): TrendingTermsModels {
        return client.getTrendingTerms()
    }
}