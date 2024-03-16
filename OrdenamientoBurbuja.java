package com.mycompany.algoritmoordenamiento;

public class OrdenamientoBurbuja {

    public static void main(String[] args) {
        int[] arr = {1, 2,4,3,5,6};

        int[] arregloOrde = burbujaMejorado(arr);

        for (int i = 0; i < arregloOrde.length; i++) {

            System.out.print(arregloOrde[i] + " ");

        }

    }

    public static int[] ordenamientoBurbuja(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    arr = intercambiar(j, arr);

                }

            }

        }
        return arr;

    }

    public static int[] intercambiar(int j, int[] arreglo) {
        int aux = arreglo[j];

        arreglo[j] = arreglo[j + 1];

        arreglo[j + 1] = aux;

        return arreglo;

    }

    public static int[] burbujaMejorado(int[] arr) {

        int i = 0;

        boolean ordenado = false;
        while (i < arr.length - 1 && !ordenado) {
            ordenado = true;

            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    ordenado = false;
                    System.out.println(ordenado);
                    arr = intercambiar(j, arr);

                }

            }
            i++;

        }
        return arr;

    }

}
