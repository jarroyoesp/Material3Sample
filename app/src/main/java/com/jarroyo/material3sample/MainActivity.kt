@file:OptIn(ExperimentalMaterial3Api::class)

package com.jarroyo.material3sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.jarroyo.material3sample.ui.theme.Material3SampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            Material3SampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val scrollState = rememberLazyListState()
                    val topBarState = rememberTopAppBarState()
                    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(topBarState)
                    Scaffold(
                        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                        topBar = {
                            TopAppBar(
                                title = "Title",
                                // Use statusBarsPadding() to move the app bar content below the status bar
                                //modifier = Modifier.statusBarsPadding(),
                                scrollBehavior = scrollBehavior,
                            )
                        },
                    ) { scaffoldPadding ->
                        LazyColumn(
                            Modifier
                                .fillMaxSize()
                                .nestedScroll(scrollBehavior.nestedScrollConnection),
                            state = scrollState,
                            contentPadding = PaddingValues(
                                top = scaffoldPadding.calculateTopPadding(),
                                bottom = scaffoldPadding.calculateBottomPadding(),
                            ),
                        ) {
                            for (pos in 0..20) {
                                item {
                                    Text("Android $pos", modifier = Modifier.height(80.dp))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Material3SampleTheme {
        Greeting("Android")
    }
}