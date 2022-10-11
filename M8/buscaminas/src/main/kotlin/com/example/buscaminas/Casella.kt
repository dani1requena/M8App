package com.example.buscaminas

class Casella (esMina: Boolean, descoberta: Boolean, minaMarcada:Boolean, mines: Int) {
    var esMina:Boolean = esMina;
    var descoberta:Boolean = descoberta;
    var minaMarcada: Boolean = minaMarcada;
    var mines: Int = mines;

    @JvmName("getEsMina1")
    fun getEsMina():Boolean{
        return esMina;
    }

    @JvmName("setEsMina1")
    fun setEsMina(em:Boolean){
        esMina = em;
    }
    @JvmName("getDescoberta1")
    fun getDescoberta():Boolean{
        return descoberta;
    }
    @JvmName("setDescoberta1")
    fun setDescoberta(desc:Boolean){
        descoberta = desc;
    }
    @JvmName("getMinaMarcada1")
    fun getMinaMarcada():Boolean{
        return minaMarcada;
    }
    @JvmName("setMinaMarcada1")
    fun setMarcaMina(Mm:Boolean){
        minaMarcada = Mm;
    }
    fun getMinas():Int{
        return mines;
    }
    fun setMinas(min:Int){
        mines = min
    }


    override fun toString():String {
        if (getEsMina()) {
            return ". ";
        }
        if (!getDescoberta()) {
            return ". ";
        }
        if (getMinaMarcada()) {
            return "* ";
        }
        if (getMinas() >= 0 && getMinas() <= 8) {
            return "$mines "
        }
        return ""
    }
}