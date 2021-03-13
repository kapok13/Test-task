package com.vb.test_task.data.network.model.author


data class Data (

	val is_employee : Boolean,
	val is_friend : Boolean,
	val subreddit : Subreddit,
	val snoovatar_size : List<Int>,
	val awardee_karma : Int,
	val id : String,
	val verified : Boolean,
	val is_gold : Boolean,
	val is_mod : Boolean,
	val awarder_karma : Int,
	val has_verified_email : Boolean,
	val icon_img : String,
	val hide_from_robots : Boolean,
	val link_karma : Int,
	val total_karma : Int,
	val pref_show_snoovatar : Boolean,
	val name : String,
	val created : Int,
	val created_utc : Int,
	val snoovatar_img : String,
	val comment_karma : Int,
	val has_subscribed : Boolean
)