package com.coal.countryapp.data.remote.APIResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FactResponse(

	@SerializedName("title")
	@Expose
	val title: String? = null,

	@SerializedName("rows")
	@Expose
	val rows: List<FactItem?>? = null
)