package ir.mebank.loan.core.publicFun

import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import ir.mebank.loan.core.R
import org.jetbrains.anko.*
import ir.mebank.loan.core.main.G

class RecyDocumentsUI : AnkoComponent<ViewGroup> {

    companion object {
        val loan_doc = 1
        val pic_name = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        verticalLayout {
            lparams(matchParent, wrapContent)
            verticalLayout {
                backgroundResource = R.drawable.style_bck_layout_user
                linearLayout {
                    gravity = Gravity.CENTER
                    imageView(R.drawable.ic_launcher_background){
                        id = loan_doc
                    }.lparams {
                        width = 360
                        height = 360
                    }
                }
                linearLayout {
                    gravity = Gravity.CENTER
                    textView() {
                        id = pic_name
                    }
                }
                linearLayout {
                    textView("ویرایش و حذف : ") {}
                    textView("") {}
                }
            }.applyRecursively {
                when (it) {
                    is _LinearLayout -> it.lparams { lparamsPartLay2() }
                }
            }
        }.applyRecursively {
            when (it) {
                is TextView -> it.setTypeface(G.defaultFont, Typeface.ITALIC + Typeface.BOLD)
            }
        }
    }
}

data class Documents(
    var loan_doc_id: Int = 0,
    var pic_name: String? = null
)

fun LinearLayout.LayoutParams.lparamsPartLay2() {
    width = matchParent
    height = wrapContent
    gravity = Gravity.CENTER
    topMargin = 10
    bottomMargin = 10
    leftMargin = 20
    rightMargin = 20
}