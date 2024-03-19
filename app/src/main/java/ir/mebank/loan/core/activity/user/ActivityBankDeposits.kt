package ir.mebank.loan.core.activity.user

import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import ir.mebank.loan.core.R
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk27.coroutines.onClick
import ir.mebank.loan.core.activity.XActivity
import ir.mebank.loan.core.main.G
import ir.mebank.loan.core.module.DrawerHelper.Companion.setDrawerView
import ir.mebank.loan.core.module.adapter.AdapterRecyclerBankDeposits
import ir.mebank.loan.core.module.dip
import ir.mebank.loan.core.module.makeView
import ir.mebank.loan.core.publicFun.BankDeposit
import java.util.*

class ActivityBankDeposits : XActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDrawerView(contentBankDeposits())
    }
}

fun contentBankDeposits() = makeView {
    val bankDepositList = ArrayList<BankDeposit>()
    verticalLayout {
        lparams(matchParent, matchParent)
        verticalLayout {
            lparams(matchParent, matchParent)
            gravity = Gravity.CENTER_HORIZONTAL
            linearLayout {
                gravity = Gravity.CENTER
                textView("نام کاربر : ").lparams(wrapContent, matchParent)
                textView("حمید خان محمدی")
            }
            imageView {
                backgroundResource = R.drawable.user_line
            }.lparams {
                width = matchParent
                height = 2
                topMargin = 2.dip()
                leftMargin = 2.dip()
                rightMargin = 2.dip()
                bottomMargin = 2.dip()
            }
            //اطلاعیه
            verticalLayout {
                backgroundResource = R.drawable.style_bck_layout_user
                textView("در این قسمت اطلاعات مربوط به حساب های بانکی خود را درج نمایید.") {

                }.lparams {
                    gravity = Gravity.CENTER
                    leftPadding = 20
                    rightPadding = 40
                    bottomPadding = 10
                    topPadding = 10
                }
            }.lparams {
                lparamsPartLay()
            }
            linearLayout {
                gravity = Gravity.CENTER
                verticalLayout {
                    addStyleLayout()
                    imageButton { addStyleLayout() }.lparams(wrapContent, wrapContent)
                    textView("افزودن حساب") { addStyleLayout() }.lparams(wrapContent, wrapContent)
                }.lparams(wrapContent, wrapContent).applyRecursively {
                    onClick {
                        myIntent(ActivityAddBankDeposits())
                    }
                }
            }.lparams(matchParent, wrapContent)
            imageView {
                backgroundResource = R.drawable.list_devider_question
            }.lparams {
                width = matchParent
                height = 2
                topMargin = 6.dip()
                bottomMargin = 4.dip()
            }
            verticalLayout {
                val recyclerView = recyclerView {}
                for (i in 0..49) {
                    val bankDep = BankDeposit()
                    bankDep.loan_row = i
                    bankDep.bank_name = "بانک مهر اقتصاد $i"
                    bankDep.account_number = (Math.random() * 20 + 10).toInt() * 100
                    bankDep.opening_date = (Math.random() * 20 + 10).toInt() * 100
                    bankDep.creditor_turnover = (Math.random() * 20 + 10).toInt() * 100
                    bankDep.six_month_average = (Math.random() * 20 + 10).toInt() * 100
                    bankDep.current_balance = (Math.random() * 20 + 10).toInt() * 100
                    bankDep.number_checks_returned = (Math.random() * 20 + 10).toInt() * 100

                    bankDepositList.add(bankDep)
                }
                recyclerView.layoutManager = LinearLayoutManager(G.context, LinearLayoutManager.VERTICAL, false)
                val adapterPeroductRecycler = AdapterRecyclerBankDeposits(bankDepositList)
                recyclerView.adapter = adapterPeroductRecycler
                adapterPeroductRecycler.notifyDataSetChanged()
            }
        }.applyRecursively {
            when (it) {
                is TextView -> it.setTypeface(G.defaultFont, Typeface.ITALIC + Typeface.BOLD)
            }
        }
    }
}
