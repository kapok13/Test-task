package com.vb.test_task.domain.model

data class Post(
    val header: String,
    val body: String,
    val image: String?,
    val videoUrl: String?,
    val authorName: String
)