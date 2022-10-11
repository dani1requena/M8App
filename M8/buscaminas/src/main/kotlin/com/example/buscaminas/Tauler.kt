package com.example.buscaminas

import java.util.ArrayList
import kotlin.random.Random

//Li pasem n i nm i crea un tauler amb nxn caselles, amb nm mines. Cada casella contindrà la informació del nombre de mines veïnes.
class Tauler (n:Int, nm:Int) {
    var n = n;
    var nm = nm;

    var tablero = Array(n) { Array(n) { Casella(false, false, false, 0) } }

    init {
        posaMines(nm);
        comptaMines();
    }

    //Li pasem nm i posa les nm mines de forma aleatòria.
    fun posaMines(nm: Int) {
        var cont = 0;

        while (cont < nm) {
            var x = Random.nextInt(0, n)
            var y = Random.nextInt(0, n)
            if (tablero[x][y].getEsMina() === false) {
                tablero[x][y].setEsMina(true);
                cont++;
            }
        }
    }
    //Per cada casella compta quantes mines té al voltant i estableix el seu valor.
    fun comptaMines() {
        var top: Int
        var right: Int
        var left: Int
        var bottom: Int
        var contador:Int=0
        for(i in 0 until  tablero.size){
            for(j in 0 until tablero[i].size){
                //top
                if (i-1>=0){
                    top = i-1
                }else{
                    top=0
                }
                //bottom
                if(i+1<=(n-1)) {
                    bottom = i + 1
                }else{
                    bottom= n - 1
                }
                //right
                if (j+1<=(n-1)){
                    right = j+1
                }else{
                    right=n-1
                }
                //left
                if(j-1>=0) {
                    left = j - 1
                }else{
                    left= 0
                }

                contador =0
                for(l in top .. bottom){
                    for(t in left .. right){
                        if(tablero[l][t].getEsMina()==true){
                            contador++
                        }
                    }
                }
                tablero[i][j].setMinas(contador);
            }
        }
    }
    //Mira si hi ha mina en una casella a partir de les coordenades x,y.
    fun hiHaMina(x: Int, y: Int): Boolean {
        return tablero[x][y].getEsMina()
    }
    //Mira si el tauler està totalment descobert (si no hi ha cel·les sense mines per descobrir) o no.
    fun descobert(): Boolean {
        for (i in 0 until tablero.size) {
            for (j in 0..tablero[i].size) {
                if (tablero[i][j].toString().equals(". ")) {
                    return false
                }
            }
        }
        return true
    }
    //Descobreix una casella a partir de les coordenades x,y.
    fun descobreixCasella(x: Int, y: Int) {
        tablero[x][y].setDescoberta(true)
    }
    //Destapa tot el tauler pel final del joc.
    fun descobreixTauler() {
        for (i in 0 until tablero.size) {
            for (j in 0 until tablero[i].size) {
                if(tablero[i][j].getEsMina()===true){
                    print("#")
                }
                tablero[i][j].setDescoberta(true)
                print(tablero[i][j])
            }
            println()
        }
    }
    //Ens diu si una casella està descoberta o no a partir de les coordenades x,y.
    fun descoberta(x: Int, y: Int) {
        tablero[x][y].getDescoberta()
    }
    //A partir de les coordenades x,y marca una casella com a mina si no estava marcada, i la desmarca si ja ho estava.
    fun marcaMina(x: Int, y: Int) {
        if (tablero[x][y].getMinaMarcada() == false) {
            tablero[x][y].setMarcaMina(true)
        } else {
            tablero[x][y].setMarcaMina(false)
        }
    }
    //A partir de les coordenades x,y ens diu si la casella està marcada com a mina.
    fun minaMarcada(x: Int, y: Int): Boolean {
        return tablero[x][y].getMinaMarcada()
    }
    override fun toString(): String {
        if (true) {
            var ret = " ";
            //Primera fila de letras
                for (i in 0 until n) {
                    ret += " " + (i + 97).toChar();
                }
                ret += "\n";
                for (i in 0 until n) {
                    ret += (i + 97).toChar() + " ";
                    for (j in 0 until n) {
                        ret += tablero[i][j].toString();
                    }
                    ret += "\n";
                }
                println(ret)
        }
        return ""
    }
}