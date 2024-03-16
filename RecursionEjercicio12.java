package com.mycompany.desarrollorecursividad;

import java.util.Scanner;

public class RecursionEjercicio12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char caracter;
        int tamaño;

        System.out.println("Ingrese el tamaño de su arreglo");
        tamaño = sc.nextInt();

        char[] arreglo = new char[tamaño];

        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Ingrese el elemento " + i);
            sc = new Scanner(System.in);

            caracter = sc.nextLine().charAt(0);

            arreglo[i] = caracter;

        }
        System.out.println("Ingrese un caracter que quiere verificar si se encuentra en el arreglo");
        caracter = sc.nextLine().charAt(0);
        
        boolean respuesta = verifCar(arreglo, caracter, arreglo.length-1);
        
        
        System.out.println(respuesta);
        
        
        
        

    }

    public static boolean verifCar(char[] arreglo, char caracter, int longitud) {

        boolean resultado;

        //Caso base
        if (longitud < 0) {
            resultado = false;

        } else {

            resultado = (arreglo[longitud] == caracter);
            System.out.println(resultado);

            if (resultado == false) {
                resultado = verifCar(arreglo, caracter, longitud - 1);

            }
            

        }
        return resultado;

    }

}
