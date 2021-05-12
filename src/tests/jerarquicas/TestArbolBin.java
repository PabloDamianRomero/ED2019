/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.jerarquicas;

import jerarquicas.ArbolBin;
import lineales.dinamicas.Lista;
import utiles.TecladoIn;

/**
 * Test Árbol Binario
 *
 * @author Romero Pablo Damian Legajo: FAI-1652 Año: 2019
 */
public class TestArbolBin {

    public static void main(String[] args) {
        ArbolBin a = new ArbolBin();
        Lista l = new Lista();
        /*
        a.insertar(9, 5, 'D');
        a.insertar(45, 9, 'I');
        a.insertar(23, 9, 'D');
        a.insertar(36, 23, 'I');
        a.insertar(99, 23, 'D');
         */

        //-------------------------------------    
        a.insertar(1, 5, 'D');
        a.insertar(9, 1, 'I');
        a.insertar(7, 2, 'I');
        a.insertar(2, 1, 'D');
        a.insertar(8, 2, 'I');
        a.insertar(7, 2, 'D');
        a.insertar(5, 8, 'D');
        //a.insertar(6, 5, 'D');

        //-------------------------------------    
//        a.insertar("A", 5, 'D');
//        a.insertar("B", "A", 'I');
//        a.insertar("C", "A", 'D');
//        a.insertar("D", "B", 'I');
//        a.insertar("E", "C", 'I');
//        a.insertar("F", "C", 'D');
//        a.insertar("G", "E", 'I');
//        a.insertar("H", "E", 'D');
//
//        //-------------------------------------    
//        l = a.porNivel();
//        System.out.println("Por nivel: " + l.toString());
//
//        Object buscado = "F";
//        Object res = a.padre(buscado);
//        System.out.println("Padre de " + buscado + ": " + res);
//
//        l = a.preOrden();
//        System.out.println("Pre-orden: " + l.toString());
//        l.vaciar();
//        l = a.inOrden();
//        System.out.println("In-orden: " + l.toString());
//        l.vaciar();
//        l = a.posOrden();
//        System.out.println("Pos-orden: " + l.toString());
//          */
//                 ArbolBin clon = a.clone();
//        System.out.println("Original");
//        System.out.println(a.toString());
//        System.out.println("Clon");
//        System.out.println();
//        System.out.println(clon.toString());
//        System.out.println("-------------------");
//        clon = a.cloneInvertido();
//        System.out.println();
//        System.out.println(clon.toString());


//        Lista f = new Lista();
//        f = a.frontera();
//        System.out.println("Frontera: "+f.toString());
//        l = a.listarPorNiveles();
//        System.out.println("Nivel: "+l.toString());

        Lista patron = new Lista();
        patron.insertar(1, 1);
        patron.insertar(2, 2);
        patron.insertar(8, 3);
        patron.insertar(5, 4);
        boolean p = a.verificarPatron(patron);
        System.out.println(a.toString());
        System.out.println("Patron: "+p);
        
    }
}
