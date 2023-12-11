
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class TrabajoFinalDesarrollo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String promedio, accion;
        int grado, vacantes, posicion, legaj, contador = 0;

        Alumno[] egresados = new Alumno[500];
        Alumno[][] nuevaMatrizAlumnos = new Alumno[7][30];
        Alumno[] alumnosIngresantes = cargarAlumnosArreglo("src/ListaIngresantes.txt");

        Alumno[] alumnosDesaprobados = cargarAlumnosArreglo("src/ListaDesaprobados.txt");

        Alumno[][] matrizAlumnos = crearMatrizAlumnos("src/ListaAlumnos.txt");

        System.out.println("Este es un menú para realizar operaciones :)");

        imprimirMenu();

        accion = sc.nextLine();
        accion = accion.toLowerCase();

        while (!accion.equals("no")) {

            switch (accion) {
                case "pasar año":
                    contador++; //Declaro un contador para el pasaje de año, si es la primera vez que se pasa de año, utilizo la matriz principal, 
                    //si no, utilizo la nueva matriz.

                    if (contador > 1) {
                        egresados = AlumnosEgresados(nuevaMatrizAlumnos, egresados, alumnosDesaprobados);
                        nuevaMatrizAlumnos = pasajeDeAñoAlumnos(nuevaMatrizAlumnos, alumnosDesaprobados, alumnosIngresantes);

                    } else {

                        egresados = AlumnosEgresados(matrizAlumnos, egresados, alumnosDesaprobados);
                        nuevaMatrizAlumnos = pasajeDeAñoAlumnos(matrizAlumnos, alumnosDesaprobados, alumnosIngresantes);

                    }

                    System.out.println("Alumnos:");
                    imprimirMatriz(nuevaMatrizAlumnos);
                    System.out.println("Egresados:");
                    imprimirArreglo(egresados);

                    break;
                case "promedio":
                    if (contador >= 1) { //Si ya se utilizó la función 'pasaje de año', utilizo la nueva matriz.
                        promedio = calcularPromedio(nuevaMatrizAlumnos, 0);

                    } else { //Si no, utilizo la matriz principal.
                        promedio = calcularPromedio(matrizAlumnos, 0);

                    }

                    System.out.println(promedio);
                    break;

                case "ordenar":
                    System.out.println("Ingrese el grado que quiere ordenar de forma ascendente.");
                    grado = sc.nextInt();
                    if (grado >= 1 && grado <= 7) { //Verifico que el grado esté dentro del rango.
                        nuevaMatrizAlumnos = ordenarAlumnos(matrizAlumnos, grado);
                        imprimirGradoMatriz(nuevaMatrizAlumnos, grado);

                    } else {
                        System.out.println("El grado ingresado no es válido. :(");

                    }

                    break;

                case "promedioe":
                    egresados = ordenarPromedio(egresados);
                    imprimirArreglo(egresados);
                    break;

                case "vacantes":
                    if (contador >= 1) { //Si se realizó la función de pasaje de año, utilizo la nueva matriz.
                        vacantes = calcularVacantes(nuevaMatrizAlumnos, 0, 0);

                    } else {
                        vacantes = calcularVacantes(matrizAlumnos, 0, 0);

                    }

                    System.out.println("El total de vacantes es " + vacantes);
                    break;

                case "nuevo":
                    matrizAlumnos = cargarAlumno(matrizAlumnos);

                    break;
                case "encontrar":
                    System.out.println("Ingrese el legajo del alumno");
                    legaj = sc.nextInt();
                    System.out.println("Ingrese el grado del alumno");
                    grado = sc.nextInt();
                    if (grado >= 1 && grado <= 7) {
                        posicion = buscarAlumno(matrizAlumnos, legaj, grado);
                        System.out.println("El alumno se encuentra en la posición " + posicion);

                    } else {
                        System.out.println("El grado ingresado no es válido. :(");
                    }

                    break;
                case "imprimir":
                    imprimirMenu();

                    break;

                default:
                    break;

            }
            System.out.println("¿Qué acción quiere realizar?");
            accion = sc.nextLine();
            accion.toLowerCase();

        }

    }

    //Ejercicio 1. Carga de Alumnos en las estructuras adecuadas.//-
    public static Alumno[][] crearMatrizAlumnos(String ruta) {
        //Este módulo crea y retorna una matriz dónde carga el archivo 'alumnos.txt'.
        Alumno[][] matriz = new Alumno[7][30];
        Alumno alumno;
        String cadena;
        FileReader archivo;
        BufferedReader lector;
        int i = 0;
        boolean carga = false;

        try {
            archivo = new FileReader(ruta);
            lector = new BufferedReader(archivo);

            while ((cadena = lector.readLine()) != null) {
                //Creo mí objeto alumno.

                alumno = crearAlumno(cadena);

                while (carga == false && i < matriz[0].length) {//Evaluación que no se vaya de rango

                    if (matriz[alumno.getGrado() - 1][i] == null) { //Verifico que la posicón sea nula.
                        matriz[alumno.getGrado() - 1][i] = alumno;
                        carga = true;

                    }
                    i++;

                }
                //Reinicio 'i' y 'carga', para continuar con el siguiente alumno.
                i = 0;
                carga = false;

            }

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());

        }

        return matriz;

    }

    public static Alumno[] cargarAlumnosArreglo(String ruta) {
        //Este módulo crea y retorna un arreglo el cual cargo los archivos 'alumnosIngresantes.txt'
        //o 'alumnosDesaprobados.txt'
        Alumno[] arr = new Alumno[62];

        String cadena;
        FileReader archivo;
        BufferedReader lector;
        int i = 0;

        try {

            archivo = new FileReader(ruta);
            lector = new BufferedReader(archivo);

            if (ruta.equals("src/ListaDesaprobados.txt")) {
                //Si la lista equivale a la de 'desaprobados', solo tengo que cargar el legajo de ellos.

                while ((cadena = lector.readLine()) != null && i != arr.length) {
                    arr[i] = new Alumno(Integer.parseInt(cadena));
                    i++;

                }

            } else {
                //Si no es la lista de desaprobados, entonces debo cargar todos los atributos de mi objeto alumno.

                while ((cadena = lector.readLine()) != null && i != arr.length) {
                    arr[i] = crearAlumno(cadena);
                    i++;

                }

            }

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());

        }
        return arr;

    }

    public static Alumno crearAlumno(String cadena) {
        //En este módulo creo un objeto 'alumno' a partir de la posición de la cadena actual.
        //Como los atributos del objeto alumno están ordenados, usé el siguiente método haciendo uso del orden.

        String arreglo[] = cadena.split(";"); //Guardo cada atributo en un arreglo de 4 posiciones.

        Alumno alumno;

        //Asigno a cada atributo el orden correspondiente del arreglo.
        alumno = new Alumno(arreglo[0], arreglo[1], Integer.parseInt(arreglo[2]), Integer.parseInt(arreglo[3]), Integer.parseInt(arreglo[4]));

        return alumno;

    }

    //Ejercicio 2. Pasaje de grado a los alumnos.//
    //Primero realizo el pasaje de egresados a el arreglo correspondiente, entonces
    //en el pasaje de grado no voy a perder ningún alumno egresado.
    public static Alumno[] AlumnosEgresados(Alumno[][] alumnos, Alumno[] egresados, Alumno[] desaprobados) {
        int j = 0;
        boolean carga = false;

        for (int i = 0; i < alumnos[6].length; i++) { //Recorre la última fila de la matriz completa.

            if (alumnos[6][i] != null && alumnosDesaprobados(alumnos[6][i], desaprobados) == false) {
                //Busco un alumno que no esté desaprobado.

                while (carga == false && j < egresados.length) {

                    if (egresados[j] != null) {
                        j++;

                    } else {
                        //Busco la posición nula del arreglo de egresados, y le asigno el alumno
                        //que no está desaprobado.

                        egresados[j] = alumnos[6][i];
                        egresados[j].egresado();
                        alumnos[6][i] = null; //Quito el alumno egresado de la matriz.

                        carga = true;

                    }

                }
                carga = false; //Reinicio la variable carga.

            }

        }

        return egresados;

    }

    public static Alumno[][] pasajeDeAñoAlumnos(Alumno matriz[][], Alumno desaprobados[], Alumno[] ingresantes) {
        //Este módulo se encarga de pasar de año a los alumnos correspondientes, y
        //realizar el ingreso de nuevos alumnos.
        Alumno[][] nuevaMatriz = new Alumno[7][30];
        Alumno alumno;

        int j = 0;

        for (int i = 0; i < matriz.length - 1; i++) { // i < matriz.length-1 para que no llegue a la última fila y se pase de rango.

            while (j < matriz[i].length && matriz[i][j] != null) {
                alumno = matriz[i][j];

                if (alumnosDesaprobados(alumno, desaprobados) == false) {//Verifico que el alumno no sea repitente.
                    alumno.pasarAño();
                    nuevaMatriz = asignarAlumno(nuevaMatriz, alumno, i + 1); //Asigno el alumno al grado siguiente.

                } else {

                    nuevaMatriz = asignarAlumno(nuevaMatriz, alumno, i);  //Si el alumno es desaprobado, no pasa de grado.
                }
                j++;

            }
            j = 0;

        }
        //Luego de pasar de año, llamo al módulo 'ingresarAlumnos' para ingresar alumnos en los grados correspondientes.

        nuevaMatriz = ingresarAlumnos(nuevaMatriz, ingresantes);

        return nuevaMatriz;

    }

    public static Alumno[][] asignarAlumno(Alumno[][] matriz, Alumno alumno, int grado) {
        //Este módulo tiene utilidad para ir reacomodando los alumnos de manera que no queden espacios nulos entre ellos.
        int i = 0;
        boolean asignacion = false;

        while (asignacion == false && i < matriz[grado].length) {
            if (matriz[grado][i] == null) {
                matriz[grado][i] = alumno;
                asignacion = true;

            }
            i++;

        }
        return matriz;

    }

    public static Alumno[][] ingresarAlumnos(Alumno[][] matriz, Alumno[] ingresantes) {
        //Este módulo se encarga de ingresar los alumnos según la cantidad que corresponda.

        //Primero ingreso los alumnos de grado uno, ya que no tienen un límite de ingresantes.
        matriz = alumnosGradoUno(matriz, ingresantes);

        int j = 0, cantAlumnos = 0;
        Alumno alumno;

        for (int i = 1; i < matriz.length; i++) { //Recorro desde la fila '1', ya que la '0' la modifiqué anteriormente.

            while (j < matriz[i].length && cantAlumnos <= 3) {

                if (matriz[i][j] == null) { //Si la posición es nula, entonces busco un alumno y lo asigno ( si es != null)
                    alumno = obtenerAlumno(ingresantes, i + 1);
                    if (alumno != null) {

                        ingresantes = quitarIngresante(alumno, ingresantes); //Quito el alumno del arreglo 'ingresantes'.

                        matriz[i][j] = alumno;
                        cantAlumnos++;
                    }

                }
                j++;

            }
            //Reinicio 'j' y 'cantAlumnos' para continuar con la siguiente fila.
            j = 0;
            cantAlumnos = 0;

        }

        return matriz;

    }

    public static Alumno[][] alumnosGradoUno(Alumno matriz[][], Alumno ingresantes[]) {
        //Este módulo ingresa alumnos del grado uno a la matriz, sin un límite de alumnos.

        Alumno alumno;

        for (int j = 0; j < matriz[0].length; j++) {
            if (matriz[0][j] == null) { //Si la posición es nula, entonces busca un alumno.
                alumno = obtenerAlumno(ingresantes, 1);

                if (alumno != null) { //Si el alumno != null, debo quitarlo del arreglo 'ingresantes'.

                    ingresantes = quitarIngresante(alumno, ingresantes);

                    matriz[0][j] = alumno;

                }

            }

        }

        return matriz;

    }

    public static Alumno obtenerAlumno(Alumno[] ingresantes, int grado) {
        //Este módulo se encarga de encontrar un alumno del grado pasado por parámetro.
        int i = 0;
        Alumno alumno = null; //Inicializo en null ya que me exige inicializar en algún valor.

        boolean encontrado = false;

        while (i < ingresantes.length && encontrado == false) {

            //Busco un alumno del grado pasado por parámetro.
            if (ingresantes[i] != null && ingresantes[i].getGrado() == grado) {
                alumno = ingresantes[i];

                encontrado = true;

            } else {
                i++;

            }

        }

        return alumno;

    }

    public static Alumno[] quitarIngresante(Alumno alumno, Alumno[] ingresantes) {
        int i = 0;
        boolean anulado = false;

        while (i < ingresantes.length && anulado == false) {

            if (ingresantes[i] != null && alumno.equals(ingresantes[i])) {
                //Busco el mismo alumno en el arreglo 'ingresantes', y si lo es
                //entonces anulo esa posición.

                ingresantes[i] = null;
                anulado = true;

            }

            i++;

        }
        return ingresantes;

    }

    public static boolean alumnosDesaprobados(Alumno unAlumno, Alumno[] desaprobados) {
        //Este módulo se encarga de determinar si un alumno es o no desaprobado.

        boolean desaprobado = false;
        int i = 0;
        while (desaprobado == false && i < desaprobados.length && desaprobados[i] != null) {

            if (unAlumno.equals(desaprobados[i])) {

                desaprobado = true;

            }
            i++;

        }
        return desaprobado;

    }

    //Ejercicio 3.
    //Calculo el promedio de toda la matriz de alumnos de forma recursiva.
    public static String calcularPromedio(Alumno[][] matriz, int f) {
        //Este módulo calcula el promedio de toda la matriz.

        String cadenaProm;
        int prom;

        if (f == matriz.length - 1) {

            prom = recorrerFilas(matriz, f, 0);

            cadenaProm = " Promedio Grado nro. 7 es:" + Integer.toString(prom);

        } else {
            prom = recorrerFilas(matriz, f, 0);

            cadenaProm = "Promedio grado nro. " + Integer.toString(f + 1) + " es: " //Realizo un String con todos los promedios.
                    + Integer.toString(prom) + " ";

            cadenaProm = cadenaProm + calcularPromedio(matriz, f + 1); // Llamo al siguiente grado.

        }
        return cadenaProm;

    }

    public static int recorrerFilas(Alumno[][] matriz, int f, int c) {
        //Este módulo recorre las filas de la matriz. (Calcula el promedio por fila)

        int sumaPromedios = 0;
        int alumnos;

        if (c == matriz[f].length - 1) {
            if (matriz[f][c] != null) { //Verifico que matriz[f][c] != null.
                sumaPromedios = matriz[f][c].getPromedio();

            }

        } else {

            if (matriz[f][c] != null) {
                sumaPromedios = matriz[f][c].getPromedio();

            }
            sumaPromedios = sumaPromedios + recorrerFilas(matriz, f, c + 1);

            if (c == 0) { //Si c == 0, calculo la cantidad de alumnos de esta fila para poder
                //realizar promedio/cantidadAlumnos.
                alumnos = calcularCantAlumn(matriz, f, 0);

                sumaPromedios = sumaPromedios / alumnos;

            }

        }
        return sumaPromedios;

    }

    public static int calcularCantAlumn(Alumno[][] matriz, int f, int c) {
        //En este módulo calculo la cantidad de alumnos de cada fila.
        int cantAlumnos = 0;

        if (c == matriz[f].length - 1) {
            if (matriz[f][c] != null) {
                cantAlumnos = 1;

            }

        } else {

            if (matriz[f][c] != null) { //Verifico que sea != null.
                cantAlumnos = 1;

            }
            cantAlumnos = cantAlumnos + calcularCantAlumn(matriz, f, c + 1);

        }
        return cantAlumnos;

    }

    //Ejercicio 4.
    //Ordenar los alumnos por nombre y apellido de forma ascendente de un grado.
    //Utilizo el método de 'selección'.
    public static Alumno[][] ordenarAlumnos(Alumno[][] matriz, int grado) {
        grado = grado - 1;
        Alumno alumno;
        int maximo, j = 0;

        for (int i = 0; i < matriz[grado].length - 1; i++) {
            j = i + 1;

            while (matriz[grado][i] != null && matriz[grado][j] != null && j < matriz[grado].length) {

                if (matriz[grado][i].comparar(matriz[grado][j]) > 0) { //Si la comparación es > 0, quiere decir que este alumno 
                    //Debería ir más adelante en la matriz ordenada.

                    matriz = intercambiar(matriz, i, j, grado);

                }

                j++;

            }

        }

        return matriz;

    }

    public static Alumno[][] intercambiar(Alumno[][] matriz, int i, int j, int grado) {
        //Este módulo realiza el intercambio de dos posiciones.
        Alumno alumnoAux;

        alumnoAux = matriz[grado][i];

        matriz[grado][i] = matriz[grado][j];

        matriz[grado][j] = alumnoAux;

        return matriz;

    }

    //Ejercicio 5.
    //Mostrar los datos de los alumnos egresados de forma descendente.
    //Utilizo el método de Inserción.
    public static Alumno[] ordenarPromedio(Alumno[] arreglo) {
        int promedio = 0, j = 0;
        Alumno alumno;

        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] != null) { //Verifico que la posición no sea nula.
                j = i;
                alumno = arreglo[i];
                while (j > 0 && !alumno.menorPromedio(arreglo[j - 1]) == true && arreglo[j - 1] != null) {//Busco el mayor promedio en comparación a alumno.

                    arreglo[j] = arreglo[j - 1]; //Desplazo las posiciones.
                    j = j - 1;

                }
                arreglo[j] = alumno;

            }

        }
        return arreglo;

    }
    //Ejercicio 6.
    //Calcular la cantidad de vacantes en forma recursiva.

    public static int calcularVacantes(Alumno[][] matriz, int f, int c) {
        int vacantes = 0;

        if (f == matriz.length - 1 && c == matriz[f].length - 1) { //Caso base.

            if (matriz[f][c] == null) {
                vacantes = 1;

            }

        } else { //Paso recursivo.

            if (matriz[f][c] == null) {
                vacantes = 1;

            }
            if (c == matriz[f].length - 1) {

                vacantes = vacantes + calcularVacantes(matriz, f + 1, 0);

            } else {
                vacantes = vacantes + calcularVacantes(matriz, f, c + 1);

            }

        }
        return vacantes;

    }
    //Ejercicio 7.
    //Cargar un alumno en la matriz.

    public static Alumno[][] cargarAlumno(Alumno[][] matriz) {
        Scanner sc = new Scanner(System.in);
        String apellido, nombre;
        int prom, grado, i = 1, legajo;
        boolean carga = false;
        System.out.println("Ingrese su apellido"); //Pido los datos del alumno a ingresar.
        apellido = sc.nextLine();
        System.out.println("Ingrese el nombre");
        nombre = sc.nextLine();
        System.out.println("Ingrese el legajo");
        legajo = sc.nextInt();
        System.out.println("Ingrese el grado");
        grado = sc.nextInt();
        if (grado >= 1 && grado <= 7) { //Verifico el rango del grado.
            System.out.println("Por ultimo ingrese el promedio.");
            prom = sc.nextInt();
            Alumno alumno = new Alumno(apellido, nombre, legajo, grado, prom);
            grado = grado - 1;

            while (carga == false && i < matriz[grado].length) { //Lo asigno en una posición nula.
                if (matriz[grado][i] == null) {
                    matriz[grado][i] = alumno;
                    carga = true;
                    System.out.println("El alumno fue cargado con éxito! :D");

                }
                i++;

            }

        } else {
            System.out.println("El grado ingresado no es válido. :(");

        }

        return matriz;

    }

    //Ejercicio 8.
    //Encontrar dónde está un alumno de la forma más eficiente.
    public static int buscarAlumno(Alumno matriz[][], int legajo, int grado) {
        //Como los legajos pueden encontrarse desordenados, realizo busqueda secuencial.

        grado = grado - 1;
        int posicion = -1, i = 0;
        boolean encontrado = false;

        while (encontrado == false && i < matriz[grado].length) {
            if (matriz[grado][i].getLegajo() == legajo) {
                posicion = i;
                encontrado = true;

            }
            i++;

        }

        return posicion;

    }

    public static void imprimirGradoMatriz(Alumno[][] matriz, int grado) {
        grado = grado - 1;
        int i = 0;

        while (i < matriz[grado].length && matriz[grado][i] != null) {
            System.out.println(matriz[grado][i].toString());
            i++;

        }

    }

    public static void imprimirMatriz(Alumno[][] matriz) {
        int grado;

        for (int i = 0; i < matriz.length; i++) {
            grado = i+1;
            System.out.println("Grado número " + grado + " :");
            for (int j = 0; j < matriz[0].length; j++) {

                if (matriz[i][j] != null) {
                    System.out.println(matriz[i][j].toString());

                }

            }
            System.out.println("");

        }

    }

    public static void imprimirArreglo(Alumno[] arreglo) {
        int i = 0;

        while (i < arreglo.length && arreglo[i] != null) {
            System.out.println(arreglo[i].toString());
            i++;

        }

    }

    public static void imprimirMenu() {
        System.out.println("Para terminar con el programa, ingrese 'no' ");
        System.out.println("Las acciones a realizar son:");
        System.out.println("'pasar año' para pasar de año a los alumnos.");
        System.out.println("'promedio', para mostrar el promedio general de todos los alumnos.");
        System.out.println("'ordenar' para ordenar un grado por nombre y apellido en forma ascendente.");
        System.out.println("'promedioE' para mostrar a los egresados según su promedio en forma descendente.");
        System.out.println("'vacantes' para calcular la cantidad de vacantes totales.");
        System.out.println("'nuevo' para ingresar un nuevo alumno.");
        System.out.println("'encontrar' para buscar un alumno.");
        System.out.println(" 'imprimir' para imprimir el menú.");

    }

}
