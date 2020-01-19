package com.gmail2548sov.myrecycler

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import java.util.*

class ActivityDatalied : MainActivityListAbstract() {

    companion object {
        val MOBJECT = "name"
        val MID = "mid"
    }

    init {
        var intent = MyAdapter.mInt
        Log.d("extra777", "$intent")
        var id = intent.getSerializableExtra(MOBJECT) as UUID
        Log.d("extra777", "${intent}, $id")
        //FragmentDatalied.cid = id
        //Log.d("extra777", "${intent}, $id, ${FragmentDatalied.cid}")
    }

    override fun createFragList(): Fragment {
        return FragmentDatalied()
    }

}