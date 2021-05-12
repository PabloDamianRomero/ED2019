/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 * TDA Cola dinámica
 * 
 * @author Romero Pablo Damian
 * Legajo: FAI-1652
 * Año: 2019
 */
public class Cola {
    
    private Nodo frente;
    private Nodo fin;
    
    public Cola(){
        this.frente = null;
        this.fin = null;
    }
    
    public boolean poner(Object elem){
        Nodo nuevo = new Nodo(elem);
        // caso cola vacia
        if(this.frente == null){
            this.frente = nuevo;
            this.fin = nuevo;
        }else{
            this.fin.setEnlace(nuevo);
            this.fin = nuevo;
        }
        // no da error de cola llena (estructura dinamica)
        return true;
    }
    
    public boolean sacar(){
        boolean exito = true;
        // si cola vacia, reporta error
        if(this.frente == null){
            exito = false;
        }else{
            // al menos hay un elemento
            // quita el primer elemento y actualiza frente
            // (y fin si queda vacia)
            this.frente = this.frente.getEnlace();
            if(this.frente == null){
                this.fin = null;
            }
        }
        return exito;
    }
    
    public Object obtenerFrente(){
        Object res = null;
        // si la cola no está vacia
        if(this.frente != null){
            res = this.frente.getElemento();
        }
        return res;
    }
    
    public boolean esVacia(){
        boolean exito;
        // si la cola esta vacia
        if(this.frente == null){
            exito = true;
        }else{
            exito = false;
        }
        return exito;
    }
    
    public void vaciar(){
        this.frente = null;
        this.fin = null;
    }
    
    @Override
    public Cola clone(){
        Cola clon = new Cola();
        // si cola original no esta vacia, clono
        if(this.frente != null){
            Nodo aux = this.frente;
            Nodo nuevo = new Nodo(aux.getElemento());
            clon.frente = nuevo;
            clon.fin = nuevo;
            aux = aux.getEnlace();
            while(aux != null){
                Nodo restante = new Nodo(aux.getElemento());
                clon.fin.setEnlace(restante);
                clon.fin = restante;
                aux = aux.getEnlace();
            }
        }
        return clon;
    }
    
    @Override
    public String toString(){
        String cadena = "";
        // caso cola vacia
        if(this.frente != null){
            Nodo aux = this.frente;
            while(aux != null){
                cadena += aux.getElemento();
                aux = aux.getEnlace();
            }
        }
        return cadena;
    }
    
}
