package dev.zero.practiceforexam.api

import dev.zero.practiceforexam.model.Product
import retrofit2.http.GET

interface ProductApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>
}