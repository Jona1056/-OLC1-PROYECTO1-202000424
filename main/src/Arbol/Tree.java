/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;
import Arbol.type.Types;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.*;
import java.util.Random;
/**
 *
 * @author Jonatan Garcia
 */

public class Tree {
    
    node root;
     
    public Tree( String er, ArrayList<node> leaves, ArrayList<ArrayList> table ) {
        
      
        Stack pila = new Stack();
           
        String[] erSplit = er.split("");
          ArrayList<String> erSplitList = new ArrayList<>();
        ArrayList<String> erSplitList2 = new ArrayList<>();

for (int i = 0; i < erSplit.length; i++) {
    if (erSplit[i].equals("|")) {
        erSplitList.add("|");
    } else if (erSplit[i].equals("*")) {
        erSplitList.add("*");
    } else if (erSplit[i].equals("+")) {
        erSplitList.add("+");
    } else if (erSplit[i].equals("?")) {
        erSplitList.add("?");
    } else if (erSplit[i].equals(".")) {
        erSplitList.add(".");
         } else if (erSplit[i].equals("#")) {
        erSplitList.add("#");
      erSplitList2.add("#");
    } else if (erSplit[i].equals("{")) {
        // Buscar el siguiente cierre de llave '}'
        int j = i + 1;
        while (j < erSplit.length && !erSplit[j].equals("}")) {
            j++;
        }
        // Si se encontró el cierre de llave, agregar los caracteres entre las llaves a la lista
        if (j < erSplit.length) {
            String variable = "";
            for (int k = i + 1; k < j; k++) {
                variable += erSplit[k];
            }
            erSplitList.add(variable);
              erSplitList2.add(variable);
            i = j; // saltar el bloque de caracteres procesados
        }
    } else if (erSplit[i].equals("\"")) {
        // Buscar la siguiente comilla doble '"'
        int j = i + 1;
        while (j < erSplit.length && !erSplit[j].equals("\"")) {
            j++;
        }
        // Si se encontró la comilla doble, agregar los caracteres entre las comillas a la lista
        if (j < erSplit.length) {
            String variable = "";
            variable += "\"";
            for (int k = i + 1; k < j; k++) {
                variable += erSplit[k];
            }
             variable += "\"";
             System.out.println(variable);
             if(variable.equals("\" \"")){
                    erSplitList.add("vacio");
              erSplitList2.add("vacio");
             }else{
                    erSplitList.add(variable);
              erSplitList2.add(variable);
             }
           
                 
             
         
            i = j; // saltar el bloque de caracteres procesados
        }
    }else if (erSplit[i].equals("\\")) {
        // Verificar el siguiente carácter después de '\'
        if (i + 1 < erSplit.length) {
  
            String variable = erSplit[i] + erSplit[i+1];
       
                 erSplitList.add(variable);
                 erSplitList2.add(variable);

            }
           
                i++; // saltar el siguiente carácter
         
        } 
        }


  System.out.println("---------------------------------------------------");
          System.out.println(erSplitList);
         System.out.println(erSplitList2.size());
            System.out.println("---------------------------------------------------");
        Collections.reverse(erSplitList);
         numLeave numHoja = new numLeave(erSplitList2.size());
        erSplitList.forEach((character) -> {
       
            switch (character) {
                case "|":
                    node lefto = (node) pila.pop();
                    node righto = (node) pila.pop();
                      
                    node no = new node(character, Types.OR, 0, lefto, righto, leaves, table);
                    pila.push(no);
                    
                    break;
                case ".":
                    node lefta = (node) pila.pop();
                    node righta = (node) pila.pop();
                    
                    node na = new node(character, Types.AND, 0, lefta, righta, leaves, table);
                    pila.push(na);
                    
                    break;
                case "*":
                    node unario = (node) pila.pop();
                    
                    node nk = new node(character, Types.KLEENE, 0, unario, null, leaves, table);
                    pila.push(nk);
                    
                    break;
                 case "+":
                    node unario1 = (node) pila.pop();
                    
                    node nk1 = new node(character, Types.SUMA, 0, unario1, null, leaves, table);
                    pila.push(nk1);
                    
                    break;
                 case "?":
                    node unario2 = (node) pila.pop();
                    
                    node nk2 = new node(character, Types.INTE, 0, unario2, null, leaves, table);
                    pila.push(nk2);
                    
                    break;
                default:
                    node nd = new node(character, Types.HOJA, numHoja.getNum(), null, null, leaves, table);
                    pila.push(nd); //Contruir el arbol
                    leave hoja = new leave();
                    hoja.addLeave(nd, leaves); //Tabla de siguientes o transiciones
                    break;
            }
        });
        this.root = (node) pila.pop();
    }
    
