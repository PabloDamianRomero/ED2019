/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Pila;

/**
 *
 * @author Athena
 */
public class MixLineales2 {

    public static void main(String[] args) {
        Lista l = new Lista();
        Lista mix = new Lista();
        l.insertar('A', 1);
        l.insertar('B', 2);
        l.insertar('*', 3);
        l.insertar('C', 4);
        l.insertar('*', 5);
        l.insertar('D', 6);
        l.insertar('E', 7);
        l.insertar('F', 8);
        //l.insertar('*', 9);

        mix = generarLista(l.clone());
        System.out.println("Original: " + l.toString());
        System.out.println("Mix: " + mix.toString());

    }

    private static Lista generarLista(Lista l) {
        // codigo piola
        Lista l2 = new Lista();
        Pila p = new Pila();
        Cola c = new Cola();
        int i = 1, j = 1;
        int t = l.longitud() + 1;
        int e = 1;
        while (e <= t) {
            Object comp = l.recuperar(i);
            //System.out.println("e: "+e+ " t: "+t+" comp: "+comp);
            if (comp != null) {
                if ((char) comp != '*') {
                    p.apilar(comp);
                    c.poner(comp);
                    l2.insertar(comp, j);
                    j++;
                    System.out.println("Pila: " + p.toString());
                    System.out.println("Cola: " + p.toString());
                    l.eliminar(i);
                }
                //    System.out.println("t:"+t +" e: "+e);
                if ((char) comp == '*' || e == t - 1) {
                    //System.out.println("dfgd"+e);
                    while (!p.esVacia()) {
                        l2.insertar(p.obtenerTope(), j);
                        p.desapilar();
                        j++;
                    }
                    while (!c.esVacia()) {
                        l2.insertar(c.obtenerFrente(), j);
                        c.sacar();
                        j++;
                    }
                    if (e != t - 1) {
                        l2.insertar('*', j);
                        j++;
                        l.eliminar(i);
                    }
                }
            }
            //-----------------------------
            e++;
        }
        return l2;
    }

    /*
    private static Lista generarLista(Lista l) {
    // codigo no tan peola
        Lista l2 = new Lista();
        Pila p = new Pila();
        Cola c = new Cola();
        int i = 1, j = 1;
        
        while(!l.esVacia()){
            if((char)l.recuperar(i)!= '*'){
                
                p.apilar(l.recuperar(i));
                c.poner(l.recuperar(i));
                l2.insertar(l.recuperar(i), j);
                j++;
                System.out.println("Pila: "+p.toString());
                System.out.println("Cola: "+p.toString());
                l.eliminar(i);
            }else{
                while(!p.esVacia()){
                    l2.insertar(p.obtenerTope(), j);
                    p.desapilar();
                    j++;
                }
                while(!c.esVacia()){
                    l2.insertar(c.obtenerFrente(), j);
                    c.sacar();
                    j++;
                }
                if(l.recuperar(i)!=null){
                    l2.insertar('*', j);
                    j++;
                    l.eliminar(i);
                }
            }
            //-----------------------------
            if(l.recuperar(i)==null){
                while(!p.esVacia()){
                    l2.insertar(p.obtenerTope(), j);
                    p.desapilar();
                    j++;
                }
                while(!c.esVacia()){
                    l2.insertar(c.obtenerFrente(), j);
                    c.sacar();
                    j++;
                }
            }
        }
        return l2;
    }
     */
}
