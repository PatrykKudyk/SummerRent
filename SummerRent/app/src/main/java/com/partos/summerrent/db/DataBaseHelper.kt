package com.partos.summerrent.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.partos.summerrent.MyApp
import com.partos.summerrent.models.Date
import com.partos.summerrent.models.Day


object TableInfo : BaseColumns {
    const val DATABASE_NAME = "Summer Rent"
    const val TABLE_NAME_SMALL = "Small"
    const val TABLE_COLUMN_DAY = "day"
    const val TABLE_COLUMN_MONTH = "month"
    const val TABLE_COLUMN_YEAR = "year"
    const val TABLE_COLUMN_DAY_OF_WEEK = "dayOfWeek"
    const val TABLE_COLUMN_STATUS = "status"
    const val TABLE_COLUMN_NOTE = "note"
    const val TABLE_NAME_BIG = "Big"

}

object BasicCommand {
    const val SQL_CREATE_TABLE_SMALL =
        "CREATE TABLE ${TableInfo.TABLE_NAME_SMALL} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${TableInfo.TABLE_COLUMN_DAY} INTEGER NOT NULL," +
                "${TableInfo.TABLE_COLUMN_MONTH} INTEGER NOT NULL," +
                "${TableInfo.TABLE_COLUMN_YEAR} INTEGER NOT NULL," +
                "${TableInfo.TABLE_COLUMN_STATUS} INTEGER NOT NULL," +
                "${TableInfo.TABLE_COLUMN_NOTE} TEXT NOT NULL)"

    const val SQL_CREATE_TABLE_BIG =
        "CREATE TABLE ${TableInfo.TABLE_NAME_BIG} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${TableInfo.TABLE_COLUMN_DAY} INTEGER NOT NULL," +
                "${TableInfo.TABLE_COLUMN_MONTH} INTEGER NOT NULL," +
                "${TableInfo.TABLE_COLUMN_YEAR} INTEGER NOT NULL," +
                "${TableInfo.TABLE_COLUMN_STATUS} INTEGER NOT NULL," +
                "${TableInfo.TABLE_COLUMN_NOTE} TEXT NOT NULL)"

    const val SQL_DELETE_TABLE_SMALL = "DROP TABLE IF EXISTS ${TableInfo.TABLE_NAME_SMALL}"
    const val SQL_DELETE_TABLE_BIG = "DROP TABLE IF EXISTS ${TableInfo.TABLE_NAME_BIG}"
}

