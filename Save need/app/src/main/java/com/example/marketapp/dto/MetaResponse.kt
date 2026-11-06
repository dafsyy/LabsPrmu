package com.example.marketapp.dto

data class MetaResponse(
    val total: Int = 0,
    val page: Int = 1,
    val page_size: Int = 20,
    val total_pages: Int = 1
)