package ir.mebank.loan.core.activity.user

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import ir.mebank.loan.core.R
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk27.coroutines.onClick
import ir.mebank.loan.core.activity.XActivity
import ir.mebank.loan.core.main.G
import ir.mebank.loan.core.module.DrawerHelper.Companion.setDrawerView
import ir.mebank.loan.core.module.adapter.AdapterRecyclerDocuments
import ir.mebank.loan.core.module.dip
import ir.mebank.loan.core.module.makeView
import ir.mebank.loan.core.publicFun.Documents
import java.util.*

class ActivityDocuments : XActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDrawerView(contentDocuments())
    }
}

fun contentDocuments() = makeView {
    val documentsList = ArrayList<Documents>()
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
                textView("در این قسمت میتوانید تمامی مدارک و مستندات خود را مدیریت کنید.") {

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
                    textView("افزودن مدارک") { addStyleLayout() }.lparams(wrapContent, wrapContent)
                }.lparams(wrapContent, wrapContent).applyRecursively {
                    onClick {
                        myIntent(ActivityAddDocuments())
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
                    val loanRec = Documents()
                    loanRec.loan_doc_id = i
                    loanRec.pic_name = "name #$i"

                    documentsList.add(loanRec)
                }
                recyclerView.layoutManager = LinearLayoutManager(G.context, LinearLayoutManager.VERTICAL, false)
                val adapterPeroductRecycler = AdapterRecyclerDocuments(documentsList)
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

fun _LinearLayout.addStyleLayout() {
    backgroundResource = R.drawable.style_button_login
    gravity = Gravity.CENTER
    topPadding = 15
    bottomPadding = 25
    leftPadding = 100
    rightPadding = 100
}

fun ImageButton.addStyleLayout() {
    backgroundColor = Color.parseColor("#57b846")
    imageResource = R.drawable.ic_add_black_24dp
}

fun TextView.addStyleLayout() {
    setTypeface(typeface, Typeface.BOLD_ITALIC)
    textColor = Color.parseColor("#e3ffff")
    textSize = 17f
}