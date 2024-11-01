//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.AccessTime
//import androidx.compose.material.icons.filled.Download
//import androidx.compose.material.icons.filled.Favorite
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardElevation
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.unit.dp
//import com.blannon_network.androidmin_projects.R
//
//data class RecentListItem(
//    val id: Int,
//    val title: String,
//    val subtitle: String,
//    val image: Int,
//    val isFav: Boolean = false,
//    val isSaved: Boolean = false
//)
//
//val recentListItems = listOf(
//    RecentListItem(
//        1,
//        "apple",
//        "Lorem ipsum",
//        R.drawable.apple,
//        isFav = true,
//        isSaved = true
//    ),
//    RecentListItem(2, "facebook", "Lorem ipsum", R.drawable.facebook, isSaved = true),
//    RecentListItem(3, "starbucks", "Lorem ipsum", R.drawable.ic_starbucks, isFav = true),
//    RecentListItem(4, "google", "Lorem ipsum", R.drawable.google),
//    RecentListItem(5, "netflix", "Lorem ipsum", R.drawable.ic_netflix, isSaved = true),
//)
//
//sealed class TabScreen(
//    val title: String,
//    val icon: ImageVector,
//    val screen: @Composable () -> Unit,
//) {
//    object Tab1 : TabScreen("Recent", Icons.Filled.AccessTime, screen = { RecentTab() })
//    object Tab2 : TabScreen("Favourite", Icons.Filled.Favorite, screen = { FavouriteTab() })
//    object Tab3 : TabScreen("Downloads", Icons.Filled.Download, screen = { DownloadsTab() })
//}
//
//
//
//@Composable
//fun RecentTab() {
//    LazyColumn(
//        verticalArrangement = Arrangement.Top
//    ) {
//        items(recentListItems) { item ->
//            RecentListItem(item)
//        }
//
//    }
//}
//
//@Composable
//fun FavouriteTab() {
//    LazyColumn(
//        verticalArrangement = Arrangement.Top
//    ) {
//        items(recentListItems) { item ->
//            if(item.isFav) {
//                RecentListItem(item)
//            }
//        }
//    }
//}
//
//@Composable
//fun DownloadsTab() {
//    LazyColumn(
//        verticalArrangement = Arrangement.Top
//    ) {
//        items(recentListItems) { item ->
//            if(item.isSaved) {
//                RecentListItem(item)
//            }
//        }
//    }
//}
//
//
//@Composable
//fun RecentListItem(item: RecentListItem) {
//    Card(
//        modifier = Modifier.padding(10.dp),
//        shape = RoundedCornerShape(10.dp),
//        elevation = CardElevation(6.dp)
//    ) {
//        Row(
//            modifier = Modifier
//                .padding(12.dp)
//                .fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Image(
//                painter = painterResource(id = item.image),
//                contentDescription = "Image",
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .size(60.dp)
//                    .clip(RoundedCornerShape(size = 10.dp))
//            )
//            Column(
//                modifier = Modifier
//                    .padding(horizontal = 15.dp)
//                    .weight(2f)
//            ) {
//                Text(
//                    text = item.title,
//                    style = TextStyle(
//                        color = Color(0xFF5c5c5c),
//                        fontWeight = FontWeight.W600,
//                        fontSize = 16.sp
//                    )
//                )
//                Text(text = item.subtitle,
//                    style = TextStyle(
//                        color = Color(0xFF5c5c5c),
//                    ))
//            }
//            IconButton(
//                onClick = {}
//            ) {
//                Icon(
//                    imageVector = if (item.isFav) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder,
//                    contentDescription = "",
//                    tint = Color(0xFFE93224)
//                )
//            }
//            IconButton(
//                onClick = {}
//            ) {
//                Icon(
//                    imageVector = if (item.isSaved) Icons.Outlined.DownloadDone else Icons.Filled.Download,
//                    contentDescription = "",
//                    tint = Color(0xFF757474)
//                )
//            }
//        }
//    }
//}
//
//arrange the codes in mvvm structure and also explain each code and how it works