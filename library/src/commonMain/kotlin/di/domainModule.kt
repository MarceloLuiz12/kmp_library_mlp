package di

import domain.usecases.GetProductRatingUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.module

val domainModule = module {
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