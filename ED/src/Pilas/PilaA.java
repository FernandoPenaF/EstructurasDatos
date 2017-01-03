/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pilas;

/**
 *
 * @author Fernando Peña
 */
public class PilaA <T> implements PilaADT <T>{
    
    private T pila[];
    private int tope;
    private final int MAX = 50;

    public PilaA(){
        pila = (T[])new Object[MAX];
        tope = -1; //la pila esta vacia
    }
    
    public PilaA(int max){
        pila = (T[])new Object[max];
        tope = -1;
    }
    
    @Override
    public boolean isEmpty(){
        return tope == -1;
    }
    
    @Override
    public void push(T dato){
        if(tope == pila.length - 1)
            expandCapacity(pila.length * 2);
        tope++;
        pila[tope] = dato;
    }
    
    @Override
    public T pop(){
        if(!isEmpty()){
            T result = pila[tope];
            pila[tope] = null;
            tope--;
            return result;
        }
        throw new EmptyCollectionException("Pila vacia"); 
    }
    
    @Override
    public T peek(){
        if(!isEmpty())
            return pila[tope];
        throw new EmptyCollectionException("Pila vacia");
    }
    
    public boolean equals(Object otro){
        boolean resp = false;
        
        if(otro != null && otro instanceof PilaA){
            PilaA <T> comp = (PilaA) otro;
            if(tope != comp.tope)
                return resp;
            else
                resp = equals(comp,0);
        }
        return resp;
    }
    
    private boolean equals(PilaA <T> p, int i){
        if(tope >= i)
            if(pila[i].equals(p.pila[i]))
                return equals(p,i + 1);
            else
                return false;
        else
            return true;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = tope; i >= 0; i--) {
            sb.append(pila[i]).append("\n");
        }
        return sb.toString();
    }
    
    private void expandCapacity(int n){
        T nuevo[] = (T[]) new Object [n];
        for(int i = 0; i <= tope; i++)
            nuevo[i] = pila[i];
        pila = nuevo;
    }
}