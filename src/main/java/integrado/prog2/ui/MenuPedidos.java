/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integrado.prog2.ui;

import integrado.prog2.entities.Pedido;
import integrado.prog2.entities.Producto;
import integrado.prog2.entities.Usuario;
import integrado.prog2.enums.Estado;
import integrado.prog2.enums.FormaPago;
import integrado.prog2.exception.NumeroNegativoException;
import integrado.prog2.service.PedidoService;
import integrado.prog2.service.ProductoService;
import integrado.prog2.service.UsuarioService;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author JOAQUIN
 */
public class MenuPedidos {
    PedidoService service;
    UsuarioService usuarioService;
    ProductoService productoService;

    public MenuPedidos(PedidoService service, UsuarioService usuarioService, ProductoService productoService) {
        this.service = service;
        this.usuarioService = usuarioService;
        this.productoService = productoService;
    }
    
    public void mostrar(Scanner input) {
        int opcion = -1;
        
        while (opcion != 0) {           
            System.out.println("=== GESTION DE PEDIDOS ===");
            System.out.println("1. Listar");
            System.out.println("2. Crear");
            System.out.println("3. Editar");
            System.out.println("4. Eliminar");
            System.out.println("0. Volver al menu principal");
            System.out.print("Seleccione: ");

            opcion = Integer.parseInt(input.nextLine());
            switch (opcion) {
                case 1 -> listar();
                case 2 -> crear(input);
                case 3 -> editar(input);
                case 4 -> eliminar(input);
                default -> {
                System.out.println("=====================================");
                System.out.println("Debe seleccionar una opcion valida");
                System.out.println("=====================================");
                }
            }
            opcion = 0;
        }
    }
    
    public void listar(){
        service.listarTodos();
    }
    public void crear(Scanner input){
        usuarioService.listarTodos();
        System.out.print("Ingrese el ID de usuario: ");
        long id = Long.parseLong(input.nextLine());
        Usuario usuarioBuscado = usuarioService.buscarUsuarioPorId(id);
        if (usuarioBuscado == null || usuarioBuscado.isEliminado() == true) {
            System.out.println("=====================================");
            System.out.println("El usuario no existe o ha sido eliminado");
            System.out.println("=====================================");
            return;
        }
        
        Pedido nuevoPedido = service.crearPedido(usuarioBuscado, LocalDate.now());
        
        boolean salir = false;
        do {           
            productoService.listarTodos();
            System.out.print("Ingrese el ID del producto a agregar: ");
            long idProducto = Long.parseLong(input.nextLine());
            Producto productoBuscado = productoService.buscarProductoPorId(idProducto);
            if (productoBuscado == null || productoBuscado.isEliminado() == true) {
                System.out.println("=====================================");
                System.out.println("El producto no existe o ha sido eliminado");
                System.out.println("=====================================");
                continue;
            }

            System.out.print("Ingrese la cantidad: ");
            int cantidad;
            try {               
                cantidad = Integer.parseInt(input.nextLine());
                if (cantidad <= 0) {
                    throw new NumeroNegativoException("La cantidad debe ser mayor a 0");
                }
            } catch (NumeroNegativoException e) {
                System.out.println(e.getMessage());
                continue;
            }

            if (cantidad > productoBuscado.getStock()) {
                System.out.println("Stock insuficiente: " + productoBuscado.getStock() + " unidades disponibles");
                continue;
            }
            
            service.agregarDetalle(nuevoPedido, productoBuscado, cantidad);
            
            System.out.print("Desea agregar mas productos? (S/N): ");
            String respuesta = input.nextLine();
            if(!respuesta.equalsIgnoreCase("S")) {
                salir = true;
            }
        } while (!salir);
        
        nuevoPedido.calcularTotal();
        System.out.println("Pedido creado exitosamente");
    }
    public void editar(Scanner input){
        listar();
        System.out.print("Ingrese el ID del pedido: ");
        long id = Long.parseLong(input.nextLine());
        Pedido pedidoBuscado = service.buscarPedidoPorId(id);
        if (pedidoBuscado == null || pedidoBuscado.isEliminado() == true) {
            System.out.println("=====================================");
            System.out.println("El pedido no existe o ha sido eliminado");
            System.out.println("=====================================");
            return;
        }
        
        System.out.println("=== ESTADO DEL PEDIDO ===");
        System.out.println("1. PENDIENTE");
        System.out.println("2. CONFIRMADO");
        System.out.println("3. TERMINADO");
        System.out.println("4. CANCELADO");
        System.out.print("Seleccione una opcion: ");
        int opcion = Integer.parseInt(input.nextLine());
        switch (opcion) {
            case 1 -> pedidoBuscado.setEstado(Estado.PENDIENTE);
            case 2 -> pedidoBuscado.setEstado(Estado.CONFIRMADO);
            case 3 -> pedidoBuscado.setEstado(Estado.TERMINADO);
            case 4 -> pedidoBuscado.setEstado(Estado.CANCELADO);
            default -> {
                System.out.println("Opcion invalida");
                return;
            }
        }
        
        System.out.println("=====================================");
        System.out.println("Estado actualizado");
        System.out.println("=====================================");
        
        System.out.println("=== FORMA DE PAGO ===");
        System.out.println("1. TARJETA");
        System.out.println("2. TRANSFERENCIA");
        System.out.println("3. EFECTIVO");
        System.out.print("Seleccione una opcion: ");
        opcion = Integer.parseInt(input.nextLine());
        switch (opcion) {
            case 1 -> pedidoBuscado.setFormaPago(FormaPago.TARJETA);
            case 2 -> pedidoBuscado.setFormaPago(FormaPago.TRANSFERENCIA);
            case 3 -> pedidoBuscado.setFormaPago(FormaPago.EFECTIVO);
            default -> {
                System.out.println("Opcion invalida");
                return;
            }
        }
        
        System.out.println("=====================================");
        System.out.println("Forma de pago actualizada");
        System.out.println("=====================================");
    }
    
    public void eliminar(Scanner input){
        listar();
        System.out.print("Ingrese el ID del pedido a eliminar: ");
        long id = Long.parseLong(input.nextLine());
        Pedido pedidoBuscado = service.buscarPedidoPorId(id);
        if (pedidoBuscado == null || pedidoBuscado.isEliminado() == true) {
            System.out.println("=====================================");
            System.out.println("El pedido no existe o fue eliminado");
            System.out.println("=====================================");
            return;
        }
        
        System.out.print("Esta seguro que desea eliminar el pedido ID " + pedidoBuscado.getId() + " ? (S/N): ");
        String respuesta = input.nextLine();
        if (respuesta.equalsIgnoreCase("S")) {
            service.eliminarPedido(pedidoBuscado);
            System.out.println("=====================================");
            System.out.println("Pedido eliminado correctamente");
            System.out.println("=====================================");
        } else {
            System.out.println("=====================================");
            System.out.println("Eliminacion cancelada");
            System.out.println("=====================================");
        }
    }
}
