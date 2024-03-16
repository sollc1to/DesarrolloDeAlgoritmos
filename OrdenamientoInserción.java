package com.mycompany.algoritmoordenamiento;

public class OrdenamientoInserción {
    
    public static void main(String[] args) {
        int [] arr = {1,5,23,6,8,3,0,2,9};
        int[] arreglo = ordenamientoInserción(arr);
        
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
            
        }
        
      
    }

    public static int[] ordenamientoInserción(int[] arr) {
        int posicion = 0, j = 0;

        for (int i = 1; i <= arr.length - 1; i++) {
            posicion = arr[i];
            j = i;

            while (j > 0 && posicion < arr[j - 1]) {
                arr[j] = arr[j - 1];
                
                j = j - 1;
            }
            
            
            arr[j] = posicion;

        }
        
        return arr;
       

    }

}
