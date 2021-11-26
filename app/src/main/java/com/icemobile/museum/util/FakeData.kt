package com.icemobile.museum.util

import com.icemobile.museum.data.remote.model.collection.share.WebImage
import com.icemobile.museum.domain.model.collection.detail.ArtObjectDetail

class FakeData {
    companion object {
        fun getFakeArt(objectNumber: String): ArtObjectDetail {
            return arts[0]
        }

        private val arts = listOf(
            ArtObjectDetail(
                id = "en-BK-AM-33",
                objectNumber = "BK-AM-33",
                title = "Weepers from the tomb of Isabella of Bourbo",
                description = "Weepers from the tomb of Isabella of Bourbon, Borman workshop (attributed to), Renier van Thienen (I) (attributed to), c. 1475 - c. 1476".repeat(
                    10
                ),
                hasImage = true,
                principalOrFirstMaker = "Borman workshop, Renier van Thienen (I)",
                longTitle = "Weepers from the tomb of Isabella of Bourbon, Borman workshop (attributed to), Renier van Thienen (I) (attributed to), c. 1475 - c. 1476",
                webImage = WebImage(
                    "5b29ba1c-4c23-49c6-8bb6-2253ddbb560b",
                    offsetPercentageX = 0,
                    offsetPercentageY = 0,
                    width = 2500,
                    height = 1328,
                    url = "https://lh5.ggpht.com/LE3ggDaLAIwTIOknJm06U2Y_qNffQ0133bWQxnWfDtzi12uWE85MYWtYwvo8eQZx1tc-U-vH_-2ZIoDGYUUrs8YklQ=s0"
                )
            )
        )
    }
}