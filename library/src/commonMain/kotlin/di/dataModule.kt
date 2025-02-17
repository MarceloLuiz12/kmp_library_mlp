package di

import data.repositories.ProductRatingImpl
import data.utils.createHttpClient
import data.utils.defaultConfig
import domain.repositories.ProductRateRepository
import io.ktor.client.HttpClient
import org.koin.dsl.module

val dataModule = module {
    single {
        createHttpClient()
    }
    single<ProductRateRepository> {
        ProductRatingImpl(
            remoteDataSource = get<HttpClient>().config {
                defaultConfig()
            }
        )
    }
}