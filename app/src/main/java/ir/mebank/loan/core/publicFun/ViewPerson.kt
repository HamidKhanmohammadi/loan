package ir.mebank.loan.core.publicFun

import android.graphics.Typeface
import android.widget.TextView
import ir.mebank.loan.core.main.G
import ir.mebank.loan.core.module.makeView
import org.jetbrains.anko.*

class ViewPerson(var name: String)

class SpinnerCustomView(){

    companion object{
        val txtName = 1
    }

    fun closeSpin() = makeView {
        linearLayout {
            textView("hello") {
                spinnStyle()
            }
        }
    }

    fun openSpin() = makeView {
        linearLayout {
            textView("hello") {
                spinnStyle()
            }
        }
    }
}

fun TextView.spinnStyle(){
    id = SpinnerCustomView.txtName
    topPadding = 15
    bottomPadding = 15
    rightPadding = 15
    textSize = 13f
    setTypeface(G.defaultFont, Typeface.ITALIC + Typeface.BOLD)
}