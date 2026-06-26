/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integrado.prog2.ui;

import integrado.prog2.service.CategoriaService;
import integrado.prog2.service.PedidoService;
import integrado.prog2.service.ProductoService;
import integrado.prog2.service.UsuarioService;
import java.util.Scanner;

/**
 *
 * @author JOAQUIN
 */
public class MenuPrincipal {
    CategoriaService categoriaService = new CategoriaService();
    ProductoService productoService = new ProductoService();
    UsuarioService usuarioService = new UsuarioService();
    PedidoService pedidoService = new PedidoService();
    
    MenuCategorias menuCategorias = new MenuCategorias(categoriaService);
    MenuProductos menuProductos = new MenuProductos(productoService, categoriaService);
    MenuUsuarios menuUsuarios = new MenuUsuarios(usuarioService);
    MenuPedidos menuPedidos = new MenuPedidos(pedidoService, usuarioService, productoService);
    
    public void mostrar() {
        System.out.println("=== SISTEMA DE PEDIDOS (FOOD STORE) ===");
        System.out.println("1. Categorias");
        System.out.println("2. Productos");
        System.out.println("3. Usuarios");
        System.out.println("4. Pedidos");
        System.out.println("0. Salir");
        System.out.print("Seleccione: ");
    }
    
    public void seleccionarOpcion (int opcion, Scanner input) {
        switch (opcion) {
            case 1 -> menuCategorias.mostrar(input);
            case 2 -> menuProductos.mostrar(input);
            case 3 -> menuUsuarios.mostrar(input);
            case 4 -> menuPedidos.mostrar(input);
            case 0 -> {
                System.out.println("=====================================");
                System.out.println("Gracias por usar Food Store Software");
                System.out.println("=====================================");
            }
            default -> {
                System.out.println("=====================================");
                System.out.println("Debe seleccionar una opcion valida");
                System.out.println("=====================================");
            }
        }
    }
}
