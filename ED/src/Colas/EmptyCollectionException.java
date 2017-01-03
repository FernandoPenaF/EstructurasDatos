
package Colas;

public class EmptyCollectionException extends RuntimeException{//Clase de Java

    public EmptyCollectionException() {
    }

    public EmptyCollectionException(String mensaje) {
        super(mensaje);
    }
    
}
