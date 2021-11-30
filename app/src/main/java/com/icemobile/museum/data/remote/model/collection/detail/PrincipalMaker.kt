package com.icemobile.museum.data.remote.model.collection.detail


import androidx.annotation.Keep

@Keep
data class PrincipalMaker(
    val name: String,
    val unFixedName: String,
    val placeOfBirth: String,
    val dateOfBirth: String,
    val dateOfBirthPrecision: Any?,
    val dateOfDeath: String,
    val dateOfDeathPrecision: Any?,
    val placeOfDeath: String,
    val occupation: List<String>,
    val roles: List<String>,
    val nationality: String,
    val biography: Any?,
    val productionPlaces: List<String>,
    val qualification: Any?
)