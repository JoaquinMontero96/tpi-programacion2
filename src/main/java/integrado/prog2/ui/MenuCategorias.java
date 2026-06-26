/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integrado.prog2.ui;

import integrado.prog2.entities.Categoria;
import integrado.prog2.exception.CadenaVaciaException;
import integrado.prog2.service.CategoriaService;
import java.util.Scanner;

/**
 *
 * @author JOAQUIN
 */
public class MenuCategorias {
    CategoriaService service;

    public MenuCategorias(CategoriaService service) {
        this.service = service;
    }
    
    public void mostrar(Scanner input) {
        int opcion = -1;
        
        while (opcion != 0) {           
            System.out.println("=== GESTION DE CATEGORIAS ===");
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
        String nombre;
        try {            
            System.out.print("Ingrese nombre de la categoria: ");
            nombre = input.nextLine();
            if (nombre == null || nombre.isBlank()) {
                throw new CadenaVaciaException("=====================================\nDebe ingresar un nombre\n=====================================");
            }
        } catch (CadenaVaciaException e) {
            System.out.println(e.getMessage());
            return;
        }
        
        if (service.buscarCategoriaPorNombre(nombre) != null) {
            System.out.println("=====================================");
            System.out.println("Categoria ya existente");
            System.out.println("=====================================");
            return;
        }

        String descripcion;
        try {           
            System.out.print("Ingrese descripcion de la categoria: ");
            descripcion = input.nextLine();
            if (descripcion == null || descripcion.isBlank()) {
                throw new CadenaVaciaException("=====================================\nDebe ingresar una descripcion\n=====================================");
            }
        } catch (CadenaVaciaException e) {
            System.out.println(e.getMessage());
            return;
        }
        
        service.crearCategoria(nombre, descripcion);
    }
    public void editar(Scanner input){
        listar();
        System.out.print("Ingrese el ID de la categoria a editar: ");
        long id = Long.parseLong(input.nextLine());
        Categoria categoriaBuscada = service.buscarCategoriaPorId(id);
        if (categoriaBuscada == null || categoriaBuscada.isEliminado() == true) {
            System.out.println("=====================================");
            System.out.println("La categoria no existe o fue eliminada");
            System.out.println("=====================================");
            return;
        }
        
        System.out.print("Ingrese nuevo nombre (dejar vacio para omitir): ");
        String nuevoNombre = input.nextLine();
        if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
            service.cambiarNombreCategoria(categoriaBuscada, nuevoNombre);
        }
        System.out.print("Ingrese nueva descripcion (dejar vacio para omitir): ");
        String nuevaDescripcion = input.nextLine();
        if (nuevaDescripcion != null && !nuevaDescripcion.isEmpty()) {
            service.cambiarDescripcionCategoria(categoriaBuscada, nuevaDescripcion);
        }
        
        System.out.println("=====================================");
        System.out.println("Categoria actualizada exitosamente");
        System.out.println("=====================================");
    }
    public void eliminar(Scanner input){
        listar();
        System.out.print("Ingrese el ID de la categoria a eliminar: ");
        long id = Long.parseLong(input.nextLine());
        Categoria categoriaBuscada = service.buscarCategoriaPorId(id);
        if (categoriaBuscada == null || categoriaBuscada.isEliminado() == true) {
            System.out.println("=====================================");
            System.out.println("La categoria no existe o fue eliminada");
            System.out.println("=====================================");
            return;
        }
        
        System.out.print("Esta seguro que desea eliminar la categoria ID " + categoriaBuscada.getId() + " - " + categoriaBuscada.getNombre() + " ? (S/N): ");
        String respuesta = input.nextLine();
        if (respuesta.equalsIgnoreCase("S")) {
            service.eliminarCategoria(categoriaBuscada);
            System.out.println("=====================================");
            System.out.println("Categoria eliminada correctamente");
            System.out.println("=====================================");
        } else {
            System.out.println("=====================================");
            System.out.println("Eliminacion cancelada");
            System.out.println("=====================================");
        }
    }
}
