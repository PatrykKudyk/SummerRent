package com.partos.summerrent.calendar

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.partos.summerrent.MainActivity
import com.partos.summerrent.MyApp
import com.partos.summerrent.R
import com.partos.summerrent.db.DataBaseHelper
import com.partos.summerrent.models.Day
import com.partos.summerrent.recycler.CurrentRentsViewHolder
import kotlinx.android.synthetic.main.cell_month.view.*
import kotlinx.android.synthetic.main.fragment_current.*

class CurrentMonthCreator(val isBig: Boolean, val context: Context) {

    private lateinit var cellsList: Array<Array<TextView>>
    private val activity = (context as MainActivity)

    fun createJanuary(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        initCells(holder)
        setEmpty()
        if (isBig) {
            holder.view.cell_month_text_name.setText(
                holder.view.context.getString(R.string.january) + "\t\t" + dayList[0].date.year + "   47"
            )
        } else {
            holder.view.cell_month_text_name.setText(
                holder.view.context.getString(R.string.january) + "\t\t" + dayList[0].date.year + "   40/5"
            )
        }
        when (dayList[0].date.dayOfWeek) {
            1 -> init31monday(holder, dayList)
            2 -> init31tuesday(holder, dayList)
            3 -> init31wednesday(holder, dayList)
            4 -> init31thursday(holder, dayList)
            5 -> init31friday(holder, dayList)
            6 -> init31saturday(holder, dayList)
            7 -> init31sunday(holder, dayList)
        }
    }

    fun createFebruary(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        initCells(holder)
        setEmpty()
        if (isBig) {
            holder.view.cell_month_text_name.setText(
                holder.view.context.getString(R.string.february) + "\t\t" + dayList[0].date.year + "   47"
            )
        } else {
            holder.view.cell_month_text_name.setText(
                holder.view.context.getString(R.string.february) + "\t\t" + dayList[0].date.year + "   40/5"
            )
        }
        if (dayList.size == 28) {
            when (dayList[0].date.dayOfWeek) {
                1 -> init28monday(holder, dayList)
                2 -> init28tuesday(holder, dayList)
                3 -> init28wednesday(holder, dayList)
                4 -> init28thursday(holder, dayList)
                5 -> init28friday(holder, dayList)
                6 -> init28saturday(holder, dayList)
                7 -> init28sunday(holder, dayList)
            }
        } else {
            when (dayList[0].date.dayOfWeek) {
                1 -> init29monday(holder, dayList)
                2 -> init29tuesday(holder, dayList)
                3 -> init29wednesday(holder, dayList)
                4 -> init29thursday(holder, dayList)
                5 -> init29friday(holder, dayList)
                6 -> init29saturday(holder, dayList)
                7 -> init29sunday(holder, dayList)
            }
        }
    }

    fun createMarch(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        initCells(holder)
        setEmpty()
        if (isBig) {
            holder.view.cell_month_text_name.setText(
                holder.view.context.getString(R.string.march) + "\t\t" + dayList[0].date.year + "   47"
            )
        } else {
            holder.view.cell_month_text_name.setText(
                holder.view.context.getString(R.string.march) + "\t\t" + dayList[0].date.year + "   40/5"
            )
        }
        when (dayList[0].date.dayOfWeek) {
            1 -> init31monday(holder, dayList)
            2 -> init31tuesday(holder, dayList)
            3 -> init31wednesday(holder, dayList)
            4 -> init31thursday(holder, dayList)
            5 -> init31friday(holder, dayList)
            6 -> init31saturday(holder, dayList)
            7 -> init31sunday(holder, dayList)
        }
    }

    fun createApril(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        initCells(holder)
        setEmpty()
        if (isBig) {
            holder.view.cell_month_text_name.setText(
                holder.view.context.getString(R.string.april) + "\t\t" + dayList[0].date.year + "   47"
            )
        } else {
            holder.view.cell_month_text_name.setText(
                holder.view.context.getString(R.string.april) + "\t\t" + dayList[0].date.year + "   40/5"
            )
        }
        when (dayList[0].date.dayOfWeek) {
            1 -> init30monday(holder, dayList)
            2 -> init30tuesday(holder, dayList)
            3 -> init30wednesday(holder, dayList)
            4 -> init30thursday(holder, dayList)
            5 -> init30friday(holder, dayList)
            6 -> init30saturday(holder, dayList)
            7 -> init30sunday(holder, dayList)
        }
    }

