package domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    @SerialName("nomeProduto") val nameProduct: String,
    @SerialName("sku") val sku: String,
    @SerialName("dataCompra") val buyDate: String,
    @SerialName("idVenda") val id: Long
)