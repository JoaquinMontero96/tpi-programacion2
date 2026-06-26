/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package integrado.prog2;

import integrado.prog2.ui.MenuPrincipal;
import java.util.Scanner;

/**
 *
 * @author JOAQUIN
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        int opcion = -1;
        
        while (opcion != 0) {            
            menuPrincipal.mostrar();
            try {                
                opcion = Integer.parseInt(input.nextLine());
                menuPrincipal.seleccionarOpcion(opcion, input);           
            } catch (NumberFormatException e) {
                System.out.println("=====================================");
                System.out.println("Debe ingresar un numero");
                System.out.println("=====================================");
            }
        }
    }
}
