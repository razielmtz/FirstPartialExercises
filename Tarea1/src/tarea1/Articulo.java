/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

/**
 *
 * @author Raziel 2
 */
public class Articulo {
   public int sku; 
   private int existencia;
   private double costo;
   private double precio;
   public String descripcion;

    public Articulo(int sku, double costo, String descripcion){
        this.sku = sku;
        this.costo = costo;
        this.descripcion = descripcion;
}
    public Articulo(){
        this(0,0.00,"Descripción no disponible");
    }
    public int getSku(){
        return this.sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void compra(int existencia, double costo){
        setExistencia(existencia);
        setCosto(costo);
    }
    public boolean venta(int numeroDeArticulos){
           if(getExistencia()>=numeroDeArticulos){
               setExistencia(getExistencia()-numeroDeArticulos);
           return true;
       }else{ return false;
           }
           }
       public double verificarExistencia(){
           return existencia;
         
       }
       public void actualizarPrecio(double precio){
           this.precio = precio;
       }
}
