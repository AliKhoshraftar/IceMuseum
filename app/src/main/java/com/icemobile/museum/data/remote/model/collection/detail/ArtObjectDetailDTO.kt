package com.icemobile.museum.data.remote.model.collection.detail


import androidx.annotation.Keep
import com.icemobile.museum.data.remote.model.collection.share.WebImage
import com.icemobile.museum.domain.model.collection.detail.ArtObjectDetail

@Keep
data class ArtObjectDetailDTO(
    val id: String,
    val links: Links,
    val priref: String,
    val objectNumber: String,
    val language: String,
    val title: String,
    val copyrightHolder: Any?,
    val webImage: WebImage,
    val colors: List<Any>,
    val colorsWithNormalization: List<Any>,
    val normalizedColors: List<Any>,
    val normalized32Colors: List<Any>,
    val titles: List<String>,
    val description: String,
    val labelText: Any?,
    val objectTypes: List<String>,
    val objectCollection: List<String>,
    val makers: List<Any>,
    val principalMakers: List<PrincipalMaker>,
    val plaqueDescriptionDutch: String,
    val plaqueDescriptionEnglish: String,
    val principalMaker: String,
    val artistRole: Any?,
    val associations: List<Any>,
    val acquisition: Acquisition,
    val exhibitions: List<Any>,
    val materials: List<String>,
    val techniques: List<Any>,
    val productionPlaces: List<String>,
    val dating: Dating,
    val classification: Classification,
    val hasImage: Boolean,
    val historicalPersons: List<String>,
    val inscriptions: List<Any>,
    val documentation: List<String>,
    val catRefRPK: List<Any>,
    val principalOrFirstMaker: String,
    val dimensions: List<Dimension>,
    val physicalProperties: List<Any>,
    val physicalMedium: String,
    val longTitle: String,
    val subTitle: String,
    val scLabelLine: String,
    val label: Label,
    val showImage: Boolean,
    val location: String
)

fun ArtObjectDetailDTO.toArtObjectDetail() = ArtObjectDetail(
    id = id,
    objectNumber = objectNumber,
    title = title,
    description = description,
    hasImage = hasImage,
    principalOrFirstMaker = principalOrFirstMaker,
    longTitle = longTitle,
    webImage = webImage
)