    fun createMay(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        initCells(holder)
        setEmpty()
        if (isBig) {
            holder.view.cell_month_text_name.setText(
                holder.view.context.getString(R.string.may) + "\t\t" + dayList[0].date.year + "   47"
            )
        } else {
            holder.view.cell_month_text_name.setText(
                holder.view.context.getString(R.string.may) + "\t\t" + dayList[0].date.year + "   40/5"
            )
        }
        when (dayList[0].date.dayOfWeek) {
            1 -> init31monday(holder, dayList)
            2 -> init31tuesday(holder, dayList)
            3 -> init31wednesday(holder, dayList)
            4 -> init31thursday(holder, dayList)
            5 -> init31friday(holder, dayList)
            6 -> init31saturday(holder, dayList)
            7 -> init31sunday(holder, dayList)
        }
    }

    fun createJune(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        initCells(holder)
        setEmpty()
        if (isBig) {
            holder.view.cell_month_text_name.setText(
                holder.view.context.getString(R.string.june) + "\t\t" + dayList[0].date.year + "   47"
            )
        } else {
            holder.view.cell_month_text_name.setText(
                holder.view.context.getString(R.string.june) + "\t\t" + dayList[0].date.year + "   40/5"
            )
        }
        when (dayList[0].date.dayOfWeek) {
            1 -> init30monday(holder, dayList)
            2 -> init30tuesday(holder, dayList)
            3 -> init30wednesday(holder, dayList)
            4 -> init30thursday(holder, dayList)
            5 -> init30friday(holder, dayList)
            6 -> init30saturday(holder, dayList)
            7 -> init30sunday(holder, dayList)
        }
    }

    fun createJuly(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        initCells(holder)
        setEmpty()
        if (isBig) {
            holder.view.cell_month_text_name.setText(
                holder.view.context.getString(R.string.july) + "\t\t" + dayList[0].date.year + "   47"
            )
        } else {
            holder.view.cell_month_text_name.setText(
                holder.view.context.getString(R.string.july) + "\t\t" + dayList[0].date.year + "   40/5"
            )
        }
        when (dayList[0].date.dayOfWeek) {
            1 -> init31monday(holder, dayList)
            2 -> init31tuesday(holder, dayList)
            3 -> init31wednesday(holder, dayList)
            4 -> init31thursday(holder, dayList)
            5 -> init31friday(holder, dayList)
            6 -> init31saturday(holder, dayList)
            7 -> init31sunday(holder, dayList)
        }
    }

    fun createAugust(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        initCells(holder)
        setEmpty()
        if (isBig) {
            holder.view.cell_month_text_name.setText(
                holder.view.context.getString(R.string.august) + "\t\t" + dayList[0].date.year + "   47"
            )
        } else {
            holder.view.cell_month_text_name.setText(
                holder.view.context.getString(R.string.august) + "\t\t" + dayList[0].date.year + "   40/5"
            )
        }
        when (dayList[0].date.dayOfWeek) {
            1 -> init31monday(holder, dayList)
            2 -> init31tuesday(holder, dayList)
            3 -> init31wednesday(holder, dayList)
            4 -> init31thursday(holder, dayList)
            5 -> init31friday(holder, dayList)
            6 -> init31saturday(holder, dayList)
            7 -> init31sunday(holder, dayList)
        }
    }

    fun createSeptember(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        initCells(holder)
        setEmpty()
        if (isBig) {
            holder.view.cell_month_text_name.setText(
                holder.view.context.getString(R.string.september) + "\t\t" + dayList[0].date.year + "   47"
            )
        } else {
            holder.view.cell_month_text_name.setText(
                holder.view.context.getString(R.string.september) + "\t\t" + dayList[0].date.year + "   40/5"
            )
        }
        when (dayList[0].date.dayOfWeek) {
            1 -> init30monday(holder, dayList)
            2 -> init30tuesday(holder, dayList)
            3 -> init30wednesday(holder, dayList)
            4 -> init30thursday(holder, dayList)
            5 -> init30friday(holder, dayList)
            6 -> init30saturday(holder, dayList)
            7 -> init30sunday(holder, dayList)
        }
    }

