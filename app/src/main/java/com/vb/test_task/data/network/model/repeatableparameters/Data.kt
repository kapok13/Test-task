package com.vb.test_task.data.network.model.repeatableparameters

import com.vb.test_task.data.network.model.Media

data class Data(
    val title: String,
    val name: String,
    val thumbnail: String,
    val author: String,
    val media : Media,
    val is_video: Boolean
)
