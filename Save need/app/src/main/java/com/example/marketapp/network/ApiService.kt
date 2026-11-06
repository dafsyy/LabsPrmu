package com.example.marketapp.network

import com.example.marketapp.dto.ItemResponse
import com.example.marketapp.dto.PaginatedResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("items")
    fun getItems(
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int,
        @Query("category_id") categoryId: Int?
    ): Call<PaginatedResponse<ItemResponse>>
}