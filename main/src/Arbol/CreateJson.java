/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;
import static codigo.Jframe.nombrearchivo1;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
/**
 *
 * @author Jonatan Garcia
 */
public class CreateJson {
     public static  JsonArray array = new JsonArray();
    public  static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static  String result= new String();
     
      public static void main(String name,String cadena, boolean x) {
           System.out.println(cadena);
        // crear un objeto JSON
        
         JsonObject obj1 = new JsonObject();
         String cade = cadena.replace("\"", "");
         cade = cade.replace("\\'","\'");
        obj1.addProperty("valor", cade);
        obj1.addProperty("expresion Regular", name);
        if (x == true){
              obj1.addProperty("resultado", "Cadena Valida");
              result+="La expresion: " + cadena + ", es valida con la expresion regular " + name+ "\n";
        }else{
               obj1.addProperty("resultado", "Cadena Invalida");
                result+="La expresion: " + cadena + ",no es valida con la expresion regular " + name +  "\n";
        }
     

   

        // crear un arreglo JSON
     
        array.add(obj1);

         
        // escribir el contenido en un archivo JSON
      
    }
      public  static void agregar(){

          
          Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .disableHtmlEscaping()
        .create();



try (FileWriter writer = new FileWriter("D:\\Desktop\\[OLC1]PROYECTO1-202000424\\main\\SALIDAS_202000424\\"+nombrearchivo1 +".json")) {
    gson.toJson(array, writer);
} catch (IOException e) {
    e.printStackTrace();
}
   
      }

      
      
}
