/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integrado.prog2.ui;

import integrado.prog2.entities.Categoria;
import integrado.prog2.entities.Producto;
import integrado.prog2.exception.NumeroNegativoException;
import integrado.prog2.service.CategoriaService;
import integrado.prog2.service.ProductoService;
import java.util.Scanner;

/**
 *
 * @author JOAQUIN
 */
public class MenuProductos {
    ProductoService service;
    CategoriaService categoriaService;

    public MenuProductos(ProductoService service, CategoriaService categoriaService) {
        this.service = service;
        this.categoriaService = categoriaService;
    }
    
    public void mostrar(Scanner input) {
        int opcion = -1;
        
        while (opcion != 0) {           
            System.out.println("=== GESTION DE PRODUCTOS ===");
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
        System.out.print("Ingrese nombre del producto: ");
        String nombre = input.nextLine();
        if (nombre == null || nombre.isBlank()) {
            System.out.println("=====================================");
            System.out.println("Debe ingresar un nombre");
            System.out.println("=====================================");
            return;
        }
        
        System.out.print("Ingrese descripcion del producto: ");
        String descripcion = input.nextLine();

        System.out.print("Ingrese precio del producto: $ ");
        double precio;
        try {           
            precio = Double.parseDouble(input.nextLine());
            if (precio <= 0) {
                throw new NumeroNegativoException("=====================================\nDebe ingresar un precio mayor a 0\n=====================================");
            }
        } catch (NumeroNegativoException e) {
            System.out.println(e.getMessage());
            return;
        }
        
        System.out.print("Ingrese stock del producto: ");
        int stock;
        try {           
            stock = Integer.parseInt(input.nextLine());
            if (stock <= 0) {
                throw new NumeroNegativoException("=====================================\nDebe ingresar un stock inicial mayor a 0\n=====================================");
            }
        } catch (NumeroNegativoException e) {
            System.out.println(e.getMessage());
            return;
        }
        
        System.out.print("Ingrese URL de la imagen: ");
        String url = input.nextLine();
        
        System.out.print("El producto esta disponible? (S/N): ");
        String disponible = input.nextLine();
        boolean isDisponible;
        if (disponible.equalsIgnoreCase("S")) {
            isDisponible = true;
        } else if (disponible.equalsIgnoreCase("N")) {
            isDisponible = false;
        } else {
            System.out.println("=====================================");
            System.out.println("Error, debe ingresar S o N");
            System.out.println("=====================================");
            return;
        }
        
        System.out.print("Ingrese el ID de la categoria: ");
        long id = Long.parseLong(input.nextLine());
        Categoria categoriaBuscada = categoriaService.buscarCategoriaPorId(id);
        if (categoriaBuscada == null || categoriaBuscada.isEliminado() == true) {
            System.out.println("=====================================");
            System.out.println("La categoria ingresada no existe o fue eliminada");
            System.out.println("=====================================");
            return;
        }
        
        service.crearProducto(nombre, precio, descripcion, stock, url, categoriaBuscada, isDisponible);
    }
    public void editar(Scanner input){
        listar();
        System.out.print("Ingrese el ID del producto a editar: ");
        long id = Long.parseLong(input.nextLine());
        Producto productoBuscado = service.buscarProductoPorId(id);
        if (productoBuscado == null || productoBuscado.isEliminado() == true) {
            System.out.println("=====================================");
            System.out.println("El producto no existe o fue eliminado");
            System.out.println("=====================================");
            return;
        }
        
        System.out.print("Ingrese nuevo precio (dejar vacio para omitir): ");
        try {           
            double nuevoPrecio = Double.parseDouble(input.nextLine());
            service.actualizarPrecio(nuevoPrecio, productoBuscado);
        } catch (NumberFormatException e) {}
        
        System.out.print("Ingrese nuevo stock (dejar vacio para omitir): ");
        try {           
            int nuevoStock = Integer.parseInt(input.nextLine());
            service.actualizarStock(nuevoStock, productoBuscado);
        } catch (NumberFormatException e) {}
        
        System.out.print("Ingrese el ID de la nueva categoria (dejar vacio para omitir): ");
        try {           
            long idCategoria = Long.parseLong(input.nextLine());
            Categoria categoriaBuscada = categoriaService.buscarCategoriaPorId(idCategoria);
            if (categoriaBuscada == null || categoriaBuscada.isEliminado() == true) {
                System.out.println("=====================================");
                System.out.println("La categoria ingresada no existe o fue eliminada");
                System.out.println("=====================================");
            } else {
                service.actualizarCategoria(categoriaBuscada, productoBuscado); 
            }
        } catch (NumberFormatException e) {};
        
        System.out.println("=====================================");
        System.out.println("Producto actualizado correctamente");
        System.out.println("=====================================");
    }
    
    public void eliminar(Scanner input){
        listar();
        System.out.print("Ingrese el ID del producto a eliminar: ");
        long id = Long.parseLong(input.nextLine());
        Producto productoBuscado = service.buscarProductoPorId(id);
        if (productoBuscado == null || productoBuscado.isEliminado() == true) {
            System.out.println("=====================================");
            System.out.println("El producto no existe o fue eliminado");
            System.out.println("=====================================");
            return;
        }
        
        System.out.print("Esta seguro que desea eliminar el producto ID " + productoBuscado.getId() + " - " + productoBuscado.getNombre() + " ? (S/N): ");
        String respuesta = input.nextLine();
        if (respuesta.equalsIgnoreCase("S")) {
            service.eliminarProducto(productoBuscado);
            System.out.println("=====================================");
            System.out.println("Producto eliminado correctamente");
            System.out.println("=====================================");
        } else {
            System.out.println("=====================================");
            System.out.println("Eliminacion cancelada");
            System.out.println("=====================================");
        }
    }    
}
