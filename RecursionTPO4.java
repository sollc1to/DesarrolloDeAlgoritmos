package com.mycompany.desarrollorecursividad;

import java.util.Scanner;

public class RecursionTPO4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase, jeringozo;

        System.out.println("Ingrese una frase");
        frase = sc.nextLine();
        
        jeringozo = jeringoza(frase, frase.length()-1);
        System.out.println(jeringozo);
     

    }

    public static String jeringoza(String cadena, int length) {
        String jeringozo = "";

        if (length < 0) {
            jeringozo = "";

        } else {

            jeringozo = jeringozo + jeringoza(cadena, length - 1);

            switch (cadena.charAt(length)) {
                case 'a':
                    jeringozo = jeringozo + "apa";
                    break;
                case 'e':
                    jeringozo = jeringozo + "epe";
                    break;
                case 'i':
                    jeringozo = jeringozo + "ipi";
                    break;

                case 'o':
                    jeringozo = jeringozo + "opo";
                    break;

                case 'u':
                    jeringozo = jeringozo + "upu";
                    break;
                default:
                    jeringozo = jeringozo + cadena.charAt(length);
                    break;

            }

        }
        return jeringozo;

    }

}
