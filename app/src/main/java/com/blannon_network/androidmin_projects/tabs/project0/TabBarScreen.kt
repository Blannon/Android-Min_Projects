package com.blannon_network.androidmin_projects.tabs.project0

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.blannon_network.androidmin_projects.TabScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TabBarScreen(
) {
    val tabs = listOf(TabScreen.Tab1, TabScreen.Tab2, TabScreen.Tab3)
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {

        }
    ) {
        Column() {
            TabRow(
                selectedTabIndex = pagerState.currentPage,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                    )
                },
            ) {
                tabs.forEachIndexed { index, item ->
                    Tab(
                        selected = pagerState.currentPage == index,
                        onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                        icon = {
                            Icon(imageVector = item.icon, contentDescription = "")
                        },
                        text = {
                            Text(
                                text = item.title,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                    )
                }
            }
            HorizontalPager(
                state = pagerState, count = tabs.size,
                verticalAlignment = Alignment.Top,
                modifier = Modifier.padding(top = 10.dp)

            ) { page ->
                tabs[page].screen()
            }
        }

    }
}

