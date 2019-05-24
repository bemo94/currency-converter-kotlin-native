package com.octo.project.converter

import com.octo.project.app.Rates
import io.ktor.client.HttpClient
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.client.response.HttpResponse
import io.ktor.client.response.readText
import io.ktor.http.HttpMethod
import io.ktor.http.Url
import kotlinx.io.core.use
import kotlinx.serialization.json.Json

class ConverterRepositoryImpl : ConverterRepository {

    companion object {
        private const val SUCCESS = 200
    }

    private val client = HttpClient()
    private val address = Url("https://api.exchangeratesapi.io/latest?base=")

    override suspend fun convert(base: String): Response = client.request<HttpResponse> {
        method = HttpMethod.Get
        url(address.toString() + base)
    }.use { response ->
        when(response.status.value) {
            SUCCESS -> {
                val json = response.readText()
                println(json)
                val rates =  Json.parse(Rates.serializer(), json)
                Response.Result(rates)
            }
            else -> Response.Error
        }
    }
}