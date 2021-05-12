/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.conjuntistas;

import conjuntistas.ArbolHeap;

/**
 *
 * @author pabloromero
 */
public class TestArbolHeap {

    public static void main(String[] args) {
        ArbolHeap ah = new ArbolHeap();
        ArbolHeap clon = new ArbolHeap();
        ah.insertar(10);
        ah.insertar(12);
        ah.insertar(15);
        ah.insertar(21);
        ah.insertar(45);
        ah.insertar(19);
        ah.insertar(20);
        System.out.println("Árbol heap: " + ah.toString());
        boolean r = ah.esVacio();
        System.out.println("Vacio?: " + r);
        
//        ah.vaciar();
//        System.out.println("Árbol heap: " + ah.toString());
//        r = ah.esVacio();
//        System.out.println("Vacio?: " + r);
        
        //ah.eliminarCima();
        clon = ah.clone();
        System.out.println("Árbol heap: " + ah.toString());
        System.out.println("Clon: " + clon.toString());
    }

}
