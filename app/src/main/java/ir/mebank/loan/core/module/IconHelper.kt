package ir.mebank.loan.core.module

import android.graphics.Color
import com.mikepenz.iconics.IconicsColor
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.typeface.library.googlematerial.GoogleMaterial
import com.mikepenz.iconics.utils.toIconicsSizeDp
import ir.mebank.loan.core.main.G

class IconHelper {
  companion object {
    fun icon(name: GoogleMaterial.Icon, size: Int = 24, color: Int = Color.WHITE, padding: Int = 0): IconicsDrawable {
      return IconicsDrawable(G.context, name)
        .size(size.toIconicsSizeDp())
        .color(IconicsColor.colorInt(color))
        .padding(padding.toIconicsSizeDp())
    }
  }
}