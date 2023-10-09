package com.mycompany.tda_desarrollo;

public class Socio {

    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private int torneosGanados;
    private int mayorPuntaje;

    //Constructores
    public Socio (int unDni) {
        this.dni = unDni;
        apellido = null;
        nombre = null;
        edad = -1;
        torneosGanados = -1;
        mayorPuntaje = -1;

    }

    public Socio (int unDni, String unNombre, String unApellido, int unaEdad, int unTorneo, int mayorP) {
        dni = unDni;
        nombre = unNombre;
        apellido = unApellido;
        edad = unaEdad;
        torneosGanados = unTorneo;
        mayorPuntaje = mayorP;

    }

    //Observadores
    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public int getTorneo() {
        return torneosGanados;
    }

    public int getMayorP() {
        return mayorPuntaje;

    }

    public String toString() {
        String cadena = "DNI: " + dni + " Nombre: " + nombre + " Apellido: " + apellido + " Torneos ganados: "
                + +torneosGanados + " Mayor Puntaje: " + mayorPuntaje;

        return cadena;

    }

    public boolean equals(Socio otroSocio) {
        boolean resultado;
        resultado = (this.dni == otroSocio.getDni());
        return resultado;
    }
    
    
    //Modificadores.

    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }

    public void setApellido(String unApellido) {
        this.apellido = unApellido;
    }

    public void setEdad(int unaEdad) {
        this.edad = unaEdad;

    }

    public void setTorneosG(int torneosGanados) {
        this.torneosGanados = torneosGanados;
    }

    public void setMayorPuntaje(int puntaje) {
        this.mayorPuntaje = puntaje;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

}
