package com.example.myapplication.DB

object CochesContract {
    val TABLE_NAME = "coches"
    val COLUMN_NAME_MARCA = "marca"
    val COLUMN_NAME_MODELO = "modelo"
    val COLUMN_NAME_MOTOR = "motor"
    val COLUMN_NAME_TRACCION = "traccion"

    val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${TABLE_NAME} (" +
                "id INTEGER PRIMARY KEY," +
                "${COLUMN_NAME_MARCA} TEXT," +
                "${COLUMN_NAME_MODELO} TEXT," +
                "${COLUMN_NAME_MOTOR} TEXT," +
                "${COLUMN_NAME_TRACCION} TEXT);"

    val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${TABLE_NAME}"
}