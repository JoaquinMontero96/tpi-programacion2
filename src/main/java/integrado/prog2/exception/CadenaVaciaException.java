/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integrado.prog2.exception;

/**
 *
 * @author JOAQUIN
 */
public class CadenaVaciaException extends RuntimeException{

    public CadenaVaciaException() {
    }

    public CadenaVaciaException(String message) {
        super(message);
    }
    
}
