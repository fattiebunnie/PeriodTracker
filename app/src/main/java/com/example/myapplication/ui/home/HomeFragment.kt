package com.example.myapplication.ui.home
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_home.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel


    private var progressPercentage = 0
    private final var BACKGROUNDPROGRESSPERCENTAGE = 50


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
            updateProgressBar()
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.recordButton).setOnClickListener {
//            findNavController().navigate(R.id.)
            
            updateDate(view)

        }

    }

    private fun onRecordButtonClick(view : View) {
        val startDate : Date
        val stopDate : Date
        if (view.findViewById<Button>(R.id.recordButton).text == "@string/start_recording_button_text") {
            startDate = getCurrentDate()
            view.findViewById<Button>(R.id.recordButton).text = "@string/stop_recording_button_text"
        }
        else if (view.findViewById<Button>(R.id.recordButton).text == "@string/stop_recording_button_text") {
            stopDate = getCurrentDate()
            view.findViewById<Button>(R.id.recordButton).text = "@string/start_recording_button_text"

        }
    }

    private fun getCurrentDate ( ) : Date {
//        val sdf = SimpleDateFormat("yyyy/M/dd hh:mm:ss")
//        val sdf = SimpleDateFormat("yyyy/M/dd")
//        val currentDate = sdf.format(Date())
        val currentDate = Date()
//        println(currentDate)
//        println(Date())
        return currentDate
    }

    private fun dateToString (date : Date): String {
        val sdf = SimpleDateFormat("yyyy/MM/dd")
        return sdf.format(date)
    }

    private fun getDateDiff (startDate : Date, endDate : Date) : String{
        val sdf = SimpleDateFormat("yyyy/MM/dd")

        val startDate1 = dateToString(startDate)
        val endDate1 = dateToString(endDate)

        val startDate2 = sdf.parse(startDate1)
        val endDate2 = sdf.parse(endDate1)

        val difference : Long = abs(endDate2.time - startDate2.time)
        val differenceDates = difference / (24 * 60 * 60 * 1000)

        val dayDifference = differenceDates.toString()

        return dayDifference
    }

    private fun updateDate (view: View) {
        // Get the text view
        val showCountTextView = view.findViewById<TextView>(R.id.daysSinceLastPeriodView)

        // Get the value of the text view.
        val countString = showCountTextView.text.toString()

        // Convert value to a number and increment it
        var count = countString.toInt()
        count++

        // Display the new value in the text view.
        showCountTextView.text = count.toString()

        val currentDate = getCurrentDate()
    }

    private fun updateProgressBar() {
        // progress_bar_backgorund
        progress_bar_background.progress = BACKGROUNDPROGRESSPERCENTAGE

        progress_bar.progress
    }



//    fun saveData () {
//        SharedPreferences sharedPreference = prefs.edit().putLong("time", date.getTime()).apply()
//    }
}