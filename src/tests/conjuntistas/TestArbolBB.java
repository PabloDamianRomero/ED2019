/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.conjuntistas;

import conjuntistas.ArbolBB;
import lineales.dinamicas.Lista;

/**
 *
 * @author pabloromero
 */
public class TestArbolBB {

    public static void main(String[] args) {
        ArbolBB abb = new ArbolBB();

        abb.insertar(10);
//        abb.insertar(4);
        abb.insertar(14);
//        abb.insertar(3);
//        abb.insertar(2);
//        abb.insertar(7);
        abb.insertar(13);
//        abb.insertar(8);
        abb.insertar(100);

        System.out.println(abb.toString());
//        listar(abb);
//        raiz(abb);
//        elementoMinyMax(abb);
//        pertenece(9, abb);
//        rango(13, 200, abb); // (min,max,arbol)
//        listarMenores(8, abb);
//        listarMayoresIgual(10, abb);
//        eliminarMinimo(abb);
        eliminar(10, abb);
//        clonar(abb);
//        clonarDesdeElemEnFormaInvertida(4, abb);

    }

    private static void listar(ArbolBB abb) {
        System.out.println("----------------------------------------------");
        Lista l = new Lista();
        l = abb.listar();
        System.out.println("In-Orden: " + l.toString());
        l = abb.listarMayorAMenor();
        System.out.println("In-Orden inverso: " + l.toString());
        System.out.println("----------------------------------------------");
    }

    private static void elementoMinyMax(ArbolBB abb) {
        System.out.println("\t");
        Comparable r = abb.minimoElem();
        System.out.println("Minimo: " + r);
        r = abb.maximoElem();
        System.out.println("Maximo: " + r);
    }

    private static void pertenece(Comparable x, ArbolBB abb) {
        System.out.println("\t");
        boolean p = abb.pertence(x);
        System.out.println("Pertenece (" + x + "): " + p);
    }

    private static void eliminar(Comparable x, ArbolBB abb) {
        System.out.println("\n");
        boolean p = abb.eliminar(x);
        System.out.println("Eliminar (" + x + "): " + p);
        System.out.println(abb.toString());
    }

    private static void raiz(ArbolBB abb) {
        System.out.println("\t");
        Object t = abb.recuperarCima();
        System.out.println("Raiz del árbol: " + t);
    }

    private static void clonar(ArbolBB abb) {
        System.out.println("\n");
        ArbolBB clon = abb.clone();
        System.out.println("Clon (Normal desde raiz)");
        System.out.println(clon.toString());
    }

    private static void rango(Comparable min, Comparable max, ArbolBB abb) {
        System.out.println("\t");
        Lista rango = abb.listarRango(min, max);
        System.out.println("Rango " + "(" + min + ", " + max + "): " + rango.toString());
    }

    private static void clonarDesdeElemEnFormaInvertida(Comparable x, ArbolBB abb) {
        System.out.println("\n");
        ArbolBB clonInv = new ArbolBB();
        clonInv = abb.clonarParteInvertida(x);
        System.out.println("Clon (Invertido desde elemento " + x + ")");
        System.out.println(clonInv.toString());
    }

    private static void listarMenores(Comparable x, ArbolBB abb) {
        System.out.println("\t");
        Lista menor = new Lista();
        menor = abb.listarMenores(x);
        System.out.println("Menores a " + x + ": " + menor.toString());
    }

    private static void listarMayoresIgual(Comparable x, ArbolBB abb) {
        System.out.println("\t");
        Lista mayorIgual = new Lista();
        mayorIgual = abb.listarMayoresEIgual(x);
        System.out.println("Mayores e igual a " + x + ": " + mayorIgual.toString());
    }

    private static void eliminarMinimo(ArbolBB abb) {
        System.out.println(abb.toString());
        boolean r = abb.eliminarMin();
        System.out.println("Eliminar min: "+r);
        System.out.println(abb.toString());
    }

}
