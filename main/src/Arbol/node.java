/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;

import java.util.ArrayList;
import Arbol.type.Types;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.Format;
/**
 *
 * @author Jonatan Garcia
 */
public class node {
    ArrayList<Integer> first;
    ArrayList<Integer> last;
    boolean anullable;
    
    String lexeme;
    Types type;
    int number;
    
    boolean accept;
    
    Object left;
    Object right;
    
    ArrayList<node> leaves;
    ArrayList<ArrayList> table;
    
    public node(String lexeme, Types type, int number, Object left, Object right, ArrayList<node> leaves, ArrayList<ArrayList> table) {
        first = new ArrayList();
        last = new ArrayList();
        anullable = true;
        
        this.lexeme = lexeme;
        this.type = type;
        this.number = number;
        
        accept = "#".equals(this.lexeme);
        
        this.left = left;
        this.right = right;
        
        this.leaves = leaves;
        this.table = table;
    }
    
    public node getNode(){
        
        Object leftNode =  this.left instanceof node ? ((node) this.left).getNode(): null;
        Object rightNode = this.right instanceof node ? ((node) this.right).getNode(): null;
        
        if(null != this.type)switch (this.type) {
            case HOJA:
                this.anullable = false;
                this.first.add(this.number);
                this.last.add(this.number);
                break;
            case AND:
                if(leftNode instanceof node && rightNode instanceof node){
                    this.anullable = ((node)leftNode).anullable && ((node) rightNode).anullable;
                    
                    this.first.addAll(((node)leftNode).first);
                    if(((node)leftNode).anullable){
                        this.first.addAll(((node)rightNode).first);
                    }
                    
                    if(((node)rightNode).anullable){
                        this.last.addAll(((node)leftNode).last);
                    }
                    this.last.addAll(((node)rightNode).last);
                }   
                break;
            case OR:
                if(leftNode instanceof node && rightNode instanceof node){
                    this.anullable = ((node)leftNode).anullable || ((node) rightNode).anullable;
                    
                    this.first.addAll(((node)leftNode).first);
                    this.first.addAll(((node)rightNode).first);
                    
                    
                    this.last.addAll(((node)leftNode).last);
                    this.last.addAll(((node)rightNode).last);
                }  
                break;
            case KLEENE:
                if(leftNode instanceof node){
                    this.anullable = true;
                    this.first.addAll(((node)leftNode).first);
                    this.last.addAll(((node)leftNode).last);
                }
                break;
            case SUMA:
                if(leftNode instanceof node){
                    this.anullable = false;
                    this.first.addAll(((node)leftNode).first);
                    this.last.addAll(((node)leftNode).last);
                }
                break;
             case INTE:
                if(leftNode instanceof node){
                    this.anullable = true;
                    this.first.addAll(((node)leftNode).first);
                    this.last.addAll(((node)leftNode).last);
                }
                break;
            default:
                break;
        }
        return this;
    }
    
    public Object follow(){
        Object leftFollow=  this.left instanceof node ? ((node) this.left).follow() : null;
        Object rightFollow =  this.right instanceof node ? ((node) this.right).follow() : null;
        
        if(null != this.type)switch (this.type) {
            case AND:
                for (int item : ((node)leftFollow).last) {
                    leave hoja = new leave();
                    node nodo = hoja.getLeave(item, leaves);
                    followTable tabla = new followTable();
                    tabla.append(nodo.number, nodo.lexeme, ((node) rightFollow).first, table);
                }
                break;
            case KLEENE,SUMA:
                for (int item : ((node)leftFollow).last) {
                    leave hoja = new leave();
                    node nodo = hoja.getLeave(item, leaves);
                    followTable tabla = new followTable();
                    tabla.append(nodo.number, nodo.lexeme, ((node) leftFollow).first, table);
                }
                break;
            default:
                break;
        }
        
        return this;
    }
    
  public String toGraphviz(String Identificador) {
    StringBuilder sb = new StringBuilder();
    sb.append("digraph G {\n");
    sb.append("\tnode [shape=circle];\n");

    int[] nodeId = {0}; // Usaremos un array para poder modificar la variable desde la función recursiva

   buildGraphvizTree(this, nodeId, sb);

    sb.append("}\n");
    return sb.toString();
}



private void buildGraphvizTree(node node, int[] identifier, StringBuilder graphviz) {
        String idNode = "node" + identifier[0]; // a identifier for the node
        String T;
        String x = node.lexeme.toString();
         if (x == "\\\'"){
            T = "\\\'";
        }else if(x == "\\n"){
            T = "\\n";
        }else if (x == "\\\""){
            T = "\\\"";
        }
          T= x.replaceAll("\"", "");
       
        //graphviz += idNode    + " [label=\"" + node.lexeme + "\"];\n"; // add the node to the graphviz string
        graphviz.append(idNode).append(" [label=\"").append(T).append("\n"+"Anulable: "+node.anullable).append("\n"+"First"+node.first).append("\n"+"Last"+node.last).append("\"];\n");

        Object leftNode =  node.left instanceof node ? ((node) node.left).getNodeVoid(): null;
        Object rightNode = node.right instanceof node ? ((node) node.right).getNodeVoid(): null;

        if (leftNode != null) {
            String idLeftNode = "node" + (identifier[0] + 1); // a identifier for the left node
            //graphviz += idNode + " -> " + idLeftNode + ";\n"; // add the edge to the graphviz string
            graphviz.append(idNode).append(" -> ").append(idLeftNode).append(";\n");
            identifier[0]++; // increment the identifier
            buildGraphvizTree((node) leftNode, identifier, graphviz); // recursive call
        }

        if (rightNode != null) {
            String idRightNode = "node" + (identifier[0] + 1); // a identifier for the right node
            //graphviz += idNode + " -> " + idRightNode + ";\n"; // add the edge to the graphviz string
            graphviz.append(idNode).append(" -> ").append(idRightNode).append(";\n");
            identifier[0]++; // increment the identifier
            buildGraphvizTree((node) rightNode, identifier, graphviz); // recursive call
        }
        identifier[0]++; // increment the identifier

    }

public node getNodeVoid(){
        // This is a recursive method, go the deepest node and evaluate until the root
        return this;
    }



}

