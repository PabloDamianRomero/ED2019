/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 * TDA Lista dinámica
 *
 * @author Romero Pablo Damian Legajo: FAI-1652 Año: 2019
 */
public class Lista {

    private Nodo cabecera;

    public Lista() {
        this.cabecera = null;
    }

    public boolean insertar(Object elem, int pos) {
        boolean exito = true;
        // inserta el elemento nuevo en la posicion pos
        // detecta y reporta error posicion invalida
        if (pos < 1 || pos > this.longitud() + 1) {
            exito = false;
        } else if (pos == 1) {
            // crea un nuevo nodo y se enlaza en la cabecera
            this.cabecera = new Nodo(elem, this.cabecera);
        } else {
            // avanza hasta el elemento en posicion pos-1
            Nodo aux = this.cabecera;
            int i = 1;
            while (i < pos - 1) {
                aux = aux.getEnlace();
                i++;
            }
            // crea el nodo y lo enlaza
            Nodo nuevo = new Nodo(elem, aux.getEnlace());
            aux.setEnlace(nuevo);
        }
        // nunca hay error de lista llena, devuelve true
        return exito;
    }

    public boolean eliminar(int pos) {
        boolean exito = true;
        // si la lista está vacia o pos incorrecta
        if ((pos < 1) || (pos > this.longitud())) {
            exito = false;
        } else // si se elimina el primer elemento
        if (pos == 1) {
            this.cabecera = this.cabecera.getEnlace();
        } else {
            // se elimina otra posicion, distinta de 1
            Nodo aux = this.cabecera;
            int i = 1;
            while (i < pos - 1) {
                aux = aux.getEnlace();
                i++;
            }
            aux.setEnlace(aux.getEnlace().getEnlace());
        }
        return exito;
    }

    public Object recuperar(int pos) {
        Object res;
        if (pos < 1 || pos > this.longitud()) {
            res = null;
        } else {
            Nodo aux = this.cabecera;
            int i = 1;
            while (i < pos) {
                aux = aux.getEnlace();
                i++;
            }
            res = aux.getElemento();
        }
        return res;
    }

    public int localizar(Object elem) {
        int res = -1, i = 1;
        boolean seguir = true;
        // si lista no esta vacia
        if (this.cabecera != null) {
            Nodo aux = this.cabecera;
            while (aux != null && seguir) {
                if (aux.getElemento() != elem) {
                    i++;
                    aux = aux.getEnlace();
                } else {
                    seguir = false;
                    res = i;
                }
            }
        }
        return res;
    }

    public void vaciar() {
        this.cabecera = null;
    }

    public boolean esVacia() {
        boolean exito = false;
        if (this.cabecera == null) {
            exito = true;
        }
        return exito;
    }

    public int longitud() {
        int res = 0;
        // si lista no esta vacia
        if (this.cabecera != null) {
            Nodo aux = this.cabecera;
            while (aux != null) {
                res++;
                aux = aux.getEnlace();
            }
        }
        return res;
    }

    @Override
    public Lista clone() {
        Lista clon = new Lista();
        // nodo nuevo apunta a tope
        if (this.cabecera != null) {
            Nodo nuevo = this.cabecera; // recorrer original
            clon.cabecera = new Nodo(nuevo.getElemento(), null); // crear primer elem de clon
            Nodo aux = clon.cabecera; // referencia para recorrer clon
            nuevo = nuevo.getEnlace();
            while (nuevo != null) {
                aux.setEnlace(new Nodo(nuevo.getElemento(), null));
                aux = aux.getEnlace();
                nuevo = nuevo.getEnlace();
            }
        }
        return clon;
    }

    @Override
    public String toString() {
        String cadena = "";
        if (this.cabecera == null) {
            cadena = "Lista vacia";
        } else {
            cadena += "[";
            Nodo aux = this.cabecera;
            while (aux != null) {
                cadena += aux.getElemento();
                if (aux.getEnlace() != null) {
                    cadena += ", ";
                }
                if (aux.getEnlace() == null) {
                    cadena += "]";
                }
                aux = aux.getEnlace();
            }
        }
        return cadena;
    }

    public Lista invertir() {
        Lista inv = new Lista();
        // si la lista no está vacia
        if (this.cabecera != null) {
            invertirAux(this.cabecera, inv);
        }
        return inv;
    }

    private Nodo invertirAux(Nodo actual, Lista inv) {
        Nodo tmp = null;
        Nodo sig = actual.getEnlace();
        if (sig == null) {
            tmp = new Nodo(actual.getElemento());
            inv.cabecera = tmp;
        } else {
            tmp = invertirAux(actual.getEnlace(), inv);
            tmp.setEnlace(new Nodo(actual.getElemento()));
            tmp = tmp.getEnlace();
        }
        return tmp;
    }

    public Lista obtenerMultiplos(int num) {
        Lista mult = new Lista();
        int cont = 1;
        if (this.cabecera != null) {
            Nodo aux = this.cabecera;
            Nodo nuevo = null;
            while (aux != null) {
                if (cont % num == 0) {
                    if (mult.cabecera == null) {
                        nuevo = new Nodo(aux.getElemento());
                        mult.cabecera = nuevo;
                    } else {
                        Nodo tmp = new Nodo(aux.getElemento());
                        nuevo.setEnlace(tmp);
                        nuevo = tmp;
                    }
                }
                cont++;
                aux = aux.getEnlace();
            }
        }
        return mult;
    }

    public void eliminarApariciones(Object elem) {
        if (this.cabecera != null) {
            Nodo ant = this.cabecera;
            Nodo sig = this.cabecera.getEnlace();

            while (this.cabecera != null && this.cabecera.getElemento().equals(elem)) {
                this.cabecera = this.cabecera.getEnlace();
                ant = this.cabecera;
                sig = ant.getEnlace();
                if (ant.getElemento().equals(elem) && sig == null) {
                    this.cabecera = null;
                }
            }


            while (sig != null) {
                if (sig.getElemento().equals(elem)) {
                    ant.setEnlace(sig.getEnlace());
                    sig = sig.getEnlace();
                } else {
                    ant = ant.getEnlace();
                    sig = ant.getEnlace();
                }
            }
        }
    }

    /**
     * Eliminar apariciones (1ra versión) - funcionamiento incorrecto 
     * public
     * void eliminarApariciones(Object elem) { if (this.cabecera != null) { Nodo
     * ant = this.cabecera; Nodo sig = this.cabecera.getEnlace(); while (sig !=
     * null) { if (this.cabecera.getElemento().equals(elem)) { this.cabecera =
     * this.cabecera.getEnlace(); ant = this.cabecera; sig = ant.getEnlace(); if
     * (ant.getElemento().equals(elem) && sig == null) { this.cabecera = null; }
     * } else if (sig.getElemento() == elem) { ant.setEnlace(sig.getEnlace());
     * sig = sig.getEnlace(); } else { ant = ant.getEnlace(); sig =
     * ant.getEnlace(); } } } }
     */
    
    
}
