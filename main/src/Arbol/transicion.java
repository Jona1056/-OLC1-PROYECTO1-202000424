/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;

/**
 *
 * @author Jonatan Garcia
 */
public class transicion {
     public String initialState;
    public String transition;
    public String finalState;
    
    public transicion( String initialState, String transition, String finalState ) {
        this.initialState = initialState;
        this.transition = transition;
        this.finalState = finalState;
    }
    
    public boolean compare(String initialState, String transition){
        
        return this.initialState.equals(initialState) && this.transition.equals(transition);
    }
    
    @Override
    public String toString(){
         
    
        return this.initialState + " -> " + this.transition + " -> " + this.finalState;
    }
    
    public String graph(){
          String x;
               x = this.transition.replaceAll("\"", "");
         if(x.equals("\\\'")){
             x= "\\\\\'";
         }else if(x.equals("\\n")){
             x= "\\\\n";
         }else if(x.equals("\\")){
                x= "\\\\\\\"";
         }
        
     
  
          System.out.println(x);
        return this.initialState +  "->"  + this.finalState + "[label=\"" + x + "\"]";
    }

    void setNext(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
