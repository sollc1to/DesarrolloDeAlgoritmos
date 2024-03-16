package com.mycompany.desarrollorecursividad;

import java.util.Scanner;

public class RecursionEjercicio13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int filas, columnas;
        System.out.println("Ingrese el num de filas de su matriz");
        filas = sc.nextInt();
        System.out.println("Ingrese el num de columnas de su matriz");
        columnas = sc.nextInt();

        int[][] matriz = new int[filas][columnas];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("Ingrese el elemento " + i + j + " de su matriz");
                matriz[i][j] = sc.nextInt();

            }

        }

        int num = mayorNum(matriz, 0, 0);

        System.out.println(num);

    }

    public static int mayorNum(int[][] m, int f, int c) {
        int mayorNum = 0;

        //Caso base
        if (f == m.length - 1 && c == m[f].length - 1) {
            mayorNum = m[f][c];

        } else {
            if (c == m[f].length - 1) {
                mayorNum = mayorNum(m, f + 1, 0);

            } else {

                mayorNum = mayorNum(m, f, c + 1);

            }

            if (m[f][c] > mayorNum) {
                mayorNum = m[f][c];

            }

        }
        return mayorNum;

    }

}
