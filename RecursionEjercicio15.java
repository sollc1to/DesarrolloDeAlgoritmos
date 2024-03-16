package com.mycompany.desarrollorecursividad;

import java.util.Scanner;

public class RecursionEjercicio15 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena;

        System.out.println("Ingrese una cadena");
        cadena = sc.nextLine();
        
        int vocales = sumarVocales(cadena, cadena.length()-1);
        
        System.out.println(vocales);

    }

    public static int sumarVocales(String texto, int longitud) {

        int contador = 0;

        //Caso Base
        if (longitud < 0) {
            contador = 0;

        } else {

            contador += sumarVocales(texto, longitud - 1);

            switch (texto.charAt(longitud)) {

                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    contador++;
                    break;
                default:
                    break;

            }

        }
        return contador;

    }

}
