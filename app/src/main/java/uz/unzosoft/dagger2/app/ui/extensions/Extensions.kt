package uz.unzosoft.dagger2.app.ui.extensions

import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager


/**
 * Created by Abdurashidov Shahzod on 23/02/22 02:20.
 * company QQBank
 * shahzod9933@gmail.com
 */

fun Window.transparentStatusBar() {
    setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true, this)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        this.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }

    if (Build.VERSION.SDK_INT >= 21) {
        setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false, this)
        this.statusBarColor = Color.TRANSPARENT
    }
}
private fun setWindowFlag(bits: Int, on: Boolean, window: Window) {
    val winParams = window.attributes
    if (on) {
        winParams.flags = winParams.flags or bits
    } else {
        winParams.flags = winParams.flags and bits.inv()
    }
    window.attributes = winParams
}