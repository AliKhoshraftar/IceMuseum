package com.icemobile.museum.data.remote.model.collection.detail


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ArtObject(
    @SerializedName("links")
    val links: Links,
    @SerializedName("id")
    val id: String,
    @SerializedName("priref")
    val priref: String,
    @SerializedName("objectNumber")
    val objectNumber: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("copyrightHolder")
    val copyrightHolder: Any?,
    @SerializedName("webImage")
    val webImage: WebImage,
    @SerializedName("colors")
    val colors: List<Any>,
    @SerializedName("colorsWithNormalization")
    val colorsWithNormalization: List<Any>,
    @SerializedName("normalizedColors")
    val normalizedColors: List<Any>,
    @SerializedName("normalized32Colors")
    val normalized32Colors: List<Any>,
    @SerializedName("titles")
    val titles: List<String>,
    @SerializedName("description")
    val description: String,
    @SerializedName("labelText")
    val labelText: Any?,
    @SerializedName("objectTypes")
    val objectTypes: List<String>,
    @SerializedName("objectCollection")
    val objectCollection: List<String>,
    @SerializedName("makers")
    val makers: List<Any>,
    @SerializedName("principalMakers")
    val principalMakers: List<PrincipalMaker>,
    @SerializedName("plaqueDescriptionDutch")
    val plaqueDescriptionDutch: String,
    @SerializedName("plaqueDescriptionEnglish")
    val plaqueDescriptionEnglish: String,
    @SerializedName("principalMaker")
    val principalMaker: String,
    @SerializedName("artistRole")
    val artistRole: Any?,
    @SerializedName("associations")
    val associations: List<Any>,
    @SerializedName("acquisition")
    val acquisition: Acquisition,
    @SerializedName("exhibitions")
    val exhibitions: List<Any>,
    @SerializedName("materials")
    val materials: List<String>,
    @SerializedName("techniques")
    val techniques: List<Any>,
    @SerializedName("productionPlaces")
    val productionPlaces: List<String>,
    @SerializedName("dating")
    val dating: Dating,
    @SerializedName("classification")
    val classification: Classification,
    @SerializedName("hasImage")
    val hasImage: Boolean,
    @SerializedName("historicalPersons")
    val historicalPersons: List<String>,
    @SerializedName("inscriptions")
    val inscriptions: List<Any>,
    @SerializedName("documentation")
    val documentation: List<String>,
    @SerializedName("catRefRPK")
    val catRefRPK: List<Any>,
    @SerializedName("principalOrFirstMaker")
    val principalOrFirstMaker: String,
    @SerializedName("dimensions")
    val dimensions: List<Dimension>,
    @SerializedName("physicalProperties")
    val physicalProperties: List<Any>,
    @SerializedName("physicalMedium")
    val physicalMedium: String,
    @SerializedName("longTitle")
    val longTitle: String,
    @SerializedName("subTitle")
    val subTitle: String,
    @SerializedName("scLabelLine")
    val scLabelLine: String,
    @SerializedName("label")
    val label: Label,
    @SerializedName("showImage")
    val showImage: Boolean,
    @SerializedName("location")
    val location: String
)