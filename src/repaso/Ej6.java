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
public class Ej6 {
    
    public static void main(String[] args){
        int enteros[];
        int cant, largo;
        double res = 0;
        
        System.out.println("Ingrese cantidad de elementos del arreglo");
        cant = TecladoIn.readLineInt();
        enteros = new int [cant];
        largo = enteros.length;
        
        cargarArreglo(enteros, largo);
        System.out.println("Arreglo: "+mostrarArreglo(enteros));
        
        
        res = calcularProm(enteros, largo);
        System.out.println("Prom: "+res/largo);
        
        
    }

    private static String mostrarArreglo(int [] x) {
        String cad="[ ";
        int largo= x.length;
        for(int i=0; i<largo; i++){
            cad = cad + x[i]+" ";
        }
        cad = cad + " ]";
        return cad;
    }

    // Arreglo: 10, 5, 3, 7, 11, 1
    
    private static int calcularProm(int[] e, int largo) {
        int suma = 0;
        //Caso 1: Solo existe un elem en el arreglo
        if(largo==1){
            suma = suma + e[largo-1];
        }else{
            // Caso 2: Hay más de un elemento en el arreglo
            if(largo>1){
                suma = e[largo-1]+ calcularProm(e,largo-1);
            }
        }
        return suma;
    }

    private static void cargarArreglo(int[] e, int l) {
        int valor;
        for(int i=0; i<l; i++){
            System.out.println("Ingrese valor");
            valor = TecladoIn.readLineInt();
            e[i] = valor;
        }
    }
}
