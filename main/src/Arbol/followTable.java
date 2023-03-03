/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;

/**
 *
 * @author Jonatan Garcia
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class followTable {
    public void append(int numNode, String lexeme, ArrayList flwList, ArrayList<ArrayList> table){
        for (ArrayList item : table){
            if( (int) item.get(0) == numNode && item.get(1) == lexeme ){
                for (Object flwItem : flwList){
                    if(! ((ArrayList)item.get(2)).contains((int)flwItem) ){
                       ((ArrayList)item.get(2)).add(flwItem);
                    }
                }
                return;
            }
        }
        ArrayList dato = new ArrayList();
        dato.add(numNode);
        dato.add(lexeme);
        dato.add(flwList);
        
        table.add(dato);
    }
    
    public ArrayList next(int numNode, ArrayList<ArrayList> table){
        ArrayList result = new ArrayList();
        for(ArrayList item : table){
            if( (int) item.get(0) == numNode ){
                result.add(item.get(1));
                result.add(((ArrayList)item.get(2)).clone());
                return result;
            }
        }
        result.add("");
        result.add(new ArrayList());
    return result;
    }
    
    public void printTable(ArrayList<ArrayList> table){
        for(ArrayList item : table){
            System.out.println(item.get(0) + " - " + item.get(1) + " - " + item.get(2) );
        }
    }
    
    public void printHtmlTable(ArrayList<ArrayList> table, String identificador){
        String siguiente = "";
        siguiente += "<tbody>\n" ;
        siguiente += "<div class=container>"+
"		 <h1>TABLA DE SIGUIENTESCarnet: 202000424</h1>"+
"		 <table>"+
 "               <tr>" +
 "               <td colspan=2>HOJA</td>"+
 "               <td colspan=2>SIGUIENTES</td>";
              for (int i = 0; i < table.size(); i++) {
        ArrayList item = table.get(i);
        
        siguiente += "<tr>\n" +
                     "    <td>" + item.get(1) + "</td>\n" +
                     "    <td>" + item.get(0) + "</td>\n" +
                     "    <td>" + item.get(2) + "</td>\n" +
                     "</tr>\n";
        
        if (i == table.size() - 1) {
            // Estás en el último elemento, agrega otros datos a "siguiente"
            siguiente += "<tr>\n" +
                         "    <td>#</td>\n" +
                         "    <td>"+item.get(2).toString()+"</td>\n" +
                         "    <td>--</td>\n" +
                         "</tr>\n";
        }
    }
 
    
    
    
     try {
            PrintWriter writer = new PrintWriter("D:\\Desktop\\[OLC1]PROYECTO1-202000424\\main\\SIGUIENTES_202000424\\"+"SIGUIENTES_"+identificador+".html", "UTF-8");
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
siguiente+
"        </table>\n" +
"	</div>\n" 
 + "<t/body>\n"+  
          "</html>"      );
         
            writer.close();
            System.out.println("El archivo archivo.html ha sido creado correctamente.");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al crear el archivo archivo.html: " + e.getMessage());
        }
                }}