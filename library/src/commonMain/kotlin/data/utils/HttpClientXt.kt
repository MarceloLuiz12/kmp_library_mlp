package data.utils

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import data.core.Core

fun createHttpClient(): HttpClient {
    val client = HttpClient {
        install(Logging) {
            level = LogLevel.ALL
        }

        install(HttpTimeout) {
            requestTimeoutMillis = 60000
            connectTimeoutMillis = 60000
            socketTimeoutMillis = 60000
        }

        install(ContentNegotiation) {
            json(
                Json {
                    isLenient = true
                    prettyPrint = true
                    ignoreUnknownKeys = true
                }
            )
        }

        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            header(HttpHeaders.Authorization, "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IkE4MkY4NjREMEU4Qjc5RUQ2OTZGRENDRDdCMEFBRTEzRUE3OEVEMTUiLCJ0eXAiOiJKV1QifQ.eyJuYW1lIjoiSkVGRkVSU1NPTiIsImp0aSI6IjVjOTZhNjgyLTNmZDktNDk5ZS05MWJiLTAyNDliMjAyN2U5YiIsIm5iZiI6MTczOTYyNjg1OSwiaWF0IjoxNzM5NjI2ODU5LCJhdF9oYXNoIjoiSUlnSEY3TUNRQ0ZpU2wyRWxJNXZjNFR5TElTYmpyU2I4cjVmTGN1NS9kVzRxSVVicWprbmVBd3A3ZDZEM21udHpIaThubkFhUkhPdm1ZYU84M0RMSWxLdVVWMnNUZ1BZWXkxVFlaU2F1ZytGK1RLVkFLWW5kQ2NLRkpqNzNhVkJYY0Y5UVFyQ2lCbmF1dE1OOXBCbUJKZHQ3S2h6N1BYV0VNbzJ0ZEJXUE5oNVY5ZENwTkt4c01SSnp2YVIyd0RCZUprVDR0Q2gwbkpyelNJTzdOclhmZEd3YTVYMVp6SVYxVXVuaUF1ZmJMM1J0UXZMQnZiNFBERFBaZllMaEg5ZVpneVVUNWQ2NktkNXdMQmw3U2Zpc29GcjUxSTA0cEFMUWsvR3Mwa3hNNnBKU2RFd1V6Z3dzbXEvdVpCSFQwd2pLMXl4aWJZNUIyWG9CQzh2b29FV2FjZEI0Q3Zqb1o0TlNsTmI2eHFwMFdvcXhDOG1pdWpDUlVHbUdpSENFMGFMQStJR3J0QjNBdU10RG40bHd3RUlKODZxV3d3NVNYUjJrSzE2K1RsaUtVUT0iLCJPcmlnZW0iOiJBcHBIYXZhbiIsIldpdGhDYXJkIjoiVHJ1ZSIsIkJldGFUZXN0ZXIiOiJUcnVlIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvYXV0aG9yaXphdGlvbmRlY2lzaW9uIjoiV2l0aENhcmQiLCJleHAiOjE3Mzk3MTMyNTksImlzcyI6Imh0dHBzOi8vYXBwLWhhdmFuLWlkZW50aXR5LXNlcnZlcjo1MDAxLyJ9.ZgvRZ24RRToNVWocavIzvpY0wuNC9G_ZDbvhtMqBGYxhNEPY67SWPN99NcfUO7TzMFdfmOI_nodE6fF8IBpRCwuwg16-bxh12Cu-d8WlrHbKtwrfjQqPrbfb5x7V4dm89ljRrUUqf3O64or5zi0mbuQ0DLgCXym1PV-dANWYMXzFOwdJ2kjSoORmm2woLxtxLrzXBlpXMsRSJ2VTCJLri8-sZYHCiDa1qg5azVuvAZgvFvjAuUhPuJGFjhOdpl0Nhu8_fK07v8bJfFO7VIshI3NT-ld60EmPjLZ3VV0fPev8Q2E4NkaUR__mRLUMGEf4ygJe9MLlIbQzNL_CYrbxeQ")
        }
    }

    return client
}

fun HttpClientConfig<*>.defaultConfig() {
    defaultRequest {
        url {
            protocol = URLProtocol.HTTPS
            host = Core.BASE_URL
        }
    }
}