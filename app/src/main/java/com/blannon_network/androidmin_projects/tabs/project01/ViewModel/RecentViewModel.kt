package com.blannon_network.androidmin_projects.tabs.project01.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blannon_network.androidmin_projects.R
import com.blannon_network.androidmin_projects.tabs.project01.model.RecentListItem

class RecentViewModel : ViewModel() {
    private val _recentListItems = MutableLiveData(
        listOf(
            RecentListItem(
                1,
                "apple",
                "Lorem ipsum",
                R.drawable.apple,
                isFav = true,
                isSaved = true
            ),
            RecentListItem(2, "facebook", "Lorem ipsum", R.drawable.facebook, isSaved = true),
            RecentListItem(3, "starbucks", "Lorem ipsum", R.drawable.ic_starbucks, isFav = true),
            RecentListItem(4, "google", "Lorem ipsum", R.drawable.google),
            RecentListItem(5, "netflix", "Lorem ipsum", R.drawable.ic_netflix, isSaved = true),
        )
    )


    val recentListItems: LiveData<List<RecentListItem>> = _recentListItems


    fun toggleFavorite(item: RecentListItem) {
        _recentListItems.value = _recentListItems.value?.map {
            if (it.id == item.id) it.copy(isFav = !it.isFav) else it
        }
    }


    fun toggleSaved(item: RecentListItem) {
        _recentListItems.value = _recentListItems.value?.map {
            if (it.id == item.id) it.copy(isSaved = !it.isSaved) else it
        }
    }
}