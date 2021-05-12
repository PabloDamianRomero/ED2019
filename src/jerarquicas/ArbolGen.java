/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Pila;

/**
 *
 * @author pabloromero
 */
public class ArbolGen {

    private NodoGen raiz;

    public ArbolGen() {
        this.raiz = null;
    }

    private NodoGen obtenerNodo(NodoGen n, Object buscado) {
        NodoGen res = null;
        NodoGen hijo;
        if (n != null) {
            if (n.getElem().equals(buscado)) {
                res = n;
            }
            hijo = n.getHijoIzquierdo();
            while (hijo != null && res == null) {
                res = obtenerNodo(hijo, buscado);
                hijo = hijo.getHermanoDerecho();
            }

        }
        return res;
    }

    public boolean insertar(Object nuevo, Object padre) {
        boolean exito = false;
        // caso arbol vacio, inserto el elemento en raiz
        if (this.raiz == null) {
            this.raiz = new NodoGen(nuevo);
            exito = true;
        } else {
            NodoGen p = obtenerNodo(this.raiz, padre);
            if (p != null) {
                NodoGen tmp = new NodoGen(nuevo);
                tmp.setHermanoDerecho(p.getHijoIzquierdo());
                p.setHijoIzquierdo(tmp);
                exito = true;
            }
        }
        return exito;
    }

    public Lista listarPreOrden() {
        Lista pre = new Lista();
        listarPreOrdenAux(this.raiz, pre);
        return pre;
    }

    private void listarPreOrdenAux(NodoGen n, Lista l) {
        if (n != null) {
            l.insertar(n.getElem(), l.longitud() + 1);
            NodoGen hijo = n.getHijoIzquierdo();

            while (hijo != null) {
                listarPreOrdenAux(hijo, l);
                hijo = hijo.getHermanoDerecho();
            }
        }
    }

    public Lista listarInOrden() {
        Lista in = new Lista();
        listarInOrdenAux(this.raiz, in);
        return in;
    }

