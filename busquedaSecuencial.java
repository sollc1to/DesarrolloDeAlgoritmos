
package com.mycompany.algoritmoordenamiento;


public class busquedaSecuencial {

    public static void main(String[] args) {
        int posicion;
        
        int [] arr = {1,5,25,7,3,2,6};
        
        posicion = busquedaSecuencial(arr,2);
        System.out.println(posicion);
        
        

    }

    public static int busquedaSecuencial(int[] arr, int numero) {
        int posicion = -1, n = 0;
        boolean encontrado = false;

        while (encontrado == false && n < arr.length) {

            if (arr[n] == numero) {
                encontrado = true;
                posicion = n;

            }
            else{
                n++;
            }
        }
        
        return posicion;

    }
}
