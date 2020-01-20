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

    // val viewPageDetalied: ViewPager = view_page_detalied

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_detalied)
        val viewPageDetalied: ViewPager = view_page_detalied

        val fragmentMeneger = supportFragmentManager
        var id = MyAdapter.mInt.getSerializableExtra(MOBJECT) as UUID
        viewPageDetalied.adapter = (object : FragmentStatePagerAdapter(fragmentMeneger) {
            var pos = SingltonInfo.getId(id)


            override fun getItem(position: Int): Fragment {
                //var detalied = SingltonInfo.listInfo[position]
                //Log.d("mobject", "${position}")
                //var id = MyAdapter.mInt.getSerializableExtra(MOBJECT) as UUID

                var id :UUID = SingltonInfo.listInfo[position].mId

                return FragmentDatalied.newInstance(id)
            }

            override fun getCount(): Int {
                return SingltonInfo.listInfo.size
            }


        })


        for (i in 0..(SingltonInfo.listInfo.size-1)) {
            if (SingltonInfo.listInfo[i].mId==id) {
                viewPageDetalied.setCurrentItem(i)
                break
            }

        }


    }


}