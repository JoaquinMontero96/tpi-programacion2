/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integrado.prog2.service;

import integrado.prog2.entities.Usuario;
import integrado.prog2.enums.Rol;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestion de usuarios
 * @author JOAQUIN
 */
public class UsuarioService {
    List<Usuario> usuarios = new ArrayList<>(); /** Listado de usuarios */
    
    /**
     * Lista los usuarios creados
     */
    public void listarTodos() {
        if (usuarios.isEmpty()) {
            System.out.println("=====================================");
            System.out.println("No hay usuarios cargados.");
            System.out.println("=====================================");
        } else {
            for (Usuario usuario : usuarios) {
                if (usuario.isEliminado() == false) {
                    System.out.println(usuario);
                }
            }
        }
    }
    
    /**
     * Busca un usuario por su email
     * @param email Email
     * @return Usuario buscado
     */
    public Usuario buscarUsuarioPorMail(String email) {
        Usuario usuarioBuscado = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getMail().equalsIgnoreCase(email)){
                usuarioBuscado = usuario;
            }
        }
        return usuarioBuscado;
    }
    
    /**
     * Busca un usuario por su ID
     * @param id ID de usuario
     * @return Usuario buscado
     */
    public Usuario buscarUsuarioPorId(long id) {
        Usuario usuarioBuscado = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id){
                usuarioBuscado = usuario;
            }
        }
        return usuarioBuscado;
    }
    
    /**
     * Actualiza el nombre de usuario
     * @param usuario Usuario a actualizar
     * @param nombre Nuevo nombre
     */
    public void actualizarNombre (Usuario usuario, String nombre) {
        usuario.setNombre(nombre);
    }
    
    /**
     * Actualiza el apellido de usuario
     * @param usuario Usuario a actualizar
     * @param apellido Nuevo apellido
     */
    public void actualizarApellido (Usuario usuario, String apellido) {
        usuario.setApellido(apellido);
    }
    
    /**
     * Actualiza email de usuario
     * @param usuario Usuario a actualizar
     * @param email Nuevo email
     */
    public void actualizarEmail (Usuario usuario, String email) {
        usuario.setMail(email);
    }
    
    /**
     * Actualiza numero de celular de usuario
     * @param usuario Usuario a actualizar
     * @param celular Nuevo celular
     */
    public void actualizarCelular (Usuario usuario, String celular) {
        usuario.setCelular(celular);
    }
    
    /**
     * Crea un usuario y lo agrega al listado
     * @param nombre Nombre
     * @param apellido Apellido
     * @param mail Email
     * @param celular Numero de celular
     */
    public void crearUsuario(String nombre, String apellido, String mail, String celular) {
        Usuario nuevoUsuario = new Usuario(nombre, apellido, mail, celular, Rol.USUARIO);
        usuarios.add(nuevoUsuario);
        System.out.println("=====================================");
        System.out.println("Usuario ID " + nuevoUsuario.getId() + " creado exitosamente");
        System.out.println("=====================================");
        nuevoUsuario.enviarContraseniaPorMail();
    }
    
    /**
     * Cambia de estado eliminado a usuario
     * @param usuario Usuario a eliminar
     */
    public void eliminarUsuario(Usuario usuario) {
        usuario.setEliminado(true);
    }
}
