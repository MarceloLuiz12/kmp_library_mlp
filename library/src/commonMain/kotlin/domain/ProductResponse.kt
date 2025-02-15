package domain

import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    val nomeProduto: String,
    val sku: String,
    val imagem: String?,
    val dataCompra: String,
    val idVenda: Long
)