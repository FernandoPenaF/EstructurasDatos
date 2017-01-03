/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EstructurasEnlazadas;

import java.util.Iterator;

/**
 *
 * @author Fernando Peña
 */
public class EE <T> implements Iterable <T>{
    
    private Nodo <T> primero;
    
    public EE(){
        primero = null;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new IteradorEE(primero);
    }
    
    public boolean estaVacia(){
        return primero == null;
    }
    
    public void agregaInicio(T dato){
        Nodo <T> agregar = new Nodo(dato);
        
        agregar.setSiguiente(primero);
        primero = agregar;
    }
    
    public T quitaPrimero(){
        T resp = null;
        
        if(!estaVacia()){
            Nodo <T> aux = primero.getSiguiente();
            resp = primero.getDato();
            primero.setSiguiente(null);
            primero = aux;
        }
        return resp;
    }
    
    public void agregaFinal(T dato){
        Nodo <T> agregar = new Nodo(dato);
        
        if(estaVacia())
            primero = agregar;
        else{
            Nodo <T> actual = primero;
            while(actual.getSiguiente() != null)
                actual = actual.getSiguiente();
            actual.setSiguiente(agregar);
        }
    }
    
    public T quitaUltimo(){
        T resp = null;
        
        if(!estaVacia()){
            if(primero.getSiguiente() == null)
                resp = quitaPrimero();
            else{
                Nodo <T> actual = primero;
                while(actual.getSiguiente().getSiguiente() != null)
                    actual = actual.getSiguiente();
                resp = actual.getSiguiente().getDato();
                actual.setSiguiente(null);
            }
        }
        return resp;
    }
    
    public T busca(T dato){
        return busca(dato, primero);
    }
    
    private T busca(T dato, Nodo <T> primero){
        if(primero == null)
            return null;
        else
            if(primero.getDato().equals(dato))
                return primero.getDato();
            else
                return busca(dato, primero.getSiguiente());
    }
    
    public T dato(int pos){
        int cont = 1;
        Nodo <T> actual = primero;
        T resp = null;
        
        while(actual.getSiguiente() != null && cont < pos){
            actual.getSiguiente();
            cont++;
        }
        if(actual != null && cont == pos)
            resp = actual.getDato();
        return resp;
    }
    
    public T quitaDato(T dato){
        T resp = null;
        
        if(!estaVacia()){
            if(primero.getDato().equals(dato))
                resp = quitaPrimero();
            else{
                Nodo <T> anterior = primero;
                Nodo <T> actual = primero;
                while(actual != null && !actual.getDato().equals(dato)){
                    anterior = actual;
                    actual = actual.getSiguiente();
                }
                if(actual != null){
                    resp = actual.getDato();
                    anterior.setSiguiente(actual.getSiguiente());
                    actual.setSiguiente(null);
                }
            }
        }
        return resp;
    }
    
    public int contarNodos(){
        return contarNodos(0, primero);
    }
    
    private int contarNodos(int cont, Nodo <T> actual){
        if(actual == null)
            return cont;
        else
            return contarNodos(cont + 1, actual.getSiguiente());
    }
    
    @Override
    public String toString(){
        return toString(primero, "");
    }
    
    private String toString(Nodo <T> actual, String cad){
        if(actual == null)
            return cad;
        else{
            cad += actual.getDato() + "\n";
            return toString(actual.getSiguiente(), cad);
        }
    }
    
    //------------------Miscelanea de métodos-------------------------------------------
    public int eliminaRepetidosOrdenado(){
        return eliminaRepetidosOrdenado(primero, 0);
    }
    
    private int eliminaRepetidosOrdenado(Nodo <T> actual, int cont){
        if(actual == null)
            return cont;
        else{
            if(actual.getSiguiente() != null && actual.getDato().equals(actual.getSiguiente().getDato())){
                Nodo <T> aux = actual.getSiguiente();
                actual.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(null);
                cont++;
            }
            else
                actual = actual.getSiguiente();
            return eliminaRepetidosOrdenado(actual, cont);
        }
    }
    
