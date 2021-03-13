package com.vb.test_task.data.network.repository

import com.vb.test_task.data.network.datasource.RedditAPI
import com.vb.test_task.domain.model.Author
import com.vb.test_task.domain.model.Post
import com.vb.test_task.domain.repository.RedditRepo
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class RedditRepoImpl(private val redditAPI: RedditAPI) : RedditRepo {

    override suspend fun getPost(): MutableList<Post> {
        val posts = mutableListOf<Post>()
        try {
            redditAPI.getTopPosts().data.children.forEach {
                var videoUrl: String? = null
                if (it.data.is_video) videoUrl = it.data.media.reddit_video.fallback_url
                posts.add(
                    Post(
                        it.data.title,
                        it.data.name,
                        it.data.thumbnail,
                        videoUrl,
                        it.data.author
                    )
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return suspendCoroutine { it.resume(posts) }
    }

    override suspend fun getAuthorData(username: String): Author {
        try {
            val authorData = redditAPI.getAuthorData(username).data
            return suspendCoroutine {
                it.resume(
                    Author(
                        "Author karma: ${authorData.total_karma} " +
                                "\n Author id: ${authorData.id} " +
                                "\n Author name: ${authorData.name}"
                    )
                )
            }
        } catch (e: Exception) {
            return suspendCoroutine {
                it.resume(
                    Author(
                        "Author karma: 0 " +
                                "\n Author id: 0 " +
                                "\n Author name: 0"
                    )
                )
            }
        }


    }


}