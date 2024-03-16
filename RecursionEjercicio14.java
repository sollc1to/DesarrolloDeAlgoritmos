package com.mycompany.desarrollorecursividad;

import java.util.Scanner;

public class RecursionEjercicio14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fila, columna, elemento;

        System.out.println("Ingrese la fila de su matriz");
        fila = sc.nextInt();
        System.out.println("Ingrese las columnas");
        columna = sc.nextInt();

        int[][] m = new int[fila][columna];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {

                System.out.println("Ingrese el elemento " + i + j);

                m[i][j] = sc.nextInt();

            }

        }
        iteraColumnas(m, 0, 0);

    }

    public static int iteraFilas(int[][] matriz, int fila, int columna) {
        int suma = 0;

        if (fila >= 0 && fila < matriz.length) {
            suma = suma + iteraFilas(matriz, fila + 1, columna);

            suma = suma + matriz[fila][columna];

        } else {
            suma = 0;
        }

        return suma;
    }

    public static void iteraColumnas(int[][] matriz, int fila, int columna) {
        int suma = 0;

        if (columna >= 0 && columna < matriz[fila].length) {
            suma = iteraFilas(matriz, fila, columna);
            System.out.println("La suma de la fila " + columna + " es " + suma);

            iteraColumnas(matriz, fila, columna + 1);

        } else {

            suma = 0;
        }

    }

}
