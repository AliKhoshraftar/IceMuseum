package com.icemobile.museum.data

import com.icemobile.museum.data.remote.model.collection.list.*
import com.icemobile.museum.data.remote.model.collection.share.WebImage

class FakeData {
    companion object {
        fun getCollectionDTO(): CollectionsDTO =
            CollectionsDTO(
                0, 10, CountFacets(10, 10),
                listOf(
                    ArtObjectDTO(
                        id = "en-BB-A-22",
                        links = Links("test", "test"),
                        objectNumber = "BB-A-22",
                        title = "Title",
                        hasImage = true,
                        principalOrFirstMaker = "Principal",
                        longTitle = "Long Title",
                        showImage = true,
                        permitDownload = true,
                        webImage = WebImage("GUID", 10, 10, 100, 100, "url"),
                        headerImage = HeaderImage("GUID", 10, 10, 100, 100, "url"),
                        productionPlaces = listOf(
                            "1",
                            "2"
                        )
                    ),
                    ArtObjectDTO(
                        id = "en-BB-A-21",
                        links = Links("test1", "test1"),
                        objectNumber = "BB-A-23",
                        title = "Title1",
                        hasImage = true,
                        principalOrFirstMaker = "Principal1",
                        longTitle = "Long Title1",
                        showImage = true,
                        permitDownload = true,
                        webImage = WebImage("GUID1", 10, 10, 100, 100, "url1"),
                        headerImage = HeaderImage("GUID1", 10, 10, 100, 100, "url1"),
                        productionPlaces = listOf(
                            "3",
                            "4"
                        )
                    )
                ), listOf(
                    Facet(listOf(), "name", 10, 10)
                )
            )
    }
}