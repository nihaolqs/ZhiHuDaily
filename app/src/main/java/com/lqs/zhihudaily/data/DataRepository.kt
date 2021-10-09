package com.lqs.zhihudaily.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @Description:     java类作用描述
 * @Author:         Linqs
 * @CreateDate:     2021/10/9 14:52
 * @UpdateUser:     更新者：
 * @UpdateDate:     2021/10/9 14:52
 * @UpdateRemark:   更新说明：
 */
object DataRepository : Api {
    val api by lazy {
        val builder = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
        val okHttpClient = builder.build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://news-at.zhihu.com/api/4/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(Api::class.java)
    }

    override suspend fun getLatest(): NewsBean {
        return api.getLatest()
    }
}