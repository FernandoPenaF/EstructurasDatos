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
public class EmptyCollectionException extends RuntimeException{

    public EmptyCollectionException() {
        super("Colección vacía");
    }

    public EmptyCollectionException(String message) {
        super(message);
    }
}