/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integrado.prog2.service;

import integrado.prog2.entities.Categoria;
import integrado.prog2.entities.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JOAQUIN
 */
public class ProductoService {
    List<Producto> productos = new ArrayList<>();
    
    public void listarTodos() {
        if (productos.isEmpty()) {
            System.out.println("=====================================");
            System.out.println("No hay productos cargados.");
            System.out.println("=====================================");
        } else {
            for (Producto producto : productos) {
                if (producto.isEliminado() == false) {
                    System.out.println(producto);
                }
            }
        }
    }
    
    public void crearProducto(String nombre, double precio, String descripcion, int stock, String imagen, Categoria categoria, boolean isDisponible){
        Producto nuevoProducto = new Producto(nombre, precio, descripcion, stock, imagen, categoria, isDisponible);
        productos.add(nuevoProducto);
        System.out.println("=====================================");
        System.out.println("Producto ID " + nuevoProducto.getId() + " creado exitosamente");
        System.out.println("=====================================");
    }
    
    public Producto buscarProductoPorId(long id) {
        Producto productoBuscado = null;
        for (Producto producto : productos) {
            if (producto.getId() == id){
                productoBuscado = producto;
            }
        }
        return productoBuscado;
    }
    
    public void actualizarPrecio(double precio, Producto producto) {
        producto.setPrecio(precio);
    }
    
    public void actualizarStock(int stock, Producto producto) {
        producto.setStock(stock);
    }
    
    public void actualizarCategoria(Categoria categoria, Producto producto) {
        producto.setCategoria(categoria);
    }
    
    public void eliminarProducto(Producto producto){
        producto.setEliminado(true);
    }
}
