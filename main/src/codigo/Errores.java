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
public class Errores {
    static List<Errores> L_errores = new ArrayList();
    String lexema;
    int fila;
    int columna;
    String Tipo;
    String descripcion;
    
    Errores(String lexema,int fila, int columna, String Tipo, String descripcion){
        
        this.lexema = lexema;
        this.fila = fila;
        this.columna = columna;
        this.Tipo = Tipo;
        this.descripcion = descripcion;
        

    }
      
    static void addErrores(String lexema, int fila, int columna, String Tipo, String descripcion) {
      
        L_errores.add(new Errores((String) lexema,fila,columna,Tipo,descripcion));
     


    }
    static void ImprimirErrores(){
                    for (Errores er : L_errores){
                System.out.println("TOKEN: "+ er.lexema);
    }
    }
    
}
