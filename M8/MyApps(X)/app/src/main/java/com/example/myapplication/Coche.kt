package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity

class Coche (marca:String, modelo:String, motor:String, traccion:String){
    var marca = marca;
    var modelo = modelo;
    var motor = motor;
    var traccion = traccion;

    @JvmName("getMarca1")
    fun getMarca():String{
        return marca;
    }

    @JvmName("setMarca1")
    fun setMarca(Mark:String){
        marca = Mark;
    }
    @JvmName("getModelo1")
    fun getModelo():String{
        return modelo;
    }
    @JvmName("setModelo1")
    fun setModelo(mod:String){
        modelo = mod;
    }
    @JvmName("getMotor1")
    fun getMotor():String{
        return motor;
    }
    @JvmName("setMotor1")
    fun setMotor(Motor:String){
        motor = Motor;
    }
    @JvmName("getTraccion1")
    fun getTraccion():String{
        return traccion;
    }
    @JvmName("setTraccion1")
    fun setTraccion(trac:String){
        traccion = trac;
    }
}