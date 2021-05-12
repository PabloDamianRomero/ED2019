/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repaso;
import utiles.TecladoIn;

/**
 *
 * @author Athena
 */
public class Ej4c {
    
    public static void main(String[] args){
        String cadena;

        
        System.out.println("Ingrese cadena");
        cadena = TecladoIn.readLine();
        
        System.out.println("Resultado: "+inversa(cadena));
        
    }
    
    private static String inversa(String cadena) {
        String res="";
        // Caso 1: longitud 1
        if(cadena.length()==1){
            res = cadena;
        }else{
            // Caso 2: Divido la cadena y agrego al final el primer elem
            res = inversa(cadena.substring(1));
            res = res + cadena.charAt(0);
        }
        return res;
    }   
    
}
