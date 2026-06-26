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
 *
 * @author JOAQUIN
 */
public class UsuarioService {
    List<Usuario> usuarios = new ArrayList<>();
    
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
    
    public Usuario buscarUsuarioPorMail(String email) {
        Usuario usuarioBuscado = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getMail().equalsIgnoreCase(email)){
                usuarioBuscado = usuario;
            }
        }
        return usuarioBuscado;
    }
    
    public Usuario buscarUsuarioPorId(long id) {
        Usuario usuarioBuscado = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id){
                usuarioBuscado = usuario;
            }
        }
        return usuarioBuscado;
    }
    
    public void actualizarNombre (Usuario usuario, String nombre) {
        usuario.setNombre(nombre);
    }
    
    public void actualizarApellido (Usuario usuario, String apellido) {
        usuario.setApellido(apellido);
    }
    
    public void actualizarEmail (Usuario usuario, String email) {
        usuario.setMail(email);
    }
    
    public void actualizarCelular (Usuario usuario, String celular) {
        usuario.setCelular(celular);
    }
    
    public void crearUsuario(String nombre, String apellido, String mail, String celular) {
        Usuario nuevoUsuario = new Usuario(nombre, apellido, mail, celular, Rol.USUARIO);
        usuarios.add(nuevoUsuario);
        System.out.println("=====================================");
        System.out.println("Usuario ID " + nuevoUsuario.getId() + " creado exitosamente");
        System.out.println("=====================================");
        nuevoUsuario.enviarContraseniaPorMail();
    }
    
    public void eliminarUsuario(Usuario usuario) {
        usuario.setEliminado(true);
    }
}
