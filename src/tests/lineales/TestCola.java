/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

import lineales.estaticas.Cola;
//import lineales.dinamicas.Cola;
import utiles.TecladoIn;


/**
 *
 * @author Romero Pablo Damian
 * Legajo: FAI-1652
 * Año: 2019
 */
public class TestCola {
    public static void main(String[] args){
        Cola c = new Cola();
        Cola colaClon = new Cola();
        int opcion, elemento;
        Object frente;
        
        System.out.println("----- Test Cola ----");
        
        do{
            separador();
            menu();
            opcion = TecladoIn.readLineInt();
            System.out.println();
            separador();
            switch (opcion){
                case 1:
                    System.out.print("Ingresa elemento: ");
                    elemento = TecladoIn.readLineInt();
                    if(c.poner(elemento)){
                        System.out.println("Elemento puesto");
                    }else{
                        System.out.println("No se pudo poner el elemento");
                    }
                    break;
                case 2:
                    if(c.sacar()){
                        System.out.println("Elemento sacado");
                    }else{
                        System.out.println("No se pudo sacar el elemento");
                    }
                    break;
                case 3:
                    System.out.println("Cola: "+c.toString());
                    break;
                case 4:
                    c.vaciar();
                    System.out.println("Cola vaciada");
                    break;
                case 5:
                    if(c.esVacia()){
                        System.out.println("Cola vacia");
                    }else{
                        System.out.println("No esta vacia");
                    }
                    break;
                case 6:
                        colaClon = c.clone();
                        System.out.println("La cola ha sido clonada con éxito");
                    break;
                case 7:
                    System.out.println("Cola clon: "+colaClon.toString());
                    break;
                case 8:
                    frente = c.obtenerFrente();
                    if(frente != null){
                        System.out.println("Frente de cola: "+frente);
                    }else{
                        System.out.println("No existe un frente");
                    }
                break;
            }
            System.out.println();
        } while (opcion>0 && opcion <9);	
    }
	
	public static void menu(){
		System.out.println("Elija opcion");
		System.out.println("1. Poner");
		System.out.println("2. Sacar");
		System.out.println("3. Mostrar Cola");
		System.out.println("4. Vaciar");
		System.out.println("5. Es vacia?");
		System.out.println("6. Clonar");
		System.out.println("7. Mostrar Clon");
                System.out.println("8. Obtener frente");
		System.out.println("0. Salir");
		System.out.print("Opcion: ");
	}

    private static void separador(){
        System.out.println("---------------------------------------------------");
    }
    
}
