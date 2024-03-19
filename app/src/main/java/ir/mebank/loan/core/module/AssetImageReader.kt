package ir.mebank.loan.core.module

import android.graphics.drawable.Drawable
import ir.mebank.loan.core.main.G
import java.io.IOException

object AssetImageReader {
  fun getImage(imageName: String): Drawable? {

    try {
      val imageInputStream = G.assetManager.open(imageName)
      return Drawable.createFromStream(imageInputStream, null)
    } catch (e: IOException) {
      e.printStackTrace()
    }

    return null
  }
}
