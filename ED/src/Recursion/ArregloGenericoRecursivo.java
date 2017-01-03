/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Recursion;

/**
 *
 * @author Fernando Peña
 * @param <T>
 */
public class ArregloGenericoRecursivo <T extends Comparable <T> >{
    private T [] arreglo;
    private int total;
    private final int MAX = 50;
    
    public ArregloGenericoRecursivo(){
        arreglo = (T[]) new Comparable [MAX];
        total = 0;
    }
    
    public ArregloGenericoRecursivo(int max){
        arreglo = (T[]) new Comparable [max];
        total = 0;
    }

    public int getTotal() {
        return total;
    }
    
    public boolean alta(T dato){
        boolean resp = false;
        
        if(total < arreglo.length){
            arreglo[total] = dato;
            total++;
            resp = true;
        }
        return resp;
    }
    
    public T getElement(int i){
        if(i >= 0 && i < total)
            return arreglo[i];
        else
            throw new IndexOutOfBoundsException();
    }
    
    public int busquedaSecuencial(T dato){
        return busquedaSecuencial(dato,0);
    }
    
    private int busquedaSecuencial(T dato, int i){
        if(i == total)
            return -1;
        else{
            if(arreglo[i].equals(dato))
                return i;
            else
                return busquedaSecuencial(dato, i + 1);
        }
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        return toString(sb,0);
    }
    
    private String toString(StringBuilder sb, int i){
        if(i == total)
            return sb.toString();
        else
            return toString(sb.append(arreglo[i]).append("\n"), i + 1);
    }
    
    public int posMayor(){
        if(total == 0)
            return -1;
        else
            return posMayor(0,0);
    }
    
    public int posMayor(int mayor, int i){
        if(i == total)
            return mayor;
        else{
            if(arreglo[mayor].compareTo(arreglo[i]) < 0)
                mayor = i;
            return posMayor(mayor,i + 1);
        }
    }
    
    public int quitaTodos(T dato){
        return quitaTodos(dato,0,0);
    }
    
    public int quitaTodos(T dato, int i, int cont){
        if(i == total)
            return cont;
        else{
            if(arreglo[i].equals(dato)){
                arreglo[i] = arreglo[total - 1];
                arreglo[total - 1] = null;
                total--;
                cont++;
                return quitaTodos(dato, i, cont);
            }
            else
                return quitaTodos(dato, i + 1, cont);
        }
    }
    
}