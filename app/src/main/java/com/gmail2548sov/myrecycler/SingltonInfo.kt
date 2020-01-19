package com.gmail2548sov.myrecycler

import android.util.Log
import java.util.*
import kotlin.collections.ArrayList

object SingltonInfo {
    val listInfo: ArrayList<InfoPreview> = ArrayList()

    init {
        for (i in 0..99) {
            var s = if (i % 2 == 0) true else false
            Log.d("true", "${s.toString()}")
            var info: InfoPreview = InfoPreview(UUID.randomUUID(), "${i + 1}", Date(), s)
            listInfo.add(info)

        }
    }

    fun getId(id: UUID): InfoPreview? {
        for (n in listInfo) if (n.mId == id) return n
        return null
    }
}








