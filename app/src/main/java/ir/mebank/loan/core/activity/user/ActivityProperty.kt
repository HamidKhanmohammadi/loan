package ir.mebank.loan.core.activity.user

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import ir.mebank.loan.core.R
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk27.coroutines.onClick
import ir.mebank.loan.core.activity.XActivity
import ir.mebank.loan.core.main.G
import ir.mebank.loan.core.module.DrawerHelper.Companion.setDrawerView
import ir.mebank.loan.core.module.adapter.AdapterRecyclerProperty
import ir.mebank.loan.core.module.dip
import ir.mebank.loan.core.module.makeView
import ir.mebank.loan.core.publicFun.Property
import java.util.*

class ActivityProperty : XActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDrawerView(contentProperty())
    }
}

fun contentProperty() = makeView {
    val propertyList = ArrayList<Property>()

    verticalLayout {
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
                textView(
                    "در این قسمت اطلاعات مربوط به اموال و دارایی خود را درج نمایید.\n" +
                            "\n" +
                            "شایان ذکر است فایل اموال و دارایی های درج شده در قسمت مدارک بارگذاری گردد."
                ) {

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
            linearLayout {
                gravity = Gravity.CENTER
                verticalLayout {
                    addStyleLayout()
                    imageButton { addStyleLayout() }.lparams(wrapContent, wrapContent)
                    textView("افزودن دارایی") { addStyleLayout() }.lparams(wrapContent, wrapContent)
                }.lparams(wrapContent, wrapContent).applyRecursively {
                    onClick {
                        myIntent(ActivityAddProperty())
                    }
                }
            }.lparams(matchParent, wrapContent)
            imageView {
                backgroundResource = R.drawable.list_devider_question
            }.lparams {
                width = matchParent
                height = 2
                topMargin = 6.dip()
                bottomMargin = 4.dip()
            }
            verticalLayout {
                val recyclerView = recyclerView {}
                for (i in 0..49) {
                    val loanRec = Property()
                    loanRec.loan_row = i
                    loanRec.type_asset = "خودرو $i"
                    loanRec.description = "این یک توضیح است :  $i"
                    loanRec.approximate_value = (Math.random() * 20 + 10).toInt() * 100

                    propertyList.add(loanRec)
                }
                recyclerView.layoutManager = LinearLayoutManager(G.context, LinearLayoutManager.VERTICAL, false)
                val adapterPeroductRecycler = AdapterRecyclerProperty(propertyList)
                recyclerView.adapter = adapterPeroductRecycler
                adapterPeroductRecycler.notifyDataSetChanged()
            }
        }.applyRecursively {
            when (it) {
                is TextView -> it.setTypeface(G.defaultFont, Typeface.ITALIC + Typeface.BOLD)
            }
        }
    }
}

fun myIntent(activity: XActivity) {
    G.currentActivity.startActivity(Intent(G.context, activity::class.java))
}