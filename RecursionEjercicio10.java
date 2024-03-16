package com.mycompany.desarrollorecursividad;

import java.util.Scanner;

public class RecursionEjercicio10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String texto = leerCadena();
        System.out.println(texto);

    }

    public static String leerCadena() {
        char caract;
        String cadena = "";
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un caracter");
        caract = sc.nextLine().charAt(0);

        if (caract == '.') {
            cadena = ".";

        } else {

            cadena = caract + leerCadena();
        }

        return cadena;

    }

}
