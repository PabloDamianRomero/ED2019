/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.jerarquicas;

import jerarquicas.ArbolGen;
import lineales.dinamicas.Lista;

/**
 *
 * @author pabloromero
 */
public class TestArbolGen {

    public static void main(String[] args) {
        ArbolGen ag = new ArbolGen();

//        ag.insertar(1, 1);
//        ag.insertar(4, 1);
//        ag.insertar(3, 1);
//        ag.insertar(2, 1);
//        ag.insertar(6, 2);
//        ag.insertar(5, 2);
//        ag.insertar(9, 4);
//        ag.insertar(8, 4);
//        ag.insertar(7, 4);
//        ag.insertar(10, 9);
//        ag.insertar(20, 10);
//        ag.insertar(21, 10);
//        ag.insertar(22, 10);
//        ag.insertar(23, 10);
//        ag.insertar(24, 10);
//        ag.insertar(30, 21);
//        ag.insertar(31, 21);
//        ag.insertar(32, 31);
//        ag.insertar(40, 31);
        usarArbolSimulacro(ag);

//        listar(ag);
//        clonar(ag);
        mostrarArbolGen(ag);
//        preOrden(ag);
//        inOrden(ag);
//        posOrden(ag);
//        nivelOrden(ag);
//        perteneceELem(9, ag);
        alturaArbolGen(ag);
//        nivelElemArbol(17, ag);
//        padreDelElem(31, ag);
//        ancestrosDelElem(10, ag);
//        fronteraArbolGen(ag);
//        verificarCaminoGen(ag);
//        listaEntreNiveles(0, 1, ag);
//        listaHastaNivel(2, ag);
//        verificarCaminoHastaHoja(ag);
//        eliminarElem(27, ag);

    }

    private static void listar(ArbolGen a) {
        System.out.println("\t");
        System.out.println("------------------------------------------");
        Lista l = new Lista();
        l = a.listarPreOrden();
        System.out.println("Pre-Orden: " + l.toString());
        l = a.listarPosOrden();
        System.out.println("Pos-Orden: " + l.toString());
        l = a.listarInOrden();
        System.out.println("In-Orden: " + l.toString());
        l = a.listarPorNivel();
        System.out.println("Por nivel: " + l.toString());
        System.out.println("------------------------------------------");
        System.out.println("\t");
    }

    private static void clonar(ArbolGen ag) {
        ArbolGen cl = new ArbolGen();
        cl = ag.clone();
        System.out.println("Clon: " + cl.clone());
        System.out.println("\t");
        ag.insertar(50, 3);
        System.out.println("ori: " + ag.toString());
        System.out.println("-----------------");
        System.out.println("Clon: " + cl.clone());
    }

    private static void usarArbolSimulacro(ArbolGen ag) {
        ag.insertar(20, 10);
        ag.insertar(54, 20);
        ag.insertar(13, 20);
        ag.insertar(12, 13);
        ag.insertar(15, 13);
        ag.insertar(4, 54);
        ag.insertar(27, 54);
        ag.insertar(11, 54);
        ag.insertar(17, 27);
    }

    private static void perteneceELem(Object i, ArbolGen ag) {
        System.out.println("\t");
        System.out.println("Pertenece: " + ag.pertenece(i));
    }

    private static void alturaArbolGen(ArbolGen ag) {
        System.out.println("\t");
        int alt = ag.altura();
        System.out.println("Altura: " + alt);
    }

    private static void nivelElemArbol(Object i, ArbolGen ag) {
        System.out.println("\t");
        int niv = ag.nivel(i);
        System.out.println("Nivel("+i+"): " + niv);
    }

    private static void padreDelElem(Object i, ArbolGen ag) {
        System.out.println("\t");
        Object padre = ag.padre(i);
        System.out.println("Padre de " + i + ": " + padre);
    }

    private static void ancestrosDelElem(int i, ArbolGen ag) {
        System.out.println("\t");
        Lista anc = ag.ancestros(i);
        System.out.println("Ancestros: " + anc.toString());
    }

    private static void fronteraArbolGen(ArbolGen ag) {
        System.out.println("\t");
        Lista front = ag.frontera();
        System.out.println("Frontera: " + front.toString());
    }

    private static void verificarCaminoGen(ArbolGen ag) {
        System.out.println("\t");
        Lista camino = new Lista();
        camino.insertar(20, 1);
        camino.insertar(54, 2);
        camino.insertar(27, 3);
//        camino.insertar(45, 4);
        boolean c = ag.verificarCamino(camino);
        System.out.println("Camino: " + camino.toString());
        System.out.println("Existe el camino? " + c);
    }

    private static void mostrarArbolGen(ArbolGen ag) {
        System.out.println(ag.toString());
    }

    private static void inOrden(ArbolGen ag) {
        System.out.println("\t");
        Lista inO = ag.listarInOrden();
        System.out.println("In-Orden: " + inO.toString());
    }

    private static void preOrden(ArbolGen ag) {
        System.out.println("\t");
        Lista preO = ag.listarPreOrden();
        System.out.println("Pre-Orden: " + preO.toString());
    }

    private static void posOrden(ArbolGen ag) {
        System.out.println("\t");
        Lista posO = ag.listarPosOrden();
        System.out.println("Pos-Orden: " + posO.toString());
    }

    private static void nivelOrden(ArbolGen ag) {
        System.out.println("\t");
        Lista nivO = ag.listarPorNivel();
        System.out.println("Por nivel: " + nivO.toString());
    }

    private static void listaEntreNiveles(int x, int y, ArbolGen ag) {
        System.out.println("\t");
        int menor, mayor;
        if (x < y) {
            menor = x;
            mayor = y;
        } else {
            menor = y;
            mayor = x;
        }
        Lista entreNiv = ag.listarEntreNiveles(menor, mayor);
        System.out.println("Elem entre Niv(" + menor + ", " + mayor + "): " + entreNiv.toString());
    }

    private static void listaHastaNivel(int i, ArbolGen ag) {
        System.out.println("\t");
        Lista hastaNiv = ag.listarHastaNivel(i);
        System.out.println("Elem hasta Niv(" + i + "): " + hastaNiv.toString());
    }

    private static void verificarCaminoHastaHoja(ArbolGen ag) {
        System.out.println("\t");
        Lista cam = new Lista();
        cam.insertar(20, 1);
        cam.insertar(54, 2);
        cam.insertar(27, 3);
        cam.insertar(17, 4);
        boolean r = ag.verificarCaminoHastaHoja(cam);
        System.out.println("Camino: " + cam.toString());
        System.out.println("Existe el camino (y último es hoja)?: " + r);
    }

    private static void eliminarElem(Object elem, ArbolGen ag) {
        System.out.println("\t");
        boolean r = ag.eliminar(elem);
        System.out.println("Eliminar: "+r);
        mostrarArbolGen(ag);
    }

}
