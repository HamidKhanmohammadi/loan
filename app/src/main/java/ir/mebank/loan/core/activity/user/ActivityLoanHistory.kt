package ir.mebank.loan.core.activity.user

import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import ir.mebank.loan.core.R
import org.jetbrains.anko.*
import ir.mebank.loan.core.activity.XActivity
import ir.mebank.loan.core.main.G
import ir.mebank.loan.core.module.DrawerHelper.Companion.setDrawerView
import ir.mebank.loan.core.module.dip
import ir.mebank.loan.core.module.makeView

class ActivityLoanHistory : XActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDrawerView(contentLoanHistory())
    }
}
fun contentLoanHistory() = makeView {
    scrollView {
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
                textView("در این بخش می توانید تاریخچه ی تسهیلات دریافتی را مشاهده کنید.") {

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

            verticalLayout {
                backgroundResource = R.drawable.style_bck_layout_user
                linearLayout {
                    textView("ردیف : ") {}
                    textView("1") {}
                }
                linearLayout {
                    textView("کد درخواست : ") {}
                    textView("#22222") {}
                }
                linearLayout {
                    textView("علت درخواست : ") {}
                    textView("خرید جهیزیه") {}
                }
                linearLayout {
                    textView("طرح : ") {}
                    textView("ثمین 2") {}
                }
                linearLayout {
                    textView("میزان تسهیلات : ") {}
                    textView("1.000.000") {}
                }
                linearLayout {
                    textView("تعداد اقساط : ") {}
                    textView("20") {}
                }
                linearLayout {
                    textView("نرخ سود : ") {}
                    textView("18") {}
                }
                linearLayout {
                    textView("نیاز به سپرده : ") {}
                    textView("دارد") {}
                }
                linearLayout {
                    textView("استان : ") {}
                    textView("تهران") {}
                }
                linearLayout {
                    textView("شهر : ") {}
                    textView("تهران") {}
                }
                linearLayout {
                    textView("شعبه : ") {}
                    textView("تهرانسر") {}
                }
                linearLayout {
                    textView("مرجع در حال بررسی : ") {}
                    textView("رئیس شعبه") {}
                }
                linearLayout {
                    textView("وضعیت : ") {}
                    textView("") {}
                }
                linearLayout {
                    textView("پیام بانک : ") {}
                    textView("") {}
                }
                linearLayout {
                    textView("تاریخ ثبت درخواست : ") {}
                    textView("98/01/01") {}
                }
                linearLayout {
                    textView("انصراف : ") {}
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