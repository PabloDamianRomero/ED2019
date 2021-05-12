/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;

/**
 * TDA Cola estática
 * 
 * @author Romero Pablo Damian
 * Legajo: FAI-1652
 * Año: 2019
 */
public class Cola {
    
    private static final int TAM = 15;
    private Object arreglo[];
    private int frente = 0;
    private int fin = 0;
    
    public Cola(){
        this.arreglo = new Object[TAM];
    }
    
    public boolean poner(Object elem){
        boolean exito;
        // caso cola llena
        if(frente == (fin+1)%TAM){
            exito = false;
        }else{
            arreglo[fin] = elem;
            fin = (fin+1)%TAM;
            exito = true;
        }
        return exito;
    }
    
    public boolean sacar(){
        boolean exito;
        // cola vacia
        if(frente == fin){
            exito = false;
        }else{
            arreglo[frente] = null;
            this.frente = (this.frente+1)%this.TAM;
            exito = true;
        }
        return exito;
    }
    
    public Object obtenerFrente(){
        Object res = null;
        if(frente != fin){
            res = arreglo[frente];
        }
        return res;
    }
    
    public boolean esVacia(){
        boolean exito;
        if(this.frente == this.fin){
            exito = true;
        }else{
            exito = false;
        }
        return exito;
    }
    
    public void vaciar(){
        while(this.frente != this.fin){
            this.arreglo[frente] = null;
            this.frente++;
            this.frente = (this.frente) % this.TAM;
        }
    }
    
    @Override
    public String toString(){
        String cadena = "";
        // caso cola no vacia
        if(this.frente != this.fin){
            cadena += "[";
            // frenteAux sirve para iterar sobre la cola original
            int frenteAux = this.frente;
            while(frenteAux != this.fin){
                cadena +=this.arreglo[frenteAux]+",";
                //frenteAux++;
                frenteAux = (frenteAux+1) % this.TAM;
                if(this.arreglo[frenteAux] == null){
                    cadena +="]";
                }
            }
        }else{
            cadena = "Cola vacia";
        }
        return cadena;
    }
    
    @Override
    public Cola clone(){
        Cola clon = new Cola();
        // si cola no vacia
        if(this.frente != this.fin){
            int aux = this.frente; // aux sirve para recorrer cola original
            // copio la estructura para el clon
            clon.frente = aux;
            clon.fin = this.fin;
            while(aux != this.fin){
                clon.arreglo[aux] = this.arreglo[aux];
                //aux++;
                aux = (aux+1) % this.TAM;
            }
        }
        return clon;
    }
}
