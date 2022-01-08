package com.example.myfirstapp
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
import java.util.Date
import java.util.Calendar
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn : TextView = findViewById(R.id.datebutton)
        btn.setOnClickListener {view ->clickDatePicker(view)

        }
    }
    fun clickDatePicker(view : View)
    {

        val mycalnedar = Calendar.getInstance()
        val year  = mycalnedar.get(Calendar.YEAR)
        val month  = mycalnedar.get(Calendar.MONTH)
        val dateee  = mycalnedar.get(Calendar.DAY_OF_MONTH)

        val dpd =  DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view, syear, smonth, sdayofmonth ->
            Toast.makeText(this, "YEAR : $syear \nMONTH : ${month + 1} \nDAY : $sdayofmonth", Toast.LENGTH_LONG).show()
              val selectedDate = "$sdayofmonth/${smonth + 1}/$syear"
            var datetodisplay : TextView  = findViewById(R.id.dateselcted)
            datetodisplay.setText("Selected Date is : $selectedDate")
            val sdf = SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH)
            val theDate = sdf.parse(selectedDate)
            val selectedDateToMinutes = theDate.time / 60000

            // Here we have parsed the current date with the Date Formatter which is used above.
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            // Current date in to minutes.
            val currentDateToMinutes = currentDate!!.time / 60000

            /**
             * Now to get the difference into minutes.
             * We will subtract the selectedDateToMinutes from currentDateToMinutes.
             * Which will provide the difference in minutes.
             */
            val differenceInMinutes = currentDateToMinutes - selectedDateToMinutes
            val inmin = findViewById<TextView>(R.id.textView5)
            inmin.setText("AGE IN MINUTES IS : ${differenceInMinutes.toString()} Minutes ")

        }, year, month, dateee)

        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()

    }

}