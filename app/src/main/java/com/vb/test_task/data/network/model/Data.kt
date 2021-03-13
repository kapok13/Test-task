package com.vb.test_task.data.network.model

data class Data (

	val modhash : String,
	val dist : Int,
	val children : List<Children>,
	val after : String,
	val before : String
)