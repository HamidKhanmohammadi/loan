package ir.mebank.loan.core.publicFun

import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ir.mebank.loan.core.R
import ir.mebank.loan.core.activity.user.lparamsPartLay
import ir.mebank.loan.core.main.G
import org.jetbrains.anko.*

class RecyPropertyUI : AnkoComponent<ViewGroup> {

    companion object {
        val loan_row = 1
        val type_asset = 2
        val description = 3
        val approximate_value = 4
    }

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        verticalLayout {
            lparams(matchParent, wrapContent)
            verticalLayout {
                backgroundResource = R.drawable.style_bck_layout_user
                linearLayout {
                    textView("ردیف : ") {}
                    textView {
                        id = loan_row
                    }
                }
                linearLayout {
                    textView("نوع دارایی : ") {}
                    textView {
                        id = type_asset
                    }
                }
                linearLayout {
                    textView("توضیحات : ") {}
                    textView {
                        id = description
                    }
                }
                linearLayout {
                    textView("ارزش تقریبی : ") {}
                    textView {
                        id = approximate_value
                    }
                }
                linearLayout {
                    textView("ویرایش و حذف : ") {}
                    textView("") {}
                }
            }.applyRecursively {
                when (it) {
                    is _LinearLayout -> it.lparams { lparamsPartLay() }
                }
            }
        }.applyRecursively {
            when (it) {
                is TextView -> it.setTypeface(G.defaultFont, Typeface.ITALIC + Typeface.BOLD)
            }
        }
    }
}

data class Property(
    var loan_row: Int = 0,
    var type_asset: String? = null,
    var description: String? = null,
    var approximate_value: Int = 0
)