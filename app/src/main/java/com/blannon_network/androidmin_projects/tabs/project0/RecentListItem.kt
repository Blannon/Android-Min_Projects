package com.blannon_network.androidmin_projects.tabs.project0

data class RecentListItem(
    val id: Int,
    val title: String,
    val subtitle: String,
    val image: Int,
    val isFav: Boolean = false,
    val isSaved: Boolean = false
)