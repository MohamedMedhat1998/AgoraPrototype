package com.andalus.agora.UI.Fragments.ElectionCreationFragments


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.andalus.agora.R
import kotlinx.android.synthetic.main.fragment_date.view.*
import java.text.SimpleDateFormat
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private const val START_CALENDAR = "start"
private const val END_CALENDAR = "end"

/**
 * A simple [Fragment] subclass.
 * Use the [DateFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class DateFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val startCalendar = Calendar.getInstance()
    private val endCalendar = Calendar.getInstance()
    private var calendarFlag = START_CALENDAR

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_date, container, false)
        val etStartDate = view.etStartDate
        val etEndDate = view.etEndDate

        val startCalendarListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
            startCalendar.set(Calendar.YEAR, year)
            startCalendar.set(Calendar.MONTH, month)
            startCalendar.set(Calendar.DAY_OF_MONTH, day)
            updateText(etStartDate)
            //-------
            val hour = startCalendar.get(Calendar.HOUR)
            val minute = startCalendar.get(Calendar.MINUTE)
            val mTimePicker = TimePickerDialog(
                context,
                TimePickerDialog.OnTimeSetListener { _, selectedHour, selectedMinute ->
                    when {
                        selectedHour == 0 -> etStartDate.setText(
                            "${etStartDate.text}, 12:$selectedMinute AM"
                        )
                        selectedHour == 12 -> etStartDate.setText(
                            "${etStartDate.text}, 12:$selectedMinute PM"
                        )
                        selectedHour < 12 -> etStartDate.setText(
                            "${etStartDate.text}, $selectedHour:$selectedMinute AM"
                        )
                        selectedHour > 12 -> etStartDate.setText(
                            "${etStartDate.text}, ${selectedHour - 12}:$selectedMinute PM"
                        )
                    }

                }, hour, minute, false
            )
            mTimePicker.show()
            //--------
        }

        val endCalendarListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
            endCalendar.set(Calendar.YEAR, year)
            endCalendar.set(Calendar.MONTH, month)
            endCalendar.set(Calendar.DAY_OF_MONTH, day)
            updateText(etEndDate)
            //-------
            val hour = endCalendar.get(Calendar.HOUR)
            val minute = endCalendar.get(Calendar.MINUTE)
            val mTimePicker = TimePickerDialog(
                context,
                TimePickerDialog.OnTimeSetListener { _, selectedHour, selectedMinute ->
                    when {
                        selectedHour == 0 -> etEndDate.setText(
                            "${etEndDate.text}, 12:$selectedMinute AM"
                        )
                        selectedHour == 12 -> etEndDate.setText(
                            "${etEndDate.text}, 12:$selectedMinute PM"
                        )
                        selectedHour < 12 -> etEndDate.setText(
                            "${etEndDate.text}, $selectedHour:$selectedMinute AM"
                        )
                        selectedHour > 12 -> etEndDate.setText(
                            "${etEndDate.text}, ${selectedHour - 12}:$selectedMinute PM"
                        )
                    }

                }, hour, minute, false
            )
            mTimePicker.show()
            //--------
        }

        etStartDate.setOnClickListener {
            calendarFlag = START_CALENDAR
            if (context != null) {
                DatePickerDialog(
                    context!!,
                    startCalendarListener,
                    startCalendar.get(Calendar.YEAR),
                    startCalendar.get(Calendar.MONTH),
                    startCalendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
        }

        etEndDate.setOnClickListener {
            calendarFlag = END_CALENDAR
            if (context != null) {
                DatePickerDialog(
                    context!!,
                    endCalendarListener,
                    endCalendar.get(Calendar.YEAR),
                    endCalendar.get(Calendar.MONTH),
                    endCalendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
        }

        return view
    }

    private fun updateText(textView: EditText) {
        val myFormat = "MM/dd/yyyy"
        val simpleDateFormat = SimpleDateFormat(myFormat, Locale.US)
        if (calendarFlag == START_CALENDAR)
            textView.setText(simpleDateFormat.format(startCalendar.time))
        else if (calendarFlag == END_CALENDAR)
            textView.setText(simpleDateFormat.format(endCalendar.time))
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DateFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String = "", param2: String = "") =
            DateFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
