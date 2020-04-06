package com.cardona.leagueteamsapp.frameworks.retrofit.dto

import com.google.gson.annotations.SerializedName

data class ResponseDTO(
	@field:SerializedName("teams")
	val teams: List<TeamDTO>
)