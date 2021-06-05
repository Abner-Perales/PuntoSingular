/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Romanos;
import java.util.Scanner;
/**
 *
 * @author PC
 */

/**
 *  Funcionamiento del programa
 * El usuario recibe un mensaje pidiendo el número en notación decimal.
 * Luego el programa valida que esté ingresando un número.
 * Posteriormnete, envía el valor de dicho número a un método llamado convertir, el cual regresará como número romano
 * Luego, se le muestra al usuario el número ya convertido. O un mensaje de error en caso de no haber ingresado correctamente un número
 * en notación decimal.
 */
public class MainRomanos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ConversorRomanos conversor = new ConversorRomanos();
        
        //Controlamos las excepciones en caso de que el usuario ingrese un caracter y no un número.
        try{
            System.out.println("Ingres número decimal"); //Desplegamos mensaje al usuario
            int x = leer.nextInt(); // Leemos el número dado por el usuario
            System.out.println(x + " en romano es: " + conversor.Convertir(x)); //Llamamos al conversor e imprimimos su resultado
        } catch(Exception e){
            //En caso de no ingresar un numero, imprimimos un mensaje
            System.out.println("Ingrese solo números por favor...");
        }
        
        
    }
    
}
