package domain.repositories

import domain.models.ProductResponse
import kotlinx.coroutines.flow.Flow

interface ProductInterface {
    fun getProductRating(): Flow<ProductResponse>
}