package com.lqs.zhihudaily.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lqs.zhihudaily.data.NewsBean
import com.lqs.zhihudaily.data.Story
import com.lqs.zhihudaily.theme.Purple500
import com.lqs.zhihudaily.theme.ZhiHuDailyTheme
import com.lqs.zhihudaily.utils.dateStr
import java.util.*

/**
 * @Description:     java类作用描述
 * @Author:         Linqs
 * @CreateDate:     2021/10/9 16:59
 * @UpdateUser:     更新者：
 * @UpdateDate:     2021/10/9 16:59
 * @UpdateRemark:   更新说明：
 */

@Composable
fun News(newsViewModel: NewsViewModel = viewModel()) {
    Column {
        Spacer(modifier = Modifier.height(5.dp))
        NewsGroup(
            newsViewModel.dateSequence,
            newsViewModel.selectDate.observeAsState(),
            onClick = newsViewModel::getNews
        )
        Spacer(modifier = Modifier.height(5.dp))

        NewsList(newsViewModel.news.observeAsState())
    }

}

@Composable
fun NewsGroup(groups: List<Date>, selectDate: State<String?>, onClick: (Date) -> Unit) {
    LazyRow {
        items(groups) {
            val text = it.dateStr
            val isSelect = text == selectDate.value
            val textColor = if (isSelect) {
                Purple500
            } else {
                Color.Gray
            }
            Text(
                text = text, modifier = Modifier
                    .clickable {
                        onClick(it)
                    }
                    .padding(5.dp),
                color = textColor,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
fun NewsList(news: State<NewsBean?>) {
    news.value?.stories?.let {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(it) { story ->
                StoryCard(story)
            }
        }
    }
}

@Composable
fun StoryCard(story: Story) {

}

@Preview(showBackground = true)
@Composable
fun NewsPreview() {
    ZhiHuDailyTheme {
        News()
    }
}