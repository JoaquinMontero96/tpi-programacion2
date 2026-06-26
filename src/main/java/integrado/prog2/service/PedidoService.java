/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integrado.prog2.service;

import integrado.prog2.entities.DetallePedido;
import integrado.prog2.entities.Pedido;
import integrado.prog2.entities.Producto;
import integrado.prog2.entities.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JOAQUIN
 */
public class PedidoService {
    List<Pedido> pedidos = new ArrayList<>();
    
    public void listarTodos() {
        if (pedidos.isEmpty()) {
            System.out.println("=====================================");
            System.out.println("No hay pedidos cargados.");
            System.out.println("=====================================");
        } else {
            for (Pedido pedido : pedidos) {
                if (pedido.isEliminado() == false) {
                    System.out.println(pedido);
                }
            }
        }
    }
    
    public Pedido crearPedido(Usuario usuario, LocalDate fecha) {
        Pedido nuevoPedido = new Pedido(usuario, fecha);
        this.pedidos.add(nuevoPedido);
        return nuevoPedido;
    }
    
    public void agregarDetalle(Pedido nuevoPedido, Producto producto, int cantidad) {
        double subtotal = producto.getPrecio() * cantidad;
        nuevoPedido.addDetallePedido(cantidad, subtotal, producto);
        producto.setStock(producto.getStock() - cantidad);
    }
    
    public void eliminarPedido(Pedido pedido) {
        pedido.setEliminado(true);
    }
    
    public Pedido buscarPedidoPorId(long id) {
        Pedido pedidoBuscado = null;
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id){
                pedidoBuscado = pedido;
            }
        }
        return pedidoBuscado;
    }
}
