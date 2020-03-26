package com.example.spacerocketssolo.Model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class SpaceResponse(

	@SerializedName("mission_name")
	val missionName: String? = null,

//	@Json(name="static_fire_date_utc")
//	val staticFireDateUtc: String? = null,
//
//	@Json(name="launch_year")
//	val launchYear: String? = null,

//	@Json(name="launch_date_utc")
//	val launchDateUtc: String? = null,
//
//	@Json(name="launch_failure_details")
//	val launchFailureDetails: LaunchFailureDetails? = null,
//
//	@Json(name="flight_number")
//	val flightNumber: Int? = null,
//
//	@Json(name="is_tentative")
//	val isTentative: Boolean? = null,
//
	@SerializedName("rocket")
	val rocket: Rocket? = null,
//
//	@Json(name="mission_id")
//	val missionId: List<Any?>? = null,
//
//	@Json(name="launch_window")
//	val launchWindow: Int? = null,
//
//	@Json(name="crew")
//	val crew: Any? = null,
//
	@SerializedName("launch_date_local")
	val launchDateLocal: String? = null,
//
//	@Json(name="tentative_max_precision")
//	val tentativeMaxPrecision: String? = null,
//
//	@Json(name="ships")
//	val ships: List<Any?>? = null,
//
//	@Json(name="launch_date_unix")
//	val launchDateUnix: Int? = null,
//
//	@Json(name="launch_success")
//	val launchSuccess: Boolean? = null,
//
//	@Json(name="static_fire_date_unix")
//	val staticFireDateUnix: Int? = null,
//
//	@Json(name="tbd")
//	val tbd: Boolean? = null,
//
//	@Json(name="timeline")
//	val timeline: Timeline? = null,
//
//	@Json(name="telemetry")
//	val telemetry: Telemetry? = null,
//
	@SerializedName("links")
	val links: Links? = null,
//
	@SerializedName("details")
	val details: String? = null,
//
	@SerializedName("launch_site")
	val launchSite: LaunchSite? = null,

	@SerializedName("upcoming")
	val upcoming: Boolean? = null
)