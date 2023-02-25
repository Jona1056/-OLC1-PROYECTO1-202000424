/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Jonatan Garcia
 */
public class Principal {
        public static void main(String[] args) throws IOException, Exception {
        String ruta1 = "D:/Desktop/[OLC1]PROYECTO1-202000424/main/src/codigo/Lexer.flex";
        String ruta2 = "D:/Desktop/[OLC1]PROYECTO1-202000424/main/src/codigo/LexerCup.flex";
        String[] rutaS = {"-parser","Sintax","D:/Desktop/[OLC1]PROYECTO1-202000424/main/src/codigo/Sintax.cup"};
        generarLexer(ruta1,ruta2,rutaS);
    }
        public static void generarLexer(String ruta1, String ruta2, String [] rutaS) throws IOException, Exception{
           File archivo;
            archivo = new File(ruta1);
           JFlex.Main.generate(archivo);
           archivo = new File(ruta2);
           JFlex.Main.generate(archivo);
           java_cup.Main.main(rutaS);
           
           Path rutaSym = Paths.get("D:/Desktop/[OLC1]PROYECTO1-202000424/main/src/codigo/sym.java");
           if(Files.exists(rutaSym)){
               Files.delete(rutaSym);
           }
           
           Files.move(
                   Paths.get("D:/Desktop/[OLC1]PROYECTO1-202000424/main/sym.java"),
                   Paths.get("D:/Desktop/[OLC1]PROYECTO1-202000424/main/src/codigo/sym.java")
                   );
           
           
            Path rutaSin = Paths.get("D:/Desktop/[OLC1]PROYECTO1-202000424/main/src/codigo/Sintax.java");
           if(Files.exists(rutaSin)){
               Files.delete(rutaSin);
           }
            Files.move(
                   Paths.get("D:/Desktop/[OLC1]PROYECTO1-202000424/main/Sintax.java"),
                   Paths.get("D:/Desktop/[OLC1]PROYECTO1-202000424/main/src/codigo/Sintax.java")
                   );
        }
}
