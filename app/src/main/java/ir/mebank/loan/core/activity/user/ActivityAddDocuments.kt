package ir.mebank.loan.core.activity.user

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentResolver
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Typeface
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import ir.mebank.loan.core.module.Debug
import ir.mebank.loan.core.module.PermissionHandler
import ir.mebank.loan.core.R
import ir.mebank.loan.core.module.adapter.SpinnerAdapter
import ir.mebank.loan.core.publicFun.ViewPerson
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import ir.mebank.loan.core.activity.XActivity
import ir.mebank.loan.core.fragment.btnLogin
import ir.mebank.loan.core.fragment.btnhClose
import ir.mebank.loan.core.main.G
import ir.mebank.loan.core.main.L
import ir.mebank.loan.core.module.AndroidPermission
import ir.mebank.loan.core.module.DrawerHelper.Companion.setDrawerView
import ir.mebank.loan.core.module.dip
import ir.mebank.loan.core.module.makeView
import ir.mebank.loan.core.module.mspace
import java.util.*

class ActivityAddDocuments : XActivity() {
companion object{
    lateinit var pic : ImageView
}
    var image_uri: Uri? = null
    private val IMAGE_CAPTURE_CODE: Int = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDrawerView(contentAddDucuments())
    }

    private fun openCamera() {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "camera image")
        values.put(MediaStore.Images.Media.DESCRIPTION, "camera image description")
        val a: ContentResolver
        image_uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri)
        startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE)
    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            pic.setImageURI(image_uri)
        }
    }


    fun contentAddDucuments() = makeView {
        scrollView {
            lparams(matchParent, matchParent)
            verticalLayout {
                lparams(matchParent, matchParent)
                gravity = Gravity.CENTER_HORIZONTAL
                //افزودن حساب بانکی
                verticalLayout {
                    backgroundResource = R.drawable.style_bck_layout_user
                    textView("افزودن مدارک") {
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
                            textView("عنوان مدرک(*)").lparams {
                                lparamsElemanTitle()
                            }
                            linearLayout {
                                paddingElemansLay()
                                imageButton {
                                    imageResource = R.drawable.ic_contacts_black_24dp
                                }.lparams {
                                    lparamsIcons()
                                }
                                val people = ArrayList<ViewPerson?>()
                                people.add(ViewPerson("نوع مدرک را انتخاب کنید"))
                                people.add(ViewPerson("سایر دارایی ها و اموال"))
                                people.add(ViewPerson("سند ملک"))
                                people.add(ViewPerson("تصویر اصل آخرین فیش حقوقی"))
                                people.add(ViewPerson("تصویر گردش سه ماه آخر حساب جاری"))
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
                            textView("توضیحات").lparams {
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
                                    hint = "توضیحات"
                                    back_edt_text()
                                }.lparams(matchParent, wrapContent) {
                                }
                            }.lparams(matchParent, wrapContent) {
                                gravity = Gravity.BOTTOM
                            }
                        }.lparams(matchParent, wrapContent)
                    }.lparams(matchParent, wrapContent)

                    verticalLayout {
                        backgroundResource = R.drawable.style_bck_layout_user
                        bottomPadding = 8.dip()
                        textView("تصویر مدارک (*)") {
                            textSize = 15f
                            setTypeface(typeface, Typeface.ITALIC + Typeface.BOLD)
                        }.lparams {
                            gravity = Gravity.CENTER
                        }
                        textView("برای بارگذاری تصویر داخل باکس زیر کلیک کنید") {
                            textSize = 12f
                            setTypeface(typeface, Typeface.ITALIC + Typeface.BOLD)
                        }.lparams {
                            gravity = Gravity.CENTER
                        }
                        imageView {
                            backgroundResource = R.drawable.list_devider_question
                        }.lparams {
                            width = matchParent
                            height = 2
                            topMargin = 6.dip()
                            bottomMargin = 4.dip()
                        }
                        pic = imageView {
                            backgroundResource = R.drawable.ic_launcher_background
                            bottomPadding = 4
                        }.lparams {
                            width = wrapContent
                            height = wrapContent
                            gravity = Gravity.CENTER
                        }

                    }.lparams {
                        lparamsPartLay()
                    }

                }.lparams {
                    lparamsPartLay()
                }
                linearLayout {
                    gravity = Gravity.CENTER_HORIZONTAL
                    button("افزودن") {
                        leftPadding = 100
                        rightPadding = 100
                        textSize = 15f
                        btnLogin()
                    }.lparams(0, wrapContent, 4.5f) {
                        rightMargin = 10
                        bottomMargin = 20
                    }.onClick {

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (checkSelfPermission(android.Manifest.permission.CAMERA)== PackageManager.PERMISSION_DENIED || checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                                PermissionHandler(
                                    listOf(
                                        AndroidPermission.CAMERA,
                                        AndroidPermission.WRITE_EXTERNAL_STORAGE
                                    )
                                ) {
                                    whyPermissionRequired = L.permissionRequiredMessage
                                    onGrant = {
                                        Debug.info("Client Granted second")
                                        openCamera()
                                    }
                                }
                            } else {
                                openCamera()
                            }
                        } else {
                            openCamera()
                        }
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
                        myIntent(ActivityDocuments())
                    }
                }
            }.applyRecursively {
                when (it) {
                    is TextView -> it.setTypeface(G.defaultFont, Typeface.ITALIC + Typeface.BOLD)
                }
            }
        }
    }
}