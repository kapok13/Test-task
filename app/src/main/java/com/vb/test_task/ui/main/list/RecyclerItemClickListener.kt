package com.vb.test_task.ui.main.list

interface RecyclerItemClickListener {
    fun onItemClicked(
        imageUrl: String?,
        header: String,
        body: String,
        videoUrl: String?,
        authorInfo: String
    )
}