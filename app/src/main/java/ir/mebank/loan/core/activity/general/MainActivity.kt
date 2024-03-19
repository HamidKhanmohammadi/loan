package ir.mebank.loan.core.activity.general

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import ir.mebank.loan.core.R
import ir.mebank.loan.core.activity.XActivity
import ir.mebank.loan.core.activity.user.myIntent
import ir.mebank.loan.core.main.G
import ir.mebank.loan.core.module.HelperDialog
import ir.mebank.loan.core.module.adapter.AdapterImagePager
import ir.mebank.loan.core.module.dip
import ir.mebank.loan.core.module.makeView
import ir.mebank.loan.core.module.mspace
import ir.mebank.loan.core.test.PagerIndicator
import ir.mebank.loan.core.test.testWebservice2
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.viewPager

class MainActivity : XActivity() {
    private val handler = Handler()
    private var runnable: Runnable? = null

    var imageId: Int = 0
    lateinit var imagePagerAdapter: AdapterImagePager
    lateinit var slider: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_about)
        setContentView(generalContent())
        //setDrawerView(generalContent())
        testWebservice2()
    }

    override fun onStart() {
        handler.postDelayed(object : Runnable {
            override fun run() {
                imageId++
                if (imageId >= imagePagerAdapter.count) {
                    imageId = 0
                }
                slider.currentItem = imageId
                runnable = this
                handler.postDelayed(runnable, 5000)
            }
        }, 5000)
        super.onStart()
    }

    fun generalContent() = makeView {
        lateinit var title: String
        lateinit var desc: String
        val imageIds = ArrayList<Int>()
        val titles = ArrayList<String>()
        val descs = ArrayList<String>()
        verticalLayout {
            linearLayout {
                lparams {
                    width = matchParent
                    height = wrapContent
                    backgroundColor = Color.parseColor("#078A07")
                    padding = 7.dip()
                    bottomPadding = 7.dip()
                }
                button {
                    text = "ورود"
                    btnHome()
                }.setOnClickListener{
                    myIntent(RegisterActivity())
                }
                button {
                    text = "ثبت نام"
                    btnHome()
                }.lparams {
                    leftMargin = 2.dip()
                }.onClick{
                    myIntent(RegisterActivity())
                }
                mspace(0.5f)
                imageView(R.drawable.text_panel).lparams {
                    width = dip(108)
                    height = dip(47)
                    topMargin = dip(2)
                }
                imageView(R.drawable.white_favicon_180).lparams {
                    width = dip(35)
                    height = dip(35)
                    topMargin = dip(8)
                    marginEnd = dip(8)
                }
            }
            scrollView {
                lparams {
                    width = matchParent
                    height = matchParent
                }
                verticalLayout {
                    lparams {
                        width = matchParent
                        height = matchParent
                        gravity = Gravity.CENTER
                    }
                    verticalLayout {
                        lparams {
                            width = matchParent
                            height = wrapContent
                            greenLayout()
                        }
                        verticalLayout {
                            slider = viewPager {
                                for (i in 1..4) {
                                    imageId = G.context.resources.getIdentifier(
                                        "slide$i",
                                        "drawable",
                                        G.context.packageName
                                    )
                                    imageIds.add(imageId)
                                    when (imageIds.size) {
                                        1 -> {
                                            title = "محاسبه آنلاین سود تسهیلات"
                                            desc =
                                                "با ثبت نام در سامانه تسهیلات می توانید با انتخاب طرح مورد نظر خود و مبلغ تسهیلات ، سود تسهیلات و تعداد قسط های خود را مشاهده کنید"
                                        }
                                        2 -> {
                                            title = "درخواست آنلاین تسهیلات"
                                            desc =
                                                "شما میتوانید در این سامانه ، تسهیلات مورد نظر خود را به صورت آنلاین درخواست داده و از روند پیشرفت آن مطلع شوید"
                                        }
                                        3 -> {
                                            title = "پیگیری درخواست تسهیلات"
                                            desc =
                                                "با پیگیری درخواست تسهیلات ، پس از تأییدیه با مراجعه به شعبه تسهیلات خود را دریافت کنید"
                                        }
                                        4 -> {
                                            title = "دریافت راهنمای کاربری"
                                            desc =
                                                "برای آشنایی با روند ثبت درخواست تسهیلات می توانید فایل را بارگزاری کنید"
                                        }
                                    }
                                    titles.add(title)
                                    descs.add(desc)
                                }

                                imagePagerAdapter = AdapterImagePager(imageIds, titles, descs)
                            }.lparams {
                                width = matchParent
                                height = 230.dip()
                            }
                            slider.adapter = imagePagerAdapter
                            addView(PagerIndicator(this.context))
                        }
                    }
                    verticalLayout {
                        lparams {
                            width = matchParent
                            height = wrapContent
                            wightLayout()
                        }
                        linearLayout {
                            backgroundResource = R.drawable.style_title_l1
                            gravity = Gravity.CENTER
                            textView("طرح های تسهیلات") {
                                textSize = 26f
                                textColor = Color.BLACK
                            }
                        }
                        linearLayout {
                            lparams {
                                width = matchParent
                                height = matchParent
                                topMargin = 2.dip()
                                leftMargin = 2.dip()
                                rightMargin = 2.dip()
                                bottomMargin = 2.dip()
                            }
                            verticalLayout {
                                lparams {
                                    width = 0.dip()
                                    height = wrapContent
                                    weight = 1F
                                    topMargin = 2.dip()
                                    leftMargin = 2.dip()
                                    rightMargin = 2.dip()
                                    bottomMargin = 2.dip()
                                    backgroundResource = R.drawable.style_bck_layout
                                }
                                textView("میثاق قرض الحسنه") {
                                    txtTitleLoan()
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                                imageView {
                                    backgroundResource = R.drawable.list_devider_loan

                                }.lparams {
                                    width = matchParent
                                    height = 2
                                    topMargin = 2.dip()
                                    leftMargin = 2.dip()
                                    rightMargin = 2.dip()
                                    bottomMargin = 2.dip()
                                }
                                textView {
                                    text =
                                        "این طرح در راستای اعمال سیاست های خدماتی برای اعطای وام ارزان قیمت با هدف کمک به تامین منابع مالی مو..."
                                    txtdescLoan()
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent

                                }
                            }
                            verticalLayout {
                                lparams {
                                    width = 0.dip()
                                    height = wrapContent
                                    weight = 1F
                                    topMargin = 2.dip()
                                    leftMargin = 2.dip()
                                    rightMargin = 2.dip()
                                    bottomMargin = 2.dip()
                                    backgroundResource = R.drawable.style_bck_layout
                                }
                                textView("ثمین 2") {
                                    txtTitleLoan()
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                                imageView {
                                    backgroundResource = R.drawable.list_devider_loan

                                }.lparams {
                                    width = matchParent
                                    height = 2
                                    topMargin = 2.dip()
                                    leftMargin = 2.dip()
                                    rightMargin = 2.dip()
                                    bottomMargin = 2.dip()
                                }
                                textView {
                                    text =
                                        "این طرح در راستای اعمال سیاست های خدماتی و با هدف کمک به تامین منابع مالی مورد نیاز مشتریان برای خرید..."
                                    txtdescLoan()
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent

                                }
                            }
                        }
                        linearLayout {
                            lparams {
                                width = matchParent
                                height = matchParent
                                topMargin = 2.dip()
                                leftMargin = 2.dip()
                                rightMargin = 2.dip()
                                bottomMargin = 2.dip()
                            }
                            verticalLayout {
                                lparams {
                                    width = 0.dip()
                                    height = wrapContent
                                    weight = 1F
                                    topMargin = 2.dip()
                                    leftMargin = 2.dip()
                                    rightMargin = 2.dip()
                                    bottomMargin = 2.dip()
                                    backgroundResource = R.drawable.style_bck_layout
                                }
                                textView("میثاق مبادله ای") {
                                    txtTitleLoan()
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                                imageView {
                                    backgroundResource = R.drawable.list_devider_loan
                                }.lparams {
                                    width = matchParent
                                    height = 2
                                    topMargin = 2.dip()
                                    leftMargin = 2.dip()
                                    rightMargin = 2.dip()
                                    bottomMargin = 2.dip()
                                }
                                textView {
                                    text =
                                        "این طرح در راستای اعمال سیاست های خدماتی برای اعطای تسهیلات ارزان قیمت با هدف کمک به تامین منابع مالی..."
                                    txtdescLoan()
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent

                                }
                            }
                            verticalLayout {
                                lparams {
                                    width = 0.dip()
                                    height = wrapContent
                                    weight = 1F
                                    topMargin = 2.dip()
                                    leftMargin = 2.dip()
                                    rightMargin = 2.dip()
                                    bottomMargin = 2.dip()
                                    backgroundResource = R.drawable.style_bck_layout
                                }
                                textView("مهر") {
                                    txtTitleLoan()
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                                imageView {
                                    backgroundResource = R.drawable.list_devider_loan

                                }.lparams {
                                    width = matchParent
                                    height = 2
                                    topMargin = 2.dip()
                                    leftMargin = 2.dip()
                                    rightMargin = 2.dip()
                                    bottomMargin = 2.dip()
                                }
                                textView {
                                    text =
                                        "سپرده سرمایه گذاری طرح مهر در راستای اعمال سیاست های خدماتی و با هدف کمک به تأمین منابع مالی مورد نیاز..."
                                    txtdescLoan()
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent

                                }
                            }
                        }
                        linearLayout {
                            lparams {
                                width = matchParent
                                height = matchParent
                                topMargin = 2.dip()
                                leftMargin = 2.dip()
                                rightMargin = 2.dip()
                                bottomMargin = 2.dip()
                            }
                            verticalLayout {
                                lparams {
                                    width = 0.dip()
                                    height = wrapContent
                                    weight = 1F
                                    topMargin = 2.dip()
                                    leftMargin = 2.dip()
                                    rightMargin = 2.dip()
                                    bottomMargin = 2.dip()
                                    backgroundResource = R.drawable.style_bck_layout
                                }
                                textView("ثمین 3") {
                                    txtTitleLoan()
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                                imageView {
                                    backgroundResource = R.drawable.list_devider_loan

                                }.lparams {
                                    width = matchParent
                                    height = 2
                                    topMargin = 2.dip()
                                    leftMargin = 2.dip()
                                    rightMargin = 2.dip()
                                    bottomMargin = 2.dip()
                                }
                                textView {
                                    text =
                                        "طرح ثمین در راستای اعمال سیاست های خدماتی و با هدف کمک به تامین منابع مالی مورد نیاز مشتریان..."
                                    txtdescLoan()
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent

                                }
                            }
                            verticalLayout {
                                lparams {
                                    width = 0.dip()
                                    height = wrapContent
                                    weight = 1F
                                    topMargin = 2.dip()
                                    leftMargin = 2.dip()
                                    rightMargin = 2.dip()
                                    bottomMargin = 2.dip()
                                    backgroundResource = R.drawable.style_bck_layout
                                }
                                textView("شمیم مهر") {
                                    txtTitleLoan()
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                                imageView {
                                    backgroundResource = R.drawable.list_devider_loan

                                }.lparams {
                                    width = matchParent
                                    height = 2
                                    topMargin = 2.dip()
                                    leftMargin = 2.dip()
                                    rightMargin = 2.dip()
                                    bottomMargin = 2.dip()
                                }
                                textView {
                                    text =
                                        "سپرده سرمایه گذاری شمیم مهر راستای اعمال سیاست های خدماتی و با هدف کمک به تامین منابع مالی مو..."
                                    txtdescLoan()
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent

                                }
                            }
                        }
                        linearLayout {
                            lparams {
                                width = matchParent
                                height = matchParent
                                topMargin = 2.dip()
                                leftMargin = 2.dip()
                                rightMargin = 2.dip()
                                bottomMargin = 2.dip()
                            }
                            verticalLayout {
                                lparams {
                                    width = 0.dip()
                                    height = wrapContent
                                    weight = 1F
                                    topMargin = 2.dip()
                                    leftMargin = 2.dip()
                                    rightMargin = 2.dip()
                                    bottomMargin = 2.dip()
                                    backgroundResource = R.drawable.style_bck_layout
                                }
                                textView("سرو مهر - خرید دین") {
                                    txtTitleLoan()
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                                imageView {
                                    backgroundResource = R.drawable.list_devider_loan

                                }.lparams {
                                    width = matchParent
                                    height = 2
                                    topMargin = 2.dip()
                                    leftMargin = 2.dip()
                                    rightMargin = 2.dip()
                                    bottomMargin = 2.dip()
                                }
                                textView {
                                    text =
                                        "تعریف طرح سرو مهر(خرید دین) : در این طرح بانک به منظور سهولت در تأمین منابع مالی و سرمایه..."
                                    txtdescLoan()
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent

                                }
                            }
                            verticalLayout {
                                lparams {
                                    width = 0.dip()
                                    height = wrapContent
                                    weight = 1F
                                    topMargin = 2.dip()
                                    leftMargin = 2.dip()
                                    rightMargin = 2.dip()
                                    bottomMargin = 2.dip()
                                    backgroundResource = R.drawable.style_bck_layout
                                }
                                textView("مشارکت مدنی") {
                                    txtTitleLoan()
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                                imageView {
                                    backgroundResource = R.drawable.list_devider_loan

                                }.lparams {
                                    width = matchParent
                                    height = 2
                                    topMargin = 2.dip()
                                    leftMargin = 2.dip()
                                    rightMargin = 2.dip()
                                    bottomMargin = 2.dip()
                                }
                                textView {
                                    text =
                                        "بانک به منظور تأمین منابع مالی اشخاص حقیقی و حقوقی در زمینه فعالیت های تولیدی ، بازرگانی و..."
                                    txtdescLoan()
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent

                                }
                            }
                        }
                    }
                    verticalLayout {
                        lparams {
                            width = matchParent
                            height = wrapContent
                            greenLayout()
                        }
                        linearLayout {
                            gravity = Gravity.CENTER
                            backgroundResource = R.drawable.style_title_l2
                            textView("سوالات متداول") {
                                textSize = 26f
                                textColor = Color.WHITE
                            }
                        }
                        verticalLayout {
                            textView("سامانه تسهیلات اینترنتی مهر اقتصاد چیست؟") {
                                question()
                                setOnClickListener {
                                    HelperDialog.alertOk(
                                        title = "جواب سوال",
                                        message = "شما با ثبت نام در این سامانه می توانید، درخواست تسهیلات خود را به صورت آنلاین بدهیدو بعد از تاییدیه آن به شعبه مراجعه وتسهیلات خود را دریافت کنید.",
                                        onOk = {
                                        }
                                    )
                                }
                            }
                            imageView {
                                backgroundResource = R.drawable.list_devider_question

                            }.lparams {
                                width = matchParent
                                height = 2
                                topMargin = 2.dip()
                                leftMargin = 2.dip()
                                rightMargin = 2.dip()
                                bottomMargin = 2.dip()
                            }
                            textView("اگر دربانک مهر اقتصاد حساب نداشته باشیم، میتوانیم وام بگیریم ؟ ") {
                                question()
                                setOnClickListener {
                                    HelperDialog.alertOk(
                                        title = "جواب سوال",
                                        message = "بله، با ثبت نام در این سایت میتوانید درخواست تسهیلات خود را بدهید و بعد از تاییدیه از سوی بانک، به شعبه مراجعه کنید و تسهیلات خود را دریافت کنید.",
                                        onOk = {
                                        }
                                    )
                                }
                            }
                            imageView {
                                backgroundResource = R.drawable.list_devider_question

                            }.lparams {
                                width = matchParent
                                height = 2
                                topMargin = 2.dip()
                                leftMargin = 2.dip()
                                rightMargin = 2.dip()
                                bottomMargin = 2.dip()
                            }
                            textView("آیا هر نوع طرح تسهیلات را میتوانیم به صورت آنلاین دریافت کنیم ؟") {
                                question()
                                setOnClickListener {
                                    HelperDialog.alertOk(
                                        title = "جواب سوال",
                                        message = "بله، هر طرح تسهیلاتی که در بانک مهر اقتصاد باشد، را میتوانید از این سامانه درخواست بدهید.",
                                        onOk = {
                                        }
                                    )
                                }
                            }
                            imageView {
                                backgroundResource = R.drawable.list_devider_question
                            }.lparams {
                                width = matchParent
                                height = 2
                                topMargin = 2.dip()
                                leftMargin = 2.dip()
                                rightMargin = 2.dip()
                                bottomMargin = 2.dip()
                            }
                            textView("آیا می توان سود تسهیلات و مبلغ ماهیانه قسط را به صورت آنلاین محسابه کرد ؟") {
                                question()
                                setOnClickListener {
                                    HelperDialog.alertOk(
                                        title = "جواب سوال",
                                        message = "بله، با ثبت نام در سامانه میتوانید مبلغ تسهیلات و مدت زمان بازگشت آن را مشخص کرده و سود آن به صورت اتوماتیک محاسبه می شود.",
                                        onOk = {
                                        }
                                    )
                                }
                            }
                        }
                    }
                    verticalLayout {
                        wightLayout()
                        linearLayout {
                            backgroundResource = R.drawable.style_title_l1
                            gravity = Gravity.CENTER
                            textView("ارتباط با ما") {
                                textSize = 26f
                                textColor = Color.BLACK
                            }
                        }
                        linearLayout {
                            editText {
                                hint = "email@example.com"
                            }.lparams {
                                width = 0
                                height = wrapContent
                                weight = 1f
                            }
                            mspace(0.20f)
                            editText {
                                hint = "نام"
                            }.lparams {
                                width = 0
                                height = wrapContent
                                weight = 1f
                            }
                        }
                        editText {
                            hint = "موضوع"
                        }.lparams {
                            width = matchParent
                            height = wrapContent
                        }
                        editText {
                            hint = "متن پیام"
                            setSingleLine(false)
                            imeOptions = EditorInfo.IME_FLAG_NO_ENTER_ACTION
                        }.lparams {
                            width = matchParent
                            height = wrapContent
                        }
                        button("ارسال") {
                            textSize = 17f
                            btnHome()
                        }.lparams {
                            width = 150.dip()
                            gravity = Gravity.CENTER
                            topMargin = 10.dip()
                            bottomMargin = 10.dip()
                        }
                    }
                }
            }
        }.applyRecursively {
            when (it) {
                is TextView -> it.setTypeface(G.defaultFont, it.typeface.style)
            }
        }
    }
}

fun _LinearLayout.wightLayout() {
    backgroundColor = Color.parseColor("#f2fef5")
}

fun _LinearLayout.greenLayout() {
    backgroundColor = Color.rgb(2, 151, 20)
    gravity = Gravity.CENTER
}

fun TextView.txtTitleLoan() {
    textSize = 21f
    gravity = Gravity.CENTER
    textColor = Color.BLACK
    setTypeface(typeface, Typeface.ITALIC)
}

fun TextView.txtdescLoan() {
    padding = 6.dip()
    gravity = Gravity.CENTER
    textColor = Color.BLACK
}

fun TextView.question() {
    padding = 8.dip()
    textColor = Color.WHITE
    textSize = 15f
}

fun Button.btnHome() {
    setTypeface(typeface, Typeface.BOLD_ITALIC)
    textColor = Color.parseColor("#007E42")
    width = wrapContent
    height = wrapContent
    backgroundResource = R.drawable.style_button_home
}