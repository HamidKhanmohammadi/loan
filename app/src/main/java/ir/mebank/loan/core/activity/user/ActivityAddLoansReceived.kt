package ir.mebank.loan.core.activity.user

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog
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
import ir.mebank.loan.core.test.HDateHelper
import java.util.*

class ActivityAddLoansReceived : XActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDrawerView(contentAddLoansReceived())
    }
}

fun contentAddLoansReceived() = makeView {
    scrollView {
        lparams(matchParent, matchParent)
        verticalLayout {
            lparams(matchParent, matchParent)
            gravity = Gravity.CENTER_HORIZONTAL
            //افزودن دیگر تسهیلات
            verticalLayout {
                backgroundResource = R.drawable.style_bck_layout_user
                textView("افزودن دیگر تسهیلات") {
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
                        textView("نام موسسه یا بانک (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_account_balance_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            val people = ArrayList<ViewPerson?>()
                            people.add(ViewPerson("نام موسسه یا بانک را انتخاب کنید"))
                            people.add(ViewPerson("بانک مهر اقتصاد"))
                            people.add(ViewPerson("بانک مسکن"))
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
                        textView("مبلغ تسهیلات (ریال)(*)").lparams {
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
                                hint = "مبلغ تسهیلات بر حسب ریال"
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
                        textView("تعداد اقساط").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_repeat_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "مبلغ تسهیلات بر حسب ریال"
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
                        textView("مبلغ باقیمانده تسهیلات (ریال)").lparams {
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
                                hint = "مبلغ باقیمانده تسهیلات بر حسب ریال"
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
                        textView("تاریخ اخذ تسهیلات (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_date_range_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            ActivityIdentityInformation.txtD = textView {
                                hint = "تاریخ اخذ تسهیلات"
                                textSize = 15f
                                topPadding = 20
                                bottomPadding = 30
                                rightPadding = 10
                                backgroundResource = R.drawable.style_edit_text
                            }.lparams(matchParent, wrapContent)

                            ActivityIdentityInformation.txtD!!.onClick {


                                val my =
                                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                                        // Display Selected date in textbox
                                        ActivityIdentityInformation.txtD!!.setText(" " + dayOfMonth + "/ " + monthOfYear + "/ " + year)
                                    }
                                HDateHelper.openDatePicker(G.currentActivity, my)
                            }
                        }.lparams(matchParent, wrapContent)
                    }.lparams(matchParent, wrapContent)
                }.lparams(matchParent, wrapContent)
            }.lparams {
                lparamsPartLay()
            }
            linearLayout {
                gravity = Gravity.CENTER_HORIZONTAL
                val btn_loan_add = button("افزودن تسهیلات") {
                    leftPadding = 100
                    rightPadding = 100
                    textSize = 15f
                    btnLogin()
                }.lparams(0, wrapContent, 4.5f) {
                    rightMargin = 10
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
                }
                btn_loan.onClick {
                    G.currentActivity.startActivity(
                        Intent(
                            G.context,
                            ActivityLoansReceived::class.java
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