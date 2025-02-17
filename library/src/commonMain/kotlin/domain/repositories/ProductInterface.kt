package domain.repositories

import domain.models.ProductResponseWrapper
import kotlinx.coroutines.flow.Flow

interface ProductInterface {
    fun getProductRating(
        page: Int,
        productName: String,
        dateFilter: Int,
        token: String
    ): Flow<ProductResponseWrapper>
}