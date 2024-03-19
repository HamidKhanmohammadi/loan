package ir.mebank.loan.core.module.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import ir.mebank.loan.core.publicFun.SpinnerCustomView
import ir.mebank.loan.core.publicFun.ViewPerson
import java.util.*

class SpinnerAdapter(mContext: Context, arrayList: ArrayList<ViewPerson?>?) :
    ArrayAdapter<ViewPerson?>(mContext, 0, arrayList!!) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, CLOSE)!!
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, OPEN)!!
    }

    fun getCustomView(position: Int, type: Int): View? {
        var mView: View? = null
        when (type) {
            OPEN -> mView = SpinnerCustomView().openSpin()
            CLOSE -> mView = SpinnerCustomView().closeSpin()
        }
        val txtName = mView!!.findViewById<TextView>(SpinnerCustomView.txtName)
        txtName.text = getItem(position)!!.name
        return mView
    }

    companion object {
        private const val CLOSE = 645
        private const val OPEN = 974
    }
}

