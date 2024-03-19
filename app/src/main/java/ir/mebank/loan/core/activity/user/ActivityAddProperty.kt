package ir.mebank.loan.core.activity.user

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import ir.mebank.loan.core.R
import ir.mebank.loan.core.module.adapter.SpinnerAdapter
import ir.mebank.loan.core.publicFun.ViewPerson
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import ir.mebank.loan.core.activity.XActivity
import ir.mebank.loan.core.fragment.btnLogin
import ir.mebank.loan.core.fragment.btnhClose
import ir.mebank.loan.core.main.G
import ir.mebank.loan.core.module.DrawerHelper.Companion.setDrawerView
import ir.mebank.loan.core.module.dip
import ir.mebank.loan.core.module.makeView
import ir.mebank.loan.core.module.mspace
import java.util.*

class ActivityAddProperty : XActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDrawerView(contentAddProperty())
    }
}
fun contentAddProperty() = makeView {
    scrollView {
        lparams(matchParent, matchParent)
        verticalLayout {
            lparams(matchParent, matchParent)
            gravity = Gravity.CENTER_HORIZONTAL
            //افزودن حساب بانکی
            verticalLayout {
                backgroundResource = R.drawable.style_bck_layout_user
                textView("افزودن دارایی") {
                    textSize = 20f
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
                        textView("نوع دارایی (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_attach_money_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            val people = ArrayList<ViewPerson?>()
                            people.add(ViewPerson("نوع دارایی را انتخاب کنید"))
                            people.add(ViewPerson("آپارتمان"))
                            people.add(ViewPerson("ملک"))
                            people.add(ViewPerson("فلزات گرانبها"))
                            people.add(ViewPerson("جواهرات"))
                            people.add(ViewPerson("مستغلات"))
                            people.add(ViewPerson("اوراق بهادار"))
                            people.add(ViewPerson("ارز"))
                            people.add(ViewPerson("خودرو"))
                            people.add(ViewPerson("سهام"))
                            val adapter = SpinnerAdapter(G.context, people)
                            val spinner = spinner {
                                backgroundResource = R.drawable.selector_spinner
                            }.lparams {
                                width = matchParent
                                height = wrapContent
                            }
                            spinner.adapter = adapter
                            spinner.onItemSelectedListener =
                                object : AdapterView.OnItemSelectedListener {
                                    override fun onItemSelected(
                                        parent: AdapterView<*>?,
                                        view: View,
                                        position: Int,
                                        id: Long
                                    ) {
                                        //supportActionBar!!.title = people[position]?.name
                                    }

                                    override fun onNothingSelected(parent: AdapterView<*>?) {}
                                }
                        }.lparams(matchParent, wrapContent) {
                            gravity = Gravity.BOTTOM
                        }
                    }.lparams(matchParent, wrapContent)
                }.lparams(matchParent, wrapContent)
                linearLayout {
                    verticalLayout {
                        textView("ارزش تقریبی (ریال) (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_local_atm_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "بر حسب ریال"
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
                        textView("توضیحات(*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_info_outline_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "مشخصات دارایی..."
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
            linearLayout {
                gravity = Gravity.CENTER_HORIZONTAL
                val btn_loan_add = button("افزودن") {
                    leftPadding = 100
                    rightPadding = 100
                    textSize = 15f
                    btnLogin()
                }.lparams(0, wrapContent, 4.5f) {
                    rightMargin = 10
                    bottomMargin = 20
                }
                btn_loan_add.onClick {

                }
                mspace(1f)
                val btn_loan = button("بستن") {
                    leftPadding = 100
                    rightPadding = 100
                    textSize = 15f
                    btnhClose()
                }.lparams(0, wrapContent, 4.5f) {
                    leftMargin = 10
                    bottomMargin = 20
                }
                btn_loan.onClick {
                    G.currentActivity.startActivity(
                        Intent(
                            G.context,
                            ActivityProperty::class.java
                        )
                    )
                }
            }
        }.applyRecursively {
            when (it) {
                is TextView -> it.setTypeface(G.defaultFont, Typeface.ITALIC + Typeface.BOLD)
            }
        }
    }
}