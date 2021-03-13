package com.vb.test_task.data.network.datasource

import com.vb.test_task.data.network.model.RedditResponse
import com.vb.test_task.data.network.model.author.AuthorResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RedditAPI {

    @GET("top.json")
    suspend fun getTopPosts(): RedditResponse

    @GET("user/{username}/about.json")
    suspend fun getAuthorData(
        @Path("username") username: String
    ) : AuthorResponse
}