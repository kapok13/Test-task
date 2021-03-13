package com.vb.test_task.domain.repository

import com.vb.test_task.domain.model.Author
import com.vb.test_task.domain.model.Post

interface RedditRepo {
    suspend fun getPost(): MutableList<Post>
    suspend fun getAuthorData(username: String): Author
}