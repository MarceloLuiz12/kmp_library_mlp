package domain.usecases

import domain.models.ProductResponse
import domain.core.UseCase
import domain.repositories.ProductInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetProductRatingUseCase(
    scope: CoroutineScope,
    private val repository: ProductInterface
): UseCase<ProductResponse, Unit>(scope = scope) {
    override fun run(params: Unit?): Flow<ProductResponse> = repository.getProductRating()
}