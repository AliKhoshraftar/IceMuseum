package com.icemobile.museum.data.remote.model.collection.detail


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class PrincipalMaker(
    @SerializedName("name")
    val name: String,
    @SerializedName("unFixedName")
    val unFixedName: String,
    @SerializedName("placeOfBirth")
    val placeOfBirth: String,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("dateOfBirthPrecision")
    val dateOfBirthPrecision: Any?,
    @SerializedName("dateOfDeath")
    val dateOfDeath: String,
    @SerializedName("dateOfDeathPrecision")
    val dateOfDeathPrecision: Any?,
    @SerializedName("placeOfDeath")
    val placeOfDeath: String,
    @SerializedName("occupation")
    val occupation: List<String>,
    @SerializedName("roles")
    val roles: List<String>,
    @SerializedName("nationality")
    val nationality: String,
    @SerializedName("biography")
    val biography: Any?,
    @SerializedName("productionPlaces")
    val productionPlaces: List<String>,
    @SerializedName("qualification")
    val qualification: Any?
)