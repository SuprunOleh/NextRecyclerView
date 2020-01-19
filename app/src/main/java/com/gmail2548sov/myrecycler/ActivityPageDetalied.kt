package com.gmail2548sov.myrecycler

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.page_detalied.*
import java.util.*

class ActivityPageDetalied : AppCompatActivity() {


    companion object {
        val MOBJECT = "name"
        val MID = "mid"
    }

    val viewPageDetalied: ViewPager = view_page_detalied


    init {
        var intent = MyAdapter.mInt
        Log.d("extra777", "$intent")
        var id = intent.getSerializableExtra(MOBJECT) as UUID
        Log.d("extra777", "${intent}, $id")
        //FragmentDatalied.cid = id
        //Log.d("extra777", "${intent}, $id, ${FragmentDatalied.cid}")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_detalied)

        val fragmentMeneger = supportFragmentManager
        viewPageDetalied.adapter = (object : FragmentStatePagerAdapter(fragmentMeneger) {
            override fun getItem(position: Int): Fragment {
               // var detalied = SingltonInfo.listInfo[position]
                return FragmentDatalied.newInstance(MyAdapter.mInt.getSerializableExtra(MOBJECT) as UUID)
            }

            override fun getCount(): Int {
                return SingltonInfo.listInfo.size
            }


        })


    }


}