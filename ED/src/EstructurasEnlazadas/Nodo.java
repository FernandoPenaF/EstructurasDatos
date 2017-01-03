/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EstructurasEnlazadas;

/**
 *
 * @author Fernando Peña
 */
public class Nodo <T>{
    private T dato;
    private Nodo <T> siguiente;
    
    public Nodo(){
        siguiente = null;
    }
    
    public Nodo(T dato){
        this.dato = dato;
        siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> sig) {
        this.siguiente = sig;
    }
    
    @Override
    public String toString(){
        return dato.toString();
    }
}