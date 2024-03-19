package ir.mebank.loan.core.fragment

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ir.mebank.loan.core.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import ir.mebank.loan.core.activity.user.ActivitySubmitRequest
import ir.mebank.loan.core.activity.user.back_edt_text
import ir.mebank.loan.core.activity.user.myIntent
import ir.mebank.loan.core.main.G
import ir.mebank.loan.core.module.dip
import ir.mebank.loan.core.module.makeView

class FragmentInter :Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = makeView {
        verticalLayout {
            imageView(R.drawable.login).lparams {
                width = 400
                height = 400
                gravity = Gravity.CENTER
            }
            textView("در صورتی که عضو سامانه نیستید، اگر در بانک مهر اقتصاد حساب دارید تب مشتریان بانک را لمس کنید. در غیر این صورت از تب ثبت نام استفاده نمایید.") {
                gravity = Gravity.CENTER
            }
            editText {
                hint = "کد ملی"
                back_edt_text()
            }.lparams {
                width = matchParent
                height = wrapContent
                topMargin = 30
                leftMargin = 40
                rightMargin = 40
                bottomMargin = 10
            }
            editText {
                hint = "کلمه ی عبور"
                back_edt_text()
            }.lparams {
                width = matchParent
                height = wrapContent
                leftMargin = 40
                rightMargin = 40
            }
            button("ورود") {
                btnLogin()
            }.lparams(matchParent, wrapContent) {
                topMargin = 70
                leftMargin = 40
                rightMargin = 40
            }.onClick {
                myIntent(ActivitySubmitRequest())
            }
            imageView {
                backgroundResource = R.drawable.list_devider_question

            }.lparams {
                width = matchParent
                height = 2
                topMargin = 20.dip()
                leftMargin = 2.dip()
                rightMargin = 2.dip()
                bottomMargin = 2.dip()
            }
            textView("رمز عبور خود را فراموش کرده اید؟ کلیک کنید") {
                gravity = Gravity.CENTER
            }
        }.applyRecursively {
            when (it) {
                is TextView -> it.setTypeface(G.defaultFont, it.typeface.style)
            }
        }
    }
}