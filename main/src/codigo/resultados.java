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

public class resultados { 
    static List<Conjuntos> Conjun = new ArrayList();
    static List<expresiones1> Expresiones1 = new ArrayList();
        static List<Conjuntos2> Conjun2 = new ArrayList();
                static List<Oraciones> ORA = new ArrayList();
    
    
    public static void addconj(Object a,Object b) {
        //convertir a string
        String x = a.toString();
        String y = b.toString();
        String ySin = y.replaceAll("\\s+", "");
        Conjun.add(new Conjuntos(x,ySin));
     


    }
    public  static void addconj2(Object a,Object b) {
        //convertir a string
        String x = a.toString();
        String y = b.toString();
        String ySin = y.replaceAll("\\s+", "");
        Conjun2.add(new Conjuntos2(x,ySin));
     


    }
    public static void imprimir(){
          System.out.println("CONJUNTO CON COMAS");
            
            for (Conjuntos conjunto : Conjun){
                
                System.out.println("Identificador " +" "+ conjunto.name + " "+ "CADENA " + conjunto.cadena);
    }
              System.out.println("CONJUNTO COMPLETO");
        for (Conjuntos2 conjuntos2 : Conjun2){
                
                System.out.println("Identificador " +" "+ conjuntos2.name + " "+ "CADENA " + conjuntos2.cadena);
    }
            for(expresiones1 exp: Expresiones1){
                 System.out.println("Identificador " +" "+ exp.name + " "+ "CADENA " + exp.cadena);
            }
        System.out.println("ORACIONES A EVALUAR");
             for(Oraciones ora: ORA){
                 System.out.println("Identificador " +" "+ ora.name + " "+ "CADENA " + ora.cadena);
            }
        
    }
    public static String buscarconjunto(String name){
        if(Conjun.isEmpty()){
            
        }else{
          for (Conjuntos conjunto : Conjun){
               if(name.equals(conjunto.name)){
                    return conjunto.cadena;
                }else{
                 
                }
    }
        }
        
        if(Conjun2.isEmpty()){
            
        }else{
         for (Conjuntos2 conjuntos2 : Conjun2){
                if(name.equals(conjuntos2.name)){
                    return conjuntos2.cadena;
                }else{
                  
                }
               
                
    }}
        return null;
      
    }
    
    public static void addExpresiones(Object a, Object b){
         String x = a.toString();
        String y = b.toString();

        Expresiones1.add(new expresiones1(x,y));
     
    }
    
    public static void addOraciones(Object a, Object b){
         String x = a.toString();
        String y = b.toString();

        ORA.add(new Oraciones(x,y));
     
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
 class Conjuntos2 {
    
    String name;
    String cadena;
    
    Conjuntos2(String name, String cadena){
        
        this.name = name;
        this.cadena = cadena;
        

    }


    
}
class expresiones1{
    String name;
    String cadena;
            
        expresiones1(String name, String cadena){
            this.name = name;
            this.cadena = cadena;
        }
                
}
class Oraciones{
    String name;
    String cadena;
            
        Oraciones(String name, String cadena){
            this.name = name;
            this.cadena = cadena;
        }
                
}