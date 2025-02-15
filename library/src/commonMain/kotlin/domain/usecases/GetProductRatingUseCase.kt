package domain.usecases

import domain.core.UseCase
import domain.models.ProductResponseWrapper
import domain.repositories.ProductInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetProductRatingUseCase(
    scope: CoroutineScope,
    private val repository: ProductInterface
): UseCase<ProductResponseWrapper, Unit>(scope = scope) {
    override fun run(params: Unit?): Flow<ProductResponseWrapper> = repository.getProductRating()
}