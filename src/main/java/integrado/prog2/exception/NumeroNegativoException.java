/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integrado.prog2.exception;

/**
 * Excepcion de numeros negativos
 * @author JOAQUIN
 */
public class NumeroNegativoException extends RuntimeException{

    public NumeroNegativoException() {
    }

    public NumeroNegativoException(String message) {
        super(message);
    }
}
