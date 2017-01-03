/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Colas;

import pilas.*;

/**
 *
 * @author Fernando Peña
 */
public class OperacionesColas {

    public static <T> String toString(ColaADT <T> cola){
        String resp = "";
        
        if(cola != null && !cola.estaVacia()){
            ColaADT <T> aux = new ColaA();
            T dato;
            
            while(!cola.estaVacia()){
                dato = cola.quita();
                resp += dato + ", ";
                aux.agrega(dato);
            }
            resp = resp.substring(0, resp.length() - 2);
            mueveOtraCola(aux, cola);
        }
        return resp;
    }
    
    public static <T> void mueveOtraCola(ColaADT <T> origen, ColaADT <T> destino){
        if(origen != null && destino != null)
            while(!origen.estaVacia())
                destino.agrega(origen.quita());
    }
    
    public static <T> void invierteCola(ColaADT <T> cola){
        if(cola != null && !cola.estaVacia()){
            PilaADT <T> aux = new PilaA();
            
            while(!cola.estaVacia())
                aux.push(cola.quita());
            while(!aux.isEmpty())
                cola.agrega(aux.pop());
        }
    }
    
    public static <T> void quitaRepetidosConsecutivos(ColaADT <T> cola){
        if(cola != null && !cola.estaVacia()){
            T dato;
            ColaADT <T> aux = new ColaA();
            
            while(!cola.estaVacia()){
                dato = cola.quita();
                aux.agrega(dato);
                while(!cola.estaVacia() && cola.primero().equals(dato))
                    cola.quita();
            }
            mueveOtraCola(aux, cola);
        }
    }
    
    public static <T> void quitaRepetidosConsecutivosRec(ColaADT <T> cola){
        if(cola != null && !cola.estaVacia()){
            ColaADT <T> nueva = new ColaA();
            T dato;
            
            dato = cola.quita();
            nueva.agrega(dato);
            quitaRepetidosConsecutivosRec(cola, nueva, dato);
            mueveOtraCola(nueva, cola);
        }
    }
    
    private static <T> void quitaRepetidosConsecutivosRec(ColaADT <T> cola, ColaADT <T> otra, T dato){
        if(!cola.estaVacia()){
            if(dato.equals(cola.primero())){
                cola.quita();
                quitaRepetidosConsecutivosRec(cola, otra, dato);
            }
            else{
                T aux = cola.quita();
                otra.agrega(aux);
                quitaRepetidosConsecutivosRec(cola, otra, aux);
            }
        }
    }
    
    public static <T> void eliminaDato(ColaADT <T> cola, T dato){
        if(cola != null && !cola.estaVacia() && dato != null){
            ColaADT <T> aux = new ColaA();
            T compara;
            
            while(!cola.estaVacia()){
                compara = cola.quita();
                if(!dato.equals(compara))
                    aux.agrega(compara);
            }
            mueveOtraCola(aux, cola);
        }
    }
    
    public static <T> void eliminaDatoRec(ColaADT <T> cola, T dato){
        if(cola != null && !cola.estaVacia() && dato != null){
            ColaADT <T> aux = new ColaA();
            eliminaDatoRec(cola, dato, aux);
            mueveOtraCola(aux, cola);
        }
    }
    
    private static <T> void eliminaDatoRec(ColaADT <T> cola, T dato, ColaADT <T> aux){
        if(!cola.estaVacia()){
            T comparar = cola.quita();
            
            if(!dato.equals(comparar))
                aux.agrega(comparar);
            eliminaDatoRec(cola, dato, aux);
        }
    }
}