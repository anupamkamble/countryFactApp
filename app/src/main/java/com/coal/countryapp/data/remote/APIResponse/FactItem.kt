package com.coal.countryapp.data.remote.APIResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FactItem(

	@SerializedName("imageHref")
	@Expose
	val imageHref: String? = null,

	@SerializedName("description")
	@Expose
	val description: String? = null,

	@SerializedName("title")
	@Expose
	val title: String? = null
)