package com.octo.project.history

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.octo.project.History
import com.octo.project.R
import kotlinx.android.synthetic.main.history_item.view.*

class HistoryAdapter(private val items: MutableList<History>, private val context: Context) :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.history_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.date.text = items[position].date
        holder.rate.text = context.getString(
            R.string.history_value, items[position].originValue,
            items[position].origin, items[position].destinationValue, items[position].destination
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val date: TextView = view.date
        val rate: TextView = view.rate
    }

}