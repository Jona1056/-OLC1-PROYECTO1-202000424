/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

import static codigo.Errores.L_errores;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Jonatan Garcia
 */
public class ErrorHTML {
    static String Errores;
     public static void main() {
        try {
            PrintWriter writer = new PrintWriter("D:\\Desktop\\[OLC1]PROYECTO1-202000424\\main\\ERRORES_202000424\\ERRORES.html", "UTF-8");
            writer.println("<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"	<title>ERRORES GENERADOS Carnet: 202000424</title>\n" +
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
"	</style>\n" +
"</head>\n" +
"<body>\n" +
"	<div class=\"container\">\n" +
"		<h1>ERRORES GENERADOS Carnet: 202000424</h1>\n" +
"		<table>\n" +
"			<thead>\n" +
"				<tr>\n" +
                                       "<th>No</th>\n" +
"					<th>Lexema</th>\n" +
"					<th>Fila</th>\n" +
"					<th>Columna</th>\n" +
"					<th>Tipo</th>\n" +
"					<th>Descripcion</th>\n" +
                    
"				</tr>\n" +
"			</thead>\n" +
                        Errores +
"		</table>\n" +
"	</div>\n" +
"</body>\n" +
"</html>");
         
            writer.close();
            System.out.println("El archivo archivo.html ha sido creado correctamente.");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al crear el archivo archivo.html: " + e.getMessage());
        }
    }
     
     
     public static void Apertura() {
        // Ruta del archivo PDF
        String rutaArchivo = "D:\\Desktop\\[OLC1]PROYECTO1-202000424\\main\\ERRORES_202000424\\ERRORES.html";

        // Verificar si Desktop es compatible con la plataforma actual
        if (!Desktop.isDesktopSupported()) {
            System.out.println("Desktop no está soportado en la plataforma actual");
            return;
        }

        // Obtener instancia de Desktop
        Desktop desktop = Desktop.getDesktop();

        // Verificar si el archivo existe
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            System.out.println("El archivo " + rutaArchivo + " no existe");
            return;
        }

        // Abrir el archivo con la aplicación predeterminada del sistema
        try {
            desktop.open(archivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     public static void Imprimir_errores(){
         //recorrer erroes y agregarlos a una variable
           Errores += "<tbody>\n" ;
           
           int x = 1;
           for (Errores er : L_errores){
               Errores +="<tr>\n "+
"					<td>"+x+"</td>\n" +
"					<td>"+er.lexema+"</td>\n" +
"					<td>"+er.fila+"</td>\n" +
"					<td>"+er.columna+"</td>\n" +
"					<td>"+er.Tipo+"</td>\n" +
"					<td>"+er.descripcion+"</td>\n" +
"				</tr>\n" +
"				<tr>\n" ;
           
                       
              x++;
        
         
     }
              Errores += "<t/body>\n" ;
     
}
}