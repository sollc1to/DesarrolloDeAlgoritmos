package com.mycompany.desarrollorecursividad;

import java.util.Scanner;

public class RecursionEjercicio9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int divisor, dividendo;

        System.out.println("Ingrese un divisor");
        divisor = sc.nextInt();
        System.out.println("Ingrese un dividendo");
        dividendo = sc.nextInt();

        System.out.println(divRest(divisor, dividendo));

    }

    public static int divRest(int divisor, int dividendo) {
        int resto, cociente = 1;

        resto = divisor - dividendo;

        if (resto < dividendo) {
            cociente = 1;

        } else {
            cociente = cociente + divRest(divisor - dividendo, dividendo);

        }
        return cociente;

    }

}
