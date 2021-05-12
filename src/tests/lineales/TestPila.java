/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

//import lineales.estaticas.Pila;
import lineales.dinamicas.Pila;
import utiles.TecladoIn;

/**
 *
 * @author Romero Pablo Damian
 * Legajo: FAI-1652
 * Año: 2019
 */
public class TestPila {
    
    public static void main(String[] args){
        Pila p = new Pila();
        Pila clon = new Pila();
        int op, entero, tope;
        
        
        do{
            menu();
            op = TecladoIn.readLineInt();
            switch(op){
                case 1:
                    System.out.println("Ingrese entero");
                    entero = TecladoIn.readLineInt();
                    if(p.apilar(entero)){
                        System.out.println("Entero apilado");
                    }else{
                        System.out.println("No se pudo apilar");
                    }
                    break;
                case 2:
                    if(p.desapilar()){
                        System.out.println("Elemento desapilado");
                    }else{
                        System.out.println("No se pudo desapilar");
                    }
                    break;
                case 3:
                    if(p.obtenerTope() != null){
                        tope = (int) p.obtenerTope();
                        System.out.println("Tope: "+tope);
                    }else{
                        System.out.println("Tope nulo (inexistente)");
                    }
                    break;
                case 4:
                    if(p.esVacia()){
                        System.out.println("Pila vacia");
                    }else{
                        System.out.println("La pila no esta vacia");
                    }
                    break;
                case 5:
                    p.vaciar();
                    System.out.println("Pila vaciada");
                    break;
                case 6:
                    System.out.println("Pila: " + p.toString());
                    break;
                case 7:
                    System.out.println("Clon: " + clon.toString());
                    break;
                case 8:
                    clon = p.clone();
                    System.out.println("Pila clonada");
                    break;
                case 9:
                    if(!p.esVacia()){
                        if(capicua(p.clone())){
                            System.out.println("Es capicua");
                        }else{
                            System.out.println("No es capicua");
                        }
                    }else{
                        System.out.println("Pila original vacia. Error");
                    }
                    break;
            }
        }while(op > 0 && op < 10);
        
        
    }

    // x = clon de pila original. Condición: no vacia
    private static boolean capicua(Pila x) {
        // Utilizo una nueva pila (inversa) para apilar al reves los datos
        Pila inversa = new Pila();
        // Utilizo clon de x en aux para comparar topes al final
        Pila aux = x.clone();
        boolean exito = true;
        // apilo en inversa los elementos del tope de x
        while(!x.esVacia()){
            inversa.apilar(x.obtenerTope());
            x.desapilar();
        }
        // comparo los elementos del tope de ambas pilas (aux e inversa)
        while(!aux.esVacia() && exito){
            if(aux.obtenerTope() == inversa.obtenerTope()){
                //exito = true; // puede no ir
                aux.desapilar();
                inversa.desapilar();
            }else{
                exito = false;
            }
        }
        return exito;
    }
    
    
        private static void menu() {
        System.out.println("---------------------");
        System.out.println("Ingrese opción");
        System.out.println("---------------------");
        System.out.println("1 - Apilar");
        System.out.println("2 - Desapilar");
        System.out.println("3 - Obtener tope");
        System.out.println("4 - Consultar vacia");
        System.out.println("5 - Vaciar");
        System.out.println("6 - Mostrar");
        System.out.println("7 - Mostrar clon");
        System.out.println("8 - Clonar");
        System.out.println("9 - Verificar capicua");
        System.out.println("Otro número - Salir");
        System.out.println("---------------------");
    }
    
}
