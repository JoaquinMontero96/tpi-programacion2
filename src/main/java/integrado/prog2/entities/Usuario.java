/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integrado.prog2.entities;

import integrado.prog2.enums.Rol;
import java.time.LocalDateTime;
import java.security.SecureRandom;

/**
 * Usuario
 * @author JOAQUIN
 */
public class Usuario extends Base {
    private String nombre; /** Nombre de usuario */
    private String apellido; /** Apellido de usuario */
    private String mail; /** Email de usuario */
    private String celular; /** Numero de celular de usuario */
    private String contrasenia; /** Contraseña de usuario */
    private Rol rol; /** Rol de usuario */
    private static long cantidadUsuarios = 0; /** Cantidad de usuarios creados */
    private static final String ALFANUMERICO = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; /** Caracteres permitidos para contraseña*/
    private static final SecureRandom RANDOM = new SecureRandom(); /** Generador de contraseñas */

    public Usuario(String nombre, String apellido, String mail, String celular, Rol rol) {
        super(cantidadUsuarios + 1, false, LocalDateTime.now());
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.celular = celular;
        this.contrasenia = generarContrasenia(8);
        this.rol = rol;
        cantidadUsuarios++;
    }

    public String getMail() {
        return mail;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void enviarContraseniaPorMail() {
        System.out.println("Contraseña enviada por mail: " + this.contrasenia);
        System.out.println("=====================================");
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    
    /**
     * Genera una contraseña aleatoria
     * @param longitud Cantidad de caracteres
     * @return 
     */ 
    private String generarContrasenia(int longitud) {
        StringBuilder sb = new StringBuilder(longitud);
        
        for (int i = 0; i < longitud; i++) {
            // Selecciona un índice aleatorio del pool de caracteres
            int indiceAleatorio = RANDOM.nextInt(ALFANUMERICO.length());
            char caracterAleatorio = ALFANUMERICO.charAt(indiceAleatorio);
            
            // Lo añade al constructor de la cadena
            sb.append(caracterAleatorio);
        }

        return sb.toString();
    }
    
    @Override
    public String toString() {
        return this.getId() + "  -  " + this.nombre + " " + this.apellido + "  -  " + this.mail + "  -  " + this.rol;
    }
    
}
