/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;

/*
import lineales.estaticas.Cola;
import lineales.estaticas.Pila;
*/
/**
 *
 * @author Romero Pablo Damian
 * Legajo: FAI-1652
 * Año: 2019
 */
public class MixLineales {
    
    public static void main(String[] args){
        Cola c = new Cola();
        Cola clon = new Cola();
        Cola mix = new Cola();
        
        c.poner('A');
        c.poner('B');
        c.poner('$');
        c.poner('C');
        c.poner('$');
        c.poner('D');
        c.poner('E');
        c.poner('F');

        System.out.println("Original: "+c.toString());
        System.out.println("-------------------------");
        clon = c.clone();
        mix = generarOtraCola(clon);
        System.out.println("Mix: "+mix.toString());
    }
    
    
    public static Cola generarOtraCola(Cola c){
        // res será la cola que se retorna
        // inv es la pila auxiliar para invertir
        Cola res = new Cola();
        Pila inv = new Pila();
        // mientras la cola original tenga datos
        while(!c.esVacia()){
            // copio elementos en res e inv hasta encontrar el signo peso
            if((c.obtenerFrente().equals('$'))){
                res.poner(inv.obtenerTope());
                inv.desapilar();
                if(inv.esVacia()){
                    res.poner(c.obtenerFrente());
                    c.sacar();
                }
            }else{
                inv.apilar(c.obtenerFrente());
                res.poner(c.obtenerFrente());
                c.sacar();
            }
        }
        // al quedarme la cola original vacia, me queda copiar los elementos
        // que me quedaron en la pila inv (no tengo un sigo peso como bandera)
        while(!inv.esVacia()){
            res.poner(inv.obtenerTope());
            inv.desapilar();
        }
        return res;
    }
    
}
