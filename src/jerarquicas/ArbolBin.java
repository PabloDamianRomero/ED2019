/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;

/**
 * TDA Árbol Binario dinámico
 *
 * @author Romero Pablo Damian Legajo: FAI-1652 Año: 2019
 */
public class ArbolBin {

    private NodoArbol raiz;

    private NodoArbol obtenerNodo(NodoArbol n, Object buscado) {
        // metodo privado que busca un elemento y devuelve el nodo
        NodoArbol res = null;
        if (n != null) {
            if (n.getElem() == buscado) {
                // si el buscado es n, lo devuelve
                res = n;
            } else {
                // no es el buscado; busca primero en el HI
                res = obtenerNodo(n.getIzquierdo(), buscado);
                // si no lo encuentra en el HI, busca en HD
                if (res == null) {
                    res = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return res;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar) {
        boolean exito = true;
        if (this.raiz == null) {
            // si el arbol esta vacio, ponemos el elemNuevo en la raiz
            this.raiz = new NodoArbol(elemNuevo);
        } else {
            // si no esta vacio, se busca el padre
            NodoArbol nodoPadre = obtenerNodo(this.raiz, elemPadre);
            if (nodoPadre != null) {
                if (lugar == 'I' && nodoPadre.getIzquierdo() == null) {
                    // si el padre existe y no tiene HI se lo agrega
                    nodoPadre.setIzquierdo(new NodoArbol(elemNuevo));
                } else if (lugar == 'D' && nodoPadre.getDerecho() == null) {
                    // si el padre existe y no tiene HD se lo agrega
                    nodoPadre.setDerecho(new NodoArbol(elemNuevo));
                } else {
                    // si el padre no existe o ya tiene ese hijo, da error
                    exito = false;
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    public int altura() {
        int alt = 0;
        alt = retornarAltura(this.raiz);
        return alt;
    }

    private int retornarAltura(NodoArbol n) {
        int resultado = -1, hi, hd;
        if (n != null) {
            hi = retornarAltura(n.getIzquierdo());
            hd = retornarAltura(n.getDerecho());
            if (hi > hd) {
                resultado = hi + 1;
            } else {
                resultado = hd + 1;
            }
        }
        return resultado;
    }

    public int nivel(Object elem) {
        int resp = 0;
        resp = nivelAux(raiz, elem, 0);
        return resp;
    }

    private int nivelAux(NodoArbol n, Object elem, int nivel) {
        int cont = -1;
        if (n != null) {
            if (n.getElem().equals(elem)) {
                cont = 0;
            } else {
                cont = nivelAux(n.getIzquierdo(), elem, nivel++);
                if (cont >= 0) {
                    cont = cont + 1;
                } else {
                    cont = nivelAux(n.getDerecho(), elem, nivel++);
                    if (cont >= 0) {
                        cont = cont + 1;
                    }
                }
            }
        }
        return cont;
    }

    public Object padre(Object elem) {
        Object p = null;
        if (this.raiz != null) {
            p = padreAux(this.raiz, elem, false, p);
        }
        return p;
    }

    private Object padreAux(NodoArbol n, Object elem, boolean seguir, Object res) {
        // caso raiz
        if (n != null && !seguir) {
            if (n.getIzquierdo() != null && n.getIzquierdo().getElem().equals(elem)) {
                res = n.getElem();
                seguir = true;
            } else if (!seguir) {
                res = padreAux(n.getIzquierdo(), elem, false, res);
            }
            if (n.getDerecho() != null && n.getDerecho().getElem().equals(elem)) {
                res = n.getElem();
                seguir = true;
            } else if (!seguir) {
                res = padreAux(n.getDerecho(), elem, false, res);
            }
        }
        return res;
    }

    public Lista listarPreOrden() {
        Lista listaPreOrden = new Lista();
        // imprime los elementos por consola en preorden
        // invoca un metodo recursivo privado a la clase
        listaPreOrden = preOrdenAux(this.raiz, listaPreOrden, 1);
        return listaPreOrden;
    }

    private Lista preOrdenAux(NodoArbol n, Lista l, int pos) {
        // metodo recursivo es PRIVADO porque su parametro es de tipo NodoArbol
        if (n != null) {
            // visita el nodo (raiz)
            l.insertar(n.getElem(), pos);
            // recorre a sus hijos en preOrden
            preOrdenAux(n.getIzquierdo(), l, l.longitud() + 1); // Pasa al hijo izquierdo
            preOrdenAux(n.getDerecho(), l, l.longitud() + 1); // Pasa al hijo derecho
        }
        return l;
    }

    public Lista listarInOrden() {
        Lista listaInOrden = new Lista();
        // imprime los elementos por consola en inOrden
        // invoca un metodo recursivo privado a la clase
        listaInOrden = inOrdenAux(this.raiz, listaInOrden, 0);
        return listaInOrden;
    }

    private Lista inOrdenAux(NodoArbol n, Lista l, int pos) {
        // metodo recursivo es PRIVADO porque su parametro es de tipo NodoArbol
        // recorre a sus hijos en InOrden
        if (n != null) {
            inOrdenAux(n.getIzquierdo(), l, l.longitud() + 1); // Pasa al hijo izquierdo
            l.insertar(n.getElem(), l.longitud() + 1); // visita el nodo (raiz)
            inOrdenAux(n.getDerecho(), l, l.longitud() + 1); // Pasa al hijo derecho
        }
        return l;
    }

    public Lista listarPosOrden() {
        Lista listaPosOrden = new Lista();
        // imprime los elementos por consola en posOrden
        // invoca un metodo recursivo privado a la clase
        listaPosOrden = posOrdenAux(this.raiz, listaPosOrden, 0);
        return listaPosOrden;
    }

    private Lista posOrdenAux(NodoArbol n, Lista l, int pos) {
        // metodo recursivo es PRIVADO porque su parametro es de tipo NodoArbol
        // recorre a sus hijos en posOrden
        if (n != null) {
            posOrdenAux(n.getIzquierdo(), l, l.longitud() + 1); // Pasa al hijo izquierdo
            posOrdenAux(n.getDerecho(), l, l.longitud() + 1); // Pasa al hijo derecho
            l.insertar(n.getElem(), l.longitud() + 1); // visita el nodo (raiz)
        }
        return l;
    }

    public Lista listarPorNiveles() {
        Lista listaPorNivel = new Lista();
        Cola c = new Cola();
        NodoArbol n = this.raiz;
        if (n != null) {
            c.poner(n);
            while (!c.esVacia()) {
                NodoArbol actual;
                actual = (NodoArbol) c.obtenerFrente();
                c.sacar();
                listaPorNivel.insertar(actual.getElem(), listaPorNivel.longitud() + 1);
                if (actual.getIzquierdo() != null) {
                    c.poner(actual.getIzquierdo());
                }
                if (actual.getDerecho() != null) {
                    c.poner(actual.getDerecho());
                }
            }
        }
        return listaPorNivel;
    }

    public boolean esVacio() {
        boolean exito = false;
        if (this.raiz == null) {
            exito = true;
        }
        return exito;
    }

    public void vaciar() {
        this.raiz = null;
    }

    @Override
    public String toString() {
        String cadena = "";
        if (this.raiz != null) {
            cadena = toStringAux(this.raiz);
        } else {
            cadena = "Arbol Binario vacio";
        }
        return cadena;
    }

    private String toStringAux(NodoArbol n) {
        String c = "";
        if (n != null) {

            c += "Nodo: " + n.getElem() + " ";
            if (n.getIzquierdo() != null) {
                c += ", HI: " + n.getIzquierdo().getElem();
            } else {
                c += ", HI: null ";
            }
            if (n.getDerecho() != null) {
                c += ", HD: " + n.getDerecho().getElem();
            } else {
                c += ", HD: null ";
            }
            c += "\n";
            c += toStringAux(n.getIzquierdo());
            c += toStringAux(n.getDerecho());
        }
        return c;
    }

    /**
     * // Clonar (Manera 1)
     *
     * @Override public ArbolBin clone() { ArbolBin clon = new ArbolBin(); if
     * (this.raiz != null) { NodoArbol primero = new
     * NodoArbol(this.raiz.getElem()); clon.raiz = primero; cloneAux(this.raiz,
     * clon.raiz); } return clon; }
     *
     * private void cloneAux(NodoArbol nodo, NodoArbol nodoClon) { if
     * (nodo.getIzquierdo() != null) { nodoClon.setIzquierdo(new
     * NodoArbol(nodo.getIzquierdo().getElem())); cloneAux(nodo.getIzquierdo(),
     * nodoClon.getIzquierdo()); } if (nodo.getDerecho() != null) {
     * nodoClon.setDerecho(new NodoArbol(nodo.getDerecho().getElem()));
     * cloneAux(nodo.getDerecho(), nodoClon.getDerecho()); } }
     *
     */
    
    @Override
    public ArbolBin clone() {
        ArbolBin clon = new ArbolBin();
        if (this.raiz != null) {
            clon.raiz = clonarAux(this.raiz);
        }
        return clon;
    }

    private NodoArbol clonarAux(NodoArbol n) {
        NodoArbol nuevo = null;
        if (n != null) {
            nuevo = new NodoArbol(n.getElem());
            nuevo.setIzquierdo(clonarAux(n.getIzquierdo()));
            nuevo.setDerecho(clonarAux(n.getDerecho()));
        }
        return nuevo;
    }

    public ArbolBin cloneInvertido() {
        ArbolBin clon = new ArbolBin();
        if (this.raiz != null) {
            clon.raiz = cloneAuxInvertido(this.raiz);
        }
        return clon;
    }

    private NodoArbol cloneAuxInvertido(NodoArbol n) {
        NodoArbol nuevo = null;
        if (n != null) {
            nuevo = new NodoArbol(n.getElem());
            nuevo.setIzquierdo(cloneAuxInvertido(n.getDerecho()));
            nuevo.setDerecho(cloneAuxInvertido(n.getIzquierdo()));
        }
        return nuevo;
    }

    public Lista frontera() {
        Lista frontera = new Lista();
        if (this.raiz != null) {
            frontera = fronteraAux(this.raiz, frontera);
        }
        return frontera;
    }

    private Lista fronteraAux(NodoArbol n, Lista l) {
        if (n != null) {
            l = fronteraAux(n.getIzquierdo(), l);
            l = fronteraAux(n.getDerecho(), l);
            if (n.getIzquierdo() == null && n.getDerecho() == null) {
                int largo = l.longitud() + 1;
                l.insertar(n.getElem(), largo);
            }
        }
        return l;
    }

    public boolean verificarPatron(Lista l) {
        int pos = 1;
        boolean res = false;
        int largo = l.longitud();
        if (this.raiz == null && l.esVacia()) {
            res = true;
        } else if (this.raiz != null && !l.esVacia() && this.raiz.getElem().equals(l.recuperar(pos))) {
            res = verificarPatronAux(this.raiz, l, pos + 1, largo);
        }
        return res;
    }

    private boolean verificarPatronAux(NodoArbol n, Lista l, int pos, int largo) {
        boolean res = false;
        if (pos > largo) {
            // verificar condicion de hoja
            if (n.getDerecho() == null && n.getIzquierdo() == null) {
                res = true;
            }/* else {
                pos--;
            }*/
        } else {
            if (n.getIzquierdo() != null && l.recuperar(pos).equals(n.getIzquierdo().getElem()) /* && !res*/) {
                res = verificarPatronAux(n.getIzquierdo(), l, pos + 1, largo);
            }
            if (n.getDerecho() != null && l.recuperar(pos).equals(n.getDerecho().getElem()) && !res) {
                res = verificarPatronAux(n.getDerecho(), l, pos + 1, largo);
            }
        }
        return res;
    }

}
