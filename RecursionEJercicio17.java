package com.mycompany.desarrollorecursividad;

import java.util.Scanner;

public class RecursionEJercicio17 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;

        System.out.println("Ingrese el numero de su pirámide");
        numero = sc.nextInt();
        
        imprimirPiramide(numero);

    }

    public static String formarPiramide(int n) {
        String cadena = "";

        if (n > 0) {
            cadena = cadena + n;
            cadena = cadena + formarPiramide(n - 1);

        } else {
            cadena = "";
        }
        return cadena;

    }

    public static void imprimirPiramide(int n) {
        String cadena;
        if (n > 0) {
            imprimirPiramide(n - 1);
            cadena = formarPiramide(n);
            System.out.println(cadena);
        
            

        }

    }
}
