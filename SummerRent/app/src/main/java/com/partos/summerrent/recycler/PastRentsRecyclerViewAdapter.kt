package com.partos.summerrent.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.partos.summerrent.R
import com.partos.summerrent.models.Day

class PastRentsRecyclerViewAdapter(val isBig: Boolean, var monthsList: ArrayList<ArrayList<Day>>) :
    RecyclerView.Adapter<PastRentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PastRentsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowCell = layoutInflater.inflate(R.layout.cell_month, parent, false)
        return PastRentsViewHolder(rowCell)
    }

    override fun getItemCount(): Int {
        return monthsList.size
    }

    override fun onBindViewHolder(holder: PastRentsViewHolder, position: Int) {
        
    }
}

class PastRentsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

}