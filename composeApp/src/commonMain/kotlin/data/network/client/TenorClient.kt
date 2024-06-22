package data.network.client

import data.network.models.TrendingTermsModels
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


class TenorClient {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    suspend fun getTrendingTerms(): TrendingTermsModels {
        return httpClient.get("https://tenor.googleapis.com/v2/trending_terms").body()
    }
}