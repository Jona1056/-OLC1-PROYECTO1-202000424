/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;

import codigo.resultados;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 *
 * @author Jonatan Garcia
 */
public class transitionTable {
    public String Transicion;
    public ArrayList<ArrayList> states;
    public int cont;
    public ArrayList<ArrayList> evaluar = new ArrayList<>();;
    public ArrayList<ArrayList> evaluar2 =new ArrayList<>();;
  
    
    public transitionTable(node root, ArrayList tabla, ArrayList<node> leaves) {
        this.states = new ArrayList(); // estados del afd

        ArrayList datos = new ArrayList();
        datos.add("S0");
        datos.add(root.first);
        datos.add(new ArrayList());
        datos.add(false);
     
        int aceptacion = 0;
       
        this.states.add(datos);
        this.cont = 1;

        for (int i = 0; i < states.size(); i++) { 
            ArrayList state = states.get(i); 

            ArrayList<Integer> elementos = (ArrayList) state.get(1);
            Map<String, ArrayList<Integer>> transiciones = new HashMap<>();

            for (int hoja : elementos) {
                followTable sigTabla = new followTable();
                ArrayList lexemeNext = (ArrayList) sigTabla.next(hoja, tabla).clone();

                if (lexemeNext.get(0) == "") {
                    continue;
                }

                ArrayList<Integer> sigEstados = transiciones.get(lexemeNext.get(0));
                if (sigEstados == null) {
                    sigEstados = new ArrayList<>();
                    transiciones.put((String) lexemeNext.get(0), sigEstados);
                }
                sigEstados.addAll((ArrayList<Integer>) lexemeNext.get(1));

                leave hojas = new leave(); 

            }

            for (Map.Entry<String, ArrayList<Integer>> entrada : transiciones.entrySet()) {
                ArrayList<Integer> sigEstados = entrada.getValue();

                String nombreEstadoSiguiente = null;
                for (ArrayList estado : states) {
                    if (estado.get(1).equals(sigEstados)) {
                        nombreEstadoSiguiente = (String) estado.get(0);
                        break;
                    }
                }

                if (nombreEstadoSiguiente == null) {
                    nombreEstadoSiguiente = "S" + cont;
                    cont++;

                    ArrayList nuevo = new ArrayList();
                    nuevo.add(nombreEstadoSiguiente);
                    nuevo.add(sigEstados);
                    nuevo.add(new ArrayList());
                    // evaluate if the number is in sigEstados
                    if (sigEstados.contains(aceptacion)) {
                        nuevo.add(true);

                    } else {
                        nuevo.add(false);
                    }
                
                    states.add(nuevo);
                }
                transicion trans = new transicion(state.get(0) + "", entrada.getKey(), nombreEstadoSiguiente);
                ((ArrayList) state.get(2)).add(trans);
             
            }
        }
        aceptacion(states, leaves);
    }
    
    public void aceptacion(ArrayList<ArrayList> states, ArrayList<node> leaves) {
    for(ArrayList state : states) {
        boolean acceptState = false;
        for(Integer leaf : (ArrayList<Integer>)state.get(1)) {
            if(new leave().isAccept(leaf, leaves)) {
                acceptState = true;
                break;
            }
        }
        state.set(3, acceptState);
    }
}
    public void evaluarcadena(String cadena, String nombre){
        int contador = 0;
        evaluar = new ArrayList();
        for (ArrayList state : states) {
            System.out.println("--------------------------------");
            ArrayList<Object> dat = (ArrayList<Object>) state.get(2);
            evaluar2 = new ArrayList();
            for (Object state1 : dat) {

                String cadena1 = state1.toString();
                cadena1 = cadena1.replace("->", "");

                String[] palabras = cadena1.split("[\\s]+");

                String x = state.get(3).toString();
                ArrayList<String> sublista = new ArrayList<>(Arrays.asList(palabras));

                sublista.add(x);
                evaluar2.add(sublista);

            }
            evaluar.add(evaluar2);
            if (contador == states.size() - 1) {
                ArrayList<String> sublista1 = new ArrayList<>();
                String x1 = "S" + contador;
                sublista1.add(x1);
                sublista1.add("true");
                sublista1.add("true");
                sublista1.add("true");

                evaluar2.add(sublista1);
            }

            contador++;
        }
        for (ArrayList evalu : evaluar) {
            System.out.println(evalu);
        }
        evaluar(evaluar, cadena, nombre);

    }
    
