package com.example.spacerocketssolo.Model

import com.squareup.moshi.Json

data class FirstStage(

	@Json(name="cores")
	val cores: List<CoresItem?>? = null
)