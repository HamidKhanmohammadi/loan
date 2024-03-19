package ir.mebank.loan.core.publicFun

import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ir.mebank.loan.core.R
import org.jetbrains.anko.*
import ir.mebank.loan.core.activity.user.lparamsPartLay
import ir.mebank.loan.core.main.G

class RecyLoanReceivedUI : AnkoComponent<ViewGroup> {

    companion object {
        val loan_row = 1
        val bank_name = 2
        val loan_amount = 3
        val installments_number = 4
        val remaining_amount = 5
        val obtaining_loan_date = 6
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
                    textView("نام موسسه یا بانک : ") {}
                    textView {
                        id = bank_name
                    }
                }
                linearLayout {
                    textView("مبلغ تسهیلات : ") {}
                    textView {
                        id = loan_amount
                    }
                }
                linearLayout {
                    textView("تعداد اقساط : ") {}
                    textView {
                        id = installments_number
                    }
                }
                linearLayout {
                    textView("مبلغ باقی مانده : ") {}
                    textView {
                        id = remaining_amount
                    }
                }
                linearLayout {
                    textView("تاریخ اخذ تسهیلات : ") {}
                    textView {
                        id = obtaining_loan_date
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

data class LoanReceived(
    var loan_row: Int = 0,
    var bank_name: String? = null,
    var loan_amount: Int = 0,
    var installments_number: Int = 0,
    var remaining_amount: Int = 0,
    var obtaining_loan_date: Int = 0
)