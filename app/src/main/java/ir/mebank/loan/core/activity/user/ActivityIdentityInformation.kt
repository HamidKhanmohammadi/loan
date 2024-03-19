package ir.mebank.loan.core.activity.user

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog
import ir.mebank.loan.core.R
import ir.mebank.loan.core.module.adapter.SpinnerAdapter
import ir.mebank.loan.core.publicFun.ViewPerson
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import ir.mebank.loan.core.activity.XActivity
import ir.mebank.loan.core.activity.user.ActivityIdentityInformation.Companion.txtD
import ir.mebank.loan.core.main.G
import ir.mebank.loan.core.module.DrawerHelper.Companion.setDrawerView
import ir.mebank.loan.core.module.dip
import ir.mebank.loan.core.module.makeView
import ir.mebank.loan.core.test.HDateHelper
import java.util.*


class ActivityIdentityInformation : XActivity() {

    companion object {
        var txtD: TextView? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDrawerView(contentIdentityInformation())

    }
}

@SuppressLint("RtlHardcoded")
fun contentIdentityInformation() = makeView {
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
                textView("مشتری گرامی، در صورتی که اطلاعات خود را در بانک بروز رسانی نموده اید یا نیاز به بروزرسانی اطلاعات خود دارید. میتوانید از کلید زیر استفاده نمایید.") {

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
            //مشخصات فردی
            verticalLayout {
                backgroundResource = R.drawable.style_bck_layout_user
                textView("مشخصات فردی") {
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
                        textView("نام (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_person_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "نام "
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
                        textView("نام خانوادگی (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_person_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "نام خانوادگی "
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
                        textView("نام پدر (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_person_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "نام پدر "
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
                        textView("تاریخ تولد (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_date_range_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            txtD = textView {
                                hint = "تاریخ تولد"
                                textSize = 15f
                                topPadding = 20
                                bottomPadding = 30
                                rightPadding = 10
                                backgroundResource = R.drawable.style_edit_text
                            }.lparams(matchParent, wrapContent)

                            txtD!!.onClick {


                                val my = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                                        // Display Selected date in textbox
                                        txtD!!.setText(" " + dayOfMonth + "/ " + monthOfYear + "/ " + year)
                                    }
                                HDateHelper.openDatePicker(G.currentActivity, my)
                            }
                        }.lparams(matchParent, wrapContent)
                    }.lparams(matchParent, wrapContent)
                }.lparams(matchParent, wrapContent)
                linearLayout {
                    verticalLayout {
                        textView("شماره شناسنامه (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_contacts_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "شماره شناسنامه "
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
                        textView("کد ملی (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_chrome_reader_mode_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "کد ملی "
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
                        textView("وضعیت جسمانی (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_accessible_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            val people = ArrayList<ViewPerson?>()
                            people.add(ViewPerson("انتخاب کنید"))
                            people.add(ViewPerson("سالم"))
                            people.add(ViewPerson("دارای معلولیت"))
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
                        textView("استان محل صدور (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_vpn_lock_black_24dp
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
                        textView("شهر محل صدور (*)").lparams {
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
                        textView("شماره همراه (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_phone_iphone_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "شماره همراه "
                                back_edt_text()
                            }.lparams(matchParent, wrapContent) {
                                topMargin = 7
                            }
                        }.lparams(matchParent, wrapContent) {
                            gravity = Gravity.BOTTOM
                        }
                    }.lparams(matchParent, wrapContent)
                }.lparams(matchParent, wrapContent)
                linearLayout {
                    verticalLayout {
                        textView("پست الکترونیک (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            gravity = Gravity.LEFT
                            paddingElemansLay()
                            editText {
                                gravity = Gravity.LEFT
                                hint = "example@domain.com "
                                back_edt_text()
                            }.lparams(0, wrapContent, 8.75f) {
                                topMargin = 7
                                rightMargin = 5
                            }
                            imageButton {
                                imageResource = R.drawable.ic_email_black_24dp
                            }.lparams {
                                width = 0
                                height = 133
                                weight = 1.25f
                            }
                        }.lparams(matchParent, wrapContent) {
                        }
                    }.lparams(matchParent, wrapContent)
                }.lparams(matchParent, wrapContent)
                linearLayout {
                    verticalLayout {
                        textView("میزان تحصیلات (*)").lparams {
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
                            people.add(ViewPerson("انتخاب کنید"))
                            people.add(ViewPerson("زیر دیپلم"))
                            people.add(ViewPerson("دیپلم"))
                            people.add(ViewPerson("کاردانی"))
                            people.add(ViewPerson("کارشناسی"))
                            people.add(ViewPerson("کارشناسی ارشد"))
                            people.add(ViewPerson("دکتری"))
                            people.add(ViewPerson("فوق دکتری"))
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
                        textView("وضعیت تأهل (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_add_circle_outline_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            val people = ArrayList<ViewPerson?>()
                            people.add(ViewPerson("انتخاب کنید"))
                            people.add(ViewPerson("متأهل"))
                            people.add(ViewPerson("مجرد"))
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
                        textView("تعداد فرزندان (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_child_care_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "تعداد فرزندان "
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
            //مشخصات شغلی
            verticalLayout {
                backgroundResource = R.drawable.style_bck_layout_user
                textView("مشخصات شغلی") {
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
                        textView("وضعیت اشتغال (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_priority_high_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "وضعیت اشتغال "
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
                        textView("عنوان محل اشتغال (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_keyboard_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "عنوان محل اشتغال "
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
                        textView("سمت (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_format_align_center_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "سمت "
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
                        textView("مدت اشتغال بر حسب سال (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_schedule_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "مدت اشتغال بر حسب سال"
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
                        textView("شماره تلفن محل اشتغال (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_local_phone_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "شماره تلفن محل اشتغال"
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
                        textView("استان محل اشتغال (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_vpn_lock_black_24dp
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
                        textView("شهر محل اشتغال (*)").lparams {
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
                        textView("آدرس محل اشتغال (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_place_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "آدرس محل اشتغال"
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
            //محل سکونت
            verticalLayout {
                backgroundResource = R.drawable.style_bck_layout_user
                textView("محل سکونت") {
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
                        textView("وضعیت محل سکونت (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_home_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            val people = ArrayList<ViewPerson?>()
                            people.add(ViewPerson("انتخاب کنید"))
                            people.add(ViewPerson("مستأجر"))
                            people.add(ViewPerson("مالک"))
                            people.add(ViewPerson("سایر"))
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
                        textView("کد پستی (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_local_post_office_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "کد پستی "
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
                        textView("شماره محل سکونت (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_local_phone_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "شماره محل سکونت"
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
                        textView("استان محل سکونت (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_vpn_lock_black_24dp
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
                        textView("شهر محل سکونت (*)").lparams {
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
                        textView("آدرس محل سکونت (*)").lparams {
                            lparamsElemanTitle()
                        }
                        linearLayout {
                            paddingElemansLay()
                            imageButton {
                                imageResource = R.drawable.ic_place_black_24dp
                            }.lparams {
                                lparamsIcons()
                            }
                            editText {
                                hint = "آدرس محل سکونت"
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

fun LinearLayout.LayoutParams.lparamsPartLay() {
    width = matchParent
    height = wrapContent
    topMargin = 10
    bottomMargin = 15
    leftMargin = 20
    rightMargin = 20
}

fun LinearLayout.LayoutParams.lparamsElemanTitle() {
    topMargin = 10
    bottomMargin = 2
    rightMargin = 10
}

fun LinearLayout.LayoutParams.lparamsIcons() {
    width = wrapContent
    height = 133
}

fun _LinearLayout.paddingElemansLay() {
    bottomPadding = 20
    leftPadding = 20
    rightPadding = 10
}

fun EditText.back_edt_text() {
    rightPadding = 10
    textSize = 13f
    backgroundResource = R.drawable.style_edit_text
}