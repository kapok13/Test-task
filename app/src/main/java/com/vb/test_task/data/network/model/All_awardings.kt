package com.vb.test_task.data.network.model

data class All_awardings (

	val giver_coin_reward : Int,
	val subreddit_id : String,
	val is_new : Boolean,
	val days_of_drip_extension : Int,
	val coin_price : Int,
	val id : String,
	val penny_donate : Int,
	val award_sub_type : String,
	val coin_reward : Int,
	val icon_url : String,
	val days_of_premium : Int,
	val tiers_by_required_awardings : String,
	val resized_icons : List<Resized_icons>,
	val icon_width : Int,
	val static_icon_width : Int,
	val start_date : String,
	val is_enabled : Boolean,
	val awardings_required_to_grant_benefits : String,
	val description : String,
	val end_date : String,
	val subreddit_coin_reward : Int,
	val count : Int,
	val static_icon_height : Int,
	val name : String,
	val resized_static_icons : List<Resized_static_icons>,
	val icon_format : String,
	val icon_height : Int,
	val penny_price : Int,
	val award_type : String,
	val static_icon_url : String
)