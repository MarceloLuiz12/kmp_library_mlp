package di

import domain.usecases.GetProductRatingUseCase
import data.repositories.ProductImpl
import data.utils.createHttpClient
import data.utils.defaultConfig
import domain.repositories.ProductInterface
import io.ktor.client.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.module

val sharedModule = module {
    //dataModule
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

    //domain module
    single {
        CoroutineScope(Dispatchers.Default + SupervisorJob())
    }
    factory {
        GetProductRatingUseCase(
            scope = get(),
            repository = get()
        )
    }
}