package data.repositories

import data.core.GenericResponse
import data.core.ProductConstants.GET_PRODUCT_RATING
import data.core.wrapperGenericResponse
import domain.models.ProductResponseWrapper
import domain.repositories.ProductInterface
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.http.HttpHeaders
import io.ktor.http.parameters
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductImpl(
    private val remoteDataSource: HttpClient
) : ProductInterface {
    override fun getProductRating(
        page: Int,
        productName: String,
        dateFilter: Int,
        token: String
    ): Flow<ProductResponseWrapper> = flow {
        emit(
            wrapperGenericResponse {
                remoteDataSource.get(GET_PRODUCT_RATING) {
                    parameters {
                        append("nomeProduto", productName)
                        append("filtroData", dateFilter.toString())
                        append("pagina", page.toString())
                    }

                    headers {
                        append(HttpHeaders.Authorization, "Bearer $token")
                    }
                }.body<GenericResponse<ProductResponseWrapper>>()
            }
        )
    }
}