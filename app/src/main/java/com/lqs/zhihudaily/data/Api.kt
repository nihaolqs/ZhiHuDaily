package com.lqs.zhihudaily.data

import retrofit2.http.GET
import retrofit2.http.Path

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

    @GET("news/before/{date}")
    suspend fun getNewsByDate(
        @Path("date") date: String
    ): NewsBean

    @GET("news/{id}")
    suspend fun getDetaily(
        @Path("id") id: String
    ): DetailyBean
}