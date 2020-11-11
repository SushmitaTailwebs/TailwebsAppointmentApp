package com.tailwebs.tailwebsappointmentapp.view.bottonview

import android.content.Intent
import android.os.Bundle
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import butterknife.BindView
import butterknife.ButterKnife
import com.jonaswanke.calendar.BaseEvent
import com.jonaswanke.calendar.Event
import com.jonaswanke.calendar.utils.Week
import com.tailwebs.tailwebsappointmentapp.R
import com.tailwebs.tailwebsappointmentapp.utils.GlobalValue
import com.tailwebs.tailwebsappointmentapp.view.ShowShopsAndTrunkShowDetails
import java.lang.Math.abs
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AppointmentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AppointmentFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    @BindView(R.id.layoutId)
    @JvmField
    var layout: LinearLayout? = null

    @BindView(R.id.shopNameId)
    @JvmField
    var shopNameTv: TextView? = null

    @BindView(R.id.calendar)
    @JvmField
    var calendar: com.jonaswanke.calendar.CalendarView? = null
    private var nextId: Long = 0
    private val random = Random()
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
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_appointment, container, false)
        ButterKnife.bind(this, view)
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AppointmentFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AppointmentFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        GlobalValue.isFromAdapter = false
        if (!GlobalValue.ShopName.equals("")) {
            shopNameTv!!.setText(GlobalValue.ShopName)
        }
        layout!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, ShowShopsAndTrunkShowDetails::class.java)
            context!!.startActivity(intent)
        })

//        calendar!!.eventRequestCallback = { week ->
//            // Retrieve events synchronously or asynchronously
//            populate(it.title)
//        }
//        calendar!!.onEventClickListener = {
//            Toast!!.makeText(this, it.title + " clicked", Toast.LENGTH_SHORT).show()
//
//        }
    }

    @Suppress("MagicNumber")
    private fun populate(week: Week, force: Boolean = false) {
        if (!force && calendar!!.cachedEvents.contains(week))
            return

        val events = mutableListOf<Event>()
        for (i in 0..15) {
            val id = nextId++.toString()
            val start = week.start + abs(random.nextLong()) % DateUtils.WEEK_IN_MILLIS
            events.add(BaseEvent(
                id,
                id,
                (random.nextInt() or 0xFF000000.toInt()) and 0x00202020.inv(),
                start,
                start + abs(random.nextLong()) % (DateUtils.DAY_IN_MILLIS / 8)))
        }
        for (i in 0..3) {
            val id = nextId++.toString()
            val start = week.start + abs(random.nextLong()) % DateUtils.WEEK_IN_MILLIS
            events.add(
                BaseEvent(
                id,
                id,
                (random.nextInt() or 0xFF000000.toInt()) and 0x00202020.inv(),
                start,
                start + abs(random.nextLong()) % (DateUtils.DAY_IN_MILLIS * 7),
                true)
            )
        }
        calendar!!.setEventsForWeek(week, events)
    }

    open class BaseEvent(
        override val title: String,
        override val description: String?,
        @get:ColorInt
        override val color: Int?,
        override val start: Long,
        override val end: Long,
        override val allDay: Boolean = false
    ) : Event {
        override fun compareTo(other: Event): Int {
            val result = start.compareTo(other.start)
            if (result != 0)
                return result
            return end.compareTo(other.end)
        }

        override fun toString(): String {
            return "$title ($description), $start-$end, allDay: $allDay"
        }
    }
}