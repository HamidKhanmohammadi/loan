package ir.mebank.loan.core.module

import android.content.Context
import android.widget.Space
import org.jetbrains.anko.*
import ir.mebank.loan.core.main.G


fun _LinearLayout.mspace(weight: Float): Space {
  return space().lparams(0, 0, weight)
}

fun makeView(init: AnkoContext<Context>.() -> Unit) = G.currentActivity.UI {
  init()
}.view


fun Int.dip() = G.context.dip(this)