    private void listarInOrdenAux(NodoGen n, Lista l) {
        if (n != null) {
            // llamado recursivo con primer hijo de n
            if (n.getHijoIzquierdo() != null) {
                listarInOrdenAux(n.getHijoIzquierdo(), l);
            }
            // visita del nodo n
            l.insertar(n.getElem(), l.longitud() + 1);

            // llamados recursivos con los otros hijos de n
            if (n.getHijoIzquierdo() != null) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarInOrdenAux(hijo, l);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    public Lista listarPosOrden() {
        Lista l = new Lista();
        listarPosOrdenAux(this.raiz, l);
        return l;
    }

    private Lista listarPosOrdenAux(NodoGen n, Lista l) {
        if (n != null) {
            NodoGen hermano = n.getHijoIzquierdo();
            while (hermano != null) {
                listarPosOrdenAux(hermano, l);
                hermano = hermano.getHermanoDerecho();
            }
            l.insertar(n.getElem(), l.longitud() + 1);
        }
        return l;
    }

    public Lista listarPorNivel() {
        Lista nivel = new Lista();
        if (!this.esVacio()) {
            NodoGen n = this.raiz;
            Cola q = new Cola();
            q.poner(n);
            while (!q.esVacia()) {
                NodoGen tmp = (NodoGen) q.obtenerFrente();
                q.sacar();
                nivel.insertar(tmp.getElem(), nivel.longitud() + 1);
                tmp = tmp.getHijoIzquierdo();
                while (tmp != null) {
                    q.poner(tmp);
                    tmp = tmp.getHermanoDerecho();
                }
            }
        }
        return nivel;
    }

    public boolean pertenece(Object buscado) {
        boolean exito = false;
        if (this.raiz != null) {
            exito = perteneceAux(this.raiz, buscado);
        }
        return exito;
    }

    private boolean perteneceAux(NodoGen n, Object buscado) {
        NodoGen hijo;
        boolean res = false;
        if (n != null) {
            if (n.getElem().equals(buscado)) {
                res = true;
            }
            hijo = n.getHijoIzquierdo();
            while (hijo != null && !res) {
                res = perteneceAux(hijo, buscado);
                hijo = hijo.getHermanoDerecho();
            }

        }
        return res;
    }

    public int altura() {
        int alt = -1;
        if (this.raiz != null) {
            alt = alturaAux(this.raiz, alt);
            if (alt == -1) {
                alt++;
            }
        }
        return alt;
    }

    private int alturaAux(NodoGen n, int alt) {
        if (n != null) {
            NodoGen hijo = n.getHijoIzquierdo();
            if (hijo != null) {
                alt = alt + 1;
            }
            while (hijo != null) {
                alt = alturaAux(hijo, alt);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return alt;
    }

    public int nivel(Object elem) {
        int niv = -1;
        boolean existe = pertenece(elem); // verificar si es eficiente
        if (!this.esVacio() && existe) {
            niv = nivelAux(this.raiz, elem, 0);
        }
        return niv;
    }

    private int nivelAux(NodoGen n, Object x, int cont) {
        int res = 0;
        NodoGen h;
        if (n != null) {
            if (n.getElem().equals(x)) {
                res = cont;
            } else {
                //System.out.println("^: " + n.getElem() + " niv: " + cont);
                if (n.getHijoIzquierdo() != null && res == 0) {
                    res = nivelAux(n.getHijoIzquierdo(), x, cont + 1);
                }
                if (n.getHijoIzquierdo() != null) {
                    h = n.getHijoIzquierdo().getHermanoDerecho();
                    cont = cont + 1;
                    while (h != null && res == 0) {
                        res = nivelAux(h, x, cont);
                        h = h.getHermanoDerecho();
                    }
                }
            }
        }
        return res;
    }

//    private int nivelAux2(NodoGen n, Object x, int niv) {
//        int cont = -1;
//        if (n != null) {
//            if (n.getElem().equals(x)) {
//                cont = niv + 1;
//            } else if (n.getHijoIzquierdo() != null && n.getHijoIzquierdo().getElem().equals(x)) {
//                cont = niv + 2;
//            }
//        }
//        NodoGen hijo = n.getHijoIzquierdo();
//        while (hijo != null && cont == -1) {
//            cont = nivelAux2(hijo, x, niv + 1);
//            hijo = hijo.getHermanoDerecho();
//        }
//        return cont;
//    }

    public Object padre(Object x) {
        Object p = null;
        if (!this.esVacio()) {
            p = padreAux(this.raiz, x);
        }
        return p;
    }

    private Object padreAux(NodoGen n, Object x) {
        Object res = null;
        if (n != null) {
            if (n.getHijoIzquierdo() != null && n.getHijoIzquierdo().getElem().equals(x)) {
                res = n.getElem();
            }
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null && res == null) {
                res = padreAux(hijo, x);
                hijo = hijo.getHermanoDerecho();
                if (hijo != null && hijo.getElem().equals(x)) {
                    res = n.getElem();
                }
            }
        }
        return res;
    }

    /**
     * // Metodo ancestros (Con PILA) public Lista ancestros(Object elem) {
     * Lista list = new Lista(); Pila pila = new Pila(); ancestrosAux(elem,
     * this.raiz, pila); while (!pila.esVacia()) {
     * list.insertar(pila.obtenerTope(), 1); pila.desapilar(); } return list; }
     *
     * private void ancestrosAux(Object elem, NodoGen n, Pila pila) { if (n !=
     * null) { pila.apilar(n.getElem()); if (!n.getElem().equals(elem)) {
     * ancestrosAux(elem, n.getHijoIzquierdo(), pila); if (!pila.esVacia() &&
     * !pila.obtenerTope().equals(elem)) { pila.desapilar(); ancestrosAux(elem,
     * n.getHermanoDerecho(), pila); } } } }
     *
     */
    public Lista ancestros(Object x) {
        Lista l = new Lista();
        if (this.raiz != null) {
            ancestrosAux(this.raiz, x, l);
        }
        return l;
    }

    private boolean ancestrosAux(NodoGen n, Object x, Lista anc) {
        boolean res = false;
        if (n != null) {
            if (n.getElem().equals(x)) {
                res = true;
            } else {
                NodoGen hijo = n.getHijoIzquierdo();
                if (hijo != null) {
                    res = ancestrosAux(hijo, x, anc);
                }
                if (res) {
                    anc.insertar(n.getElem(), 1);
                }
            }
            NodoGen hermano = n.getHermanoDerecho();
            if (hermano != null && !res) {
                res = ancestrosAux(hermano, x, anc);
            }
        }
        return res;
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
    public ArbolGen clone() {
        ArbolGen clon = new ArbolGen();
        if (this.raiz != null) {
            clon.raiz = clonarAux(this.raiz);
        }
        return clon;
    }

    private NodoGen clonarAux(NodoGen n) {
        NodoGen nuevo = null;
        if (n != null) {
            nuevo = new NodoGen(n.getElem());
            nuevo.setHijoIzquierdo(clonarAux(n.getHijoIzquierdo()));
            nuevo.setHermanoDerecho(clonarAux(n.getHermanoDerecho()));
        }
        return nuevo;
    }

    @Override
    public String toString() {
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoGen n) {
        String cadena = "";
        if (n != null) {
            // visita del nodo n
            cadena += n.getElem().toString() + " -> ";
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                cadena += hijo.getElem().toString() + ", ";
                hijo = hijo.getHermanoDerecho();
            }
            // comienza recorrido de los hijos de n llamando recursivamente
            // para que cada hijo agregue su subcadena a la general
            hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                cadena += "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return cadena;
    }

    public Lista frontera() {
        Lista frontera = new Lista();
        if (this.raiz != null) {
            frontera = fronteraAux(this.raiz, frontera);
        }
        return frontera;
    }

    private Lista fronteraAux(NodoGen n, Lista l) {
        if (n != null) {
            l = fronteraAux(n.getHijoIzquierdo(), l);
            l = fronteraAux(n.getHermanoDerecho(), l);
            if (n.getHijoIzquierdo() == null) {
                // condicion de hoja
                l.insertar(n.getElem(), 1);
            }
        }
        return l;
    }

    public boolean verificarCamino(Lista camino) {
        boolean res = false;
        int aciertos = 0;
        if (camino.longitud() >= 1) {
            res = caminoAux(this.raiz, camino, 1, aciertos);
        }
        return res;
    }

    private boolean caminoAux(NodoGen n, Lista l, int cont, int aciertos) {
        boolean res;
        if (aciertos == l.longitud()) {
            res = true;
        } else {
            res = false;
        }
        if (n != null && cont <= l.longitud()) {
//            System.out.println("* " + n.getElem());
            Object r = l.recuperar(cont);
            NodoGen h;
            if (n.getElem().equals(r)) {
                aciertos++;
//                System.out.println("------------> == " + n.getElem());
                cont++;
                h = n.getHijoIzquierdo();
            } else {
                h = n.getHermanoDerecho();
                boolean hermano = false;
                while (h != null && !hermano) {
//                    System.out.println("Hd " + h.getElem());
                    if (!h.getElem().equals(r)) {
                        h = h.getHermanoDerecho();
                    } else {
                        hermano = true;
                    }
                }
            }
            res = caminoAux(h, l, cont, aciertos);
        }
        return res;
    }

    public Lista listarEntreNiveles(int niv1, int niv2) {
        Lista elemNiv = new Lista();
        listarEntreNivAux(this.raiz, niv1, niv2, elemNiv, 0);
        return elemNiv;
    }

    private void listarEntreNivAux(NodoGen n, int menor, int mayor, Lista l, int cont) {
        /**
         * nota: el contador de nivel se aumenta solamente por cada vez que se
         * baja hacia izquierda
         */
        if (n != null) {
//            System.out.println("V: " + n.getElem());
            if (n.getHijoIzquierdo() != null && cont < mayor) {
                listarEntreNivAux(n.getHijoIzquierdo(), menor, mayor, l, cont + 1);
            }
//            System.out.println("* " + n.getElem() + " | cont: " + cont);
            if (cont >= menor && cont <= mayor) {
                l.insertar(n.getElem(), l.longitud() + 1);
            }
            if (n.getHijoIzquierdo() != null && cont < mayor) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                cont++;
                while (hijo != null) {
                    listarEntreNivAux(hijo, menor, mayor, l, cont);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    public Lista listarHastaNivel(int i) {
        Lista hastaNiv = new Lista();
        listarHastaNivAux(this.raiz, i, hastaNiv, 0);
        return hastaNiv;
    }

    private void listarHastaNivAux(NodoGen n, int max, Lista l, int cont) {
        if (n != null) {
//            System.out.println("V: "+n.getElem());
            if (n.getHijoIzquierdo() != null && cont < max) {
                listarHastaNivAux(n.getHijoIzquierdo(), max, l, cont + 1);
            }
//            System.out.println("* " + n.getElem() + " | niv: " + cont);
            if (cont <= max) {
                l.insertar(n.getElem(), l.longitud() + 1);
            }
            if (n.getHijoIzquierdo() != null && cont < max) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                cont++;
                while (hijo != null) {
                    listarHastaNivAux(hijo, max, l, cont);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    public boolean verificarCaminoHastaHoja(Lista cam) {
        boolean res = false;
        int aciertos = 0;
        if (cam.longitud() > 1) {
            res = caminoHastaHojaAux(this.raiz, cam, 1, aciertos, false);
        }
        return res;
    }

    private boolean caminoHastaHojaAux(NodoGen n, Lista l, int cont, int aciertos, boolean esHoja) {
        boolean res;
        if (aciertos == l.longitud() && esHoja) {
            res = true;
        } else {
            res = false;
        }
        if (n != null && cont <= l.longitud()) {
//            System.out.println("** " + n.getElem());
            Object r = l.recuperar(cont);
            NodoGen h;
            if (n.getElem().equals(r)) {
                aciertos++;
//                System.out.println("------------> == " + n.getElem());
                cont++;
                if (n.getHijoIzquierdo() == null) {
                    esHoja = true;
                }
                h = n.getHijoIzquierdo();
            } else {
                h = n.getHermanoDerecho();
                boolean hermano = false;
                while (h != null && !hermano) {
//                    System.out.println("Hd " + h.getElem());
                    if (!h.getElem().equals(r)) {
                        h = h.getHermanoDerecho();
                    } else {
                        hermano = true;
                    }
                }
            }
            res = caminoHastaHojaAux(h, l, cont, aciertos, esHoja);
        }
        return res;
    }

    public boolean eliminar(Object elem) {
        boolean exito = false;
        exito = eliminarAux(this.raiz, null, elem, true);
        return exito;
    }

    private boolean eliminarAux(NodoGen n, NodoGen tmp, Object x, boolean continuar) {
        boolean res = false;
        if (n != null && continuar) {
            NodoGen h = null;
            /*if (tmp != null) {
                System.out.println("tmp " + tmp.getElem());
            } else {
                System.out.println("tmp null");
            }
            System.out.println("n " + n.getElem());
            System.out.println("------------------");*/
            if (n.getElem().equals(x)) {
                if (n.getHermanoDerecho() == null) {
                    tmp.setHijoIzquierdo(null);
                } else {
                    tmp.setHijoIzquierdo(n.getHermanoDerecho());
                }
                continuar = false;
//                System.out.println("ENC HI " + n.getElem());
            } else {
                NodoGen antH = n;
                h = n.getHermanoDerecho();
                boolean seguir = false;

                while (h != null && !seguir) {
                    System.out.println("----------------");
                    System.out.println("antH: " + antH.getElem());
                    System.out.println("h: " + h.getElem());
                    System.out.println("----------------");
                    if (h.getElem().equals(x)) {
                        antH.setHermanoDerecho(h.getHermanoDerecho());
                        seguir = true;
                        continuar = false;
                    } else {
                        h = h.getHermanoDerecho();
                    }
                }
                if (!seguir) {
                    tmp = n;
                    h = n.getHijoIzquierdo();
                }
            }
            res = eliminarAux(h, tmp, x, continuar);
        }
        return res;
    }
}
