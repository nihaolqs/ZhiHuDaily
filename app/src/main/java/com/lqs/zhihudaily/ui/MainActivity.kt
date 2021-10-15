package com.lqs.zhihudaily.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.lqs.zhihudaily.data.DataRepository
import com.lqs.zhihudaily.theme.ZhiHuDailyTheme
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DailyApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DailyApp()
}