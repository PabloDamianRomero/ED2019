/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

import jerarquicas.NodoArbol;
import lineales.dinamicas.Lista;

/**
 *
 * @author pabloromero
 */
public class ArbolBB {

    private NodoArbol raiz;

    public ArbolBB() {
        this.raiz = null;
    }

    public Object recuperarCima() {
        Object cima = null;
        if (!this.esVacio()) {
            cima = this.raiz.getElem();
        }
        return cima;
    }

    public boolean insertar(Comparable elem) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoArbol(elem);
        } else {
            exito = insertarAux(this.raiz, elem);
        }
        return exito;
    }

    private boolean insertarAux(NodoArbol n, Comparable elem) {
        // precondicion: n no es nulo
        boolean exito = true;
        if ((elem.compareTo(n.getElem()) == 0)) {
            // reportar error: elemento repetido
            exito = false;
        } else if (elem.compareTo(n.getElem()) < 0) {
            // elemento es menor que n.getElem()
            // si tiene HI baja a la izquierda, sino agrega el elemento
            if (n.getIzquierdo() != null) {
                exito = insertarAux(n.getIzquierdo(), elem);
            } else {
                n.setIzquierdo(new NodoArbol(elem));
            }
        } else // elemento es mayor que n.getElem()
        // si tiene HD baja a la derecha, sino agrega el elemento
        {
            if (n.getDerecho() != null) {
                exito = insertarAux(n.getDerecho(), elem);
            } else {
                n.setDerecho(new NodoArbol(elem));
            }
        }
        return exito;
    }

    public Lista listar() {
        Lista l = new Lista();
        listarAux(this.raiz, l);
        return l;
    }

    private void listarAux(NodoArbol n, Lista l) {
        if (n != null) {
            listarAux(n.getIzquierdo(), l);
            l.insertar(n.getElem(), l.longitud() + 1);
            listarAux(n.getDerecho(), l);
        }
    }

    public Lista listarMayorAMenor() {
        Lista l = new Lista();
        listarAuxMayorAMenor(this.raiz, l);
        return l;
    }

    private void listarAuxMayorAMenor(NodoArbol n, Lista l) {
        if (n != null) {
            listarAuxMayorAMenor(n.getDerecho(), l);
            l.insertar(n.getElem(), l.longitud() + 1);
            listarAuxMayorAMenor(n.getIzquierdo(), l);
        }
    }

    public void vaciar() {
        this.raiz = null;
    }

    public boolean esVacio() {
        boolean exito = false;
        if (this.raiz == null) {
            exito = true;
        }
        return exito;
    }

    public Comparable minimoElem() {
        Comparable res = null;
        if (!this.esVacio()) {
            NodoArbol tmp = this.raiz;
            while (tmp != null) {
                if (tmp.getIzquierdo() == null) {
                    res = (Comparable) tmp.getElem();
                }
                tmp = tmp.getIzquierdo();
            }
        }
        return res;
    }

    public Comparable maximoElem() {
        Comparable res = null;
        if (!this.esVacio()) {
            NodoArbol tmp = this.raiz;
            while (tmp != null) {
                if (tmp.getDerecho() == null) {
                    res = (Comparable) tmp.getElem();
                }
                tmp = tmp.getDerecho();
            }
        }
        return res;
    }

    public boolean pertence(Object elem) {
        boolean exito = false;
        Comparable x = (Comparable) elem;
        if (!this.esVacio()) {
            NodoArbol tmp = this.raiz;
            while (tmp != null && !exito) {
                if (x.compareTo(tmp.getElem()) == 0) {
                    exito = true;
                } else if (x.compareTo(tmp.getElem()) < 0) {
                    tmp = tmp.getIzquierdo();
                } else {
                    tmp = tmp.getDerecho();
                }
            }
        }
        return exito;
    }

    public boolean eliminar(Comparable elem) {
        boolean exito = false;
        if (!this.esVacio()) {
            char l = ' ';
            exito = eliminarAux(this.raiz, null, elem, l);
        }
        return exito;
    }

    private boolean eliminarAux(NodoArbol n, NodoArbol tmp, Comparable x, char lugar) {
        boolean res = false;
        if (n != null) {
            if (x.compareTo(n.getElem()) < 0) {
                // si elem es menor, avanzo hacia subarbol izq
                res = eliminarAux(n.getIzquierdo(), n, x, 'I');
            } else if (x.compareTo(n.getElem()) > 0) {
                // si elem es mayor, avanzo hacia subarbol der
                tmp = n;
                lugar = 'D';
                res = eliminarAux(n.getDerecho(), tmp, x, lugar);
            } else//(x.compareTo(n.getElem()) == 0) {
            // si encontro elem
            {
                if (n.getIzquierdo() == null && n.getDerecho() == null) {
                    res = caso1(tmp, lugar);

                } else if (n.getIzquierdo() == null && n.getDerecho() != null || n.getIzquierdo() != null && n.getDerecho() == null) {
                    res = caso22(tmp, lugar);

                } else {
                    // caso 3: el nodo tiene ambos hijos
                    res = caso3(n);
                }
            }

        }
        return res;
    }

    private boolean caso1(NodoArbol tmp, char l) {
        boolean exito = true;
        switch (l) {
            case ' ':
                raiz = null;
                break;
            case 'I':
                tmp.setIzquierdo(null);
                break;
            case 'D':
                tmp.setDerecho(null);
                break;
            default:
                exito = false;
        }
        return exito;
    }

    private boolean raizConHijo(NodoArbol n) {
        boolean exito = false;
        if (n.getIzquierdo() != null && n.getDerecho() == null) {
            n.setElem(n.getIzquierdo().getElem());
            n.setIzquierdo(null);
            exito = true;
        } else if (n.getDerecho() != null && n.getIzquierdo() == null) {
            n.setElem(n.getDerecho().getElem());
            n.setDerecho(null);
            exito = true;
        }
        return exito;
    }

    private boolean caso22(NodoArbol tmp, char l) {
        // precondicion si tmp==null, l=' '
        boolean exito = true;
        NodoArbol hijo = null;

        // apuntar al hijo que se debe eliminar
        switch (l) {
            case ' ':
                hijo = raiz;
                break;
            case 'I':
                hijo = tmp.getIzquierdo();
                break;
            case 'D':
                hijo = tmp.getDerecho();
                break;
            default:
                exito = false;
        }
        if (exito) {
            // buscar el candidato
            NodoArbol candidato;
            if (hijo != null && hijo.getIzquierdo() != null) {
                candidato = hijo.getIzquierdo();
            } else {
                candidato = hijo.getDerecho();
            }

            // cambiar el hijo por el candidato
            switch (l) {
                case ' ':
                    raiz = candidato;
                    break;
                case 'I':
                    tmp.setIzquierdo(candidato);
                    break;
                case 'D':
                    tmp.setDerecho(candidato);
                    break;
            }
        }
        return exito;
    }

    private boolean caso2(NodoArbol tmp, char l) {
        boolean exito = false;
        NodoArbol aux;
        if (l == 'I') {
            aux = tmp.getIzquierdo();
            if (aux != null) {
                if (aux.getIzquierdo() != null) {
                    tmp.setIzquierdo(aux.getIzquierdo());
                    exito = true;
                } else {
                    tmp.setIzquierdo(aux.getDerecho());
                    exito = true;
                }
            }
        }
        if (l == 'D') {
            aux = tmp.getDerecho();
            if (aux != null) {
                if (aux.getDerecho() != null) {
                    tmp.setDerecho(aux.getDerecho());
                    exito = true;
                } else {
                    tmp.setDerecho(aux.getIzquierdo());
                    exito = true;
                }
            }
        }
        return exito;
    }

    private boolean caso3(NodoArbol aux) {
        boolean exito = false;
        char l;
        NodoArbol base = aux; // base será el nodo con el valor del candidato
        NodoArbol padreDeAux = aux;
        aux = aux.getIzquierdo(); // busco por candidatoA (mayor elemento del subarbol izquierdo de n)
        if (aux.getDerecho() == null) {
            l = 'I';
        } else {
            l = 'D';
        }
        if (aux != null) {
            while (aux.getDerecho() != null) {
                padreDeAux = aux;
                aux = aux.getDerecho();
            }
        }
        base.setElem(aux.getElem());
        if (aux.getIzquierdo() == null && aux.getDerecho() == null) {
            // caso 1: hoja
            exito = caso1(padreDeAux, l);
        } else if (aux.getIzquierdo() == null && aux.getDerecho() != null || aux.getIzquierdo() != null && aux.getDerecho() == null) {
            // caso 2: el nodo solo tiene un hijo
            exito = caso2(padreDeAux, l);
        }
        return exito;
    }

    @Override
    public ArbolBB clone() {
        ArbolBB clon = new ArbolBB();
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

    public Lista listarRango(Comparable min, Comparable max) {
        Lista rango = new Lista();
        listarRangoAux(this.raiz, min, max, rango);
        return rango;
    }

    private void listarRangoAux(NodoArbol n, Comparable min, Comparable max, Lista l) {
        if (n != null) {
//            System.out.println("* " + n.getElem());
            if (min.compareTo(n.getElem()) < 0 && max.compareTo(n.getElem()) > 0) {
                // si estoy en el rango
                listarRangoAux(n.getIzquierdo(), min, max, l);
                l.insertar(n.getElem(), l.longitud() + 1);
                listarRangoAux(n.getDerecho(), min, max, l);
            } else {
                if (min.compareTo(n.getElem()) >= 0) {
//                    System.out.println("D " + n.getElem());
                    listarRangoAux(n.getDerecho(), min, max, l);
                }
                if (max.compareTo(n.getElem()) <= 0) {
//                    System.out.println("I " + n.getElem());
                    listarRangoAux(n.getIzquierdo(), min, max, l);
                }
            }
        }

    }

    public ArbolBB clonarParteInvertida(Comparable elem) {
        ArbolBB clon = new ArbolBB();
        NodoArbol encontrado = buscarPadreClonInv(this.raiz, elem);
        if (encontrado != null) {
            clon.raiz = clonarParteInvAux(encontrado);
        }
        return clon;
    }

    private NodoArbol buscarPadreClonInv(NodoArbol n, Comparable x) {
        NodoArbol res = null;
        if (n != null) {
            if (x.compareTo(n.getElem()) < 0) {
                res = buscarPadreClonInv(n.getIzquierdo(), x);
            }
            if (x.compareTo(n.getElem()) > 0) {
                res = buscarPadreClonInv(n.getDerecho(), x);
            }
            if (x.compareTo(n.getElem()) == 0) {
                res = n;
            }
        }
        return res;
    }

    private NodoArbol clonarParteInvAux(NodoArbol p) {
        NodoArbol nuevo = null;
        if (p != null) {
            nuevo = new NodoArbol(p.getElem());
            nuevo.setIzquierdo(clonarParteInvAux(p.getDerecho()));
            nuevo.setDerecho(clonarParteInvAux(p.getIzquierdo()));
        }
        return nuevo;
    }

    public Lista listarMenores(Comparable elem) {
        Lista menor = new Lista();
        listarMenoresAux(this.raiz, elem, menor);
        return menor;
    }

    private void listarMenoresAux(NodoArbol n, Comparable x, Lista l) {
        if (n != null) {
            if (x.compareTo(n.getElem()) == 0) {
                listarMenoresAux(n.getIzquierdo(), x, l);
            }
            if (x.compareTo(n.getElem()) < 0) {
                listarMenoresAux(n.getIzquierdo(), x, l);
            }
            if (x.compareTo(n.getElem()) > 0) {
                listarMenoresAux(n.getIzquierdo(), x, l);
                //System.out.println("* " + n.getElem());
                l.insertar(n.getElem(), l.longitud() + 1);
                listarMenoresAux(n.getDerecho(), x, l);
            }
        }
    }

    public Lista listarMayoresEIgual(Comparable elem) {
        Lista mayorIgual = new Lista();
        listarMayorIgualAux(this.raiz, elem, mayorIgual);
        return mayorIgual;
    }

    private void listarMayorIgualAux(NodoArbol n, Comparable x, Lista l) {
        if (n != null) {
            //System.out.println("* "+n.getElem());
            if (x.compareTo(n.getElem()) == 0) {
                l.insertar(n.getElem(), 1);
                listarMayorIgualAux(n.getDerecho(), x, l);
            }
            if (x.compareTo(n.getElem()) < 0) {
                listarMayorIgualAux(n.getIzquierdo(), x, l);
                l.insertar(n.getElem(), l.longitud() + 1);
                listarMayorIgualAux(n.getDerecho(), x, l);
            }
            if (x.compareTo(n.getElem()) > 0) {
                listarMayorIgualAux(n.getDerecho(), x, l);
            }
        }
    }

    public boolean eliminarMin() {
        boolean res = false;
        if (!this.esVacio()) {
            if (this.raiz.getIzquierdo() == null) {
                // caso raiz
                res = casoRaizMin(this.raiz);
            } else {
                res = eliminarMinAux(this.raiz, null);
            }
        }
        return res;
    }

    private boolean eliminarMinAux(NodoArbol n, NodoArbol tmp) {
        boolean res = false;
//        System.out.println("* " + n.getElem());
        if (n != null) {
            // si n no es raiz
            if (n.getIzquierdo() != null) {
                // bajar por izq
                tmp = n;
                res = eliminarMinAux(n.getIzquierdo(), tmp);
            } else {
                res = caso2Min(tmp, n);
            }
        }

        return res;

    }

    private boolean caso1Min(NodoArbol tmp) {
//        System.out.println("\t");
//        System.out.println("Caso 1");
//        System.out.println("-----------------");
        tmp.setIzquierdo(null);
        return true;
    }

    private boolean caso2Min(NodoArbol tmp, NodoArbol n) {
        boolean res = false;
//        System.out.println("\t");
//        System.out.println("Caso 2");
//        System.out.println("-----------------");
        NodoArbol derecho = n.getDerecho();
        if (n.getIzquierdo() == null && n.getDerecho() == null) {
            // n caso hoja
            res = caso1Min(tmp);
        } else {
            tmp.setIzquierdo(derecho);
            res = true;
        }
        return res;
    }

    private boolean casoRaizMin(NodoArbol n) {
//        System.out.println("\t");
//        System.out.println("Caso RAIZ");
//        System.out.println("-----------------");
        boolean res = false;
        if (n.getDerecho() == null) {
            this.raiz = null;
            res = true;
        } else {
            this.raiz = n.getDerecho();
            res = true;
        }
        return res;
    }

}
