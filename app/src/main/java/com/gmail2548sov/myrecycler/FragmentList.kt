package com.gmail2548sov.myrecycler

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gmail2548sov.myrecycler.SingltonInfo.listInfo
import kotlinx.android.synthetic.main.fragment_list.view.*

class FragmentList : Fragment() {

    companion object {
        val SOLV = "solv"
        val MID = "mid"
    }

    val myAdapter: MyAdapter = MyAdapter(listInfo)
    lateinit var myrecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("000", "${savedInstanceState.toString()}")
    }

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        Log.d ("123", "${inflater.toString()}, ${container.toString()}, ${savedInstanceState.toString()}")
        val view: View = inflater.inflate(R.layout.fragment_list, container, false)
        myrecyclerView = view.myrecycler
        Log.d("000", "${savedInstanceState.toString()}")
        myrecyclerView.setHasFixedSize(true)
        myrecyclerView.layoutManager = LinearLayoutManager(context)
        setMyAdapter()
        return view
    }

    override fun onResume() {
        super.onResume()
        myAdapter.notifyDataSetChanged()
        Log.d("345", "2")
    }

    fun setMyAdapter() {
        myrecyclerView.adapter = myAdapter
        myAdapter.notifyDataSetChanged()
        Log.d("345", "1")
    }


}