package com.mycompany.matrices_desarrollo;
import java.util.Scanner;

public class Matrices_Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int promedio, alumno;
        String decision;
        int [][] notasAlumnos = new int [10][6];

        for (int i = 0; i < notasAlumnos.length; i++) {
            for (int j = 0; j < notasAlumnos[0].length; j++) {
                notasAlumnos[i][j] = (int)Math.floor(Math.random()*10+1);
            }
            
        }
        for (int i = 0; i < notasAlumnos.length; i++) {
            System.out.println("Alumno " + i + ":");
            for (int j = 0; j < notasAlumnos[0].length; j++) {
                System.out.print(notasAlumnos[i][j]);
                
            }
            System.out.println("");
            
        }
        System.out.println("¿Qué función quiere realizar?");
        System.out.println("Ingrese 'promedio' para calcular el promedio total.");
        System.out.println("Ingrese 'alumno' para mostrar las notas de un determinado alumno.");
        System.out.println("Ingrese 'mayor nota' para mostrar la mayor nota del último examen.");
        System.out.println("Ingrese 'terminar' para finalizar el programa.");
        decision = sc.nextLine();
        decision = decision.toLowerCase();
        
        while(!"terminar".equals(decision)){
            switch (decision) {
                case "promedio":
                    promedio = calcularPromedio(notasAlumnos);
                    System.out.println("El promedio total de las  notas es de " + promedio + " puntos.");
                    break;
                case "alumno":
                    System.out.println("¿De que alumno desea ver las notas?");
                    alumno = sc.nextInt();
                    mostrarNotasAlumno(notasAlumnos,alumno);
                    break;
                case "mayor nota":
                    mayorNota(notasAlumnos);
                    break;
                default:
                    break;
            }
            
            System.out.println("¿Que función quiere realizar?");
            decision = sc.nextLine();
        
        }
        
        
      
            
            
        }
    
    public static int calcularPromedio(int [][] unaMatriz){
        int promedio = 0; 
        
        for (int i = 0; i < unaMatriz.length; i++) {
            for (int j = 0; j < unaMatriz[0].length ; j++) {
                promedio = promedio + unaMatriz[i][j]; 
                
                
            }
            
        }
        promedio = promedio/unaMatriz.length;
        
        return promedio;
        
        
    }
     public static void mostrarNotasAlumno(int[][] unaMatriz, int unAlumno){
         for (int i = unAlumno; i <= unAlumno; i++) {
             System.out.println("Las notas del alumno " + i + " son:");
             for (int j = 0; j < unaMatriz[0].length; j++) {
                 System.out.println(unaMatriz[i][j]);
                 
                 
             }
             
         }
         
     }
     
     public static void mayorNota(int [][] unaMatriz){
         int mayorNota = 0;
         for (int i = 0; i < unaMatriz.length; i++) {
             for (int j = 5; j <= unaMatriz[0].length; j++) {
                 if (unaMatriz[i][5] > mayorNota) {
                     mayorNota = unaMatriz[i][j];
                     
                     
                 }
                 
             }
             
         }
         System.out.println("La mayor nota fue de " + mayorNota);
         
     }
        
        
        
        
}
