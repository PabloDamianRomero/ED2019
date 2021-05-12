/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Pila;
import utiles.TecladoIn;


/**
 *
 * @author Romero Pablo Damian
 * Legajo: FAI-1652
 * Año: 2019
 */
public class PruebaLista {
    
    public static void main(String[] args){
        Lista l1 = new Lista();
        Lista l2 = new Lista();
        Lista l3 = new Lista();
        int op, buscado,cont;
        

        cargarLista(l1);
        cargarLista(l2);
        mostrarOriginales(l1,l2);

        
        
        do{
            menu();
            op = TecladoIn.readLineInt();
            switch(op){
                case 0:
                    l1.vaciar();
                    l2.vaciar();
                    cargarLista(l1);
                    cargarLista(l2);
                    mostrarOriginales(l1,l2);
                    break;
                case 1:
                    Lista concatenar = concatenar(l1.clone(),l2.clone());
                    mostrarOriginales(l1,l2);
                    System.out.println("Lista concatenar: "+concatenar.toString());
                    break;
                case 2:
                    l3.insertar(9, 1);
                    l3.insertar(6, 2);
                    l3.insertar(5, 3);
                    l3.insertar(0, 4);
                    l3.insertar(9, 5);
                    l3.insertar(6, 6);
                    l3.insertar(5, 7);
                    l3.insertar(0, 8);
                    l3.insertar(5, 9);
                    l3.insertar(6, 10);
                    l3.insertar(9, 11);
                    System.out.println("L3: "+l3.toString());
                    boolean exito = comprobar(l3.clone());
                    mostrarOriginal(l3);
                    if(exito){
                        System.out.println("Cumple con la condicion");
                    }else{
                        System.out.println("No cumple");
                    }
                    break;
                case 3:
                    Lista inv = invertir(l1.clone());
                    mostrarOriginal(l1);
                    System.out.println("Lista invertida: "+inv);
                    break;
                case 4:
                    Lista inter = intercalar(l1.clone(),l2.clone());
                    mostrarOriginales(l1, l2);
                    System.out.println("Intercalar: " + inter.toString());
                    break;
                case 5:
                    System.out.println("Ingrese elemento a buscar");
                    buscado = TecladoIn.readLineInt();
                    cont = contar(l1.clone(), buscado);
                    mostrarOriginal(l1);
                    System.out.println("Cantidad de veces que aparece "+buscado+" en la lista: "+cont);
                    break;
                case 6:
                    System.out.println("Ingrese elemento a buscar");
                    buscado = TecladoIn.readLineInt();
                    int i = 1, c = 0;
                    cont = 0;
                    cont = contarRecursivo(l1.clone(), buscado, i, c);
                    mostrarOriginal(l1);
                    System.out.println("Cantidad de veces que aparece "+buscado+" en la lista: "+cont);
                    break;
                case 7:
                    l3.insertar(3, 1);
                    l3.insertar(2, 2);
                    l3.insertar(5, 3);
                    l3.insertar(2, 4);
                    l3.insertar(3, 5);
                    l3.insertar(9, 6);
                    mostrarOriginal(l3);
                    l3.vaciar();
                    exito = esCapicua(l3.clone());
                    if(exito){
                        System.out.println("Es capicua");
                    }else{
                        System.out.println("No es capicua");
                    }
                    break;
            }
        }while(op>-1 && op<7);

        
    }

    private static void menu() {
        System.out.println("----------------");
        System.out.println("0. Reiniciar listas");
        System.out.println("1. Concatenar");
        System.out.println("2. Comprobar");
        System.out.println("3. Invertir");
        System.out.println("4. Intercalar");
        System.out.println("5. Contar");
        System.out.println("6. Contar (Recursivo)");
        System.out.println("7. Es capicua");
        System.out.println("----------------");
    }

    private static void cargarLista(Lista l) {
        // cargar valores aleatorias hasta tam
        int tam = (int)(Math.random() * 5)+1;
        for(int i = 1; i <= tam; i++){
            int valor = (int)(Math.random()*9) + 1;
            l.insertar(valor, i);
        }
    }

    private static Lista concatenar(Lista x, Lista y) {
        Lista res = new Lista();
        // condicion: ninguna de las listas originales vacias
        if(!x.esVacia() && !y.esVacia()){
            // calculo el tamaño que tendrá res
            int total = x.longitud() + y.longitud();
            //System.out.println("Total: "+total);
            // variables para posicion
            int i = 1, j = 1;
            while(i <= total){
                // recupero los datos de x, luego los de y
                if(x.recuperar(i) != null){
                    res.insertar(x.recuperar(i), i);
                    i++;
                }else{
                    res.insertar(y.recuperar(j), i);
                    i++;
                    j++;
                }
            }
        }
        return res;
    }
    
