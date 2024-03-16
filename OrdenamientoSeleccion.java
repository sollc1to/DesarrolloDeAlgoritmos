package com.mycompany.algoritmoordenamiento;

public class OrdenamientoSeleccion {
    public static void main(String[] args) {
        
        int arr[] = {2,4,3,6,7,8,1,68,3,1,7};
        int[] arregloOrdenado = ordenamientoSeleccion(arr);
        
        for (int i = 0; i < arregloOrdenado.length; i++) {
            System.out.print(arregloOrdenado[i] + " ");
            
            
        }
        
        
    }

    public static int[] ordenamientoSeleccion(int[] arr) {
        int min;

        for (int i = 0; i < arr.length-2; i++) {
            min = i;

            for (int j = i+1; j <= arr.length - 1; j++) {
                if (arr[j] < arr[min]) {
                    min = j;

                }

            }
            
            arr = intercambiar(i,min,arr);

        }
        return arr;

    }

    public static int[] intercambiar(int i, int min, int[] arreglo) {
        int aux = arreglo[i];

        arreglo[i] = arreglo[min];

        arreglo[min] = aux;

        return arreglo;

    }

}
