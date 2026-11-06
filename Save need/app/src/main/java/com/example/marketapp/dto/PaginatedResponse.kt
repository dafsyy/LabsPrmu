package com.example.marketapp.dto

data class PaginatedResponse<T>(
    val items: List<T> = emptyList(),
    val meta: MetaResponse = MetaResponse()
)