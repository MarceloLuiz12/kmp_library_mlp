package usecases

import domain.models.ProductResponseWrapper
import domain.usecases.GetProductRatingUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetProductRatingIOSHelperUseCase : KoinComponent {

    private val getProductRatingUseCase by inject<GetProductRatingUseCase>()
    fun fetchProduct(
        page: Int,
        productName: String,
        dateFilter: Int,
        token: String,
        success: (ProductResponseWrapper) -> Unit,
        error: (Throwable) -> Unit
    ) = getProductRatingUseCase(
        params = GetProductRatingUseCase.Params(
            page = page,
            productName = productName,
            dateFilter = dateFilter,
            accessToken = token
        ),
        onSuccess = { success.invoke(it) },
        onError = { error.invoke(it) }
    )
}