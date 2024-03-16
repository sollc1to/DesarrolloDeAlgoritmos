package com.mycompany.algoritmoordenamiento;

public class BusquedaBinaria {
    
    
    public static void main(String[] args) {
        int [] arr = {1,4,5,7,8,9,13,16,25,67};
        
        System.out.println(busquedaBinaria(arr,25));
        
        
        
    }

    public static int busquedaBinaria(int[] arr, int numero) {
        int medio = -1, inicio = 0, fin = arr.length - 1;

        boolean encontrado = false;

        while (encontrado == false && inicio < fin) {
            
            medio = (inicio + fin) / 2;
            
            if (numero < arr[medio]) {
                fin = medio - 1;

            } else {

                if (numero == arr[medio]) {
                    encontrado = true;
                

                } else {

                    inicio = medio + 1;
                }
            }

        }
        return medio;

    }

}
