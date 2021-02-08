package com.wlcookies.library.utils

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog

/**
 * ```
 * 两个按钮的提示框
 *
 * 创建时间： 2/8/21
 * 更新说明： `[序号][日期YYYY-MM-DD] [更改人姓名][变更描述]`
 *  1. -
 * ```
 * @author wg
 */
object AlertUtil {

    enum class ButtonType {
        POSITIVE, NEGATIVE
    }

    /**
     * 简单的弹出框，确定、取消
     */
    fun showMsg(
        context: Context,
        msg: String,
        positive: String = "确定",
        negative: String = "取消",
        title: String = "提示",
        cancelable: Boolean = true,
        actionButton: (buttonType: ButtonType, dialog: DialogInterface, which: Int) -> Unit,
    ) {
        AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(msg)
            .setCancelable(cancelable)
            .setPositiveButton(positive) { d, w ->
                actionButton(ButtonType.POSITIVE, d, w)
            }
            .setNegativeButton(negative) { d, w ->
                actionButton(ButtonType.NEGATIVE, d, w)
            }
            .create()
            .show()
    }
}