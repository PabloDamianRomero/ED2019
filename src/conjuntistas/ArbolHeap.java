/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

/**
 *
 * @author pabloromero
 */
public class ArbolHeap {

    private static final int TAM = 78;
    private Comparable heap[];
    private int ultimo = 0;

    public ArbolHeap() {
        this.heap = new Comparable[TAM];
    }

    public boolean insertar(Comparable elem) {
        boolean exito = false;
        if (ultimo < TAM - 1) {
            ultimo++;
            this.heap[ultimo] = elem;
            if (ultimo != 1 && ultimo < TAM) {
                int cont = ultimo;
                Comparable aux = this.heap[ultimo / 2];
                while (elem.compareTo(aux) < 0 && cont > 1) {
                    this.heap[cont] = aux;
                    cont = cont / 2;
                    this.heap[cont] = elem;
                    if (cont != 1) {
                        aux = this.heap[cont / 2];
                    }
                }
            }
            exito = true;
        }
        return exito;
    }
    
    public boolean eliminarCima(){
        boolean exito;
        if(this.ultimo == 0){
            // estructura vacia
            exito = false;
        }else{
            // saca la raiz y pone la ultima hoja en su lugar
            this.heap[1] = this.heap[ultimo];
            this.ultimo--;
            // reestablece la propiedad de heap minimo
            hacerBajar(1);
            exito = true;
        }
        return exito;
    }
    
    private void hacerBajar(int pos){
        int hijoMenor;
        int temp = (int) this.heap[pos];
        boolean salir = false;
        while(!salir){
            hijoMenor = pos * 2;
            if(hijoMenor <= this.ultimo){
                // temp tiene hijos (al menos uno)
                if(hijoMenor < this.ultimo){
                    // hijoMenor tiene hermano derecho
                    if((int)this.heap[hijoMenor+1] < (int)this.heap[hijoMenor]){
                        hijoMenor++;
                    }
                }
                if((int)this.heap[hijoMenor] < temp){
                    this.heap[pos] = this.heap[hijoMenor];
                    pos = hijoMenor;
                }else{
                    // el padre es menor que sus hijos
                    salir = true;
                }
            }else{
                // hijo menor es hoja
                salir = true;
            }
        }
        this.heap[pos] = temp;
    }

    public String toString() {
        String c = "[";
        if (this.ultimo != 0) {
            for (int i = 1; i <= ultimo; i++) {
                c += this.heap[i];
                if (i != ultimo) {
                    c += ", ";
                }
            }
            c += "]";
            c += "\n Ùltimo (pos) " + ultimo;
        }
        c += "]";
        return c;
    }

    public boolean esVacio() {
        boolean exito = false;
        if (this.ultimo == 0) {
            exito = true;
        }
        return exito;
    }

    public void vaciar() {
        if (this.ultimo != 0) {
            for (int i = 1; i <= ultimo; i++) {
                this.heap[i] = null;
            }
            ultimo = 0;
        }
    }
    
    public ArbolHeap clone(){
        ArbolHeap clon = new ArbolHeap();
        clon.ultimo = this.ultimo;
        if(this.ultimo != 0){
            for(int i = 0; i <= clon.ultimo; i++){
                clon.heap[i] = this.heap[i];
                System.out.println("Clon: "+clon.heap[i]);
            }
        }
        return clon;
    }

}
