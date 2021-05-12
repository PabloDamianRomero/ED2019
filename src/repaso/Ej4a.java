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
public class Ej4a {
    
    public static void main(String[] args){
        String cadena;
        char letra;
        int i = 0;
        int largo;
        
        System.out.println("Ingrese cadena");
        cadena = TecladoIn.readLine();
        System.out.println("Ingrese letra");
        letra = TecladoIn.readLineNonwhiteChar();
        
        largo = cadena.length();
        
        if(primerPos(cadena,letra,i,largo)==-1){
            System.out.println("Error");
        }else{
            System.out.println("Letra "+letra+" en pos "+primerPos(cadena,letra,i,largo));
        }
        
        
    }

    private static int primerPos(String cadena, char letra, int i, int largo) {
        int res=0;
        // Primer caso: el iterador no existe dentro del rango de la cadena
        if(i<0 || i>=largo){
            res = -1;
        }else{
            // Segundo caso: se encuentra la letra en la cadena
            if(cadena.charAt(i)==letra){
                res = i;
            }else{
                // Tercer caso; la letra no es encontrada, sigo buscando
                res = primerPos(cadena,letra,i+1,largo);
            }
        }
        return res;
    }
    
}
