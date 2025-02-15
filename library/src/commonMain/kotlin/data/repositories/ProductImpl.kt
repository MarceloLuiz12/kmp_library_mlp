package data.repositories

import data.core.GenericResponse
import data.core.ProductConstants.GET_PRODUCT_RATING
import data.core.wrapperGenericResponse
import domain.ProductResponse
import domain.repositories.ProductInterface
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductImpl(
    private val remoteDataSource: HttpClient
): ProductInterface{
    override fun getProductRating(): Flow<ProductResponse> = flow {
        emit(
            wrapperGenericResponse {
                remoteDataSource.get(GET_PRODUCT_RATING)
                    .body<GenericResponse<ProductResponse>>()
            }
        )
    }
}