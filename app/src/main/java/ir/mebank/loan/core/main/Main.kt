package ir.mebank.loan.core.main

import android.content.Context
import android.content.Intent
import androidx.annotation.Keep
import androidx.appcompat.app.AppCompatActivity
import ir.mebank.loan.core.activity.general.MainActivity

@Keep
class Main {
  companion object {

    @Keep
    fun main(args: Array<Any>) {
      G.context = args[0] as Context
      G.initialize()
      val activity = args[1] as AppCompatActivity

      val intent = Intent(activity, MainActivity::class.java)
      activity.startActivity(intent)
      activity.finish()
    }
  }
}