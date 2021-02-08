package com.wlcookies.library.utils

import android.app.ProgressDialog
import android.content.Context

class LoadingDialogUtil {
    companion object {

        private var progressDialog: ProgressDialog? = null

        fun show(context: Context, title: String, cancelable: Boolean) {
            progressDialog = ProgressDialog(context).apply {
                this.setMessage(title)
                this.setCancelable(cancelable)
                this.show()
            }
        }

        fun miss() {
            progressDialog?.let {
                if (it.isShowing) {
                    it.dismiss()
                }
            }
        }
    }

}