package di

import data.repositories.ProductImpl
import data.utils.createHttpClient
import data.utils.defaultConfig
import domain.repositories.ProductInterface
import io.ktor.client.HttpClient
import org.koin.dsl.module

val dataModule = module {
    single {
        createHttpClient()
    }
    single<ProductInterface> {
        ProductImpl(
            remoteDataSource = get<HttpClient>().config {
                defaultConfig()
            }
        )
    }
}