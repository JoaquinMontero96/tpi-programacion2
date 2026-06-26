/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integrado.prog2.entities;

import java.time.LocalDateTime;

/**
 *
 * @author JOAQUIN
 */
public class DetallePedido extends Base {
    private int cantidad;
    private double subtotal;
    private Producto producto;
    private static long cantidadDetalles = 0;

    public DetallePedido(Producto producto, int cantidad, double subtotal) {
        super(cantidadDetalles + 1, false, LocalDateTime.now());
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        cantidadDetalles++;
    }

    public double getSubtotal() {
        return subtotal;
    }
}
