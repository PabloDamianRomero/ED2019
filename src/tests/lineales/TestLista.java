/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

import lineales.dinamicas.Lista;
import utiles.TecladoIn;

/**
 *
 * @author Romero Pablo Damian Legajo: FAI-1652 Año: 2019
 */
public class TestLista {

    public static void main(String[] args) {
        int op, pos, elem;
        Lista l = new Lista();
        Lista clon = new Lista();

        l.insertar(1, 1);
        l.insertar(2, 2);
        l.insertar(1, 3);
        l.insertar(3, 4);
        l.insertar(1, 5);
        l.insertar(4, 6);

//        l.insertar(9, 1);
//        l.insertar(8, 2);
//        l.insertar(7, 3);
//        l.insertar(6, 4);

        //cargarLista(l);
        System.out.println("Lista original: " + l.toString());
        do {
            menu();
            op = TecladoIn.readLineInt();
            switch (op) {
                case 0:
                    l.vaciar();
                    cargarLista(l);
                    System.out.println("Lista: " + l.toString());
                    break;
                case 1:
                    System.out.println("Ingrese elemento");
                    elem = TecladoIn.readLineInt();
                    System.out.println("Ingrese posicion");
                    pos = TecladoIn.readLineInt();
                    if (l.insertar(elem, pos)) {
                        System.out.println("Elemento insertado");
                    } else {
                        System.out.println("Error al insertar");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese posicion a eliminar");
                    pos = TecladoIn.readLineInt();
                    if (l.eliminar(pos)) {
                        System.out.println("Elemento eliminado");
                    } else {
                        System.out.println("No se pudo eliminar");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese posicion a recuperar");
                    pos = TecladoIn.readLineInt();
                    Object res = l.recuperar(pos);
                    if (res != null) {
                        System.out.println("Recuperar: " + res);
                    } else {
                        System.out.println("Error");
                    }
                    break;
                case 4:
                    System.out.println("Ingrese elemento");
                    elem = TecladoIn.readLineInt();
                    int loc = l.localizar(elem);
                    if (loc != -1) {
                        System.out.println("Localizar: " + loc);
                    } else {
                        System.out.println("Error");
                    }
                    break;
                case 5:
                    System.out.println("Longitud: " + l.longitud());
                    break;
                case 6:
                    if (l.esVacia()) {
                        System.out.println("Lista vacia");
                    } else {
                        System.out.println("No vacia");
                    }
                    break;
                case 7:
                    l.vaciar();
                    System.out.println("Lista vaciada");
                    break;
                case 8:
                    clon = l.clone();
                    System.out.println("Lista clonada");
                    break;
                case 9:
                    System.out.println("Lista: " + l.toString());
                    break;
                case 10:
                    System.out.println("Lista clon: " + clon.toString());
                    break;
                case 11:
                    Lista inv = l.invertir();
                    System.out.println("Original: " + l.toString());
                    System.out.println("------");
                    System.out.println("Inv cab: " + inv.recuperar(1));
                    System.out.println("Invertida: " + inv.toString());
                    break;
                case 12:
                    System.out.println("Ingrese elemento aparicion");
                    Object x = TecladoIn.readLineInt();
                    clon = l.clone();
                    clon.eliminarApariciones(x);
                    System.out.println("Original: " + l.toString());
                    System.out.println("Apariciones: " + clon.toString());
                    break;
                case 13:
                    System.out.println("Ingrese multiplo");
                    int multiplo = TecladoIn.readLineInt();
                    System.out.println("Original: " + l.toString());
                    Lista m = l.obtenerMultiplos(multiplo);
                    System.out.println("Mult: " + m.toString());
                    break;
            }
        } while (op > -1 && op < 14);

    }

    private static void menu() {
        System.out.println("----------------------");
        System.out.println("0 - Reiniciar lista");
        System.out.println("1 - Insertar");
        System.out.println("2 - Eliminar");
        System.out.println("3 - Recuperar");
        System.out.println("4 - Localizar");
        System.out.println("5 - Longitud");
        System.out.println("6 - Consultar vacia");
        System.out.println("7 - Vaciar");
        System.out.println("8 - Clonar");
        System.out.println("9 - Mostrar");
        System.out.println("10 - Mostrar clon");
        System.out.println("11 - Invertir");
        System.out.println("12 - Eliminar apariciones");
        System.out.println("13 - Multiplos");
        System.out.println("----------------------");
    }

    private static void cargarLista(Lista l) {
        // cargar valores aleatorias hasta tam
        int tam = (int) (Math.random() * 15) + 1;
        for (int i = 1; i <= tam; i++) {
            int valor = (int) (Math.random() * 9) + 1;
            l.insertar(valor, i);
        }
    }

}
