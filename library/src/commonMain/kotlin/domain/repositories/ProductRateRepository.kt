package domain.repositories

import domain.models.ProductResponseWrapper
import kotlinx.coroutines.flow.Flow

interface ProductRateRepository {
    fun getProductRating(
        page: Int,
        productName: String,
        dateFilter: Int,
        token: String
    ): Flow<ProductResponseWrapper>
}