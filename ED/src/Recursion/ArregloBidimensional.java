/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Recursion;

/**
 *
 * @author Fernando Peña
 */
public class ArregloBidimensional {
    
    public static int sumaPorRenglones(int arre[][]){
        return sumaPorRenglones(arre, 0, 0, 0);
    }
    
    private static int sumaPorRenglones(int arre[][], int ren, int col, int suma){
        if(ren == arre.length)
            return suma;
        else{
            suma += arre[ren][col];
            if(col == arre[0].length - 1)
                return sumaPorRenglones(arre, ren + 1, 0, suma);
            else
                return sumaPorRenglones(arre, ren, col + 1, suma);
        }
    }
    
    public static int sumaPorColumnas(int arre[][]){
        return sumaPorColumnas(arre, 0, 0, 0);
    }
    
    private static int sumaPorColumnas(int arre[][], int ren, int col, int suma){
        if(col == arre[0].length)
            return suma;
        else{
            suma += arre[ren][col];
            if(ren == arre.length - 1)
                return sumaPorColumnas(arre, 0, col + 1, suma);
            else
                return sumaPorColumnas(arre, ren + 1, col, suma);
        }
    }
    
    public static int sumaDiagonalPrincipal(int arre[][]){
        return sumaDiagonalPrincipal(arre, 0, 0, 0);
    }
    
    private static int sumaDiagonalPrincipal(int arre[][], int ren, int col, int suma){
        if(ren == arre.length)
            return suma;
        else{
            suma += arre[ren][col];
            return sumaDiagonalPrincipal(arre, ren + 1, col + 1, suma);
        }
    }
    
    public static int sumaDiagonalSecundaria(int arre[][]){
        int col = arre[0].length - 1;
        return sumaDiagonalSecundaria(arre, 0, col, 0);
    }
    
    private static int sumaDiagonalSecundaria(int arre[][], int ren, int col, int suma){
        if(ren == arre.length)
            return suma;
        else{
            suma += arre[ren][col];
            return sumaDiagonalSecundaria(arre, ren + 1, col - 1, suma);
        }
    }
    
    public static String toString(int arre[][]){
         return toString(arre, 0, 0, "");
    }
    
    private static String toString(int arre[][], int ren, int col, String cad){
        if(ren == arre.length)
            return cad;
        else{
            if(col == arre[0].length - 1){
                cad += arre[ren][col] + "\n";
                return toString(arre, ren + 1, 0, cad);
            }
            else{
                cad += arre[ren][col] + ", ";
                return toString(arre, ren, col + 1, cad);
            }  
        }
    }
}
