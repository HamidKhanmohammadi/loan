package ir.mebank.loan.core.fragment

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.typeface.library.googlematerial.GoogleMaterial
import com.mikepenz.iconics.utils.toIconicsSizeDp
import ir.mebank.loan.core.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import ir.mebank.loan.core.activity.user.ActivitySubmitRequest
import ir.mebank.loan.core.activity.user.back_edt_text
import ir.mebank.loan.core.activity.user.myIntent
import ir.mebank.loan.core.main.G
import ir.mebank.loan.core.module.dip
import ir.mebank.loan.core.module.makeView

class FragmentRegister : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = makeView {
        val d = IconicsDrawable(G.context, GoogleMaterial.Icon.gmd_call_merge)
            .size(24.toIconicsSizeDp())
            .padding(1.toIconicsSizeDp())
        verticalLayout {
            imageView(R.drawable.login).lparams {
                width = 400
                height = 400
                gravity = Gravity.CENTER
            }
            textView("اگر در بانک مهر اقتصاد حساب ندارید، برای ثبت نام کافی است شماره موبایل و کد ملی خود را وارد کنید.") {
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
                hint = "شماره همراه"
                back_edt_text()
            }.lparams {
                width = matchParent
                height = wrapContent
                leftMargin = 40
                rightMargin = 40
            }
            var d = button("ثبت نام") {
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
            textView("اگر در بانک مهر اقتصاد حساب دارید، رمز عبور دریافت کنید.") {
                gravity = Gravity.CENTER
            }
        }.applyRecursively {
            when (it) {
                is TextView -> it.setTypeface(G.defaultFont, it.typeface.style)
            }
        }
    }
}
fun Button.btnLogin() {
    setTypeface(typeface, Typeface.BOLD_ITALIC)
    textColor = Color.parseColor("#e3ffff")
    backgroundResource = R.drawable.style_button_login
}
fun Button.btnhClose() {
    setTypeface(typeface, Typeface.BOLD_ITALIC)
    textColor = Color.parseColor("#e3ffff")
    backgroundResource = R.drawable.style_button_close
}