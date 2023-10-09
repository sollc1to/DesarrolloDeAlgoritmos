package com.mycompany.mavenproject1;

import java.util.Scanner;

public class Mavenproject1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String frase = "", palabra = "", palabraAuxiliar = "";
        int  cantidadR = 0;

        //Usuario ingresa frase y palabra
        System.out.println("Ingrese una frase");
        frase = sc.nextLine();
        System.out.println("Ingrese una palabra");
        palabra = sc.nextLine();

        frase = frase + "";

        //For de comparación
        for (int i = 0; i < frase.length(); i++) {
            //Crea una palabra auxiliar
            

            if (frase.charAt(i) != ' ') {
                palabraAuxiliar = palabraAuxiliar + frase.charAt(i);
               
               
                }
            else{
                  //Compara palabra auxiliar y palabra ingresada
                
                if (palabraAuxiliar.equals(palabra)) {
                    cantidadR = cantidadR + 1;
                
                 }
                
                palabraAuxiliar = "";

               
            }

            

        }
        if (cantidadR > 0) {
            System.out.println("La palabra se repite " + cantidadR + " veces");

        } else {
            System.out.println("La palabra no se repite");
        }

    }

}
