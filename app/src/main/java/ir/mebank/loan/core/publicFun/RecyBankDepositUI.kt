package ir.mebank.loan.core.publicFun

import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ir.mebank.loan.core.R
import org.jetbrains.anko.*
import ir.mebank.loan.core.activity.user.lparamsPartLay
import ir.mebank.loan.core.main.G

class RecyBankDepositUI : AnkoComponent<ViewGroup> {

    companion object {
        val loan_row = 1
        val bank_name = 2
        val account_number = 3
        val opening_date = 4
        val creditor_turnover = 5
        val six_month_average = 6
        val current_balance = 7
        val number_checks_returned = 8
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
                    textView("شماره حساب : ") {}
                    textView {
                        id = account_number
                    }
                }
                linearLayout {
                    textView("تاریخ افتتاح : ") {}
                    textView {
                        id = opening_date
                    }
                }
                linearLayout {
                    textView("گردش بستانکار : ") {}
                    textView {
                        id = creditor_turnover
                    }
                }
                linearLayout {
                    textView("میانگین شش ماهه : ") {}
                    textView {
                        id = six_month_average
                    }
                }
                linearLayout {
                    textView("موجودی فعلی : ") {}
                    textView {
                        id = current_balance
                    }
                }
                linearLayout {
                    textView("تعداد چک برگشتی : ") {}
                    textView {
                        id = number_checks_returned
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

data class BankDeposit(
    var loan_row: Int = 0,
    var bank_name: String? = null,
    var account_number: Int = 0,
    var opening_date: Int = 0,
    var creditor_turnover: Int = 0,
    var six_month_average: Int = 0,
    var current_balance: Int = 0,
    var number_checks_returned: Int = 0
)