    private static boolean comprobar(Lista l) {
        boolean res = true;
        int pos = 1;
        int cont = 1;
        int i = 1;
        Cola c = new Cola();
        Pila p = new Pila();
        
        while(l.recuperar(pos) != null){
            if((int)l.recuperar(pos) == 0){
                cont++;
                l.eliminar(pos);
            }else{
            
            }
            pos++;
        }
        
        pos = 1;
        while(pos <= cont){
            c.poner(l.recuperar(i));
            p.apilar(l.recuperar(i));
            l.eliminar(i);
            pos++;
        }
        
        pos = 1;
        while((pos <= cont) && (res==true)){
            if(l.recuperar(i).equals(c.obtenerFrente())){
                c.sacar();
                l.eliminar(i);
            }else{
                res = false;
            }
            pos++;
        }
        
        pos = 1;
        while(pos <= cont && res==true){
            if(l.recuperar(i).equals(p.obtenerTope())){
                p.desapilar();
                l.eliminar(i);
                res = true;
            }else{
                res = false;
            }
            pos++;
        }
        
        System.out.println("l: "+l.toString());
        
        System.out.println("Cont: "+cont);
        System.out.println("c: "+c.toString());
        System.out.println("p: "+p.toString());
        return res;
    }



    /*// Opcion 1 (Invertir)
    private static Lista invertir(Lista x) {
        Lista inv = new Lista();
        Pila aux = new Pila();
        if(!x.esVacia()){
            int i = 1, j = 1, tam = x.longitud();
            while(i <= tam){
                aux.apilar(x.recuperar(i));
                i++;
            }
            while(j <= tam){
                inv.insertar(aux.obtenerTope(), j);
                aux.desapilar();
                j++;
            }
        }
        return inv;
    }*/
    
    // Opcion 2 (Invertir)
    private static Lista invertir(Lista x) {
        Lista inv = new Lista();
        if(!x.esVacia()){
            int i = 1, tam = x.longitud();
            // recupero los elementos de x, e inserto siempre en pos 1 de la lista nueva
            // (al hacer pos siempre 1, inserta los elementos por delante)
            while(i <= tam){
                inv.insertar(x.recuperar(i), 1);
                i++;
            }
        }
        return inv;
    }
    
        private static void mostrarOriginales(Lista l1, Lista l2) {
        System.out.println("------------------------------------------------");
        System.out.println("Lista 1: "+l1.toString());
        System.out.println("Lista 2: "+l2.toString());
        System.out.println("------------------------------------------------");
    }

    private static void mostrarOriginal(Lista l1) {
        System.out.println("------------------------------------------------");
        System.out.println("Lista 1: "+l1.toString());
        System.out.println("------------------------------------------------");
    }

    private static Lista intercalar(Lista l1, Lista l2) {
        Lista l3 = new Lista();
        int tam = l1.longitud() + l2.longitud();
        int i = 1, j=1;
        while(j <= tam){
            if(!l1.esVacia()){
                l3.insertar(l1.recuperar(i), j);
                l1.eliminar(i);
                j++;
            }
            if(!l2.esVacia()){
                l3.insertar(l2.recuperar(i), j);
                l2.eliminar(i);
                j++;
            }
        }
        return l3;
    }

    
    public static int contar(Lista l, int x){
        int i = 1;
        int cont = 0;
        while(l.recuperar(i) != null){
            if((int)l.recuperar(i)== x){
                cont++;
                i++;
            }else{
                i++;
            }
        }
        return cont;
    }
    
    public static int contarRecursivo(Lista l, int x, int i, int cont){
        if(l.recuperar(i) != null){
            if(l.recuperar(i).equals(x)){
                cont = 1 + contarRecursivo(l, x, i+1, cont);
            }else{
                cont = 0 + contarRecursivo(l, x, i+1, cont);
            }
        }else{
            cont = 0;
        }
        return cont;
    }
    

    
    /*
    private static int contar(Lista l, int x) {
        int cont = 0;
        int i = 1;
        while(!l.esVacia()){
            if((int)l.recuperar(i)==x){
                cont++;
            }
            l.eliminar(i);
        }
        return cont;
    }
*/

    private static boolean esCapicua(Lista l) {
        boolean seguir = true;
        int ult = l.longitud();
        int medio = l.longitud()/2;
        int i = 1;
        
        while(i<=medio && seguir){
            if(l.recuperar(i)==l.recuperar(ult)){
                i++;
                ult--;
            }else{
                seguir = false;
            }
        }
        return seguir;
    }
}
