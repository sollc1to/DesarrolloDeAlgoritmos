package com.mycompany.tda_desarrollo;

public class Fecha {

    private int dia;
    private int mes;
    private int año;
    //Constructores

    public Fecha() {
        dia = -1;
        mes = -1;
        año = -1;
    }

    public Fecha(int unDia, int unMes, int unAño) {
        dia = unDia;
        mes = unMes;
        año = unAño;

    }
    //Observadores

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;

    }

    public String toString() {
        String cadena = dia + "/" + mes + "/" + año;

        return cadena;
    }

    public boolean equals(Fecha otraFecha) {
        boolean resultado = (this.dia == otraFecha.getDia() && this.mes == otraFecha.getMes() && this.año == otraFecha.getAño());
        return resultado;

    }

    //Modificadores
    public void setDia(int unDia) {
        this.dia = unDia;

    }

    public void setMes(int unMes) {
        this.mes = unMes;
    }

    public void setAño(int unAño) {
        this.año = unAño;
    }

    //Propias del tipo
    public int diasTranscurridos() {
        int[] arregloMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int dias = 0;

        for (int i = 0; i < this.mes - 1; i++) {
            dias = dias + arregloMes[i];

        }
        dias = dias + this.dia;

        if (año % 4 == 0) {
            dias = dias - 1;

        }

        return dias;

    }

    public boolean esFechaAnterior(Fecha otraFecha) {
        boolean resultado = true;
        resultado = (this.año < otraFecha.getAño() && this.mes < otraFecha.getMes() && this.dia < otraFecha.getDia());

        return resultado;

    }

    public void calculaFecha(int dias) {

        dias = dia + dias;

        if (dia > 28 && this.mes == 2) {

            dias = dias - 28;

            this.dia = dias;

            this.mes = mes + 1;

        } else {
            if (dias > 30 && (mes == 4 || mes == 6 || mes == 8 || mes == 11)) {

                dias = dias - 30;

                this.dia = dias;

                mes = mes + 1;

            } else {
                if (dias > 31 && (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)) {
                    dias = dias - 31;
                    this.dia = dias;
                    mes = mes + 1;

                } else {
                    if (mes > 12 && dia > 31) {

                        dias = dias - 31;
                        this.año = año + 1;
                        mes = 1;
                        dia = dias;

                    } else {
                        if (dia + dias < 28) {
                            dia = dia + dias;

                        }
                    }
                }

            }

        }
        System.out.println("La nueva fecha es " + dia + "/" + mes + "/" + año);

    }

    public int esBisiesto() {
        if (año % 4 == 0) {
            dia = dia - 1;

        }

        return dia;

    }

}
