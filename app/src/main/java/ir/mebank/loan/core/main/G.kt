package ir.mebank.loan.core.main

import android.app.Application
import android.content.Context
import android.content.res.AssetManager
import android.graphics.Typeface
import android.view.View
import androidx.core.content.res.ResourcesCompat
import ir.mebank.loan.core.activity.XActivity
import ir.mebank.loan.core.module.Configurator
import ir.mebank.loan.core.module.Debug
import ir.mebank.loan.core.module.ThemeHelper
import ir.mebank.loan.core.module.lang.EnLang
import ir.mebank.loan.core.module.lang.FaLang
import ir.mebank.loan.core.module.lang.Lang
import org.jetbrains.anko.defaultSharedPreferences

val L = G.language

class G : Application() {
    companion object {
        lateinit var currentActivity: XActivity
        lateinit var language: Lang
        lateinit var context: Context
        lateinit var assetManager: AssetManager
        var versionCode: Int = 100
        var versionName: String = "1.00"
        lateinit var theme: String
        var locale: String = "fa"
        lateinit var defaultFont: Typeface

        var layoutDirection: Int = View.LAYOUT_DIRECTION_LTR

        var config: Configurator? = null
            set(value) {
                field = value
                value?.config()
                value?.populateNotificationChannels()
            }


        fun initialize() {
            theme = context.defaultSharedPreferences.getString("theme", "light")!!
            assetManager = context.assets
            config()
        }

        fun config() {
            Debug.logTag = "Sample"
            Debug.level = Debug.LOG_LEVEL.DEBUG
            language = EnLang()

            processLanguage()
        }

        private fun processLanguage() {
            when (locale) {
                "en" -> {
                    language = EnLang()
                    layoutDirection = View.LAYOUT_DIRECTION_LTR
                    defaultFont = ResourcesCompat.getFont(
                        context,
                        ThemeHelper.getResource("english", "font")
                    )!!
                }

                "fa" -> {
                    language = FaLang()
                    layoutDirection = View.LAYOUT_DIRECTION_RTL
                    defaultFont =
                        ResourcesCompat.getFont(context, ThemeHelper.getResource("farsi", "font"))!!
                }
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = this.applicationContext
        initialize()
    }
}