package com.lqs.zhihudaily.data

import retrofit2.http.GET

/**
 * @Description:     java类作用描述
 * @Author:         Linqs
 * @CreateDate:     2021/10/9 14:43
 * @UpdateUser:     更新者：
 * @UpdateDate:     2021/10/9 14:43
 * @UpdateRemark:   更新说明：
 */
interface Api {
    @GET("news/latest")
    suspend fun getLatest(): NewsBean
}