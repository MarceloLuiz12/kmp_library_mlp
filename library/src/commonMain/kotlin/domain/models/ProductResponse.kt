package domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductResponseWrapper(
    @SerialName("itens") val items: List<ProductResponse>? = null,
    @SerialName("totalItens") val totalItems: Int? = null,
    @SerialName("paginaAtual") val page: Int? = null,
    @SerialName("totalPaginas") val totalPage: Int? = null
)

@Serializable
data class ProductResponse(
    @SerialName("nomeProduto") val nameProduct: String? = null,
    @SerialName("sku") val sku: String? = null,
    @SerialName("dataCompra") val buyDate: String? = null,
    @SerialName("idVenda") val id: Long? = null
)