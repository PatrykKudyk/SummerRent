package com.partos.summerrent.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.partos.summerrent.R
import com.partos.summerrent.calendar.CurrentMonthCreator
import com.partos.summerrent.calendar.PastMonthCreator
import com.partos.summerrent.models.Day

class CurrentRentsRecyclerViewAdapter(val isBig: Boolean, var monthsList: ArrayList<ArrayList<Day>>) :
    RecyclerView.Adapter<CurrentRentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrentRentsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowCell = layoutInflater.inflate(R.layout.cell_month, parent, false)
        return CurrentRentsViewHolder(rowCell)
    }

    override fun getItemCount(): Int {
        return monthsList.size
    }

    override fun onBindViewHolder(holder: CurrentRentsViewHolder, position: Int) {
        createMonthCell(monthsList[position][0].date.month, holder, position)
    }

    private fun createMonthCell(month: Int, holder: CurrentRentsViewHolder, position: Int) {
        val monthCreator = CurrentMonthCreator(isBig, holder.view.context)
        when (month) {
            1 -> monthCreator.createJanuary(holder, monthsList[position])
            2 -> monthCreator.createFebruary(holder, monthsList[position])
            3 -> monthCreator.createMarch(holder, monthsList[position])
            4 -> monthCreator.createApril(holder, monthsList[position])
            5 -> monthCreator.createMay(holder, monthsList[position])
            6 -> monthCreator.createJune(holder, monthsList[position])
            7 -> monthCreator.createJuly(holder, monthsList[position])
            8 -> monthCreator.createAugust(holder, monthsList[position])
            9 -> monthCreator.createSeptember(holder, monthsList[position])
            10 -> monthCreator.createOctober(holder, monthsList[position])
            11 -> monthCreator.createNovember(holder, monthsList[position])
            12 -> monthCreator.createDecember(holder, monthsList[position])
        }
    }
}

class CurrentRentsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

}