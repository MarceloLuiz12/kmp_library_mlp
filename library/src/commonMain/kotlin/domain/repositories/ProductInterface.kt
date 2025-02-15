package domain.repositories

import domain.models.ProductResponseWrapper
import kotlinx.coroutines.flow.Flow

interface ProductInterface {
    fun getProductRating(): Flow<ProductResponseWrapper>
}