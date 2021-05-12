/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 * TDA Pila dinámica
 *
 * @author Romero Pablo Damian Legajo: FAI-1652 Año: 2019
 */
public class Pila {

    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public boolean apilar(Object elem) {
        Nodo nuevo = new Nodo(elem, this.tope);
        this.tope = nuevo;
        return true;
    }

    public boolean desapilar() {
        boolean exito;
        // caso1: Pila vacia
        if (this.tope == null) {
            exito = false;
        } else {
            exito = true;
            this.tope = this.tope.getEnlace();
        }
        return exito;
    }

    public Object obtenerTope() {
        Object res = null;
        // caso: pila vacia
        if (this.tope != null) {
            res = this.tope.getElemento();
        }
        return res;
    }

    public void vaciar() {
        this.tope = null;
    }

    public boolean esVacia() {
        boolean exito;
        if (this.tope == null) {
            exito = true;
        } else {
            exito = false;
        }
        return exito;
    }

    @Override
    public String toString() {
        String cadena = "";
        if (this.tope == null) {
            cadena = "Pila vacia";
        } else {
            // se ubica para recorrer la pila
            Nodo aux = this.tope;
            cadena = "[";
            while (aux != null) {
                // agrega el texo del elem y avanza
                cadena += aux.getElemento().toString();
                aux = aux.getEnlace();
                if (aux != null) {
                    cadena += ", ";
                }
            }
            cadena += "]";
        }
        return cadena;
    }

    /*    
    // Clonar Iterativo
    @Override
    public Pila clone(){
        Pila clon = new Pila();
        // nodo nuevo apunta a tope
        if(this.tope != null){
            Nodo nuevo = this.tope;
            clon.tope = new Nodo(nuevo.getElemento(),null);
            Nodo aux = clon.tope;
            nuevo = nuevo.getEnlace();
            while(nuevo != null){
                aux.setEnlace(new Nodo(nuevo.getElemento(),null));
                aux = aux.getEnlace();
                nuevo = nuevo.getEnlace();
            }
        }
        return clon;
    }
     */
    
    // Clonar Recursivo
    @Override
    public Pila clone() {
        Pila clon = new Pila();
        // nodo nuevo apunta a tope
        Nodo aux = this.tope;
        clonar(aux, clon);
        return clon;
    }

    private void clonar(Nodo aux, Pila clon) {
        if (aux != null) {
            Nodo nuevo = new Nodo(aux.getElemento(), null);
            clonar(aux.getEnlace(), clon);
            nuevo.setEnlace(clon.tope);
            clon.tope = nuevo;
        }
    }

}
