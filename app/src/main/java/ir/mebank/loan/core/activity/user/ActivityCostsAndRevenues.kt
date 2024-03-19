package ir.mebank.loan.core.activity.user

import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageButton
import android.widget.TextView
import ir.mebank.loan.core.R
import org.jetbrains.anko.*
import ir.mebank.loan.core.activity.XActivity
import ir.mebank.loan.core.main.G
import ir.mebank.loan.core.module.DrawerHelper.Companion.setDrawerView
import ir.mebank.loan.core.module.dip
import ir.mebank.loan.core.module.makeView

class ActivityCostsAndRevenues : XActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDrawerView(contentCostsAndRevenues())
    }
}
fun contentCostsAndRevenues() =  makeView {
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
                textView("هزینه ها و درآمدها") {

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
            //هزینه ها
            verticalLayout {
                backgroundResource = R.drawable.style_bck_layout_user
                textView("هزینه ها ( تقریب ماهیانه )") {
                    setTypeface(typeface, Typeface.ITALIC + Typeface.BOLD)
                }.lparams {
                    gravity = Gravity.CENTER
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
                linearLayout {
                    verticalLayout {
                        textView("اجاره (ریال)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                monyIcon()
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "اجاره"
                                back_edt_text()
                            }.lparams(matchParent, wrapContent) {
                            }
                        }.lparams(matchParent, wrapContent) {
                            gravity = Gravity.BOTTOM
                        }
                    }.lparams(matchParent, wrapContent)
                }.lparams(matchParent, wrapContent)
                linearLayout {
                    verticalLayout {
                        textView("تحصیل (ریال)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                monyIcon()
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "تحصیل"
                                back_edt_text()
                            }.lparams(matchParent, wrapContent) {
                            }
                        }.lparams(matchParent, wrapContent) {
                            gravity = Gravity.BOTTOM
                        }
                    }.lparams(matchParent, wrapContent)
                }.lparams(matchParent, wrapContent)
                linearLayout {
                    verticalLayout {
                        textView("سایر مخارج (ریال)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                monyIcon()
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "سایر مخارج"
                                back_edt_text()
                            }.lparams(matchParent, wrapContent) {
                            }
                        }.lparams(matchParent, wrapContent) {
                            gravity = Gravity.BOTTOM
                        }
                    }.lparams(matchParent, wrapContent)
                }.lparams(matchParent, wrapContent)
            }.lparams {
                lparamsPartLay()
            }
            //درآمدها
            verticalLayout {
                backgroundResource = R.drawable.style_bck_layout_user
                textView("درآمدها ( ماهیانه )") {
                    setTypeface(typeface, Typeface.ITALIC + Typeface.BOLD)
                }.lparams {
                    gravity = Gravity.CENTER
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
                textView("*فایل مدارک و مستندات درآمدی ابراز شده باید در قسمت مدارک بارگذاری گردد.") {
                    setTypeface(typeface, Typeface.ITALIC + Typeface.BOLD)
                }.lparams {
                    gravity = Gravity.CENTER
                    leftPadding = 20
                    rightPadding = 40
                    bottomPadding = 10
                    topPadding = 10
                }

                linearLayout {
                    verticalLayout {
                        textView("درآمد شغل اول (ریال)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                monyIcon()
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "درآمد شغل اول (ریال)"
                                back_edt_text()
                            }.lparams(matchParent, wrapContent) {
                            }
                        }.lparams(matchParent, wrapContent) {
                            gravity = Gravity.BOTTOM
                        }
                    }.lparams(matchParent, wrapContent)
                }.lparams(matchParent, wrapContent)
                linearLayout {
                    verticalLayout {
                        textView("درآمد شغل دوم (ریال)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                monyIcon()
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "درآمد شغل دوم (ریال)"
                                back_edt_text()
                            }.lparams(matchParent, wrapContent) {
                            }
                        }.lparams(matchParent, wrapContent) {
                            gravity = Gravity.BOTTOM
                        }
                    }.lparams(matchParent, wrapContent)
                }.lparams(matchParent, wrapContent)
                linearLayout {
                    verticalLayout {
                        textView("سایر درآمدها(ریال)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                monyIcon()
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "سایر درآمدها(ریال)"
                                back_edt_text()
                            }.lparams(matchParent, wrapContent) {
                            }
                        }.lparams(matchParent, wrapContent) {
                            gravity = Gravity.BOTTOM
                        }
                    }.lparams(matchParent, wrapContent)
                }.lparams(matchParent, wrapContent)
            }.lparams {
                lparamsPartLay()
            }
        }.applyRecursively {
            when (it) {
                is TextView -> it.setTypeface(G.defaultFont, Typeface.ITALIC + Typeface.BOLD)
            }
        }
    }
}

fun ImageButton.monyIcon(){
    imageResource = R.drawable.ic_attach_money_black_24dp
}