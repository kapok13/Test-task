package com.vb.test_task.ui.main.details

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.vb.test_task.R
import com.vb.test_task.databinding.FragmentDetailsBinding
import com.vb.test_task.ui.main.MainActivity

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val listBinding by lazy { FragmentDetailsBinding.bind(requireView()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setSupportActionBar(listBinding.detailsToolbar)
        listBinding.detailsToolbar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_detailsFragment_to_listFragment)
        }
        val header = arguments?.getString("header")
        val body = arguments?.getString("body")
        val imageUrl = arguments?.getString("image")
        val videoUrl = arguments?.getString("video")
        val authorInfo = arguments?.getString("authorInfo")
        (activity as MainActivity).mainVM.initAuthorData(
            authorInfo!!,
            listBinding.detailsTextContent
        )
        if (videoUrl != null && videoUrl.isNotBlank()) initPlayer(videoUrl)
        else initPlayer("https://v.redd.it/qr0u25sq1om61/DASH_720.mp4?source=fallback")
        initItemInfo(header!!, body!!, imageUrl!!)
    }

    private fun initPlayer(url: String) {
        val player = SimpleExoPlayer.Builder(requireContext()).build()
        listBinding.detailsPlayerview.player = player
        player.setMediaItem(MediaItem.fromUri(Uri.parse(url)))
        player.repeatMode = Player.REPEAT_MODE_ALL
        player.prepare()
        player.play()
    }

    private fun initItemInfo(header: String, body: String, imageUrl: String) {
        listBinding.detailsBody.text = body
        listBinding.detailsHeader.text = header
        try {
            Glide.with(requireContext())
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .circleCrop()
                .into(listBinding.detailsImage)
        } catch (e: Exception) {
            listBinding.detailsImage.setImageResource(R.drawable.ic_launcher_background)
        }
    }
}