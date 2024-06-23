package domain.use_case

import data.repository.TenorRepository
import domain.entities.TrendingTerms

class GetTrendingTermsUseCase(private val tenorRepository: TenorRepository) {

    suspend operator fun invoke(): TrendingTerms {
        return tenorRepository.getTrendingTerms()

    }
}