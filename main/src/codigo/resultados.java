/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonatan Garcia
 */

class resultados { 
    static List<Conjuntos> Conjun = new ArrayList();
    
    
    static void addconj(Object a,Object b) {
        //convertir a string
        String x = a.toString();
        String y = b.toString();
        Conjun.add(new Conjuntos(x,y));
     


    }
    static void imprimir(){
       
            for (Conjuntos conjunto : Conjun){
                System.out.println("Identificador " + conjunto.name + "CADENA " + conjunto.cadena);
    }
    }
}
class Conjuntos {
    
    String name;
    String cadena;
    
    Conjuntos(String name, String cadena){
        
        this.name = name;
        this.cadena = cadena;
        

    }

   
    
}