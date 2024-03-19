package ir.mebank.loan.core.module

import ir.mebank.loan.core.main.G
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.runOnUiThread

typealias FunctionBlock = () -> Unit
typealias MethodBlock<T> = T.() -> Unit
typealias AndroidPermission = android.Manifest.permission

fun launch(block: FunctionBlock) = GlobalScope.launch {
    block()
}

fun launch(delay: Long, block: FunctionBlock) = GlobalScope.launch {
    kotlinx.coroutines.delay(delay)
    block()
}


fun runOnUi(block: FunctionBlock) = GlobalScope.launch {
    G.context.runOnUiThread {
        block()
    }
}

fun runOnUi(delay: Long, block: FunctionBlock) = GlobalScope.launch {
    kotlinx.coroutines.delay(delay)
    G.context.runOnUiThread {
        block()
    }
}
