package com.heyoh.model.home

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Add @JsonClass(generateAdapter = true) annotation to all data classes
 * Which are going to participate in the serializing/deserializing JSON process.
 * This helps Moshi to use code-gen and not to use reflection which will increase the speed of the process.
 */
@JsonClass(generateAdapter = true)
data class Author(
    val id: String,
    @Json(name="first_name") val firstName: String,
    @Json(name="last_name") val lastName: String,
    @Json(name="image_url") val imgUrl: String,
    val description: String
)
