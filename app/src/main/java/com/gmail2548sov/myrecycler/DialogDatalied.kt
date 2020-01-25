package com.gmail2548sov.myrecycler

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_date.*
import kotlinx.android.synthetic.main.dialog_date.view.*
import java.util.*

class DialogDatalied : DialogFragment() {


    companion object {
        val ARG_DATE = "date"
        val EXTRA_DATA = "com.gmail2548sov.myrecycler"
        fun newInstance(date: Date): DialogDatalied {
            var args = Bundle()
            args.putSerializable(ARG_DATE, date)
            var fragment = DialogDatalied()
            fragment.arguments = args
            return fragment

        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var date = arguments?.getSerializable(ARG_DATE) as Date
        var calendar = Calendar.getInstance()
        calendar.time = date
        Log.d("time5", "${calendar.time.toString()}")
        var year = calendar.get(Calendar.YEAR)
        var month = calendar.get(Calendar.MONTH)
        var day = calendar.get(Calendar.DAY_OF_MONTH)
        var time = calendar.get(Calendar.AM_PM)
        var min = calendar.get(Calendar.MINUTE)
        Log.d("time5", "${time}:$min")

        Log.d("date5", date.toString())

        val v = LayoutInflater.from(context).inflate(R.layout.dialog_date, null)
        // var dialogDate = v.findViewById<DatePicker>(R.id.dialog_date)
        // dialogDate.init(day,month,year,null)
        v.dialog_date.init(year, month, day, null)

        return AlertDialog.Builder(context).setTitle(R.string.date_Action).setView(v)
            .setNegativeButton(android.R.string.cancel, null)
            .setPositiveButton(
                android.R.string.ok,
                DialogInterface.OnClickListener { dialog, which ->
                    var year = v.dialog_date.year
                    var month = v.dialog_date.month
                    var day = v.dialog_date.dayOfMonth
                    var date = GregorianCalendar(year, month, day).time
                    sendResult(Activity.RESULT_OK, date)
                }).create()
    }

    fun sendResult(resultCode: Int, date: Date) {
        if (targetFragment == null) return
        val intent = activity?.intent
        intent?.putExtra(EXTRA_DATA, date)
        targetFragment?.onActivityResult(targetRequestCode, resultCode, intent)

    }
}