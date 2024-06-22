package data.repository.impl

import data.dataSource.tenor.remoteDataSource.RemoteDataSource
import data.repository.TenorRepository
import domain.entities.TrendingTerms

class TenorRepositoryImpl(private val remoteDataSource: RemoteDataSource) : TenorRepository {
    override suspend fun getTrendingTerms(): TrendingTerms {
        val remote = remoteDataSource.getTrendingTerms()

        return TrendingTerms.FromRemote(remote)
    }
}