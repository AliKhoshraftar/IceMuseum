package com.icemobile.museum.presentation.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.icemobile.museum.domain.model.collection.list.ArtObject
import com.icemobile.museum.R

@Composable
fun CollectionListItem(
    art: ArtObject,
    onItemClick: (ArtObject) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(10.dp),
    ) {
        Card(elevation = 10.dp,
            modifier = Modifier
                .clickable { onItemClick(art) }
        ) {
            Image(
                painter = rememberImagePainter(data = art.headerImage.url,
                    builder = {
                        crossfade(800)
                    }),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Transparent,
                                Color.Black
                            )
                        )
                    ),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Bottom)
                        .padding(start = 10.dp, bottom = 10.dp)
                ) {
                    Text(
                        text = art.title,
                        style = MaterialTheme.typography.h3,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                    Spacer(modifier = Modifier.height(7.dp))
                    Text(
                        text = art.principalOrFirstMaker,
                        style = MaterialTheme.typography.subtitle2,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }
            }
        }
    }
}