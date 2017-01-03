/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Colas;

/**
 *
 * @author Fernando Peña
 */
public class ColaA <T> implements ColaADT <T>{
    
    private T [] cola;
    private int frente, fin;
    private final int MAX = 50;
    
    public ColaA(){
        cola = (T[]) new Object [MAX];
        frente = -1;
        fin = -1;
    }
    
    public ColaA(int max){
        cola = (T[]) new Object [max];
        frente = -1;
        fin = -1;
    }
    
    @Override
    public T quita() {
        if(!estaVacia()){
            T resp = cola[frente];
            
            cola[frente] = null;
            if(frente == fin){
                frente = -1;
                fin = -1;
            }
            else
                frente = (frente + 1) % cola.length;
            return resp;
        }
        throw new EmptyCollectionException();
    }

    @Override
    public void agrega(T dato) {
        if(estaLlena())
            expandCapacity();
        fin = (fin + 1) % cola.length;
        cola[fin] = dato;
        if(frente == -1)
            frente = 0;
    }

    @Override
    public T primero() {
        if(!estaVacia())
            return cola[frente];
        throw new EmptyCollectionException();
    }

    @Override
    public boolean estaVacia() {
        return frente == -1;
    }
    
    @Override
    public boolean estaLlena() {
        return frente == (fin + 1) % cola.length;
    }
    
    public void expandCapacity(){
        T nuevo [] = (T[]) new Object [cola.length * 2];
        int total = cola.length;
        
        for (int i = 0; i < total; i++) {
            nuevo[i] = quita();
        }
        cola = nuevo;
        frente = 0;
        fin = total - 1;
    }
}