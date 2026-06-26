/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integrado.prog2.entities;

import integrado.prog2.enums.Estado;
import integrado.prog2.enums.FormaPago;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JOAQUIN
 */
public class Pedido extends Base implements Calculable{
    private LocalDate fecha;
    private Estado estado;
    private double total;
    private FormaPago formaPago;
    private List<DetallePedido> detallesPedido = new ArrayList<>();
    private Usuario usuario;
    private static long cantidadPedidos = 0;

    public Pedido(Usuario usuario, LocalDate fecha) {
        super(cantidadPedidos + 1, false, LocalDateTime.now());
        this.fecha = fecha;
        this.estado = estado.PENDIENTE;
        this.usuario = usuario;
        cantidadPedidos++;
    }
    
    public void addDetallePedido(int cantidad, double subtotal, Producto producto) {
        DetallePedido nuevoDetalle = new DetallePedido(producto, cantidad, subtotal);
        this.detallesPedido.add(nuevoDetalle);
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    @Override
    public String toString() {
        return this.getId() + "  -  " + this.usuario.getNombre() + "  -  " + this.estado + "  -  " + this.formaPago + "  -  " + this.total + "  -  " + this.fecha;
    }

    @Override
    public void calcularTotal() {
        for (DetallePedido detallePedido : detallesPedido) {
            this.total += detallePedido.getSubtotal();
        }
    }
}
