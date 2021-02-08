package com.wlcookies.funsometools

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import com.wlcookies.funsometools.databinding.ActivityMainBinding
import com.wlcookies.library.utils.*
import com.wlcookies.library.widget.DatePickerDialogFragment
import java.util.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.showPopupWindowBt.setOnClickListener(this)

        "123456".md5().log()

        getUUID().log()

        getTimeUUID().log()

        Date().format().log()
        Date().format(FORM_DATE_STR_2).log()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            // 显示PopWindow
            R.id.showPopupWindowBt -> {
                AlertUtil.showMsg(this, "haha") { buttonType, dialog, which ->
                    when (buttonType) {
                        AlertUtil.ButtonType.POSITIVE -> {
                            LoadingDialogUtil.show(this, "sad", true)
                        }
                        AlertUtil.ButtonType.NEGATIVE -> {
                            ToastUtil.show(this, "asdasd")
                        }
                    }
                }
            }
            else -> {
            }
        }
    }
}