package com.icemobile.museum.presentation.util

import com.icemobile.museum.data.remote.model.collection.share.WebImage
import com.icemobile.museum.domain.model.collection.detail.ArtObjectDetail

class FakeData {
    companion object {

        fun getFakeArt(objectNumber: String): ArtObjectDetail {
            return arts.random()
        }

        private val arts = listOf(
            ArtObjectDetail(
                id = "en-BK-AM-33",
                objectNumber = "BK-AM-33",
                title = "Weepers from the tomb of Isabella of Bourbo",
                description = "Weepers from the tomb of Isabella of Bourbon, Borman workshop (attributed to), Renier van Thienen (I) (attributed to), c. 1475 - c. 1476".repeat(
                    30
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
            ),
            ArtObjectDetail(
                id = "en-NG-444",
                objectNumber = "NG-444",
                title = "Chest with nine bottles",
                description = "Chest with nine bottles, anonymous, c. 1680 - c. 1700".repeat(
                    30
                ),
                hasImage = true,
                principalOrFirstMaker = "anonymous",
                longTitle = "Chest with nine bottles, anonymous, c. 1680 - c. 1700",
                webImage = WebImage(
                    "5b29ba1c-4c23-49c6-8bb6-2253ddbb560b",
                    offsetPercentageX = 0,
                    offsetPercentageY = 0,
                    width = 2500,
                    height = 1328,
                    url = "https://lh4.ggpht.com/zj4XExq5RGqvpQZO-gH2HsJ10eSJeGDrbuz4WSBsU0G_eSJGGVrseRSHUJFD2UouStnTSscr70Xz4M7GLWtBrmU3Zw=s0"
                )
            ),
            ArtObjectDetail(
                id = "en-SK-C-1368",
                objectNumber = "SK-C-1368",
                title = "Portraits of Giuliano and Francesco Giamberti da Sangallo",
                description = "Portraits of Giuliano and Francesco Giamberti da Sangallo, Piero di Cosimo, 1482 - 1485".repeat(
                    30
                ),
                hasImage = true,
                principalOrFirstMaker = "anonymous",
                longTitle = "Chest with nine bottles, anonymous, c. 1680 - c. 1700",
                webImage = WebImage(
                    "5b29ba1c-4c23-49c6-8bb6-2253ddbb560b",
                    offsetPercentageX = 0,
                    offsetPercentageY = 0,
                    width = 2500,
                    height = 1328,
                    url = "https://lh3.googleusercontent.com/N2m90mImdcoLacUybb_rxcktTwtr0LFhtuzxbSE9elIhElF6jpWngx96_uZ0L1TGNof5pNt4n_Ygb4KYlPTpA9o6788=s0"
                )
            )
        )
    }
}