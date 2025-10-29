package com.example.animelist.utils.helpers

import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow

@Composable
fun rememberInfiniteScroll(
    gridState: LazyGridState,
    onLoadMore: () -> Unit
) {
    LaunchedEffect(gridState) {
        snapshotFlow {
            val lastVisible = gridState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
            val total = gridState.layoutInfo.totalItemsCount
            lastVisible to total
        }.collect { (last, total) ->
            if (last != null && last >= total - 3) {
                onLoadMore()
            }
        }
    }
}
