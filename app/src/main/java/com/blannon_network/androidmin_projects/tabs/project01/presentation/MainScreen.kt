package com.blannon_network.androidmin_projects.tabs.project01.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.outlined.DownloadDone
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blannon_network.androidmin_projects.TabScreen
import com.blannon_network.androidmin_projects.tabs.project01.ViewModel.RecentViewModel
import com.blannon_network.androidmin_projects.tabs.project01.model.RecentListItem

@Composable
fun MainScreen(recentViewModel: RecentViewModel = RecentViewModel()) {
    val recentListItems by recentViewModel.recentListItems.observeAsState(listOf())


    val tabScreens = listOf(
        TabScreen.Tab1,
        TabScreen.Tab2,
        TabScreen.Tab3
    )


    RecentTab(recentListItems, recentViewModel::toggleFavorite, recentViewModel::toggleSaved)
}

@Composable
fun RecentTab(
    items: List<RecentListItem>,
    onToggleFavorite: (RecentListItem) -> Unit,
    onToggleSaved: (RecentListItem) -> Unit
) {
    LazyColumn(verticalArrangement = Arrangement.Top) {
        items(items) { item ->
            RecentListItem(item, onToggleFavorite, onToggleSaved)
        }
    }
}

@Composable
fun FavouriteTab(
    items: List<RecentListItem>,
    onToggleFavorite: (RecentListItem) -> Unit,
    onToggleSaved: (RecentListItem) -> Unit
) {
    LazyColumn(verticalArrangement = Arrangement.Top) {
        items(items.filter { it.isFav }) { item ->
            RecentListItem(item, onToggleFavorite, onToggleSaved)
        }
    }
}

@Composable
fun DownloadsTab(
    items: List<RecentListItem>,
    onToggleFavorite: (RecentListItem) -> Unit,
    onToggleSaved: (RecentListItem) -> Unit
) {
    LazyColumn(verticalArrangement = Arrangement.Top) {
        items(items.filter { it.isSaved }) { item ->
            RecentListItem(item, onToggleFavorite, onToggleSaved)
        }
    }
}

@Composable
fun RecentListItem(
    item: RecentListItem,
    onToggleFavorite: (RecentListItem) -> Unit,
    onToggleSaved: (RecentListItem) -> Unit
) {
    Card(
        modifier = Modifier.padding(10.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = "Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(size = 10.dp))
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .weight(2f)
            ) {
                Text(
                    text = item.title,
                    style = TextStyle(
                        color = Color(0xFF5c5c5c),
                        fontWeight = FontWeight.W600,
                        fontSize = 16.sp
                    )
                )
                Text(text = item.subtitle,
                    style = TextStyle(
                        color = Color(0xFF5c5c5c),
                    ))
            }
            IconButton(onClick = { onToggleFavorite(item) }) {
                Icon(
                    imageVector = if (item.isFav) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "",
                    tint = Color(0xFFE93224)
                )
            }
            IconButton(onClick = { onToggleSaved(item) }) {
                Icon(
                    imageVector = if (item.isSaved) Icons.Outlined.DownloadDone else Icons.Filled.Download,
                    contentDescription = "",
                    tint = Color(0xFF757474)
                )
            }
        }
    }
}