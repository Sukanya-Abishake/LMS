package com.elearning.lmsapp

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.elearning.model.CourseModel
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [CourseFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CourseFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null
    var datepicker: DatePickerDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = requireArguments().getString(ARG_PARAM1)
            mParam2 = requireArguments().getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_course, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val coursesGV = view.findViewById<GridView>(R.id.idGVcourses)
        val startdate = view.findViewById<EditText>(R.id.startdate)
        val courseName = view.findViewById<EditText>(R.id.coursename)
        val searchBt = view.findViewById<Button>(R.id.bt_Search)
        startdate.setOnClickListener {
            val cldr = Calendar.getInstance()
            val day = cldr[Calendar.DAY_OF_MONTH]
            val month = cldr[Calendar.MONTH]
            val year = cldr[Calendar.YEAR]
            Log.d("suki", "day:$day,month:$month,year:$year")
            // date picker dialog
            datepicker = DatePickerDialog(
                requireContext(),
                { view, year, monthOfYear, dayOfMonth -> startdate.setText(dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year) },
                year,
                month,
                day
            )
            datepicker!!.show()
        }
        val courseModelArrayList = ArrayList<CourseModel>()
        courseModelArrayList.add(CourseModel("DSA", R.drawable.ic_gfglogo))
        courseModelArrayList.add(CourseModel("JAVA", R.drawable.ic_gfglogo))
        courseModelArrayList.add(CourseModel("C++", R.drawable.ic_gfglogo))
        courseModelArrayList.add(CourseModel("Python", R.drawable.ic_gfglogo))
        courseModelArrayList.add(CourseModel("Javascript", R.drawable.ic_gfglogo))
        courseModelArrayList.add(CourseModel("DSA", R.drawable.ic_gfglogo))
        val adapter = CourseGVAdapter(requireContext(), courseModelArrayList)
        coursesGV.adapter = adapter
        searchBt.setOnClickListener {
            val searchText = courseName.text.toString()
            val dummyArrayList = ArrayList<CourseModel>()
            Log.d("suki", "searchText:$searchText")
            for (i in courseModelArrayList.indices) {
                if (courseModelArrayList[i].course_name.toLowerCase()
                        .contains(searchText.toLowerCase())
                ) {
                    dummyArrayList.add(
                        CourseModel(
                            courseModelArrayList[i].course_name,
                            R.drawable.ic_gfglogo
                        )
                    )
                }
            }
            if (TextUtils.isEmpty(searchText)) {
                val adapter = CourseGVAdapter(requireContext(), courseModelArrayList)
                coursesGV.adapter = adapter
            } else {
                val adapter = CourseGVAdapter(requireContext(), dummyArrayList)
                coursesGV.adapter = adapter
            }
        }
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CourseFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String?, param2: String?): CourseFragment {
            val fragment = CourseFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}