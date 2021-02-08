package com.wlcookies.library.utils

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

object ToastUtil {
    /**
     * @param context 上下文对象
     * @param msg
     */
    fun show(context: Context, msg: String) {
        with(Toast.makeText(context, msg, Toast.LENGTH_SHORT)) {
//            setGravity(Gravity.CENTER, 0, 0)
            show()
        }
    }

    fun show(context: Context, @StringRes msgInt: Int) {
        with(Toast.makeText(context, msgInt, Toast.LENGTH_SHORT)) {
//            setGravity(Gravity.CENTER, 0, 0)
            show()
        }
    }

}