    public int eliminaRepetidosDesordenada(){
        if(!estaVacia())
            return eliminaRepetidosDesordenada(primero, primero.getSiguiente(), primero, 0);
        else
            return 0;
    }
    
    private int eliminaRepetidosDesordenada(Nodo <T> bandera, Nodo <T> actual, Nodo <T> anterior, int cont){
        if(bandera == null || bandera.getSiguiente() == null)
            return cont;
        else{
            if(actual != null){
                if(actual.getDato().equals(bandera.getDato())){
                    anterior.setSiguiente(actual.getSiguiente());
                    actual.setSiguiente(null);
                    actual = anterior.getSiguiente();
                    return eliminaRepetidosDesordenada(bandera, actual, anterior, cont + 1);
                }
                else
                    return eliminaRepetidosDesordenada(bandera, actual.getSiguiente(), actual, cont);
            }
            else
                return eliminaRepetidosDesordenada(bandera.getSiguiente(), bandera.getSiguiente().getSiguiente(), bandera.getSiguiente(), cont);
        }
    }
    
    public boolean eliminaAnteriorA(T info){
        boolean resp = false;
        
        if(!estaVacia()){
            if(!primero.getDato().equals(info)){
                Nodo <T> actual = primero.getSiguiente();
                Nodo <T> anterior = primero;
                Nodo <T> aEliminar = primero;
                while(actual != null && !actual.getDato().equals(info)){
                    anterior = aEliminar;
                    aEliminar = actual;
                    actual = actual.getSiguiente();
                }
                if(actual != null){
                    if(aEliminar == primero)
                        quitaPrimero();
                    else{
                        anterior.setSiguiente(actual);
                        aEliminar.setSiguiente(null);
                    }
                    resp = true;
                }
            }
        }
        return resp;
    }
    
    public boolean eliminaSiguienteDe(T info){
        boolean resp = false;
        
        if(!estaVacia()){
            Nodo <T> actual = primero;
            while(actual != null && !actual.getDato().equals(info)){
                actual = actual.getSiguiente();
            }
            if(actual != null && actual.getSiguiente() != null){
                resp = true;
                Nodo <T> aEliminar = actual.getSiguiente();
                actual.setSiguiente(aEliminar.getSiguiente());
                aEliminar.setSiguiente(null);
            }
        }
        return resp;
    }
    
    public boolean insertaAntesQue(T refer, T info){
        boolean resp = false;
        
        if(!estaVacia()){
            if(primero.getDato().equals(refer)){
                resp = true;
                agregaInicio(info);
            }
            else{
                Nodo <T> actual = primero.getSiguiente();
                Nodo <T> anterior = primero;
                while(actual != null && !actual.getDato().equals(refer)){
                    anterior = actual;
                    actual = actual.getSiguiente();
                }
                if(actual != null){
                    Nodo <T> aInsertar = new Nodo(info);
                    anterior.setSiguiente(aInsertar);
                    aInsertar.setSiguiente(actual);
                    resp = true;
                }
            }
        }
        return resp;
    }
    
    public void borra(T dato){
        if(!estaVacia())
            if(primero.getDato().equals(dato)){
                Nodo <T> aux = primero;
                primero = primero.getSiguiente();
                aux.setSiguiente(null);
                borra(dato);
            }
            else
                borra(dato, primero.getSiguiente(), primero);
    }
    
    private void borra(T dato, Nodo <T> actual, Nodo <T> anterior){
        if(actual != null){
            if(!actual.getDato().equals(dato))
                borra(dato, actual.getSiguiente(), actual);
            else{
                Nodo <T> aux = actual;
                actual = actual.getSiguiente();
                anterior.setSiguiente(actual);
                aux.setSiguiente(null);
                borra(dato, actual, anterior);
            }    
        }
    }
}