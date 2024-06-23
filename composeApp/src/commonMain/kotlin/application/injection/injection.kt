package application.injection

import data.dataSource.tenor.remoteDataSource.RemoteDataSource
import data.dataSource.tenor.remoteDataSource.impl.RemoteDataSourceImpl
import data.network.client.TenorClient
import data.repository.TenorRepository
import data.repository.impl.TenorRepositoryImpl
import domain.use_case.GetTrendingTermsUseCase
import org.koin.dsl.module

val appModule = module {
    single<TenorClient> { TenorClient() }
    single<RemoteDataSource> {
        RemoteDataSourceImpl(
            client = get(),
        )
    }
    single<TenorRepository> {
        TenorRepositoryImpl(
            remoteDataSource = get(),
        )
    }
    single<GetTrendingTermsUseCase> {
        GetTrendingTermsUseCase(
            tenorRepository = get(),
        )
    }
}
