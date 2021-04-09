package com.elearning.lmsapp

import android.content.Context
import com.elearning.model.CourseModel
import android.widget.ArrayAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import java.util.ArrayList

internal class CourseGVAdapter(context: Context, courseModelArrayList: ArrayList<CourseModel>) :
    ArrayAdapter<CourseModel?>(context, 0, courseModelArrayList!! as List<CourseModel?>), Filterable {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listitemView = convertView
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(context).inflate(R.layout.card_item, parent, false)
        }
        val courseModel = getItem(position)
        val courseTV = listitemView!!.findViewById<TextView>(R.id.idTVCourse)
        val courseIV = listitemView.findViewById<ImageView>(R.id.idIVcourse)
        courseTV.text = courseModel!!.course_name
        courseIV.setImageResource(courseModel.imgid)
        return listitemView
    }
}