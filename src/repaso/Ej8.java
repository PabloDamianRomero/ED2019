/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repaso;
import utiles.TecladoIn;

/**
 *
 * @author Romero Pablo Damian
 * Estructuras de datos 2019
 * Ejercicio repaso
 */
public class Ej8 {
    
    public static void main(String[] args){
        int b,n,ant=0;
        
        System.out.println("Ingrese n");
        n = TecladoIn.readLineInt();
        System.out.println("Ingrese b");
        b = TecladoIn.readLineInt();
        
        explotar(n, b, ant);
        
    }
 
    private static void explotar(int n, int b, int ant) {
        
        // Caso base: si el divisor es menor que el dividendo
        if(b<n){
            // con ant, mantengo el valor anterior de n (antes de que sea menor a b)
            ant = n;
            explotar(n/b, b, ant);
            explotar(ant-(ant/b),b,ant);
        }else{
            System.out.println("n: "+n);
        }
    }
}