    fun createOctober(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        initCells(holder)
        setEmpty()
        if (isBig) {
            holder.view.cell_month_text_name.setText(
                holder.view.context.getString(R.string.october) + "\t\t" + dayList[0].date.year + "   47"
            )
        } else {
            holder.view.cell_month_text_name.setText(
                holder.view.context.getString(R.string.october) + "\t\t" + dayList[0].date.year + "   40/5"
            )
        }
        when (dayList[0].date.dayOfWeek) {
            1 -> init31monday(holder, dayList)
            2 -> init31tuesday(holder, dayList)
            3 -> init31wednesday(holder, dayList)
            4 -> init31thursday(holder, dayList)
            5 -> init31friday(holder, dayList)
            6 -> init31saturday(holder, dayList)
            7 -> init31sunday(holder, dayList)
        }
    }

    fun createNovember(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        initCells(holder)
        setEmpty()
        if (isBig) {
            holder.view.cell_month_text_name.setText(
                holder.view.context.getString(R.string.november) + "\t\t" + dayList[0].date.year + "   47"
            )
        } else {
            holder.view.cell_month_text_name.setText(
                holder.view.context.getString(R.string.november) + "\t\t" + dayList[0].date.year + "   40/5"
            )
        }
        when (dayList[0].date.dayOfWeek) {
            1 -> init30monday(holder, dayList)
            2 -> init30tuesday(holder, dayList)
            3 -> init30wednesday(holder, dayList)
            4 -> init30thursday(holder, dayList)
            5 -> init30friday(holder, dayList)
            6 -> init30saturday(holder, dayList)
            7 -> init30sunday(holder, dayList)
        }
    }

    fun createDecember(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        initCells(holder)
        setEmpty()
        if (isBig) {
            holder.view.cell_month_text_name.setText(
                holder.view.context.getString(R.string.december) + "\t\t" + dayList[0].date.year + "   47"
            )
        } else {
            holder.view.cell_month_text_name.setText(
                holder.view.context.getString(R.string.december) + "\t\t" + dayList[0].date.year + "   40/5"
            )
        }
        when (dayList[0].date.dayOfWeek) {
            1 -> init31monday(holder, dayList)
            2 -> init31tuesday(holder, dayList)
            3 -> init31wednesday(holder, dayList)
            4 -> init31thursday(holder, dayList)
            5 -> init31friday(holder, dayList)
            6 -> init31saturday(holder, dayList)
            7 -> init31sunday(holder, dayList)
        }
    }

    private fun initCells(holder: CurrentRentsViewHolder) {
        var cell = holder.view.cell_month_text_00
        var cell2 = holder.view.cell_month_text_01
        var cell3 = holder.view.cell_month_text_02
        var cell4 = holder.view.cell_month_text_03
        var cell5 = holder.view.cell_month_text_04
        var cell6 = holder.view.cell_month_text_05
        var cell7 = holder.view.cell_month_text_06
        var array1 = arrayOf(cell, cell2, cell3, cell4, cell5, cell6, cell7)

        cell = holder.view.cell_month_text_10
        cell2 = holder.view.cell_month_text_11
        cell3 = holder.view.cell_month_text_12
        cell4 = holder.view.cell_month_text_13
        cell5 = holder.view.cell_month_text_14
        cell6 = holder.view.cell_month_text_15
        cell7 = holder.view.cell_month_text_16

        var array2 = arrayOf(cell, cell2, cell3, cell4, cell5, cell6, cell7)

        cell = holder.view.cell_month_text_20
        cell2 = holder.view.cell_month_text_21
        cell3 = holder.view.cell_month_text_22
        cell4 = holder.view.cell_month_text_23
        cell5 = holder.view.cell_month_text_24
        cell6 = holder.view.cell_month_text_25
        cell7 = holder.view.cell_month_text_26

        var array3 = arrayOf(cell, cell2, cell3, cell4, cell5, cell6, cell7)

        cell = holder.view.cell_month_text_30
        cell2 = holder.view.cell_month_text_31
        cell3 = holder.view.cell_month_text_32
        cell4 = holder.view.cell_month_text_33
        cell5 = holder.view.cell_month_text_34
        cell6 = holder.view.cell_month_text_35
        cell7 = holder.view.cell_month_text_36

        var array4 = arrayOf(cell, cell2, cell3, cell4, cell5, cell6, cell7)


        cell = holder.view.cell_month_text_40
        cell2 = holder.view.cell_month_text_41
        cell3 = holder.view.cell_month_text_42
        cell4 = holder.view.cell_month_text_43
        cell5 = holder.view.cell_month_text_44
        cell6 = holder.view.cell_month_text_45
        cell7 = holder.view.cell_month_text_46

        var array5 = arrayOf(cell, cell2, cell3, cell4, cell5, cell6, cell7)


        cell = holder.view.cell_month_text_50
        cell2 = holder.view.cell_month_text_51
        cell3 = holder.view.cell_month_text_52
        cell4 = holder.view.cell_month_text_53
        cell5 = holder.view.cell_month_text_54
        cell6 = holder.view.cell_month_text_55
        cell7 = holder.view.cell_month_text_56

        var array6 = arrayOf(cell, cell2, cell3, cell4, cell5, cell6, cell7)


        cellsList = arrayOf(array1, array2, array3, array4, array5, array6)
    }

