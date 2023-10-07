package com.mycompany.mavenproject2;

import java.util.Scanner;

public class Mavenproject2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String palabra, mayorPalabra = "";
        int capicua = 0, cantVocales = 0;
        
        System.out.println("Ingrese una palabra, cuándo quiera terminar el programa"
                + "ingrese 'no' ");
        palabra = sc.nextLine();

        while (!palabra.equalsIgnoreCase("no")) {
            
            //Verifica si es capicua
            capicua = palabraCapicua(palabra);
            //Cuenta sus vocales
            cantVocales = cantidadVocales(palabra);
            //Verifica si es la mayor palabra
            if (palabra.length()> mayorPalabra.length()) {
                mayorPalabra = palabra;
                
            }
            
            
            System.out.println("Ingrese otra palabra");
            sc = new Scanner(System.in);
            palabra = sc.nextLine();
            
        }
        System.out.println("La cantidad de palabras capicuas es de " + capicua + ", la cantidad de palabras con mas de mas vocales"
                + "fue de  " + cantVocales + ", y la palabra de mayor longitud fue " + mayorPalabra);
    }
    

    public static int palabraCapicua(String palabra) {
        String palabraAuxiliar = "";
        int palabraCapicua = 0;

        for (int i = palabra.length(); i >= 0; i--) {
            palabraAuxiliar = palabraAuxiliar + palabra.charAt(i);

        }
        if (palabraAuxiliar.equals(palabra)) {
            palabraCapicua = palabraCapicua + 1;

        }
        return palabraCapicua;

    }

    public static int cantidadVocales(String palabra) {
        int vocales = 0, palabraMasVocales = 0;
        for (int i = 0; i < palabra.length(); i++) {
            switch (palabra.charAt(i)) {
                case 'a':
                    vocales = vocales + 1;
                    break;
                case 'e':
                    vocales = vocales + 1;
                    break;
                case 'i':
                    vocales = vocales + 1;
                    break;
                case 'o':
                    vocales = vocales + 1;
                    break;

                case 'u':
                    vocales = vocales + 1;
                    break;
                default:
                    break;

            }

        }
        if (vocales > 2) {
            palabraMasVocales = palabraMasVocales + 1;

        }
        return palabraMasVocales;

    }
}
