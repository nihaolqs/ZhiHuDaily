package com.lqs.zhihudaily.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lqs.zhihudaily.data.DataRepository
import com.lqs.zhihudaily.data.NewsBean
import com.lqs.zhihudaily.utils.dateStr
import com.lqs.zhihudaily.utils.isToday
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.HashMap

/**
 * @Description:     java类作用描述
 * @Author:         Linqs
 * @CreateDate:     2021/10/9 15:30
 * @UpdateUser:     更新者：
 * @UpdateDate:     2021/10/9 15:30
 * @UpdateRemark:   更新说明：
 */
class NewsViewModel : ViewModel() {

    val dateSequence by lazy {
        val calendar = Calendar.getInstance()
        (0..365).map {
            calendar.add(Calendar.DAY_OF_MONTH, -1)
            calendar.time
        }
    }

    private val _news by lazy {
        MutableLiveData<NewsBean>()
    }

    val news: LiveData<NewsBean> = _news

    private val _selectDate = MutableLiveData(Date().dateStr)
    val selectDate: LiveData<String> = _selectDate

    private val mNewsBeanMap: HashMap<String, NewsBean> by lazy {
        HashMap()
    }

    fun getNews(date: Date) {
        val dateStr = date.dateStr
        _selectDate.postValue(dateStr)
        var news = mNewsBeanMap[dateStr]
        if (news == null) {
            viewModelScope.launch {
                if (date.isToday) {
                    val latest = DataRepository.getLatest()
                    mNewsBeanMap[dateStr] = latest
                    _news.postValue(latest)
                } else {

                }
            }
        } else {
            _news.postValue(news)
        }
    }
}