    public node getRoot(){
        return this.root;
    }
    public String label = "";
    public String genafnd(node root){
        String label2 = "";
        
    
        AFND(root);
     label2 = "digraph G {\n"
                + "rankdir=\"LR\"\n";
         
        label2 +=label;
        label2+="}";
        
        return label2;
        
    }
    public  int id= 0;
    
    public  String AFND(node root) {
  
        label = "";
        if (root == null) {
            return label;
        }
     
        switch (root.type.name()) {
            case "HOJA" -> {
                if(root.lexeme == "#"){
                    label += "S" + (id) + " [peripheries = 2];\n";
                }else{
                label += "S" + id;
                id++;
                label += " -> S" + id + "\n";
                String lexem = root.lexeme.replace("\\n", "\"\n\"").replace("\\'", "\"\\'\"").replace("#","\"#\"");
                label += "[label = " + lexem + " ];\n";
                }
            }
            case "AND" -> { // Listo
                label += AFND((node) root.left);
                label += AFND((node) root.right);
            }
            case "OR" -> {
                int auxOr = id;
                label += "S" + auxOr;
                id++;
                label += " -> S" + id + "\n";
                label += "[label = \"e\"];\n";
                label += AFND((node) root.left);
                int auxleft = id;
                label += "S" + auxOr;
                id++;
                label += " -> S" + id + "\n";
                label += "[label = \"e\"];\n";
                label += AFND((node) root.right);
                int auxright = id;
                id++;
                label += "S" + auxleft + " -> S" + id + "\n";
                label += "[label = \"e\"];\n";
                label += "S" + auxright + " -> S" + id + "\n";
                label += "[label = \"e\"];\n";
            }
            case "SUMA" -> {
                int auxPlus = id + 1;
                label += "S" + id;
                id++;
                label += " -> " + "S" + id + "\n";
                label += "[label = \"e\"];\n";
                label += AFND((node) root.left);
                label += "S" + id + " -> " + "S" + auxPlus + "\n";
                label += "[label = \"e\"];\n";
                label += "S" + id;
                id++;
                label += " -> " + "S" + id + "\n";
                label += "[label = \"e\"];\n";
            }
            case "KLEENE" -> {
                int idKleene = id;
                int auxKleene = id + 1;
                label += "S" + id;
                id++;
                label += " -> " + "S" + id + "\n";
                label += "[label = \"e\"];\n";
                label += AFND((node) root.left);
                label += "S" + id + " -> " + "S" + auxKleene + "\n";
                label += "[label = \"e\"];\n";
                label += "S" + id;
                id++;
                label += " -> " + "S" + id + "\n";
                label += "[label = \"e\"];\n";
                label += "S" + idKleene + " -> " + "S" + id + "\n";
                label += "[label = \"e\"];\n";
            }
            case "INTE" -> {
                int auxInterrogation = id;
                label += "S" + id;
                id++;
                label += " -> " + "S" + id + "\n";
                label += "[label = \"e\"];\n";
                label += AFND((node) root.left);
                label += "S" + id;
                id++;
                label += " -> " + "S" + id + "\n";
                label += "[label = \"e\"];\n";
                label += "S" + auxInterrogation + " -> " + "S" + id + "\n";
                label += "[label = \"e\"];\n";
            }
            default -> {
            }
        }
        return label;
    }
    
    public void printafnd(String cadena, String nombre){
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
            FileOutputStream fos = new FileOutputStream("D:\\Desktop\\[OLC1]PROYECTO1-202000424\\main\\AFND_202000424\\"+"AFND_"+nombre+".png");
            fos.write(imageData);
            fos.close();

            System.out.println("Imagen AFD generada correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void printArbol(String Cadena,String Nombre){
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
            writer.write(Cadena);
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
            FileOutputStream fos = new FileOutputStream("D:\\Desktop\\[OLC1]PROYECTO1-202000424\\main\\ARBOLES_202000424\\"+"arbol_"+Nombre+".png");
            fos.write(imageData);
            fos.close();

            System.out.println("Imagen ARBOL generada correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
}