class DataBaseHelper(context: Context) :
    SQLiteOpenHelper(context, TableInfo.DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(BasicCommand.SQL_CREATE_TABLE_SMALL)
        db?.execSQL(BasicCommand.SQL_CREATE_TABLE_BIG)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL(BasicCommand.SQL_CREATE_TABLE_SMALL)
        db?.execSQL(BasicCommand.SQL_CREATE_TABLE_BIG)

        onCreate(db)
    }

    fun initDatabase() {
        for (year in 2020..2022) {
            for (month in 0..12) {
                for (day in 0..31) {
                    if (month == 2) {
                        if (year == 2020 && day <= 29) {
                            addSmall(day, month, year, 0, "")
                            addBig(day, month, year, 0, "")
                        } else if (year == 2021 && day <= 28) {
                            addSmall(day, month, year, 0, "")
                            addBig(day, month, year, 0, "")
                        }
                    } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                        if (day <= 30){
                            addSmall(day, month, year, 0, "")
                            addBig(day, month, year, 0, "")
                        }
                    } else {
                        addSmall(day, month, year, 0, "")
                        addBig(day, month, year, 0, "")
                    }
                }
            }
        }
    }


    fun getSmallList(): ArrayList<Day> {
        var smallList = ArrayList<Day>()
        val db = readableDatabase
        val selectQuery = "Select * from ${TableInfo.TABLE_NAME_SMALL}"
        val result = db.rawQuery(selectQuery, null)
        if (result.moveToFirst()) {
            do {
                var day = Day(
                    result.getInt(result.getColumnIndex(BaseColumns._ID)).toLong(),
                    Date(
                        result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_DAY)),
                        result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_MONTH)),
                        result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_YEAR))
                    ),
                    result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_STATUS)),
                    result.getString(result.getColumnIndex(TableInfo.TABLE_COLUMN_NOTE))
                )
                smallList.add(day)
            } while (result.moveToNext())
        }
        result.close()
        db.close()
        return smallList
    }

    fun getBigList(): ArrayList<Day> {
        var bigList = ArrayList<Day>()
        val db = readableDatabase
        val selectQuery = "Select * from ${TableInfo.TABLE_NAME_BIG}"
        val result = db.rawQuery(selectQuery, null)
        if (result.moveToFirst()) {
            do {
                var day = Day(
                    result.getInt(result.getColumnIndex(BaseColumns._ID)).toLong(),
                    Date(
                        result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_DAY)),
                        result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_MONTH)),
                        result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_YEAR))
                    ),
                    result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_STATUS)),
                    result.getString(result.getColumnIndex(TableInfo.TABLE_COLUMN_NOTE))
                )
                bigList.add(day)
            } while (result.moveToNext())
        }
        result.close()
        db.close()
        return bigList
    }

    fun getSmallMonth(month: Int, year: Int): ArrayList<Day> {
        var smallList = ArrayList<Day>()
        val db = readableDatabase
        val selectQuery =
            "Select * from ${TableInfo.TABLE_NAME_SMALL} where ${TableInfo.TABLE_COLUMN_MONTH} = " + month.toString() +
                    " and ${TableInfo.TABLE_COLUMN_YEAR} = " + year.toString()
        val result = db.rawQuery(selectQuery, null)
        if (result.moveToFirst()) {
            do {
                var smallDay = Day(
                    result.getInt(result.getColumnIndex(BaseColumns._ID)).toLong(),
                    Date(
                        result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_DAY)),
                        result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_MONTH)),
                        result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_YEAR))
                    ),
                    result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_STATUS)),
                    result.getString(result.getColumnIndex(TableInfo.TABLE_COLUMN_NOTE))
                )
                smallList.add(smallDay)
            } while (result.moveToNext())
        }

        result.close()
        db.close()
        return smallList
    }

    fun getBigMonth(month: Int, year: Int): ArrayList<Day> {
        var bigList = ArrayList<Day>()
        val db = readableDatabase
        val selectQuery =
            "Select * from ${TableInfo.TABLE_NAME_BIG} where ${TableInfo.TABLE_COLUMN_MONTH} = " + month.toString() +
                    " and ${TableInfo.TABLE_COLUMN_YEAR} = " + year.toString()
        val result = db.rawQuery(selectQuery, null)
        if (result.moveToFirst()) {
            do {
                var bigDay = Day(
                    result.getInt(result.getColumnIndex(BaseColumns._ID)).toLong(),
                    Date(
                        result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_DAY)),
                        result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_MONTH)),
                        result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_YEAR))
                    ),
                    result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_STATUS)),
                    result.getString(result.getColumnIndex(TableInfo.TABLE_COLUMN_NOTE))
                )
                bigList.add(bigDay)
            } while (result.moveToNext())
        }

        result.close()
        db.close()
        return bigList
    }

    fun getSmall(day: Int, month: Int, year: Int): Day {
        var smallList = ArrayList<Day>()
        val db = readableDatabase
        val selectQuery =
            "Select * from ${TableInfo.TABLE_NAME_SMALL} where ${TableInfo.TABLE_COLUMN_DAY} = " +
                    day.toString() + " and ${TableInfo.TABLE_COLUMN_MONTH} = " + month.toString() +
                    " and ${TableInfo.TABLE_COLUMN_YEAR} = " + year.toString()
        val result = db.rawQuery(selectQuery, null)
        if (result.moveToFirst()) {
            do {
                var smallDay = Day(
                    result.getInt(result.getColumnIndex(BaseColumns._ID)).toLong(),
                    Date(
                        result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_DAY)),
                        result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_MONTH)),
                        result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_YEAR))
                    ),
                    result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_STATUS)),
                    result.getString(result.getColumnIndex(TableInfo.TABLE_COLUMN_NOTE))
                )
                smallList.add(smallDay)
            } while (result.moveToNext())
        }

        result.close()
        db.close()
        return smallList[0]
    }

    fun getBig(day: Int, month: Int, year: Int): Day {
        var bigList = ArrayList<Day>()
        val db = readableDatabase
        val selectQuery =
            "Select * from ${TableInfo.TABLE_NAME_BIG} where ${TableInfo.TABLE_COLUMN_DAY} = " +
                    day.toString() + " and ${TableInfo.TABLE_COLUMN_MONTH} = " + month.toString() +
                    " and ${TableInfo.TABLE_COLUMN_YEAR} = " + year.toString()
        val result = db.rawQuery(selectQuery, null)
        if (result.moveToFirst()) {
            do {
                var smallDay = Day(
                    result.getInt(result.getColumnIndex(BaseColumns._ID)).toLong(),
                    Date(
                        result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_DAY)),
                        result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_MONTH)),
                        result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_YEAR))
                    ),
                    result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_STATUS)),
                    result.getString(result.getColumnIndex(TableInfo.TABLE_COLUMN_NOTE))
                )
                bigList.add(smallDay)
            } while (result.moveToNext())
        }

        result.close()
        db.close()
        return bigList[0]
    }

    fun addSmall(
        day: Int,
        month: Int,
        year: Int,
        status: Int,
        note: String
    ): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(TableInfo.TABLE_COLUMN_DAY, day)
        values.put(TableInfo.TABLE_COLUMN_MONTH, month)
        values.put(TableInfo.TABLE_COLUMN_YEAR, year)
        values.put(TableInfo.TABLE_COLUMN_STATUS, status)
        values.put(TableInfo.TABLE_COLUMN_NOTE, note)
        val success = db.insert(TableInfo.TABLE_NAME_SMALL, null, values)
        db.close()
        return (Integer.parseInt("$success") != -1)
    }

    fun addBig(
        day: Int,
        month: Int,
        year: Int,
        status: Int,
        note: String
    ): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(TableInfo.TABLE_COLUMN_DAY, day)
        values.put(TableInfo.TABLE_COLUMN_MONTH, month)
        values.put(TableInfo.TABLE_COLUMN_YEAR, year)
        values.put(TableInfo.TABLE_COLUMN_STATUS, status)
        values.put(TableInfo.TABLE_COLUMN_NOTE, note)
        val success = db.insert(TableInfo.TABLE_NAME_BIG, null, values)
        db.close()
        return (Integer.parseInt("$success") != -1)
    }

    fun updateSmall(day: Day): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(TableInfo.TABLE_COLUMN_DAY, day.date.day)
        values.put(TableInfo.TABLE_COLUMN_MONTH, day.date.month)
        values.put(TableInfo.TABLE_COLUMN_YEAR, day.date.year)
        values.put(TableInfo.TABLE_COLUMN_STATUS, day.status)
        values.put(TableInfo.TABLE_COLUMN_NOTE, day.note)
        val success = db.update(
            TableInfo.TABLE_NAME_SMALL, values, BaseColumns._ID + "=?",
            arrayOf(day.id.toString())
        ).toLong()
        return Integer.parseInt("$success") != -1
    }

    fun updateBig(day: Day): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(TableInfo.TABLE_COLUMN_DAY, day.date.day)
        values.put(TableInfo.TABLE_COLUMN_MONTH, day.date.month)
        values.put(TableInfo.TABLE_COLUMN_YEAR, day.date.year)
        values.put(TableInfo.TABLE_COLUMN_STATUS, day.status)
        values.put(TableInfo.TABLE_COLUMN_NOTE, day.note)
        val success = db.update(
            TableInfo.TABLE_NAME_BIG, values, BaseColumns._ID + "=?",
            arrayOf(day.id.toString())
        ).toLong()
        return Integer.parseInt("$success") != -1
    }

}