   public void evaluar(ArrayList reglas, String cadena,String identificador){
       String estado = "S0";

       boolean aceptado = true;
       int i = 0;
       String cadena1 = cadena;
       cadena1 = cadena1.substring(1, cadena1.length() - 1);

       System.out.println(cadena);
       while (i < cadena1.length() && aceptado) {
           char caracter = cadena1.charAt(i);
           if (caracter == ' ') {
               i++;
               continue;
           }
           String carac = String.valueOf(caracter);

           if (carac.equals("\\")) {
               // Si se encuentra un backslash, se avanza una posición en la cadena
               i++;
               carac += cadena1.charAt(i);
           }

           boolean avanzar_regla = true;
           for (Object evalu : reglas) {
               ArrayList ar = (ArrayList) evalu;
               if (!avanzar_regla) {
                   break;
               }
               for (Object reg : ar) {
                   String estado_inicial = ((ArrayList) reg).get(0).toString();
                   String estado_final = ((ArrayList) reg).get(2).toString();
                   String aceptado_str = ((ArrayList) reg).get(3).toString();
                   String conjunto = ((ArrayList) reg).get(1).toString();
                   boolean aceptado_regla = Boolean.parseBoolean(aceptado_str);

                   if (estado.equals(estado_inicial)) {
                       System.out.println("el estado es " + estado_inicial);
                       if (conjunto.contains("\"")) {
                           if (conjunto.equals("\\\"")) {
                               if (carac.equals(conjunto)) {
                                   estado = estado_final;
                                   System.out.println(estado);
                                   avanzar_regla = false;
                                   break;
                               }
                           } else {

                               String conjunto_sin_comillas = conjunto.replace("\"", "");

                               if (carac.equals(conjunto_sin_comillas)) {
                                   estado = estado_final;
                                   System.out.println(estado);
                                   avanzar_regla = false;
                                   break;
                               }
                           }
                       } else if (conjunto.equals("\\'") || conjunto.equals("\\\"")) {

                           if (carac.equals(conjunto)) {
                               estado = estado_final;
                               System.out.println(estado);
                               avanzar_regla = false;
                               break;
                           }
                       } else {
                           boolean perteneceAlConjunto = false;
                           String conjunto1 = resultados.buscarconjunto(conjunto);

                           if (conjunto1 == null) {

                           } else {
                               if (conjunto1.contains(",")) {
                                   String[] elementos = conjunto1.split(",");
                                   for (String elem : elementos) {
                                       if (carac.equals(elem)) {
                                           System.out.println(carac);
                                           perteneceAlConjunto = true;
                                           break;
                                       }
                                   }
                               } else {
                                   char inicio = conjunto1.charAt(0);
                                   char fin = conjunto1.charAt(2);
                                   char c = carac.charAt(0);
                                   if (c >= inicio && c <= fin) {
                                       perteneceAlConjunto = true;
                                   }
                               }
                           }
                           if (perteneceAlConjunto) {
                               estado = estado_final;
                               avanzar_regla = false;
                               if (estado_inicial.equals(estado_final)) {
                                   break;
                               }
                           }
                       }
                   }
               }
               if (!avanzar_regla) {
                   break;
               }
           }
           if (avanzar_regla) {
               aceptado = false;
           } else {
               i++;
           }
       }
CreateJson.main(identificador, cadena, aceptado);
System.out.println("El resultado es " + aceptado);}
    public void impTable(){
        Transicion ="";
         Transicion +="<div class=container>"+
"		 <h1>TABLA DE TRANSICIONES Carnet: 202000424</h1>"+
"		 <table>"+
 "               <tr>" +
 "               <td colspan=1>ESTADO</td>"+
 "               <td colspan=1>TRANSICIONES</td>"+
                  "<td colspan=1>ACEPTABLE</td>"
             
                 ;
         
        for(ArrayList state : states){
            String tran = "[";
            for(Object tr : (ArrayList)state.get(2)){
                transicion t = (transicion) tr;
                tran += t.toString() + ", ";           
            }
            tran += "]";
            tran = tran.replace(", ]", "]");
            System.out.println(state.get(0) + " " + state.get(1) + " " + tran + " " + state.get(3));
            Transicion +=  "<tr>\n" +
                     "    <td>" + state.get(0) + ""+state.get(1) +"</td>\n" +
                     "    <td>" + state.get(2) + "</td>\n" +
                        "    <td>" + state.get(3) + "</td>\n" +
                     "</tr>\n";
        
        }
        
    }
    public void HTMLTransicion(String identificador){
          try {
            PrintWriter writer = new PrintWriter("D:\\Desktop\\[OLC1]PROYECTO1-202000424\\main\\TRANSICIONES_202000424\\"+"TRANSICIONES_"+identificador+".html", "UTF-8");
            writer.println("<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"	<meta charset=\"UTF-8\">\n" +
"	<title>Tabla con estilo</title>\n" +
"	<style>\n" +
"		body {\n" +
"			background: linear-gradient(to bottom, #3a4c63, #62c98d);\n" +
"			background-size: cover;\n" +
"			background-repeat: no-repeat;\n" +
"			margin: 0;\n" +
"			padding: 0;\n" +
"			display: flex;\n" +
"			flex-direction: column;\n" +
"			height: 100vh;\n" +
"			justify-content: center;\n" +
"		}\n" +
"		h1 {\n" +
"			font-size: 36px;\n" +
"			color: white;\n" +
"			text-align: center;\n" +
"			margin-top: 40px;\n" +
"			margin-bottom: 20px;\n" +
"			text-shadow: 2px 2px #555;\n" +
"		}\n" +
"		.container {\n" +
"			display: flex;\n" +
"			flex-direction: column;\n" +
"			align-items: center;\n" +
"		}\n" +
"		table {\n" +
"			border-collapse: collapse;\n" +
"			width: 80%;\n" +
"			font-family: Arial, sans-serif;\n" +
"			font-size: 14px;\n" +
"			text-align: center;\n" +
"			background-color: #f9f9f9;\n" +
"			box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);\n" +
"			margin-top: 40px;\n" +
"			margin-bottom: 40px;\n" +
"		}\n" +
"		th, td {\n" +
"			border: 1px solid #ddd;\n" +
"			padding: 12px;\n" +
"			text-align: center;\n" +
"			vertical-align: middle;\n" +
"		}\n" +
"		th {\n" +
"			background-color: #4CAF50;\n" +
"			color: white;\n" +
"			text-transform: uppercase;\n" +
"			letter-spacing: 1px;\n" +
"			font-weight: bold;\n" +
"		}\n" +
"		tr:nth-child(even) {\n" +
"			background-color: #f2f2f2;\n" +
"		}\n" +
"		tr:hover {\n" +
"			background-color: #ddd;\n" +
"		}\n" +
"        /* Personalización de la tabla */\n" +
"        table {\n" +
"            font-size: 16px;\n" +
"        }\n" +
"	</style>\n" +
"</head>\n" +
Transicion+
"        </table>\n" +
"	</div>\n" 
 + "<t/body>\n"+  
          "</html>"      );
         
            writer.close();
            System.out.println("El archivo archivo.html ha sido creado correctamente.");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al crear el archivo archivo.html: " + e.getMessage());
        }
    }
    
