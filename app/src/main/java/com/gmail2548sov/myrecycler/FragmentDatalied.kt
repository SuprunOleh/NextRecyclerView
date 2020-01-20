package com.gmail2548sov.myrecycler

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.Intent.getIntent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.detailed_view_fragment.*
import kotlinx.android.synthetic.main.detailed_view_fragment.view.*
import java.util.*

class FragmentDatalied : Fragment(), CompoundButton.OnCheckedChangeListener {




    companion object {

        val ID: String = "id_datalied"

        fun newInstance(id: UUID): Fragment {
            val args = Bundle()
            args.putSerializable(ID, id)

            var fragment = FragmentDatalied()
            fragment.arguments = args
            return fragment
        }



    }


    //Log.d ("nullarg", "${arguments?.getSerializable(ID}")


    lateinit var cid: UUID








    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        cid = arguments?.getSerializable(ID) as UUID
        Log.d("extra888", "${cid}")

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.detailed_view_fragment, container, false)
        Log.d("extra889", "${view.crime_solved == null}")


        setdetail(view)
        view.crime_solved.setOnCheckedChangeListener(this)
        myIntent()
        return view
    }


    fun setdetail(v: View) {
        var infopreview = SingltonInfo.getId(cid)
        v.title_datalied.text = infopreview?.title
        v.crime_solved.isChecked = infopreview?.isSolved ?: false
        v.crime_date.text = infopreview?.mdate.toString()
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {

        when (buttonView!!.isChecked) {

            true -> {
                SingltonInfo.getId(cid)?.isSolved = true
            }
            false -> {
                SingltonInfo.getId(cid)?.isSolved = false
            }

        }

        myIntent()
    }

    fun myIntent() {
        var intent = MyAdapter.mInt
        intent.putExtra(FragmentList.SOLV, SingltonInfo.getId(cid)?.isSolved)
        Log.d("888", "${intent.putExtra(FragmentList.SOLV, SingltonInfo.getId(cid)?.isSolved)}")
        intent.putExtra(FragmentList.MID, SingltonInfo.getId(cid)?.mId)
        activity?.setResult(Activity.RESULT_OK, intent)
    }


}