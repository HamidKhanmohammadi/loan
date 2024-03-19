package ir.mebank.loan.core.test

import android.graphics.Color
import android.view.Gravity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.viewpager.widget.ViewPager
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar
import ir.mebank.loan.core.R
import ir.mebank.loan.core.activity.general.AboutActivity
import ir.mebank.loan.core.activity.user.*
import ir.mebank.loan.core.branchInfo.BranchInfo
import ir.mebank.loan.core.fragment.btnLogin
import ir.mebank.loan.core.main.Endpoints
import ir.mebank.loan.core.main.G
import ir.mebank.loan.core.main.L
import ir.mebank.loan.core.module.*
import ir.mebank.loan.core.module.adapter.AdapterImagePager
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.viewPager


private fun testNotification() {
    val snoozePendingIntent = XIntent.createPendingIntent(AboutActivity::class.java)
    val notificationBodyPendingIntent = XIntent.createPendingIntent(AboutActivity::class.java)

    NotificationHandler.Builder(android.R.drawable.ic_dialog_info) {
        channelId = NotificationChannels.PUBLIC
        text = "Hello from Notification Module"
        title = "Some Notification"
        pendingIntent = notificationBodyPendingIntent

        addAction(android.R.drawable.ic_dialog_alert, "Snooze", snoozePendingIntent)
    }
}

private fun testDialogs() {
    HelperDialog.alertOk(
        message = "Some Message",
        title = "Title",
        onOk = {
            HelperDialog.alertOkCancel(
                message = "Message 2",
                onOk = {
                    HelperDialog.alertYesNo(
                        message = "Message 2",
                        onYes = {
                            HelperDialog.alertYesNoCancel(
                                message = "Message 2",
                                onYes = {

                                }
                            )
                        }
                    )
                }
            )
        }
    )
}

private fun testPermissionHandlers() {
    PermissionHandler(
        listOf(
            AndroidPermission.WRITE_EXTERNAL_STORAGE,
            AndroidPermission.RECEIVE_SMS
        )
    ) {
        whyPermissionRequired = L.permissionRequiredMessage
        onGrant = {
            Debug.info("Client Granted second")
        }
    }
}

fun testWebservice1() {
    val endpoint = Endpoints.testService
    val webservice = Webservice(endpoint, resource = "/generate",
        output = ProfileResponse.Response::class.java
    )

    webservice.request {
        data = ProfileInput(
            count = 10,
            gender = "both",
            type = "brief"
        )

        success = { call, response, content, entity ->
            if (entity!!.feeds.profiles.size > 5) {
                Debug.info(entity.feeds.profiles[0].firstname)
                Debug.info(entity.feeds.profiles[1].firstname)
                Debug.info(entity.feeds.profiles[2].firstname)
                Debug.info(entity.feeds.profiles[3].firstname)
                Debug.info(entity.feeds.profiles[4].firstname)
                Debug.info("Responce Received " + content)
            }
        }

        fail = { call, e ->
            Debug.info("Webservice Failed " + e?.message)
        }
    }
}
fun testWebservice2() {
    val endpoint = Endpoints.loanBranch
    val webservice = Webservice(endpoint, resource = "/Branches.php",
        output = BranchInfo.Branches::class.java
    )

    webservice.request {
        success = { call, response, content, entity ->
            Debug.info("Responce Received " + content)
        }
        fail = { call, e ->
            Debug.info("Webservice Failed " + e?.message)
        }
    }
}

