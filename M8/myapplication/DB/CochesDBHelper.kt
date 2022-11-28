package com.example.myapplication.DB

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.myapplication.Coche
import com.example.myapplication.DB.CochesContract.COLUMN_NAME_MARCA
import com.example.myapplication.DB.CochesContract.COLUMN_NAME_MODELO
import com.example.myapplication.DB.CochesContract.COLUMN_NAME_MOTOR
import com.example.myapplication.DB.CochesContract.COLUMN_NAME_TRACCION
import com.example.myapplication.DB.CochesContract.SQL_CREATE_ENTRIES
import com.example.myapplication.DB.CochesContract.SQL_DELETE_ENTRIES
import com.example.myapplication.DB.CochesContract.TABLE_NAME


class CochesDBHelper (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    val coches = ArrayList<Coche>()
    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "coches.db"
    }
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }
    fun getAllCoches():MutableList<Coche> {
        val db = this.readableDatabase
        val llistat:ArrayList<Coche> = ArrayList()
        val cursor: Cursor = db.rawQuery("SELECT * FROM ${TABLE_NAME}",null)
        if(cursor.moveToFirst()){
            do{
                llistat.add(
                    Coche(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)
                    )
                )
            }while (cursor.moveToNext())
        }
        cursor.close()
        return llistat;
    }
    fun insertCoche(l: Coche) {
            val values = ContentValues()
            values.put(COLUMN_NAME_MARCA, l.marca)
            values.put(COLUMN_NAME_MODELO, l.modelo)
            values.put(COLUMN_NAME_MOTOR, l.motor)
            values.put(COLUMN_NAME_TRACCION, l.traccion)

            val db = this.writableDatabase
            db.insert(TABLE_NAME, null, values)
    }
}


