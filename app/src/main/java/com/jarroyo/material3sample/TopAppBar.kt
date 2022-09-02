@file:OptIn(ExperimentalMaterial3Api::class)

package com.jarroyo.material3sample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.jarroyo.material3sample.ui.theme.Material3SampleTheme

@Composable
fun TopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    onNavigateUp: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    colors: TopAppBarColors = TopAppBarDefaults.smallTopAppBarColors(),
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
//    val systemUiController = rememberSystemUiController()
//    systemUiController.setStatusBarColor(MaterialTheme.colorScheme.surface) // TODO
    SmallTopAppBar(
        title = {
            Column {
                Text(
                    text = title,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                )
                if (!subtitle.isNullOrEmpty()) {
                    Text(
                        text = subtitle,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 2,
                        style = MaterialTheme.typography.titleMedium,
                    )
                }
            }
        },
        modifier = modifier,
        navigationIcon = onNavigateUp?.let {
            {
                IconButton(
                    onClick = it,
                ) {
                }
            }
        } ?: {},
        actions = actions,
        windowInsets = windowInsets,
        colors = colors,
        scrollBehavior = scrollBehavior,
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewTopAppBarWithNavigationIcon() {
    Material3SampleTheme {
        TopAppBar(
            title = "Page title",
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewTopAppBarWithSubtitle() {
    Material3SampleTheme {
        TopAppBar(
            title = "Page title",
            subtitle = "Page subtitle",
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewTopAppBarWithAction() {
    Material3SampleTheme {
        TopAppBar(
            title = "Page title",
            actions = {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Share, contentDescription = "")
                }
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewTopAppBarWithNavigationIconAndAction() {
    Material3SampleTheme {
        TopAppBar(
            title = "Page title",
            actions = {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Share, contentDescription = "")
                }
            },
            onNavigateUp = { },
        )
    }
}
