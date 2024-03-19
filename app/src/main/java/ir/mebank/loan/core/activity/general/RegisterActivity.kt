package ir.mebank.loan.core.activity.general

import android.os.Bundle
import android.view.Gravity
import ir.mebank.loan.core.R
import ir.mebank.loan.core.activity.XActivity
import ir.mebank.loan.core.fragment.FragmentBankCustomers
import ir.mebank.loan.core.fragment.FragmentInter
import ir.mebank.loan.core.fragment.FragmentRegister
import ir.mebank.loan.core.module.PTab
import ir.mebank.loan.core.module.makeView
import org.jetbrains.anko.*
import org.jetbrains.anko.design.tabLayout
import org.jetbrains.anko.support.v4.viewPager

class RegisterActivity : XActivity() {
    companion object{
        val tab_layout = 1
        val view_pager = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(registerUi())

        val tab = PTab(this, view_pager, tab_layout)
        tab.add(FragmentRegister::class.java, "ثبت نام")
        tab.add(FragmentBankCustomers::class.java, "مشتریان بانک")
        tab.add(FragmentInter::class.java, "ورود")
    }

}
fun registerUi() = makeView {

    linearLayout {
        gravity = Gravity.CENTER
        lparams {
            width = matchParent
            height = matchParent
        }
        backgroundResource = R.drawable.style_register_background
        verticalLayout {

            val tabLayout = tabLayout {
                id = RegisterActivity.tab_layout
            }.lparams(matchParent, wrapContent)
            val viewPager = viewPager {
                id = RegisterActivity.view_pager
            }
            backgroundResource = R.drawable.style_bck_layout
        }.lparams(matchParent, wrapContent){
            topMargin = 150
            bottomMargin = 150
            leftMargin=100
            rightMargin=100
        }
    }
}
