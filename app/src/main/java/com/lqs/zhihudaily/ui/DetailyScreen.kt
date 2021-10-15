package com.lqs.zhihudaily.ui

import android.content.ClipData
import android.text.Html
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.lqs.zhihudaily.data.DetailyBean

/**
 * @Description:     java类作用描述
 * @Author:         Linqs
 * @CreateDate:     2021/10/11 15:52
 * @UpdateUser:     更新者：
 * @UpdateDate:     2021/10/11 15:52
 * @UpdateRemark:   更新说明：
 */
@Composable
fun DetailyScreen(detaily: State<DetailyBean?>) {
    LazyColumn() {
        item {
            Image(
                painter = rememberImagePainter(data = detaily.value?.image ?: ""),
                contentDescription = "image",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            )
        }
        item {
            Text(
                text = Html.fromHtml(detaily.value?.body ?: "").toString(),
                style = TextStyle(fontSize = 14.sp, textIndent = TextIndent(28.sp)),
                modifier = Modifier.padding(16.dp)
            )
        }

    }

}
