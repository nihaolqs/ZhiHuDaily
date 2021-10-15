package com.lqs.zhihudaily.data
import androidx.annotation.Keep

import com.google.gson.annotations.SerializedName


/**
 * @Description:     java类作用描述
 * @Author:         Linqs
 * @CreateDate:     2021/10/11 16:43
 * @UpdateUser:     更新者：
 * @UpdateDate:     2021/10/11 16:43
 * @UpdateRemark:   更新说明：
 */
@Keep
data class DetailyBean(
    @SerializedName("body")
    var body: String? = null,
    @SerializedName("css")
    var css: List<String>? = null,
    @SerializedName("ga_prefix")
    var gaPrefix: String? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("image")
    var image: String? = null,
    @SerializedName("image_hue")
    var imageHue: String? = null,
    @SerializedName("image_source")
    var imageSource: String? = null,
    @SerializedName("images")
    var images: List<String>? = null,
    @SerializedName("js")
    var js: List<Any>? = null,
    @SerializedName("share_url")
    var shareUrl: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("type")
    var type: Int? = null,
    @SerializedName("url")
    var url: String? = null
)