package com.example.marketapp.dto

data class ItemResponse(
    val id: Int = 0,
    val title: String = "",
    val description: String? = null,
    val price: Double = 0.0,
    val deal_type: String = "",
    val photo_url: String? = null,
    val category: CategoryResponse = CategoryResponse(),
    val author: AuthorResponse = AuthorResponse()
)