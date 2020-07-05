package com.partos.summerrent.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.partos.summerrent.R
import com.partos.summerrent.models.Day

class RentsRecyclerViewAdapter(val isBig: Boolean, var monthsList: ArrayList<ArrayList<Day>>) :
    RecyclerView.Adapter<RentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RentsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowCell = layoutInflater.inflate(R.layout.cell_month, parent, false)
        return RentsViewHolder(rowCell)
    }

    override fun getItemCount(): Int {
        return monthsList.size
    }

    override fun onBindViewHolder(holder: RentsViewHolder, position: Int) {

    }
}

class RentsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

}