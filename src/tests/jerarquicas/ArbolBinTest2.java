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
 *
 * @author Romero Pablo Damian D.N.I.: 40.068.425 Legajo : FAI-1652 Carrera:
 * Lic. en Sist de Inf Fecha: 13/04/18
 */
public class ArbolBinTest2 {

    public static void main(String[] args) {
        ArbolBin arbol = new ArbolBin();
        ArbolBin clon = new ArbolBin();
        Lista lista = new Lista();
        int opcion, altura;
        Object elemento, padre, buscado;
        char lugar;

        System.out.println("----- Test Arbol Binario Int ----");

        do {
            separador();
            menu();
            opcion = TecladoIn.readLineInt();
            System.out.println();
            separador();
            switch (opcion) {
                case 1:
                    /*
                    arbol.insertar(9, 5, 'D');
                    arbol.insertar(45, 9, 'I');
                    arbol.insertar(23, 9, 'D');
                    arbol.insertar(36, 23, 'I');
                    arbol.insertar(99, 23, 'D');
                     */
                    arbol.insertar(9, 5, 'D');
                    arbol.insertar(1, 9, 'I');
                    arbol.insertar(2, 9, 'D');
                    break;
                case 2:
                    if (arbol.esVacio()) {
                        System.out.println("El arbol binario esta vacio");
                    } else {
                        System.out.println("No esta vacio el arbol binario");
                    }
                    break;

                case 3:

                    altura = arbol.altura();
                    System.out.println("Altura: " + altura);
                    break;

                case 4:
                    System.out.println("Ingrese buscado para nivel");
                    elemento = TecladoIn.readLineInt();
                    System.out.println("Nivel de " + elemento + ": " + arbol.nivel((Object) elemento));
                    break;

                case 5:
                    break;

                case 6:
                    lista = arbol.listarPreOrden();
                    System.out.println("Pre-Orden: " + lista.toString());
                    break;

                case 7:
                    lista = arbol.listarInOrden();
                    System.out.println("In-Orden: " + lista.toString());
                    break;

                case 8:
                    lista = arbol.listarPosOrden();
                    System.out.println("Pos-Orden: " + lista.toString());
                    break;

                case 9:
                    lista = arbol.listarPorNiveles();
                    System.out.println("Por niveles: " + lista.toString());
                    break;

                case 10:
                    clon = arbol.clone();
                    System.out.println("Arbol binario clonado");
                    break;

                case 11:
                    arbol.vaciar();
                    System.out.println("Arbol binario vaciado");
                    break;

                case 12:
                    System.out.println("Arbol: " + arbol.toString());
                    break;

                case 13:
                    if (!clon.esVacio()) {
                        System.out.println("Arbol clon: " + clon.toString());
                    } else {
                        System.out.println("Clon vacio");
                    }
                    break;

            }
            System.out.println();
        } while (opcion != 0);
    }

    public static void menu() {
        System.out.println("Elija opcion");
        System.out.println("1. Insertar"); //hecho
        System.out.println("2. Verificar vacio"); //hecho
        System.out.println("3. Altura del arbol"); // hecho - revisar
        System.out.println("4. Nivel de un elemento en el arbol"); // hecho - revisar
        System.out.println("5. Consultar por padre"); // revisar
        System.out.println("6. Listar Pre-orden"); // hecho
        System.out.println("7. Listar In-orden"); //hecho
        System.out.println("8. Listar Pos-orden"); //hecho
        System.out.println("9. Listar niveles"); //hacer
        System.out.println("10. Clonar"); // hacer
        System.out.println("11. Vaciar"); //hecho
        System.out.println("12. Mostrar original"); //hecho
        System.out.println("13. Mostrar clon"); // medio hecho
        System.out.println("0. Salir");
        System.out.print("Opcion: ");
    }

    private static void separador() {
        System.out.println("---------------------------------------------------");
    }

}
