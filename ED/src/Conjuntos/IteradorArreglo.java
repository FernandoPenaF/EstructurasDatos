/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conjuntos;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Fernando Peña
 */
public class IteradorArreglo <T> implements Iterator <T>{
    
    private T[] coleccion;
    private int total;
    private int actual;
    
    public IteradorArreglo(T arreglo[], int tam){
        coleccion = arreglo;
        total = tam;
        actual = 0;
    }
    
    @Override
    public boolean hasNext(){
        return actual < total;
    }
    
    @Override
    public T next(){
        if(!hasNext())
            throw new NoSuchElementException();
        else{
            T resul = coleccion[actual];
            actual++;
            return resul;
        }
    }
    
    @Override
    public void remove(){
        throw new UnsupportedOperationException();
    }
}