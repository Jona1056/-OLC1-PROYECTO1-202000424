/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package codigo;
import Arbol.CreateJson;
import static Arbol.CreateJson.result;
import Arbol.main;
import java.awt.Color;
import java.awt.List;
import codigo.ErrorHTML;
import static codigo.resultados.Expresiones1;
import static codigo.resultados.ORA;
import com.google.gson.JsonArray;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jonatan Garcia
 */
public class Jframe extends javax.swing.JFrame {
    static File archivo;

    /**
     * Creates new form Jframe
     */
    public Jframe() {
        initComponents();
         this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(147, 177, 224));
        
     
    }
    
    private void analizarLexico() throws IOException{
        
        int cont = 1;
        String expr = (String) Area1.getText();
       
        codigo.Sintax pars;
        try {
            pars=new codigo.Sintax(new codigo.Lexer(new StringReader(expr)));
            pars.parse();        
            
        } catch (Exception ex) {
            System.out.println("Error fatal en compilación de entrada.");
            System.out.println("Causa: "+ex.getCause());
        } 
       
      
        }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_archivo = new javax.swing.JPanel();
        B_abrir = new javax.swing.JButton();
        B_guardar = new javax.swing.JButton();
        B_Gcomo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Area1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Siguientes = new javax.swing.JButton();
        Transiciones = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(147, 177, 224));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.darkGray);

        Panel_archivo.setBackground(new java.awt.Color(186, 208, 242));
        Panel_archivo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Archivo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        B_abrir.setText("Abrir");
        B_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_abrirActionPerformed(evt);
            }
        });

        B_guardar.setText("Guardar");
        B_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_guardarActionPerformed(evt);
            }
        });

        B_Gcomo.setText("Guardar como");
        B_Gcomo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_GcomoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_archivoLayout = new javax.swing.GroupLayout(Panel_archivo);
        Panel_archivo.setLayout(Panel_archivoLayout);
        Panel_archivoLayout.setHorizontalGroup(
            Panel_archivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_archivoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(Panel_archivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(B_Gcomo, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                    .addComponent(B_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(B_abrir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        Panel_archivoLayout.setVerticalGroup(
            Panel_archivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_archivoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(B_abrir, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(B_guardar)
                .addGap(12, 12, 12)
                .addComponent(B_Gcomo)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        Area1.setColumns(20);
        Area1.setRows(5);
        Area1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Archivo Cargado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        jScrollPane1.setViewportView(Area1);

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        txtResultado.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Consola", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        jScrollPane2.setViewportView(txtResultado);

        jButton1.setText("Generar Automata");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Analizar Entrada");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Arboles");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Siguientes.setText("Siguientes");
        Siguientes.setAlignmentY(0.6F);
        Siguientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguientesActionPerformed(evt);
            }
        });

        Transiciones.setText("Transiciones");
        Transiciones.setRolloverEnabled(true);
        Transiciones.setSelected(true);
        Transiciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransicionesActionPerformed(evt);
            }
        });

        jButton6.setText("AFD");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton4.setText("Errores");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Resultados");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setText("AFND");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(Panel_archivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(jButton1)
                                .addGap(28, 28, 28)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Siguientes, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Transiciones, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Panel_archivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Siguientes, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Transiciones, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   public static String nombrearchivo1;
    private void B_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_abrirActionPerformed
     JFileChooser chooser = new JFileChooser();
     chooser.showOpenDialog(null);
     archivo = new File(chooser.getSelectedFile().getAbsolutePath());
      
     
     try{
         nombrearchivo1 = "";
         nombrearchivo1 = archivo.getName();
         String ST = new String(Files.readAllBytes(archivo.toPath()));
         Area1.setText(ST);
     }  catch(FileNotFoundException ex){
         Logger.getLogger(Jframe.class.getName()).log(Level.SEVERE,null,ex);
     }
     
     catch (IOException ex) {
            Logger.getLogger(Jframe.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
    }//GEN-LAST:event_B_abrirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CreateJson je = new CreateJson();
        
        CreateJson.result= new String();
        CreateJson.result = "";
          CreateJson.array = new JsonArray();
        if(resultados.Expresiones1.isEmpty() || resultados.ORA.isEmpty()){
               JOptionPane.showMessageDialog(null, "ANALIZE EL ARCHIVO", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }else{
                 for(Oraciones ora: ORA){
                     for(expresiones1 exp: Expresiones1){
                     
                         if(ora.name.equals(exp.name)){
                             main.Datos(exp.cadena, ora.name,ora.cadena);
            
                         }else{
                           
                         }
            }
            }
        }
         CreateJson.agregar();
              
           txtResultado.setText(CreateJson.result);
            CreateJson.result = "";
                CreateJson.result= new String();
                 CreateJson.array = null;
              System.out.println(CreateJson.result);
              System.out.println(CreateJson.array);
              resultados.Expresiones1.clear();
              resultados.ORA.clear();
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          CreateJson.result= new String();
        String ST = Area1.getText();
        Sintax s = new Sintax(new codigo.Lexer(new StringReader(ST)));
        resultados.Conjun.clear();
        Errores.L_errores.clear();
        ErrorHTML.Errores = "";
        try {
            s.parse();
            
        
               txtResultado.setText("analisis realizado");
        } catch (Exception ex) {
             txtResultado.setText("error");
            Logger.getLogger(Jframe.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(Errores.L_errores.isEmpty()){
            System.out.println("No hay Errores en esta archivo");
        }
        else{
              ErrorHTML.Imprimir_errores();
              ErrorHTML.main();
              ErrorHTML.Apertura();
        }
     
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
              try {
                Desktop.getDesktop().open(new File("D:\\Desktop\\[OLC1]PROYECTO1-202000424\\main\\ARBOLES_202000424"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void SiguientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguientesActionPerformed
             try {
                Desktop.getDesktop().open(new File("D:\\Desktop\\[OLC1]PROYECTO1-202000424\\main\\SIGUIENTES_202000424"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }  // TODO add your handling code here:
    }//GEN-LAST:event_SiguientesActionPerformed

    private void TransicionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransicionesActionPerformed
         try {
                Desktop.getDesktop().open(new File("D:\\Desktop\\[OLC1]PROYECTO1-202000424\\main\\TRANSICIONES_202000424"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }  // TODO add your handling code here:
    }//GEN-LAST:event_TransicionesActionPerformed

    private void B_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_guardarActionPerformed
        //mandar datos del archivo
     
        try {
            String datos =Area1.getText();
            FileWriter archivo2 = new FileWriter(archivo);
            archivo2.write(datos);
            archivo2.close();
            System.out.println("Los datos se han sobrescrito con éxito en el archivo.");
              JOptionPane.showMessageDialog(null, "EL ARCHIVO HA SIDO GUARDADO", "GUARDADO", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
              JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR ARCHIVO", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Ha ocurrido un error al intentar sobrescribir los datos en el archivo.");
            e.printStackTrace();
        }
    }//GEN-LAST:event_B_guardarActionPerformed

    private void B_GcomoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_GcomoActionPerformed
       JFileChooser fileChooser = new JFileChooser();

    // Crea un filtro de archivo para limitar los tipos de archivos que se pueden seleccionar
    FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (*.OLC)", "OLC");
    fileChooser.setFileFilter(filtro);

    // Muestra el cuadro de diálogo para guardar archivo
    int resultado = fileChooser.showSaveDialog(null);

    if (resultado == JFileChooser.APPROVE_OPTION) {
      // Obtiene el archivo seleccionado
      File archivo = fileChooser.getSelectedFile();

      try {
        // Agrega la extensión al nombre del archivo seleccionado
        String nombreArchivo = archivo.getName();
        if (!nombreArchivo.endsWith(".OLC")) {
          archivo = new File(archivo.getParentFile(), nombreArchivo + ".OLC");
        }

        // Crea un nuevo archivo con el nombre y la ubicación seleccionados por el usuario
        archivo.createNewFile();
   
        // Crea un objeto BufferedWriter para escribir en el archivo
        BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));

        // Escribe datos en el archivo
        String res = Area1.getText();
        writer.write(res);

        // Cierra el objeto BufferedWriter
        writer.close();

        JOptionPane.showMessageDialog(null, "El archivo se ha creado y guardado correctamente.");
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Se produjo un error al crear o guardar el archivo.");
      }
    } else if (resultado == JFileChooser.CANCEL_OPTION) {
      JOptionPane.showMessageDialog(null, "La operación ha sido cancelada.");
    }
  
    }//GEN-LAST:event_B_GcomoActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       try {
                Desktop.getDesktop().open(new File("D:\\Desktop\\[OLC1]PROYECTO1-202000424\\main\\AFD_202000424"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
                Desktop.getDesktop().open(new File("D:\\Desktop\\[OLC1]PROYECTO1-202000424\\main\\ERRORES_202000424"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
           try {
                Desktop.getDesktop().open(new File("D:\\Desktop\\[OLC1]PROYECTO1-202000424\\main\\AFND_202000424"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       try {
                Desktop.getDesktop().open(new File("D:\\Desktop\\[OLC1]PROYECTO1-202000424\\main\\SALIDAS_202000424"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Area1;
    private javax.swing.JButton B_Gcomo;
    private javax.swing.JButton B_abrir;
    private javax.swing.JButton B_guardar;
    private javax.swing.JPanel Panel_archivo;
    private javax.swing.JButton Siguientes;
    private javax.swing.JButton Transiciones;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
