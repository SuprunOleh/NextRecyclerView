package com.gmail2548sov.myrecycler
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.*

open class MainActivity: MainActivityListAbstract() {

    init {
       MyAdapter.mAct = this

    }

    override fun createFragList():Fragment {
       return FragmentList()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d ("1001","$requestCode, $resultCode, $data")
        var id = data?.getSerializableExtra(FragmentList.MID) as UUID
        var isSold: Boolean = data.getBooleanExtra(FragmentList.SOLV, false)
        Toast.makeText(this, isSold.toString(), Toast.LENGTH_SHORT).show()
    }


}
