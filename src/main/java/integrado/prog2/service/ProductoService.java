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
 * Gestion de productos
 * @author JOAQUIN
 */
public class ProductoService {
    List<Producto> productos = new ArrayList<>(); /** Listado de productos */
    
    /**
     * Lista los productos creados
     */
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
    
    /**
     * Crea un producto y lo agrega al listado
     * @param nombre Nombre
     * @param precio Precio
     * @param descripcion Descripcion
     * @param stock Cantidad de stock
     * @param imagen URL de imagen
     * @param categoria Categoria
     * @param isDisponible Estado de disponibilidad
     */
    public void crearProducto(String nombre, double precio, String descripcion, int stock, String imagen, Categoria categoria, boolean isDisponible){
        Producto nuevoProducto = new Producto(nombre, precio, descripcion, stock, imagen, categoria, isDisponible);
        productos.add(nuevoProducto);
        System.out.println("=====================================");
        System.out.println("Producto ID " + nuevoProducto.getId() + " creado exitosamente");
        System.out.println("=====================================");
    }
    
    /**
     * Busca un producto por su ID
     * @param id ID del producto
     * @return Producto buscado
     */
    public Producto buscarProductoPorId(long id) {
        Producto productoBuscado = null;
        for (Producto producto : productos) {
            if (producto.getId() == id){
                productoBuscado = producto;
            }
        }
        return productoBuscado;
    }
    
    /**
     * Actualiza el precio de un producto
     * @param precio Nuevo precio
     * @param producto Producto
     */
    public void actualizarPrecio(double precio, Producto producto) {
        producto.setPrecio(precio);
    }
    
    /**
     * Actualiza el stock de un producto
     * @param stock Nuevo stock
     * @param producto Producto
     */
    public void actualizarStock(int stock, Producto producto) {
        producto.setStock(stock);
    }
    
    /**
     * Actualiza la categoria de un producto
     * @param categoria Nueva categoria
     * @param producto Producto
     */
    public void actualizarCategoria(Categoria categoria, Producto producto) {
        producto.setCategoria(categoria);
    }
    
    /**
     * Cambia de estado eliminado a un producto
     * @param producto Producto a eliminar
     */
    public void eliminarProducto(Producto producto){
        producto.setEliminado(true);
    }
}
