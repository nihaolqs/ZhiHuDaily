package com.lqs.zhihudaily.data
import androidx.annotation.Keep

import com.google.gson.annotations.SerializedName


/**
 * @Description:     java类作用描述
 * @Author:         Linqs
 * @CreateDate:     2021/10/9 15:08
 * @UpdateUser:     更新者：
 * @UpdateDate:     2021/10/9 15:08
 * @UpdateRemark:   更新说明：
 */
@Keep
data class NewsBean(
    @SerializedName("date")
    var date: String? = null,
    @SerializedName("stories")
    var stories: List<Story>? = null,
    @SerializedName("top_stories")
    var topStories: List<Story>? = null
)

@Keep
data class Story(
    @SerializedName("ga_prefix")
    var gaPrefix: String? = null,
    @SerializedName("hint")
    var hint: String? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("image_hue")
    var imageHue: String? = null,
    @SerializedName("images")
    var images: List<String>? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("type")
    var type: Int? = null,
    @SerializedName("url")
    var url: String? = null
)