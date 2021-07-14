package com.coderakshat.learningapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.coderakshat.learningapp.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // supportActionBar?.hide()


        binding.btnDatePicker.setOnClickListener { view ->
            clickDatePicker(view)
            Toast.makeText(this,"Select Date/Month/Year", Toast.LENGTH_LONG ).show()
        }

    }


    fun clickDatePicker(view: View){

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)


        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->


            val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"

            binding.dateView.setText(selectedDate)

            val sdf = SimpleDateFormat("dd/MM/yy", Locale.ENGLISH)
            val theDate = sdf.parse(selectedDate)
            val selectedDateInMinutes = theDate!!.time / 60000
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateInMinutes = currentDate!!.time / 60000
            val diffInMin = currentDateInMinutes - selectedDateInMinutes

            binding.minutesView.setText(diffInMin.toString())
                                                                  },year ,month ,day ).show()
    }


}