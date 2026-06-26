/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integrado.prog2.ui;

import integrado.prog2.entities.Usuario;
import integrado.prog2.service.UsuarioService;
import java.util.Scanner;

/**
 *
 * @author JOAQUIN
 */
public class MenuUsuarios {
    UsuarioService service;

    public MenuUsuarios(UsuarioService service) {
        this.service = service;
    }
    
    public void mostrar(Scanner input) {
        int opcion = -1;
        
        while (opcion != 0) {           
            System.out.println("=== GESTION DE USUARIOS ===");
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
        System.out.print("Ingrese nombre: ");
        String nombre = input.nextLine();
        if (nombre == null || nombre.isBlank()) {
            System.out.println("=====================================");
            System.out.println("Debe ingresar un nombre");
            System.out.println("=====================================");
            return;
        }
        
        System.out.print("Ingrese apellido: ");
        String apellido = input.nextLine();
        if (apellido == null || apellido.isBlank()) {
            System.out.println("=====================================");
            System.out.println("Debe ingresar un apellido");
            System.out.println("=====================================");
            return;
        }
        
        boolean salir = false;
        String email;
        do {     
            System.out.print("Ingrese email: ");
            email = input.nextLine();
            if (email == null || email.isBlank()) {
                System.out.println("=====================================");
                System.out.println("Debe ingresar un email");
                System.out.println("=====================================");
                continue;
            }

            Usuario usuarioBuscado = service.buscarUsuarioPorMail(email);
            if (usuarioBuscado != null) {
                System.out.println("=====================================");
                System.out.println("El mail ingresado ya se encuentra registrado");
                System.out.println("=====================================");
                continue;
            }
            
            salir = true;
        } while (!salir);
        
        System.out.print("Ingrese numero de celular: ");
        String celular = input.nextLine();
        if (celular == null || celular.isBlank()) {
            System.out.println("=====================================");
            System.out.println("Debe ingresar un celular");
            System.out.println("=====================================");
            return;
        }
        
        service.crearUsuario(nombre, apellido, email, celular);
    }
    public void editar(Scanner input){
        listar();
        System.out.print("Ingrese el ID del usuario a editar: ");
        long id = Long.parseLong(input.nextLine());
        Usuario usuarioBuscado = service.buscarUsuarioPorId(id);
        if (usuarioBuscado == null || usuarioBuscado.isEliminado() == true) {
            System.out.println("=====================================");
            System.out.println("El usuario no existe o ha sido eliminado");
            System.out.println("=====================================");
            return;
        }
        
        System.out.print("Ingrese nuevo nombre (dejar vacio para omitir): ");
        String nuevoNombre = input.nextLine();
        if (!nuevoNombre.isBlank()) {
            service.actualizarNombre(usuarioBuscado, nuevoNombre);
        }
        
        System.out.print("Ingrese nuevo apellido (dejar vacio para omitir): ");
        String nuevoApellido = input.nextLine();
        if (!nuevoApellido.isBlank()) {
            service.actualizarApellido(usuarioBuscado, nuevoApellido);
        }
        
        System.out.print("Ingrese nuevo email (dejar vacio para omitir): ");
        String nuevoEmail = input.nextLine();
        if (!nuevoEmail.isBlank()) {
            Usuario usuarioExistente = service.buscarUsuarioPorMail(nuevoEmail);
            if (usuarioExistente != null) {
                System.out.println("=====================================");
                System.out.println("El mail ingresado ya se encuentra registrado");
                System.out.println("=====================================");
            } else {                
                service.actualizarEmail(usuarioBuscado, nuevoEmail);
            }
        }
        
        System.out.print("Ingrese nuevo celular (dejar vacio para omitir): ");
        String nuevoCelular = input.nextLine();
        if (!nuevoCelular.isBlank()) {
            service.actualizarCelular(usuarioBuscado, nuevoCelular);
        }
        
        System.out.println("=====================================");
        System.out.println("Usuario actualizado correctamente");
        System.out.println("=====================================");
    }
    
    public void eliminar(Scanner input){
        listar();
        System.out.print("Ingrese el ID del usuario a eliminar: ");
        long id = Long.parseLong(input.nextLine());
        Usuario usuarioBuscado = service.buscarUsuarioPorId(id);
        if (usuarioBuscado == null || usuarioBuscado.isEliminado() == true) {
            System.out.println("=====================================");
            System.out.println("El usuario no existe o fue eliminado");
            System.out.println("=====================================");
            return;
        }
        
        System.out.print("Esta seguro que desea eliminar el usuario ID " + usuarioBuscado.getId() + " - " + usuarioBuscado.getNombre() + " ? (S/N): ");
        String respuesta = input.nextLine();
        if (respuesta.equalsIgnoreCase("S")) {
            service.eliminarUsuario(usuarioBuscado);
            System.out.println("=====================================");
            System.out.println("Usuario eliminado correctamente");
            System.out.println("=====================================");
        } else {
            System.out.println("=====================================");
            System.out.println("Eliminacion cancelada");
            System.out.println("=====================================");
        }
    }   
}