 public String impGraph(){
     String graph = "";
     graph += ("digraph G {       rankdir=LR;\n");
    graph +=("\tnode [shape=circle];\n");
    for(ArrayList state : states){
        
        String label = state.get(0).toString();
        
    
        
        // si el estado es de aceptacion, se agrega doble circulo
        if ((boolean) state.get(3)) {
            graph += "\"" + label + "\" [shape=\"doublecircle\"];\n";
        }}
         for(ArrayList state : states){  
                    String label = state.get(0).toString();
               
        for(Object tr : (ArrayList)state.get(2)){
          
       
            transicion t = (transicion) tr;
            graph += t.graph();
             graph += "\"" + label + "\" [label=\"" + label + "\"];\n";
        }
        
       
       
    }
     graph += "}";
     return graph;
    
}
 
 public void AFD(String cadena, String Identificador){
      try {
            // Crear un proceso que ejecute el comando "dot"
            ProcessBuilder pb = new ProcessBuilder("dot", "-Tpng");
            pb.redirectErrorStream(true);
            Process p = pb.start();

            // Obtener los streams de entrada y salida del proceso
            OutputStream os = p.getOutputStream();
            InputStream is = p.getInputStream();

            // Escribir el código Graphviz en el stream de entrada del proceso
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
            writer.write(cadena);
            writer.flush();
            writer.close();
            os.close();

            // Leer la imagen desde el stream de salida del proceso
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            is.close();

            // Guardar la imagen en un archivo
            byte[] imageData = baos.toByteArray();
            FileOutputStream fos = new FileOutputStream("D:\\Desktop\\[OLC1]PROYECTO1-202000424\\main\\AFD_202000424\\"+"AFD_"+Identificador+".png");
            fos.write(imageData);
            fos.close();

            System.out.println("Imagen AFD generada correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
 }
}