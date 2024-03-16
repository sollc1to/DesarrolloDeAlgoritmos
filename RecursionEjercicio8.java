package com.mycompany.desarrollorecursividad;

import java.util.Scanner;

public class RecursionEjercicio8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String cadena, resultado;
        System.out.println("Ingrese una cadena para verificar si es palíndromo");
        cadena = sc.nextLine();

        resultado = verifPalind(cadena, cadena.length() - 1);
        System.out.println(resultado);

    }

    public static String verifPalind(String cadena, int longitud) {
        String cadenaAux = "";

        //Caso base
        if (longitud == 0) {
            cadenaAux = cadenaAux + cadena.charAt(0);

        } //Paso recursivo
        else {

            cadenaAux = cadena.charAt(longitud) + verifPalind(cadena, longitud - 1);
            System.out.println(cadenaAux);

        }

        //Verificación
        if (cadenaAux.length() == cadena.length()) {

            if (cadenaAux.equalsIgnoreCase(cadena)) {
                cadenaAux = "true";

            } else {
                cadenaAux = "false";
            }

        }

        return cadenaAux;

    }

}
