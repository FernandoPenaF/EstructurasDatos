/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Conjuntos;

import java.util.Iterator;

/**
 *
 * @author Fernando Peña
 */
public class ConjuntoA <T> implements ConjuntoADT <T>{
    private T conjunto [];
    private int cardinalidad;
    private final int MAX = 50;
    
    public ConjuntoA(){
        conjunto = (T[]) new Object [MAX];
        cardinalidad = 0;
    }
    
    public ConjuntoA(int max){
        conjunto = (T[]) new Object [max];
        cardinalidad = 0;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new IteradorArreglo(conjunto, cardinalidad);
    }

    @Override
    public boolean estaVacio() {
        return cardinalidad == 0;
    }

    @Override
    public int getCardinalidad() {
        return cardinalidad;
    }

    @Override
    public boolean contiene(T dato) {
        boolean resp = false;
        Iterator <T> it = iterator();
        
        while(it.hasNext() && !resp)
            if(it.next().equals(dato))
                resp = true;
        return resp;
    }

    @Override
    public boolean agrega(T dato) {
        boolean resp = false;
        
        if(!contiene(dato)){
            if(cardinalidad == conjunto.length)
                expandCapacity();
            conjunto[cardinalidad] = dato;
            cardinalidad++;
            resp = true;
        }
        return resp;
    }
    
    private void expandCapacity(){
        T [] nuevo = (T[]) new Object [conjunto.length * 2];
        for (int i = 0; i <= cardinalidad; i++) {
            nuevo[i] = conjunto[i];
        }
        conjunto = nuevo;
    }

    @Override
    public T quita(T dato) {
        T resp = null;
        
        if(contiene(dato)){
           int i = 0;
           while(i <= cardinalidad && !conjunto[i].equals(dato))
               i++;
           if(i < cardinalidad){
               resp = conjunto[i];
               cardinalidad--;
               conjunto[i] = conjunto[cardinalidad];
               conjunto[cardinalidad] = null;
           }
        }
        return resp;
    }

    @Override
    public ConjuntoADT<T> union(ConjuntoADT<T> otro) {
        ConjuntoADT <T> nuevo = null;
        
        if(otro != null){
            nuevo = new ConjuntoA();
            Iterator <T> it = this.iterator();
            while(it.hasNext())
                nuevo.agrega(it.next());
            it = otro.iterator();
            while(it.hasNext())
                nuevo.agrega(it.next());
        }
        return nuevo;
    }

    @Override
    public ConjuntoADT<T> interseccion(ConjuntoADT<T> otro) {
        ConjuntoADT <T> nuevo = null;
        
        if(otro != null){
            nuevo = new ConjuntoA();
            Iterator <T> it = this.iterator();
            while(it.hasNext()){
                T aux = it.next();
                if(otro.contiene(aux))
                    nuevo.agrega(aux);
            }
        }
        return nuevo;
    }

    @Override
    public ConjuntoADT<T> diferencia(ConjuntoADT<T> otro) {
        ConjuntoADT <T> nuevo = null;
        
        if(otro != null){
            nuevo = new ConjuntoA();
            Iterator <T> it = this.iterator();
            while(it.hasNext()){
                T aux = it.next();
                if(!otro.contiene(aux))
                    nuevo.agrega(aux);
            }
        }
        return nuevo;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Iterator <T> it = iterator();
        
        while(it.hasNext())
            sb.append(it.next()).append(", ");
        return sb.toString();
    }
    
    //Métodos recursivos--------------------------------------------------------------
    
    public ConjuntoADT <T> unionRecursiva(ConjuntoADT <T> otro){
        ConjuntoADT <T> nuevo = null;
        
        if(otro != null){
            nuevo = new ConjuntoA();
            une(nuevo, this.iterator());
            une(nuevo, otro.iterator());
        }
        return nuevo;
    }
    
    private void une(ConjuntoADT <T> nuevo, Iterator <T> it){
        if(it.hasNext()){
            nuevo.agrega(it.next());
            une(nuevo, it);
        }
    }
    
    public ConjuntoADT <T> interseccionRecursiva(ConjuntoADT <T> otro){
        ConjuntoADT <T> nuevo = null;
        
        if(otro != null){
            nuevo = new ConjuntoA();
            interseca(nuevo, otro, this.iterator());
        }
        return nuevo;
    }
    
    private void interseca(ConjuntoADT <T> nuevo, ConjuntoADT <T> otro, Iterator <T> it){
        if(it.hasNext()){
            T aux = it.next();
            if(otro.contiene(aux))
                nuevo.agrega(aux);
            interseca(nuevo, otro, it);
        }
    }
    
    public ConjuntoADT <T> diferenciaRecursiva(ConjuntoADT <T> otro){
        ConjuntoADT <T> nuevo = null;
        
        if(otro != null){
            nuevo = this;
            elimina(nuevo, otro.iterator());
        }
        return nuevo;
    }
    
    private void elimina(ConjuntoADT <T> nuevo, Iterator <T> it){
        if(it.hasNext()){
            T aux = it.next();
            if(nuevo.contiene(aux))
                nuevo.quita(aux);
            elimina(nuevo, it);
        }
    }
}