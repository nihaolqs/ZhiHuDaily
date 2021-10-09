package com.lqs.zhihudaily.utils

import java.lang.ref.WeakReference
import java.text.SimpleDateFormat
import java.util.*

/**
 * @Description:     java类作用描述
 * @Author:         Linqs
 * @CreateDate:     2021/10/9 15:38
 * @UpdateUser:     更新者：
 * @UpdateDate:     2021/10/9 15:38
 * @UpdateRemark:   更新说明：
 */

val Date.isToday: Boolean
    get() {
        val today = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
        }
        val star = today.timeInMillis
        today.add(Calendar.DAY_OF_MONTH, 1)
        val end = today.timeInMillis
        return this.time in star until end
    }

private var dateFormat: WeakReference<SimpleDateFormat>? = null
    get() {
        if (field == null || field?.get() == null) {
            field = WeakReference(SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()))
        }
        return field
    }


val Date.dateStr: String
    get() {
        return dateFormat?.get()?.format(this) ?: ""
    }