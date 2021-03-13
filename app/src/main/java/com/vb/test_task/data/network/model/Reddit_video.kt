package com.vb.test_task.data.network.model


data class Reddit_video (

	val bitrate_kbps : Int,
	val fallback_url : String,
	val height : Int,
	val width : Int,
	val scrubber_media_url : String,
	val dash_url : String,
	val duration : Int,
	val hls_url : String,
	val is_gif : Boolean,
	val transcoding_status : String
)