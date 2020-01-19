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
class FragmentList: Fragment(){

    companion object {
       // lateinit var msetContect:Context
        val SOLV = "solv"
        val MID = "mid"
        }


    //val listInfo = SingltonInfo.listInfo
    val myAdapter: MyAdapter = MyAdapter(listInfo)
    lateinit var myrecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_list, container, false)
        Log.d ("333", "onCreateView")
        myrecyclerView = view.findViewById(R.id.myrecycler)
        myrecyclerView.setHasFixedSize(true)
        myrecyclerView.layoutManager = LinearLayoutManager(context)
        setMyAdapter()
        return view
    }

    override fun onResume() {
        super.onResume()
        myAdapter.notifyDataSetChanged()
        Log.d ("345", "2")
    }


    fun setMyAdapter(){

        myrecyclerView.adapter = myAdapter
        myAdapter.notifyDataSetChanged()
        Log.d ("345", "1")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d ("Des","fun Frag_onDestroy")
    }

}