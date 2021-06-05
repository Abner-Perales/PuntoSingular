/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Morse;

/**
 *
 * @author PC
 */

/*
 * El programa comienza declarando las variables necesarias para el funcionamiento del mismo. Luego entra al ciclo do while, el cual le permitirá ejecutarse al menos una vez.
 * Luego se le pide al usuario que eliga que tipo de traducción necesita o si desea salir del programa.
 * Una vez evaluada la respuesta, se utiliza la función de TraducirAMorse o TraducirATexto según sea el caso, o bien, sale del programa.
 * Se eligió realizar ambas funciones por separado para mejor organización y lectura del código.
 * Una vez devuelto la traducción del código o texto enviado a las funciones de traducción, se imprime el resultado en consola.
 * En caso de que se ingrese un código o caracter no válido, se mostrará un mensaje al usuario.
 * El usuario podrá traducir las veces que desee mientras no elija la opción de salir del programa.
 * 
 * El flujo del programa es:
 * MainMorse > TraducirAMorse > PalabrasAMorse > LetrasAMorse
 * MainMorse > TraducirATexto > PalabrasATexto > LetrasATexto
 * */

import java.util.Scanner;
public class MainMorse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	boolean b = true;
    	String opc = "";
    	Scanner leer = new Scanner(System.in);
    	TraductorMorse t = new TraductorMorse();
    	
    	do {
    		System.out.println("Ingrese la opción que desee:");
    		System.out.println("1. Traducir texto a código morse.");
    		System.out.println("2. Traducir código morse a texto.");
    		System.out.println("Cualquier otro caracter para cerrar el programa.");
    		opc = leer.nextLine();
    		
    		if(opc.equals("1")) {
    			System.out.println("Ingrese el texto a traducir el código morse");
    			opc = leer.nextLine();
        		System.out.println(t.TraducirAMorse(opc));
        		System.out.println("");
        		System.out.println("-------------------------------------------");
    		} else if(opc.equals("2")) {
    			System.out.println("Ingrese el código morse a traducir en texto");
    			opc = leer.nextLine();
        		System.out.println(t.TraducirATexto(opc));
        		System.out.println("");
        		System.out.println("-------------------------------------------");
    		} else
    			b = false;
    		
    	} while(b);
    	
    }
    
}
