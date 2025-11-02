package com.example.demo.dto

data class TodoCreateRequest(
    val title: String,
    val description: String? = null
)

data class TodoUpdateRequest(
    val title: String?,
    val description: String?,
    val isDone: Boolean?
)

data class TodoResponse(
    val id: Long,
    val title: String,
    val description: String?,
    val isDone: Boolean
)
