/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integrado.prog2.entities;

import java.time.LocalDateTime;

/**
 * Producto
 * @author JOAQUIN
 */
public class Producto extends Base {
    private String nombre; /** Nombre del producto */
    private double precio; /** Precio del producto */
    private String descripcion; /** Descripcion del producto */
    private int stock; /** Cantidad en stock del producto */
    private String imagen; /** URL de la imagen del producto */
    private boolean disponible; /** Estado de disponibilidad del producto */
    private Categoria categoria; /** Categoria del producto */
    private static long cantidadProductos = 0; /** Cantidad de productos creados */

    public Producto(String nombre, double precio, String descripcion, int stock, String imagen, Categoria categoria, boolean disponible) {
        super(cantidadProductos + 1, false, LocalDateTime.now());
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
        this.imagen = imagen;
        this.categoria = categoria;
        this.disponible = disponible;
        cantidadProductos++;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + this.getId() + ", nombre=" + this.nombre + ", precio=" + this.precio + ", stock=" + this.stock + ", categoria=" + this.categoria + '}';
    }
    
    
}
