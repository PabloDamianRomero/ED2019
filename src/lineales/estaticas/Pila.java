/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;

/**
 * TDA Pila estática
 * 
 * @author Romero Pablo Damian
 * Legajo: FAI-1652
 * Año: 2019
 */
public class Pila {
    private Object[] arreglo;
    private int tope;
    private static final int TAM = 15;
    
    public Pila(){
        this.arreglo = new Object[TAM];
        this.tope = -1;
    }
    
    public boolean apilar(Object elem){
        boolean exito;
        if(this.tope+1 >= this.TAM){
            exito = false;
        }else{
            arreglo[this.tope+1] = elem;
            tope++;
            exito = true;
        }
        return exito;
    }
    
    public boolean desapilar(){
        boolean exito;
        if(tope==-1){
            exito = false;
        }else{
            arreglo[tope] = null;
            tope--;
            exito = true;
        }
        return exito;
    }
    
    public Object obtenerTope(){
        Object res;
        if(tope == -1){
            res = null;
        }else{
            res = arreglo[tope];
        }
        return res;
    }
    
    public boolean esVacia(){
        boolean exito;
        if(tope == -1){
            exito = true;
        }else{
            exito = false;
        }
        return exito;
    }
    
    public void vaciar(){
        for(int i=0; i <= tope; i++){
            arreglo[i] = null;
        }
        this.tope = -1;
    }
    
    @Override
    public String toString(){
        String cadena = "";
        for(int i=0; i <= tope; i++){
            cadena += arreglo[i]+" ";
        }
        return cadena;
    }
    
    @Override
    public Pila clone(){
        Pila clon = new Pila();
        clon.tope = this.tope;
        for(int i=0; i <= tope; i++){
            clon.arreglo[i] = this.arreglo[i];
        }
        return clon;
    }
}
