/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;

import java.util.ArrayList;

import Arbol.node;

/**
 *
 * @author Jonatan Garcia
 */
public class main {

    public static void Arbol(String er,String identificador) {
         
        //String er = "...*|ababb"; //En esta er ocurre el bug
        
        ArrayList<node> leaves = new ArrayList();
        ArrayList<ArrayList> table = new ArrayList();
        
        er = "." + er + "#";
        
        Tree arbol = new Tree(er, leaves, table); // CREA EL ARBOL
        node raiz = arbol.getRoot();
        
        raiz.getNode(); // DETERMINA SI LOS NODOS SON ANULABLES, SUS PRIMEROS Y ULTIMOS
        raiz.follow();
        
        System.out.println("==============================TABLA SIGUIENTES==============================");
        followTable ft = new followTable();
        ft.printTable(table);
        transitionTable tran = new transitionTable(raiz, table, leaves); // bug
        System.out.println("=============================TABLA TRANSICIONES=============================");
        tran.impTable();
        System.out.println("============================= GRAPHVIZ===============================================");
        String afd =tran.impGraph();
        tran.AFD(afd, identificador);
        
         //AQUI CREAMOS EL ARBOL EN GRAPHVIZ
         String Cadena = raiz.toGraphviz(identificador);
         arbol.printArbol(Cadena,identificador);
       
    }
    
    
   
}


