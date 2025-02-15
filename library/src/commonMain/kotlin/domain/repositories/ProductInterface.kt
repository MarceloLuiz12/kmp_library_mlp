package domain.repositories

import domain.ProductResponse
import kotlinx.coroutines.flow.Flow

interface ProductInterface {
    fun getProductRating(): Flow<ProductResponse>
}