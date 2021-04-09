package com.elearning.lmsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.elearning.model.CourseModel
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null
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
        return inflater.inflate(R.layout.activity_course, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val coursesGV = view.findViewById<GridView>(R.id.idGVcourses)
        val userName = view.findViewById<TextView>(R.id.username_val)
        userName.text = mParam1
        val courseModelArrayList = ArrayList<CourseModel>()
        courseModelArrayList.add(CourseModel("DSA", R.drawable.ic_gfglogo))
        courseModelArrayList.add(CourseModel("JAVA", R.drawable.ic_gfglogo))
        courseModelArrayList.add(CourseModel("C++", R.drawable.ic_gfglogo))
        courseModelArrayList.add(CourseModel("Python", R.drawable.ic_gfglogo))
        courseModelArrayList.add(CourseModel("Javascript", R.drawable.ic_gfglogo))
        courseModelArrayList.add(CourseModel("DSA", R.drawable.ic_gfglogo))
        val adapter = CourseGVAdapter(requireContext(), courseModelArrayList)
        coursesGV.adapter = adapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
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
         * @return A new instance of fragment DashboardFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String?, param2: String?): DashboardFragment {
            val fragment = DashboardFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}