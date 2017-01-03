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
public class OperacionesPilas {
    
    public static <T> void mueveOtraPila(PilaADT <T> origen, PilaADT <T> destino){
        if(origen != null && destino != null){
            while(!origen.isEmpty())
                destino.push(origen.pop());
        }
    }
    
    public static String invierteCad(String cad){
        String resp = "";
        
        if(cad != null && cad.length() != 0){
            PilaA <Character> aux = new PilaA();
            
            for (int i = 0; i < cad.length(); i++) {
                aux.push(cad.charAt(i));
            }
            while(!aux.isEmpty())
                resp += aux.pop();
        }
        return resp;
    }
    
    public static <T> void inviertePila(PilaADT <T> pila){
        if(pila != null && !pila.isEmpty()){
            PilaADT <T> aux1 = new PilaA();
            PilaADT <T> aux2 = new PilaA();
            
            mueveOtraPila(pila, aux1);
            mueveOtraPila(aux1, aux2);
            mueveOtraPila(aux2, pila);
        }
    }
    
    public static <T> void quitaRepetidosConsecutivos(PilaADT <T> pila){
        if(pila != null && !pila.isEmpty()){
            PilaADT <T> aux = new PilaA();
            T dato;
            
            while(!pila.isEmpty()){
                dato = pila.pop();
                aux.push(dato);
                while(!pila.isEmpty() && pila.peek().equals(dato))
                    pila.pop();
            }
            mueveOtraPila(aux, pila);
        }
    }
}