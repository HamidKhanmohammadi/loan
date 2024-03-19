package ir.mebank.loan.core.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import ir.mebank.loan.core.module.Debug
import ir.mebank.loan.core.module.PermissionHandler
import ir.mebank.loan.core.main.G
import ir.mebank.loan.core.module.Config
import ir.mebank.loan.core.module.ThemeHelper

abstract class XActivity: AppCompatActivity() {
  private val permissionHandlers = mutableListOf<PermissionHandler>()

  override fun onCreate(savedInstanceState: Bundle?) {
    initializeConfigurator()
    super.onCreate(savedInstanceState)
    G.currentActivity = this
    ThemeHelper.applyTheme()
  }

  override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
    initializeConfigurator()
    super.onCreate(savedInstanceState, persistentState)
    G.currentActivity = this
    ThemeHelper.applyTheme()
  }

  override fun onResume() {
    super.onResume()
    G.currentActivity = this
  }

  override fun onStart() {
    super.onStart()
    G.currentActivity = this
    Debug.warn("Activity ${this::class.java.simpleName} Started")
  }

  override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
    for (permissionHandler in permissionHandlers) {
      if (permissionHandler.processOnPermissionResult(requestCode, permissions, grantResults)) {
        return
      }
    }
  }

  fun addPermissionHandler(permissionHandler: PermissionHandler) {
    permissionHandlers.add(permissionHandler)
  }

  private fun initializeConfigurator() {
    if (G.config == null) {
      G.config = Config()
    }
  }
}