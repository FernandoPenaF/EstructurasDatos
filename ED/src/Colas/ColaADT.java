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
public interface ColaADT <T>{
    
    public T quita();
    public void agrega(T nuevo);
    public T primero();
    public boolean estaVacia();
    public boolean estaLlena();
    
}