fun generalContent2() = makeView {

    var imageId: Int = 0
    lateinit var imagePagerAdapter: AdapterImagePager
    lateinit var slider: ViewPager
    lateinit var title: String
    lateinit var desc: String
    val imageIds = ArrayList<Int>()
    val titles = ArrayList<String>()
    val descs = ArrayList<String>()

    constraintLayout {
        lparams {
            width = matchParent
            height = matchParent
            backgroundColor = Color.rgb(2, 151, 20)
        }
        button {
            text = "ورود"
            textColor = Color.parseColor("#007E42")
            width = wrapContent
            height = wrapContent
            backgroundResource = R.drawable.style_button_home
        }.lparams {
            bottomToBottom = ConstraintSet.PARENT_ID
            endToEnd = ConstraintSet.PARENT_ID
            horizontalBias = 0.334f
            startToStart = ConstraintSet.PARENT_ID
            topToTop = ConstraintSet.PARENT_ID
            verticalBias = 0.011f
        }
        button {
            text = "ثبت نام"
            textColor = Color.parseColor("#007E42")
            width = wrapContent
            height = wrapContent
            backgroundResource = R.drawable.style_button_home
        }.lparams {
            bottomToBottom = ConstraintSet.PARENT_ID
            endToEnd = ConstraintSet.PARENT_ID
            horizontalBias = 0.03f
            startToStart = ConstraintSet.PARENT_ID
            topToTop = ConstraintSet.PARENT_ID
            verticalBias = 0.011f
        }
        imageView(R.drawable.text_panel).lparams {
            width = dip(108)
            height = dip(47)
            topMargin = dip(2)
            bottomToBottom = ConstraintSet.PARENT_ID
            endToEnd = ConstraintSet.PARENT_ID
            horizontalBias = 0.855f
            startToStart = ConstraintSet.PARENT_ID
            topToTop = ConstraintSet.PARENT_ID
            verticalBias = 0.001f
        }
        imageView(R.drawable.white_favicon_180).lparams {
            width = dip(35)
            height = dip(35)
            topMargin = dip(2)
            marginEnd = dip(8)
            bottomToBottom = ConstraintSet.PARENT_ID
            endToEnd = ConstraintSet.PARENT_ID
            horizontalBias = 1.0f
            startToStart = ConstraintSet.PARENT_ID
            topToTop = ConstraintSet.PARENT_ID
            verticalBias = 0.011f
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
        }.lparams {
            bottomToBottom = ConstraintSet.PARENT_ID
            endToEnd = ConstraintSet.PARENT_ID
            horizontalBias = 0.491f
            startToStart = ConstraintSet.PARENT_ID
            topToTop = ConstraintSet.PARENT_ID
            verticalBias = 0.115f
            topMargin = 10.dip()
        }
    }
}

fun generalContent1() = makeView {
    verticalLayout {
        backgroundColor = Color.rgb(2, 151, 20)
        //mspace(10f)
        linearLayout {
            lparams {
                gravity = Gravity.RIGHT
            }
            linearLayout {
                lparams {
                    height = 120
                    gravity = Gravity.RIGHT
                }
                imageView(R.drawable.text_panel).lparams {
                    backgroundColor = Color.RED
                }
            }
            linearLayout {
                lparams {
                    gravity = Gravity.RIGHT
                    height = 120
                }
                imageView(R.drawable.white_favicon_180).lparams {
                    backgroundColor = Color.BLUE

                }
            }
        }
    }
    linearLayout {
        verticalLayout {
            lparams(0, wrapContent, 0.4f) {
                paddingElemansLay()
            }
            textView("نام پدر (*)").lparams {
                lparamsElemanTitle()
            }
            linearLayout {
                imageButton {
                    imageResource = R.drawable.ic_person_black_24dp
                }.lparams {
                    lparamsIcons()
                }
                editText {
                    hint = "نام پدر "
                    back_edt_text()
                }.lparams(matchParent, wrapContent){
                }
            }.lparams(matchParent, wrapContent){
                gravity = Gravity.BOTTOM
            }
        }
        verticalLayout {
            lparams(0, wrapContent, 0.6f) {
                paddingElemansLay()
            }
            textView("تاریخ تولد (*)").lparams {
                lparamsElemanTitle()
            }
            linearLayout {
                imageButton {
                    imageResource = R.drawable.ic_date_range_black_24dp
                }.lparams {
                    lparamsIcons()
                }
                ActivityIdentityInformation.txtD = textView {
                    hint = "تاریخ تولد"
                    textSize = 15f
                }.lparams(matchParent, wrapContent)

                ActivityIdentityInformation.txtD!!.onClick {

                    val my = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                        // Display Selected date in textbox
                        ActivityIdentityInformation.txtD!!.setText(" " + dayOfMonth + "/ " + monthOfYear + "/ " + year)
                    }

                    val pc = PersianCalendar()
                    val dataPickerDialog = DatePickerDialog.newInstance(
                        my,
                        pc.persianYear,
                        pc.persianMonth,
                        pc.persianDay)
                    dataPickerDialog.minYear
                    dataPickerDialog.show(G.currentActivity.fragmentManager, "Datepickerdialog")

                }

            }.lparams(matchParent, wrapContent)
        }
    }
    linearLayout {
        gravity = Gravity.CENTER_HORIZONTAL
        button("افزودن مدارک") {
            leftPadding = 100
            rightPadding = 100
            textSize = 15f
            btnLogin()
        }.lparams(wrapContent, wrapContent)
    }

}
