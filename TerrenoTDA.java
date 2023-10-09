package com.mycompany.tda_desarrollo;

public class Terreno {

    private int codigo;
    private double base;
    private double altura;
    private int manzana;
    // Constructores 
    public Terreno(int unCodigo) {
        this.base = 0;
        this.altura = 0;
        this.codigo = -1;
        this.manzana = -1;

    }

    public Terreno(int unCodigo, double laBase, double laAltura, int laManzana) {
        this.codigo = unCodigo;
        this.base = laBase;
        this.altura = laAltura;
        this.manzana = laManzana;

    }
    //Observadores .get
    
    public int getCodigo(){
        return this.codigo;
    }
    public double getBase(){
        return this.base;
    }
    public double getAltura(){
        return this.altura;
    }
    public int getManzana (){
        return this.manzana;
    }
    public String toString(){
        String cadena; 
        cadena = "Código: " + this.codigo + "Base: " + this.base + " Altura: " 
                + this.altura +  "Manzana: " + this.manzana;
        return cadena;
    
        
    }
    public boolean equals(Terreno unTerreno) {
        boolean resultado;
        resultado =(unTerreno.getCodigo() == this.codigo);
        
        return resultado;
    }
    //Modificadores .set
    
    public void setBase(double laBase){
        this.base = laBase;
        
        
    }
    public void setAltura(double laAltura){
        this.altura = laAltura;
        
    }
    public void setManzana(int laManzana){
        this.manzana = laManzana;
    }
    
    public double perimetro (){
        double perimetro = 2*(this.base)+2*(this.altura);
        return perimetro;
        
    }
    public double superficie(){
        double superficie = (this.base)*(this.altura);
        return superficie;
        
    }
    public double valorM2(double precio){
    
        precio = precio * superficie();
        
        
        
        return precio;
        
        
    
    }
        
    
    
    
    

}
