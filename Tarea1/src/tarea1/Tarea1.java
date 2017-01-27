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
public class Tarea1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instancia de la clase Artículo
        Articulo telefono = new Articulo(120899,11500.00,"Iphone 6s 16Gb");
        //Compra de 50 teléfonos
        telefono.compra(50, 9890.00);
        //Muestra la existencia en almacén
        System.out.println("La existencia en almacén del artículo es " + 
                            telefono.verificarExistencia());
        //Se realiza una venta
        System.out.println("Se venden 15 teléfonos");
        telefono.venta(15);
        System.out.println("La nueva existencia después de la venta es "+
                            telefono.verificarExistencia());
        //Se realiza actualización de precios
        System.out.println("Hay una promo, y el nuevo precio es $10,000.00");
        telefono.actualizarPrecio(10000.00);
    } 
}

