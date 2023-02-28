/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 *
 * @author Jonatan Garcia
 */
public class transitionTable {

    public ArrayList<ArrayList> states;
    public int cont;
    
    public transitionTable(node root, ArrayList tabla, ArrayList<node> leaves) {
    this.states = new ArrayList();
    
    ArrayList datos = new ArrayList();
    datos.add("S0");
    datos.add(root.first);
    datos.add(new ArrayList());
    datos.add(false);
    
    this.states.add(datos);
    this.cont = 1;
    
    for(int i = 0; i < states.size(); i++){
        ArrayList state = states.get(i);
        ArrayList<Integer> elementos = (ArrayList) state.get(1);
        
        Map<String, ArrayList<Integer>> transiciones = new HashMap<>();
        boolean esAceptacion = false;
        
        for(int hoja : elementos){
            followTable sigTabla = new followTable();
            ArrayList lexemeNext = (ArrayList) sigTabla.next(hoja, tabla).clone();
            
            if(lexemeNext.get(0) == ""){
                continue;
            }
            
            ArrayList<Integer> sigEstados = transiciones.get(lexemeNext.get(0));
            if(sigEstados == null){
                sigEstados = new ArrayList<>();
                transiciones.put((String)lexemeNext.get(0), sigEstados);
            }
            sigEstados.addAll((ArrayList<Integer>)lexemeNext.get(1));
            
            leave hojas = new leave();
            if(hojas.isAccept(hoja, leaves)){
                   state.set(3, true);
            }
        }
        
        
        for(Map.Entry<String, ArrayList<Integer>> entrada : transiciones.entrySet()){
            ArrayList<Integer> sigEstados = entrada.getValue();
            
            String nombreEstadoSiguiente = null;
            for(ArrayList estado : states){
                if(estado.get(1).equals(sigEstados)){
                    nombreEstadoSiguiente = (String)estado.get(0);
                    break;
                }
            }
            
            
            if(nombreEstadoSiguiente == null){
                nombreEstadoSiguiente = "S" + cont;
                cont++;
                
                ArrayList nuevo = new ArrayList();
                nuevo.add(nombreEstadoSiguiente);
                nuevo.add(sigEstados);
                nuevo.add(new ArrayList());
                nuevo.add(false);
                
                states.add(nuevo);
            }
            
            transicion trans = new transicion(state.get(0) + "", entrada.getKey(), nombreEstadoSiguiente);
            ((ArrayList)state.get(2)).add(trans);
        }
    }
        updateAcceptStates(states,leaves);
    }
    
    public void updateAcceptStates(ArrayList<ArrayList> states, ArrayList<node> leaves) {
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
    
    public void impTable(){
        for(ArrayList state : states){
            String tran = "[";
            for(Object tr : (ArrayList)state.get(2)){
                transicion t = (transicion) tr;
                tran += t.toString() + ", ";           
            }
            tran += "]";
            tran = tran.replace(", ]", "]");
            System.out.println(state.get(0) + " " + state.get(1) + " " + tran + " " + state.get(3));
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
        }
        
        for(Object tr : (ArrayList)state.get(2)){
            transicion t = (transicion) tr;
            graph += t.graph();
        }
        
        graph += "\"" + label + "\" [label=\"" + label + "\"];\n";
       
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