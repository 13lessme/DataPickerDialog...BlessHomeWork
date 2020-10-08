package com.example.datapickerdialogbless

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateUtils
import android.view.View
import android.widget.DatePicker
import android.widget.TextView
import androidx.core.graphics.scaleMatrix
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
var currentDateTime: TextView? = null
    private var dateAndTime = Calendar.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        currentDateTime = findViewById<View>(R.id.currentDataTime) as TextView
        setInitialDataTime()
        btnAlertTo.setOnClickListener {
            startActivity(Intent(this, AlertActivity::class.java))
        }
    }



    fun setDate(view: View) {
        DatePickerDialog(this@MainActivity, date,
            dateAndTime[Calendar.YEAR],
        dateAndTime[Calendar.MONTH],
            dateAndTime[Calendar.DAY_OF_MONTH]).show()
    }

    fun setTime(view: View) {
        TimePickerDialog(this@MainActivity, time,
        dateAndTime[Calendar.HOUR_OF_DAY],
            dateAndTime[Calendar.MINUTE], true
        ).show()
    }
    private fun setInitialDataTime() {
        currentDateTime!!.text = DateUtils.formatDateTime(this,
            dateAndTime.timeInMillis,
            DateUtils.FORMAT_SHOW_DATE or DateUtils.FORMAT_SHOW_YEAR or DateUtils.FORMAT_SHOW_TIME)
    }
    var date = DatePickerDialog.OnDateSetListener{view, year, monthOfyear, dayOfMonth ->
        dateAndTime[Calendar.YEAR] = year
        dateAndTime[Calendar.MONTH] = monthOfyear
        dateAndTime[Calendar.DAY_OF_MONTH] = dayOfMonth
        setInitialDataTime()
    }
    var time = TimePickerDialog.OnTimeSetListener{ view, hourOfDay, minute ->
        dateAndTime[Calendar.HOUR_OF_DAY] = hourOfDay
        dateAndTime[Calendar.MINUTE] = minute
        setInitialDataTime()
    }


}
