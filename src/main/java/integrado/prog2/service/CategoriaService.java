/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integrado.prog2.service;

import integrado.prog2.entities.Categoria;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JOAQUIN
 */
public class CategoriaService {
    List<Categoria> categorias = new ArrayList<>();
    
    public void listarTodos() {
        if (categorias.isEmpty()) {
            System.out.println("=====================================");
            System.out.println("No hay categorias cargadas.");
            System.out.println("=====================================");
        } else {
            System.out.println("====== LISTADO DE CATEGORIAS ======");
            System.out.println("ID  |  Nombre  |  Descripcion  |  Fecha de creacion");
            System.out.println("----------------------------------------------------");
            for (Categoria categoria : categorias) {
                if (categoria.isEliminado() == false) {
                    System.out.println(categoria);
                }
            }
        }
    }
    
    public void crearCategoria(String nombre, String descripcion) {          
        Categoria nuevaCategoria = new Categoria(nombre, descripcion);
        categorias.add(nuevaCategoria);
        System.out.println("=====================================");
        System.out.println("Categoria ID " + nuevaCategoria.getId() + " creada correctamente");
        System.out.println("=====================================");
    }
    
    public Categoria buscarCategoriaPorNombre(String nombre) {
        Categoria categoriaBuscada = null;
        for (Categoria categoria : categorias) {
            if (categoria.getNombre().equalsIgnoreCase(nombre)){
                categoriaBuscada = categoria;
            }
        }
        return categoriaBuscada;
    }
    
    public Categoria buscarCategoriaPorId(long id) {
        Categoria categoriaBuscada = null;
        for (Categoria categoria : categorias) {
            if (categoria.getId() == id){
                categoriaBuscada = categoria;
            }
        }
        return categoriaBuscada;
    }
    
    public void cambiarNombreCategoria(Categoria categoria, String nombre) {
        categoria.setNombre(nombre);
    }
    
    public void cambiarDescripcionCategoria(Categoria categoria, String descripcion) {
        categoria.setNombre(descripcion);
    }
    
    public void eliminarCategoria(Categoria categoria){
        categoria.setEliminado(true);
    }
}
