package com.gmail2548sov.myrecycler

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.content.Intent.getIntent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CompoundButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.detailed_view_fragment.*
import kotlinx.android.synthetic.main.detailed_view_fragment.view.*
import java.util.*

class FragmentDatalied : Fragment(), CompoundButton.OnCheckedChangeListener {


    companion object {

        val DIALOG_DATALIEG = "Dialog"

        val ID: String = "id_datalied"

        val REQUEST_CODE: Int = 0


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
    lateinit var mbtnDate: Button


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

        mbtnDate = view.crime_date


        setdetail(view)
        //view.crime_date.isEnabled = false
        view.crime_date.setOnClickListener {

            var manager = getFragmentManager()
            var dataDialog = DialogDatalied.newInstance(SingltonInfo.getId(cid)?.mdate ?: Date())
            dataDialog.setTargetFragment(this, REQUEST_CODE)
            dataDialog.show(manager, DIALOG_DATALIEG)


        }

        view.crime_solved.setOnCheckedChangeListener(this)
        myIntent()
        return view
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_OK) return
        if (requestCode == REQUEST_CODE) {
        var date = data?.getSerializableExtra(DialogDatalied.EXTRA_DATA) as Date
            SingltonInfo.getId(cid)?.mdate = date
            var calendar = Calendar.getInstance()
            calendar.time = date
            var year = calendar.get(Calendar.YEAR)
            var month = calendar.get(Calendar.MONTH)
            var day = calendar.get(Calendar.DAY_OF_MONTH)
            var time = calendar.get(Calendar.AM_PM)
            mbtnDate.text = "$day.${month+1}.$year"


        }

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