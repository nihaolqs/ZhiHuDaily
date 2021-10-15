package com.lqs.zhihudaily.ui

import androidx.lifecycle.*
import com.lqs.zhihudaily.data.DataRepository
import com.lqs.zhihudaily.data.DetailyBean
import kotlinx.coroutines.launch

/**
 * @Description:     java类作用描述
 * @Author:         Linqs
 * @CreateDate:     2021/10/11 16:47
 * @UpdateUser:     更新者：
 * @UpdateDate:     2021/10/11 16:47
 * @UpdateRemark:   更新说明：
 */
class DetailyViewModel : ViewModel() {
    private val _detailyBean by lazy {
        MutableLiveData<DetailyBean>()
    }

    val detailyBean: LiveData<DetailyBean> = _detailyBean

    fun getStoryDetaily(id: String) {
        viewModelScope.launch {
            val detaily = DataRepository.getDetaily(id)
            _detailyBean.postValue(detaily)
        }
    }
}