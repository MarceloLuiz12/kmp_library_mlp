package domain.usecases

import domain.core.UseCase
import domain.models.ProductResponseWrapper
import domain.repositories.ProductRateRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetProductRatingUseCase(
    scope: CoroutineScope,
    private val repository: ProductRateRepository
) : UseCase<ProductResponseWrapper, GetProductRatingUseCase.Params>(scope = scope) {
    override fun run(params: Params?): Flow<ProductResponseWrapper> = repository.getProductRating(
        page = params?.page ?: 0,
        productName = params?.productName ?: "",
        dateFilter = params?.dateFilter ?: 0,
        token = params?.accessToken ?: ""
    )

    data class Params(
        val page: Int,
        val productName: String,
        val dateFilter: Int,
        val accessToken: String
    )
}