    private fun init31monday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..4) {
            for (j in 0..6) {
                if (i <= 3) {
                    setTextView(i, j, 0, dayList)
                } else {
                    if (j <= 2) {
                        setTextView(i, j, 0, dayList)
                    }
                }
            }
        }
    }

    private fun init31tuesday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..4) {
            for (j in 0..6) {
                if (i == 0) {
                    if (j > 0) {
                        setTextView(i, j, 1, dayList)
                    }
                } else if (i <= 3) {
                    setTextView(i, j, 1, dayList)
                } else {
                    if (j <= 3) {
                        setTextView(i, j, 1, dayList)
                    }
                }
            }
        }
    }

    private fun init31wednesday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..4) {
            for (j in 0..6) {
                if (i == 0) {
                    if (j > 1) {
                        setTextView(i, j, 2, dayList)
                    }
                } else if (i <= 3) {
                    setTextView(i, j, 2, dayList)
                } else {
                    if (j <= 4) {
                        setTextView(i, j, 2, dayList)
                    }
                }
            }
        }
    }

    private fun init31thursday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..4) {
            for (j in 0..6) {
                if (i == 0) {
                    if (j > 2) {
                        setTextView(i, j, 3, dayList)
                    }
                } else if (i <= 3) {
                    setTextView(i, j, 3, dayList)
                } else {
                    if (j <= 5) {
                        setTextView(i, j, 3, dayList)
                    }
                }
            }
        }
    }

    private fun init31friday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..4) {
            for (j in 0..6) {
                if (i == 0) {
                    if (j > 3) {
                        setTextView(i, j, 4, dayList)
                    }
                } else if (i <= 4) {
                    setTextView(i, j, 4, dayList)
                }
            }
        }
    }

    private fun init31saturday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..5) {
            for (j in 0..6) {
                if (i == 0) {
                    if (j > 4) {
                        setTextView(i, j, 5, dayList)
                    }
                } else if (i <= 4) {
                    setTextView(i, j, 5, dayList)
                } else {
                    if (j == 0) {
                        setTextView(i, j, 5, dayList)
                    }
                }
            }
        }
    }

    private fun init31sunday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..5) {
            for (j in 0..6) {
                if (i == 0) {
                    if (j > 5) {
                        setTextView(i, j, 6, dayList)
                    }
                } else if (i <= 4) {
                    setTextView(i, j, 6, dayList)
                } else {
                    if (j <= 1) {
                        setTextView(i, j, 6, dayList)
                    }
                }
            }
        }
    }

    private fun init30monday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..4) {
            for (j in 0..6) {
                if (i <= 3) {
                    setTextView(i, j, 0, dayList)
                } else {
                    if (j <= 1) {
                        setTextView(i, j, 0, dayList)
                    }
                }
            }
        }
    }

    private fun init30tuesday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..4) {
            for (j in 0..6) {
                if (i == 0) {
                    if (j > 0) {
                        setTextView(i, j, 1, dayList)
                    }
                } else if (i <= 3) {
                    setTextView(i, j, 1, dayList)
                } else {
                    if (j <= 2) {
                        setTextView(i, j, 1, dayList)
                    }
                }
            }
        }
    }

    private fun init30wednesday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..4) {
            for (j in 0..6) {
                if (i == 0) {
                    if (j > 1) {
                        setTextView(i, j, 2, dayList)
                    }
                } else if (i <= 3) {
                    setTextView(i, j, 2, dayList)
                } else {
                    if (j <= 3) {
                        setTextView(i, j, 2, dayList)
                    }
                }
            }
        }
    }

    private fun init30thursday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..4) {
            for (j in 0..6) {
                if (i == 0) {
                    if (j > 2) {
                        setTextView(i, j, 3, dayList)
                    }
                } else if (i <= 3) {
                    setTextView(i, j, 3, dayList)
                } else {
                    if (j <= 4) {
                        setTextView(i, j, 3, dayList)
                    }
                }
            }
        }
    }

    private fun init30friday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..4) {
            for (j in 0..6) {
                if (i == 0) {
                    if (j > 3) {
                        setTextView(i, j, 4, dayList)
                    }
                } else if (i <= 3) {
                    setTextView(i, j, 4, dayList)
                } else {
                    if (j <= 5) {
                        setTextView(i, j, 4, dayList)
                    }
                }
            }
        }
    }

    private fun init30saturday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..4) {
            for (j in 0..6) {
                if (i == 0) {
                    if (j > 4) {
                        setTextView(i, j, 5, dayList)
                    }
                } else if (i <= 4) {
                    setTextView(i, j, 5, dayList)
                }
            }
        }
    }

    private fun init30sunday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..5) {
            for (j in 0..6) {
                if (i == 0) {
                    if (j > 5) {
                        setTextView(i, j, 6, dayList)
                    }
                } else if (i <= 4) {
                    setTextView(i, j, 6, dayList)
                } else {
                    if (j == 0) {
                        setTextView(i, j, 6, dayList)
                    }
                }
            }
        }
    }

    private fun init28monday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..3) {
            for (j in 0..6) {
                if (i <= 4) {
                    setTextView(i, j, 0, dayList)
                }
            }
        }
    }

    private fun init28tuesday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..4) {
            for (j in 0..6) {
                if (i == 0) {
                    if (j > 0) {
                        setTextView(i, j, 1, dayList)
                    }
                } else if (i <= 3) {
                    setTextView(i, j, 1, dayList)
                } else {
                    if (j == 0) {
                        setTextView(i, j, 1, dayList)
                    }
                }
            }
        }
    }

    private fun init28wednesday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..4) {
            for (j in 0..6) {
                if (i == 0) {
                    if (j > 1) {
                        setTextView(i, j, 2, dayList)
                    }
                } else if (i <= 3) {
                    setTextView(i, j, 2, dayList)
                } else {
                    if (j <= 1) {
                        setTextView(i, j, 2, dayList)
                    }
                }
            }
        }
    }

    private fun init28thursday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..4) {
            for (j in 0..6) {
                if (i == 0) {
                    if (j > 2) {
                        setTextView(i, j, 3, dayList)
                    }
                } else if (i <= 3) {
                    setTextView(i, j, 3, dayList)
                } else {
                    if (j <= 2) {
                        setTextView(i, j, 3, dayList)
                    }
                }
            }
        }
    }

    private fun init28friday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..4) {
            for (j in 0..6) {
                if (i == 0) {
                    if (j > 3) {
                        setTextView(i, j, 4, dayList)
                    }
                } else if (i <= 3) {
                    setTextView(i, j, 4, dayList)
                } else {
                    if (j <= 3) {
                        setTextView(i, j, 4, dayList)
                    }
                }
            }
        }
    }

    private fun init28saturday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..4) {
            for (j in 0..6) {
                if (i == 0) {
                    if (j > 4) {
                        setTextView(i, j, 5, dayList)
                    }
                } else if (i <= 3) {
                    setTextView(i, j, 5, dayList)
                } else {
                    if (j <= 4) {
                        setTextView(i, j, 5, dayList)
                    }
                }
            }
        }
    }

    private fun init28sunday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..4) {
            for (j in 0..6) {
                if (i == 0) {
                    if (j > 5) {
                        setTextView(i, j, 6, dayList)
                    }
                } else if (i <= 3) {
                    setTextView(i, j, 6, dayList)
                } else {
                    if (j <= 5) {
                        setTextView(i, j, 6, dayList)
                    }
                }
            }
        }
    }

    private fun init29monday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..4) {
            for (j in 0..6) {
                if (i <= 4) {
                    setTextView(i, j, 0, dayList)
                } else {
                    if (j == 0) {
                        setTextView(i, j, 0, dayList)
                    }
                }
            }
        }
    }

    private fun init29tuesday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..4) {
            for (j in 0..6) {
                if (i == 0) {
                    if (j > 0) {
                        setTextView(i, j, 1, dayList)
                    }
                } else if (i <= 3) {
                    setTextView(i, j, 1, dayList)
                } else {
                    if (j <= 1) {
                        setTextView(i, j, 1, dayList)
                    }
                }
            }
        }
    }

    private fun init29wednesday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..4) {
            for (j in 0..6) {
                if (i == 0) {
                    if (j > 1) {
                        setTextView(i, j, 2, dayList)
                    }
                } else if (i <= 3) {
                    setTextView(i, j, 2, dayList)
                } else {
                    if (j <= 2) {
                        setTextView(i, j, 2, dayList)
                    }
                }
            }
        }
    }

    private fun init29thursday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..4) {
            for (j in 0..6) {
                if (i == 0) {
                    if (j > 2) {
                        setTextView(i, j, 3, dayList)
                    }
                } else if (i <= 3) {
                    setTextView(i, j, 3, dayList)
                } else {
                    if (j <= 3) {
                        setTextView(i, j, 3, dayList)
                    }
                }
            }
        }
    }

    private fun init29friday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..4) {
            for (j in 0..6) {
                if (i == 0) {
                    if (j > 3) {
                        setTextView(i, j, 4, dayList)
                    }
                } else if (i <= 3) {
                    setTextView(i, j, 4, dayList)
                } else {
                    if (j <= 4) {
                        setTextView(i, j, 4, dayList)
                    }
                }
            }
        }
    }

    private fun init29saturday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..4) {
            for (j in 0..6) {
                if (i == 0) {
                    if (j > 4) {
                        setTextView(i, j, 5, dayList)
                    }
                } else if (i <= 3) {
                    setTextView(i, j, 5, dayList)
                } else {
                    if (j <= 5) {
                        setTextView(i, j, 5, dayList)
                    }
                }
            }
        }
    }

    private fun init29sunday(holder: CurrentRentsViewHolder, dayList: ArrayList<Day>) {
        for (i in 0..4) {
            for (j in 0..6) {
                if (i == 0) {
                    if (j > 5) {
                        setTextView(i, j, 6, dayList)
                    }
                } else if (i <= 4) {
                    setTextView(i, j, 6, dayList)
                }
            }
        }
    }

    private fun setCellBackground(textView: TextView, color: Int, status: Int) {
        when (status) {
            0 -> {
                textView.background = null
            }
            1 -> {
                when (color) {
                    1 -> textView.setBackgroundDrawable(context.getDrawable(R.drawable.start_green))
                    2 -> textView.setBackgroundDrawable(context.getDrawable(R.drawable.start_orange))
                    3 -> textView.setBackgroundDrawable(context.getDrawable(R.drawable.start_red))
                    4 -> textView.setBackgroundDrawable(context.getDrawable(R.drawable.between_green_orange))
                    5 -> textView.setBackgroundDrawable(context.getDrawable(R.drawable.between_orange_green))
                    6 -> textView.setBackgroundDrawable(context.getDrawable(R.drawable.between_red_green))
                    7 -> textView.setBackgroundDrawable(context.getDrawable(R.drawable.between_green_red))
                    8 -> textView.setBackgroundDrawable(context.getDrawable(R.drawable.between_orange_red))
                    9 -> textView.setBackgroundDrawable(context.getDrawable(R.drawable.between_red_orange))
                }
            }
            2 -> {
                when (color) {
                    1 -> textView.setBackgroundDrawable(context.getDrawable(R.drawable.normal_green))
                    2 -> textView.setBackgroundDrawable(context.getDrawable(R.drawable.normal_orange))
                    3 -> textView.setBackgroundDrawable(context.getDrawable(R.drawable.normal_red))
                }
            }
            3 -> {
                when (color) {
                    1 -> textView.setBackgroundDrawable(context.getDrawable(R.drawable.end_green))
                    2 -> textView.setBackgroundDrawable(context.getDrawable(R.drawable.end_orange))
                    3 -> textView.setBackgroundDrawable(context.getDrawable(R.drawable.end_red))
                }
            }
        }
    }

    private fun setEmpty() {
        for (i in 0..5) {
            for (j in 0..6) {
                cellsList[i][j].setText("")
            }
        }
    }

    private fun setTextView(i: Int, j: Int, move: Int, dayList: ArrayList<Day>) {
        val db = DataBaseHelper(context)
        cellsList[i][j].setText(dayList[((7 * i) + j) - move].date.day.toString())
        setCellBackground(
            cellsList[i][j],
            dayList[((7 * i) + j) - move].color,
            dayList[((7 * i) + j) - move].status
        )
        cellsList[i][j].setOnLongClickListener {
            activity.current_card_view.visibility = View.VISIBLE
            if (isBig) {
                activity.current_text_note.setText(
                    db.getBig(
                        dayList[((7 * i) + j) - move].date.day,
                        dayList[((7 * i) + j) - move].date.month,
                        dayList[((7 * i) + j) - move].date.year
                    ).note
                )
            } else {
                activity.current_text_note.setText(
                    db.getSmall(
                        dayList[((7 * i) + j) - move].date.day,
                        dayList[((7 * i) + j) - move].date.month,
                        dayList[((7 * i) + j) - move].date.year
                    ).note
                )
            }
            activity.current_note_save.setOnClickListener {
                var day: Day
                if (isBig) {
                    day = db.getBig(
                        dayList[((7 * i) + j) - move].date.day,
                        dayList[((7 * i) + j) - move].date.month,
                        dayList[((7 * i) + j) - move].date.year
                    )
                } else {
                    day = db.getSmall(
                        dayList[((7 * i) + j) - move].date.day,
                        dayList[((7 * i) + j) - move].date.month,
                        dayList[((7 * i) + j) - move].date.year
                    )
                }
                day.note = activity.current_text_note.text.toString()
                if (isBig) {
                    db.updateBig(day)
                } else {
                    db.updateSmall(day)
                }
                Toast.makeText(
                    context,
                    context.getText(R.string.toast_successfully_saved),
                    Toast.LENGTH_SHORT
                ).show()
            }
            true
        }
        cellsList[i][j].setOnClickListener {
            if (MyApp.isEditing) {
                if (MyApp.focused != dayList[((7 * i) + j) - move].date) {
                    MyApp.focused = dayList[((7 * i) + j) - move].date
                } else {
                    var day: Day
                    if (isBig) {
                        day = db.getBig(
                            dayList[((7 * i) + j) - move].date.day,
                            dayList[((7 * i) + j) - move].date.month,
                            dayList[((7 * i) + j) - move].date.year
                        )
                    } else {
                        day = db.getSmall(
                            dayList[((7 * i) + j) - move].date.day,
                            dayList[((7 * i) + j) - move].date.month,
                            dayList[((7 * i) + j) - move].date.year
                        )
                    }
                    if (MyApp.color != -1) {
                        day.color = MyApp.color
                        if (MyApp.color == 0) {
                            day.status = 0
                            day.color = 0
                        } else if (MyApp.color == 1 || MyApp.color == 2 || MyApp.color == 3) {
                            when (day.status) {
                                0 -> day.status = 1
                                1 -> day.status = 2
                                2 -> day.status = 3
                                3 -> day.status = 0
                            }
                        } else {
                            day.status = 1
                        }
                        setCellBackground(cellsList[i][j], day.color, day.status)
                        if (isBig) {
                            db.updateBig(day)
                        } else {
                            db.updateSmall(day)
                        }
                    }
                }
            }
        }
    }
}