package com.gmail2548sov.myrecycler

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.content.Intent.getIntent
import android.content.Intent.makeRestartActivityTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuView
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*
import java.security.AccessControlContext
import java.security.AccessController.getContext

class MyAdapter(private val points: ArrayList<InfoPreview>) :
    RecyclerView.Adapter<MyAdapter.MyHolder>() {

    companion object {
        val RESPONS = 1
        lateinit var mAct: Context
        lateinit var mInt: Intent
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        Log.d("Holder", "onCreate")
        return MyHolder(layoutInflater.inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int {
        Log.d("Holder", "getItem")
        return points.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        Log.d("Holder", "onBind")
        holder.bind(position)
        Log.d(
            "sss",
            "${position + 1};_ ${points[position].title.toString()};_ ${points[position].isSolved.toString()}, $"
        )
        //var viev: View = holder.itemView

        holder.itemView.setOnClickListener {

            val xcontext = mAct
            xcontext as Activity

            var intent = Intent(xcontext,ActivityDatalied::class.java)
            mInt = intent
            intent.putExtra(ActivityDatalied.MOBJECT, points[position].mId)
            xcontext.startActivityForResult(intent, RESPONS)

            Toast.makeText(xcontext, holder.itemView.item_list.text.toString(), Toast.LENGTH_SHORT).show()

            }
    }

    inner class MyHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(posit: Int) {
            view.item_list.text = points[posit].title
            view.item_data.text = points[posit].mdate.toString()
            view.imageView2.visibility = if (points[posit].isSolved) View.VISIBLE else View.GONE

        }
/*
        init {
            view.setOnClickListener(this)
        }


        override fun onClick(v: View?) {
            //Toast.makeText(view.context, view.item_list.text.toString(), Toast.LENGTH_SHORT).show()
            Log.d ("click", "click")
        }

*/

    }

}
