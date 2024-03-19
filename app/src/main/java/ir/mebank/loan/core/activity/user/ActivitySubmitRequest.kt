package ir.mebank.loan.core.activity.user

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
import ir.mebank.loan.core.activity.XActivity
import ir.mebank.loan.core.main.G
import ir.mebank.loan.core.module.DrawerHelper.Companion.setDrawerView
import ir.mebank.loan.core.module.dip
import ir.mebank.loan.core.module.makeView
import java.util.*

class ActivitySubmitRequest : XActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDrawerView(contentSubmitRequest())
    }
}

fun contentSubmitRequest() = makeView {
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

            //انتخاب شعبه مورد نظر
            verticalLayout {
                backgroundResource = R.drawable.style_bck_layout_user
                textView("انتخاب شعبه مورد نظر") {
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
                        textView("استان (استان محل زندگی)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_public_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            val people = ArrayList<ViewPerson?>()
                            people.add(ViewPerson("انتخاب کنید"))
                            people.add(ViewPerson("قم"))
                            people.add(ViewPerson("تهران"))
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
                        textView("شهر").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_map_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            val people = ArrayList<ViewPerson?>()
                            people.add(ViewPerson("انتخاب کنید"))
                            people.add(ViewPerson("قم"))
                            people.add(ViewPerson("تهران"))
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
                        textView("شعبه").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_place_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            val people = ArrayList<ViewPerson?>()
                            people.add(ViewPerson("انتخاب کنید"))
                            people.add(ViewPerson("قم"))
                            people.add(ViewPerson("تهران"))
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
            }.lparams {
                lparamsPartLay()
            }
            //انتخاب طرح و میزان تسهیلات
            verticalLayout {
                backgroundResource = R.drawable.style_bck_layout_user
                textView("انتخاب طرح و میزان تسهیلات") {
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
                        textView("علت درخواست").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_question_answer_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            val people = ArrayList<ViewPerson?>()
                            people.add(ViewPerson("انتخاب کنید"))
                            people.add(ViewPerson("قم"))
                            people.add(ViewPerson("تهران"))
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
                        textView("طرح").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_star_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            val people = ArrayList<ViewPerson?>()
                            people.add(ViewPerson("انتخاب کنید"))
                            people.add(ViewPerson("قم"))
                            people.add(ViewPerson("تهران"))
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
                        textView("نوع محاسبه").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_question_answer_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            val people = ArrayList<ViewPerson?>()
                            people.add(ViewPerson("انتخاب کنید"))
                            people.add(ViewPerson("قم"))
                            people.add(ViewPerson("تهران"))
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
