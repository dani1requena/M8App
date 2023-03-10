package com.example.myapplication.DB

import android.annotation.SuppressLint
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

    @SuppressLint("Range")
    fun getAllCoches (): ArrayList<Coche> {
        val retList = ArrayList<Coche>();
        val db = this.readableDatabase;

        val cursor: Cursor;

        cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                var marca: String = cursor.getString(cursor.getColumnIndex(COLUMN_NAME_MARCA));
                var modelo: String = cursor.getString(cursor.getColumnIndex(COLUMN_NAME_MODELO));
                var motor: String = cursor.getString(cursor.getColumnIndex(COLUMN_NAME_MOTOR));
                var traccion: String = cursor.getString(cursor.getColumnIndex(COLUMN_NAME_TRACCION));
                var nuevoCoche = Coche(marca, modelo  , motor ,traccion);


                retList.add(nuevoCoche);
            } while (cursor.moveToNext());
        }
        return retList;
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
    fun deliteAllCoches(){
        val db = this.readableDatabase;
        db.execSQL("DELETE FROM $TABLE_NAME")
    }
}


