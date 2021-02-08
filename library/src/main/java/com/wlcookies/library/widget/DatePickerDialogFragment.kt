package com.wlcookies.library.widget

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.DatePicker
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.wlcookies.library.R
import java.util.*

class DatePickerDialogFragment(private val onDateSelectedListener: OnDateSelectedListener) :
    DialogFragment() {


    interface OnDateSelectedListener {
        fun onDateSelected(year: Int, month: Int, day: Int)
    }

    companion object {
        private const val YEAR = "year"
        private const val MONTH = "month"
        private const val DAY = "day"

        val c = Calendar.getInstance()

        fun getInstance(
            y: Int,
            m: Int,
            d: Int,
            onDateSelectedListener: OnDateSelectedListener
        ): DatePickerDialogFragment {
            val datePickerDialogFragment = DatePickerDialogFragment(onDateSelectedListener)
            val bundle = Bundle()
            bundle.putInt(YEAR, y)
            bundle.putInt(MONTH, m)
            bundle.putInt(DAY, d)
            datePickerDialogFragment.arguments = bundle
            return datePickerDialogFragment
        }
    }

    private var _init_year = 0
    private var _init_month = 0
    private var _init_day = 0

    private var _picker_year = 0
    private var _picker_month = 0
    private var _picker_day = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val arguments = arguments
        _init_year = arguments?.getInt(YEAR) ?: c.get(Calendar.YEAR)
        _init_month = arguments?.getInt(MONTH) ?: c.get(Calendar.MONTH)
        _init_day = arguments?.getInt(DAY) ?: c.get(Calendar.DAY_OF_MONTH)
        // 日期选择器样式

        _picker_year = _init_year
        _picker_month = _init_month + 1
        _picker_day = _init_day

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = LayoutInflater.from(requireContext()).inflate(R.layout.date_picker_layout, null)

        val datePickerView = view.findViewById<DatePicker>(R.id.datePicker)

        datePickerView.init(
            _init_year, _init_month, _init_day
        ) { _, y, m, d ->
            _picker_year = y
            _picker_month = m + 1
            _picker_day = d
        }

        val dialogBuilder = AlertDialog.Builder(requireContext())
        dialogBuilder.setView(view)
        dialogBuilder.setPositiveButton("确定") { _, _ ->
            onDateSelectedListener.onDateSelected(_picker_year, _picker_month, _picker_day)
        }
        dialogBuilder.setNegativeButton("取消") { d, w ->

        }
        return dialogBuilder.create()
    }

}
