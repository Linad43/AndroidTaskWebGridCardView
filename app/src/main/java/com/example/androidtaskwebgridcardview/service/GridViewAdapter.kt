package com.example.androidtaskwebgridcardview.service

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.androidtaskwebgridcardview.R
import com.example.androidtaskwebgridcardview.modal.GridViewModal

class GridViewAdapter(
    private val list: List<GridViewModal>,
    private val context: Context,
) : BaseAdapter() {

    private var layoutInflater: LayoutInflater? = null
    private lateinit var textView: TextView
    private lateinit var image: ImageView

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (convertView == null) {
            convertView = layoutInflater!!.inflate((R.layout.grid_view_item), null)
        }
        image = convertView!!.findViewById(R.id.imageIV)
        textView = convertView.findViewById(R.id.textTV)
        image.setImageResource(list[position].image)
        textView.text = list[position].name
        return convertView
    }
}