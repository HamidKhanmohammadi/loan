package ir.mebank.loan.core.main

import ir.mebank.loan.core.module.Debug
import ir.mebank.loan.core.module.Endpoint


class Endpoints {
  companion object {
    val testService = Endpoint().apply {
      url = "https://ware.uncox.com/api/profile"
      fail = { call, e -> Debug.info("Endpoint Failed " + e.message) }
    }

    val loanBranch = Endpoint().apply {
      url = "https://loan.mebank.ir/webservice"
      fail = { call, e -> Debug.info("loanBranche Failed : " + e.message) }
    }
  }
}