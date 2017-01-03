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
public class Recursion {

    public static int sumaArreglo(int [] arre){
        return sumaArreglo(arre, 0);
    }
    
    private static int sumaArreglo(int [] arre, int i){
        if(i == arre.length - 1)
            return arre[i];
        else
            return arre[i] + sumaArreglo(arre, i + 1);
    }
    
    public static String impIaD(int [] arre){
        return impIaD(arre, 0, "");
    }
    
    private static String impIaD(int [] arre, int i, String cad){
        if(i == arre.length - 1)
            return cad += arre[i];
        else{
            cad += arre[i] + ", ";
            return impIaD(arre,i + 1, cad);
        }
    }
    
    public static String impDaI(int [] arre){
        return impDaI(arre, arre.length - 1, "");
    }
    
    private static String impDaI(int [] arre, int i, String cad){
        if(i == 0)
            return cad += arre[i];
        else{
            cad += arre[i] + ", ";
            return impDaI(arre, i - 1, cad);
        }
    }
    
    public static double calculaPotencia(double num, int exp){
        if(exp == 0 && num == 0)
            throw new UnsupportedOperationException("Operación no definida");
        if(exp == 0)
            return 1;
        else
            return calculaPotencia(num, exp, 1);
    }
    
    private static double calculaPotencia(double num, int exp, double resp){
        if(exp == 0)
            return resp;
        else
            return calculaPotencia(num, exp - 1, resp * num);   
    }
    
    public static int cuantasVeces(String cad, char carac){
        if(cad.length() == 0)
            return 0;
        else
            return cuantasVeces(cad,carac,cad.length() - 1,0);
    }
    
    private static int cuantasVeces(String cad, char carac, int i, int cont){
        if(i < 0)
            return cont;
        else{
            if(cad.charAt(i) == carac)
                cont++;
            return cuantasVeces(cad, carac, i - 1, cont);
        }
    }
    
    public static int cuentaDigitos(int num){
        if(num / 10 == 0)
            return 1;
        else
            return 1 + cuentaDigitos(num / 10);
    }
}