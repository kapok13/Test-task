package com.vb.test_task.ui.main.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.vb.test_task.R
import com.vb.test_task.databinding.RecyclerItemPostBinding
import com.vb.test_task.domain.model.Post
import kotlin.random.Random

class ListRecAdapter(
    private val context: Context,
    private val posts: MutableList<Post>,
    private val callback: RecyclerItemClickListener
) : RecyclerView.Adapter<ListRecAdapter.PostsViewHolder>() {

    inner class PostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerBinding = RecyclerItemPostBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder =
        PostsViewHolder(
            LayoutInflater.from(context).inflate(R.layout.recycler_item_post, parent, false)
        )

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        with(posts[position]) {
            holder.setIsRecyclable(false)
            val randomBanner = Random.nextInt(20)
            if (position != 0 && randomBanner == 6) {
                holder.recyclerBinding.recyclerCardView.visibility = View.GONE
                holder.recyclerBinding.recyclerAds.apply {
                    visibility = View.VISIBLE
                    loadAd(AdRequest.Builder().build())
                }
            } else {
                holder.recyclerBinding.recyclerTitle.text = header
                holder.recyclerBinding.recyclerBody.text = body
                try {
                    Glide.with(holder.itemView.context)
                        .load(image)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .circleCrop()
                        .into(holder.recyclerBinding.recyclerImage)
                } catch (e: Exception) {
                    holder.recyclerBinding.recyclerImage.setImageResource(R.drawable.ic_launcher_background)
                }
                holder.itemView.setOnClickListener {
                    callback.onItemClicked(
                        image,
                        header,
                        body,
                        videoUrl,
                        authorName
                    )
                }
            }
        }
    }

    override fun getItemCount() = posts.size
}