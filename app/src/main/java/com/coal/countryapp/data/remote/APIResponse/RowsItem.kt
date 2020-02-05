package com.coal.countryapp.data.remote.APIResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RowsItem(

	@SerializedName("imageHref")
	@Expose
	val imageHref: String? = null,

	@field:SerializedName("description")
	@Expose
	val description: String? = null,

	@field:SerializedName("title")
	@Expose
	val title: String? = null
)