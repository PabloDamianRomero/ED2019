/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 * TDA Nodo
 * 
 * @author Romero Pablo Damian
 * Legajo: FAI-1652
 * Año: 2019
 */
public class Nodo {
    
    private Object elemento;
    private Nodo enlace;
    
    public Nodo(Object elemento, Nodo enlace){
        this.elemento = elemento;
        this.enlace = enlace;
    }
    
    public Nodo(Object elemento){
        this.elemento = elemento;
    }
    
    public Object getElemento(){
        return elemento;
    }
    
    public void setElemento(Object elem){
        this.elemento = elem;
    }
    
    public Nodo getEnlace(){
        return enlace;
    }
    
    public void setEnlace(Nodo enlace){
        this.enlace = enlace;
    }
    
}
