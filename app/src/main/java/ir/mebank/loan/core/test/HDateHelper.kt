package ir.mebank.loan.core.test

import android.app.Activity
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar

object HDateHelper {
  fun openDatePicker(activity: Activity, listener: DatePickerDialog.OnDateSetListener, year: Int, month: Int, day: Int) {
    show(activity, listener, year, month - 1, day)

  }

  fun openDatePicker(activity: Activity, listener: DatePickerDialog.OnDateSetListener) {
    val calendar = PersianCalendar()
    val year = calendar.persianYear
    val month = calendar.persianMonth
    val day = calendar.persianDay

    show(activity, listener, year, month, day)
  }

  fun show(activity: Activity, listener: DatePickerDialog.OnDateSetListener, year: Int, month: Int, day: Int) {
    DatePickerDialog.newInstance( listener, year, month, day).show(activity.fragmentManager,"Datepickerdialog")
  }
}
