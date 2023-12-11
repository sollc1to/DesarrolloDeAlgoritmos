
public class Alumno {

    private String apellido;
    private String nombre;
    private int legajo;
    private int grado;
    private int promedio;

    //Constructores del objeto Alumno
    public Alumno(int unLegajo) {
        this.legajo = unLegajo;
        this.nombre = "";
        this.apellido = "";
        this.grado = 0;
        this.promedio = 0;
    }

    public Alumno(String unApellido, String unNombre, int unLegajo, int unGrado, int unPromedio) {
        this.legajo = unLegajo;
        this.apellido = unApellido;
        this.nombre = unNombre;
        this.grado = unGrado;
        this.promedio = unPromedio;

    }

    //Modificadores.
    public void setNombre(String unNombre) {
        this.nombre = unNombre;

    }

    public void setApellido(String unApellido) {
        this.apellido = unApellido;
    }

    public void setGrado(int unGrado) {
        this.grado = unGrado;
    }

    public void setPromedio(int unPromedio) {

        this.promedio = unPromedio;
    }

    //Observadores.
    public int getLegajo() {
        return this.legajo;
    }

    public String getNombre() {
        return this.nombre;

    }

    public String getApellido() {
        return this.apellido;
    }

    public int getGrado() {
        return this.grado;
    }

    public int getPromedio() {
        return this.promedio;
    }

    public String toString() {
        String cadena;
        cadena = "Nombre: " + nombre + " Apellido: " + apellido + " Legajo: " + legajo
                + " Grado: " + grado + " Promedio: " + promedio;

        return cadena;

    }

    public boolean equals(Alumno otroAlumno) {
        boolean resultado = this.legajo == otroAlumno.getLegajo();
        return resultado;
    }

    //Propias del tipo.
    public void egresado() {
        this.grado = 0;

    }

    public void pasarAño() {
        this.grado = grado + 1;
    }

    public int comparar(Alumno otroAlumno) {
        int num;
        String alumno = this.nombre + this.apellido;
        String alumno2 = otroAlumno.getNombre() + otroAlumno.getApellido();

        num = alumno.compareToIgnoreCase(alumno2);

        return num;

    }

    public boolean menorPromedio(Alumno otroAlumno) {
        boolean menor = (this.promedio < otroAlumno.getPromedio());

        return menor;

    }


}
