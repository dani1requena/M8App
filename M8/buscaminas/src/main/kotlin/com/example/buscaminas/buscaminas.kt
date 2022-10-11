package com.example.buscaminas

import javafx.application.Application
import javafx.stage.Stage

class buscaminas : Application() {
    override fun start(p0: Stage?) {
    }
}
fun main() {
    var n:Int
    var nm:Int
    var x:Int
    var y:Int
    var resp:String?

    println("**BUSCAMINES**")
    println()
    println("De l' 1 al 26. Quantes caselles vols")
    n = readLine()!!.toInt()
    if(n>26 || n<1){
        println("ERROR")
    } else {
        println("Quantes mines vols?")
        nm = readLine()!!.toInt()
        if(nm <1 || nm > (n*n)){
            println("ERROR")
        }else{
            var tauler = Tauler(n, nm)
            while(!tauler.descobert()){
                tauler.toString()
                println("Vols marcar o desmarcar com a mina?(si/no)")
                resp = readLine()
                if(resp.equals("si")){
                    println("fila?")
                    x= readLine()!!.toInt()
                    println("columna?")
                    y= readLine()!!.toInt()
                    tauler.marcaMina(x,y)
                }else{
                    println("fila?")
                    x= readLine()!!.toInt()
                    println("columna?")
                    y= readLine()!!.toInt()
                    tauler.descobreixCasella(x,y)


                    if(tauler.hiHaMina(x,y)){
                        println("GAME OVER")
                        tauler.descobreixTauler()
                        break;
                    }
                }
            }
        }
    }
}
