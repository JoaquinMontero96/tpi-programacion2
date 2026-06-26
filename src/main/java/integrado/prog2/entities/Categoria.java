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
public class Categoria extends Base {
    private String nombre;
    private String descripcion;
    private static long cantidadCategorias = 0;

    public Categoria(String nombre, String descripcion) {
        super(cantidadCategorias + 1, false, LocalDateTime.now());
        this.nombre = nombre;
        this.descripcion = descripcion;
        cantidadCategorias++;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    

    @Override
    public String toString() {
        return this.getId() + "  -  " + this.nombre + "  -  " + this.descripcion + "  -  " + this.getCreatedAt();
    }
}
