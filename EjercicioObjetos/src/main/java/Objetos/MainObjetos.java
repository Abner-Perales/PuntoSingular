/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author PC
 * 
 * El programa inicia con la declaración de las variables y objetos necesarios para el funcionamiento del programa.
 * Luego, entramos a un ciclo do while, esto con el fin de que el menú se muestre al menos una vez.
 * Antes del menú, ingresamos el valor del lado, esto para poder usarse como valor para el cuadrado y el cubo.
 * No se dio la opción al usuario de elegir qué figura, puesto que las instrucciones detallaban el menú y no era una opción.
 * Después de validar que el usuario ingrese un valor válido, entramos al menú dentro de una condición, esto nos permite pedir 
 *  al usurio reingresar el dato en caso de no ser válido.
 * En dicho menú se muestra el valor del lado y permite al usuario elegir un calculo, volver a capturar el lado o salir del programa.
 * Luego se entra a un switch donde se  llama a la función correspondiente según el cálculo deseado, o se asigna el valor a las variables
 *  booleanas según la desición del usuario.
 * Dichas variables controlan el menú en el que se encuentra el usuario.
 * El programa muestra el cálculo solicitado y pregunta por otro cálculo, el usuario solo puede salir eligiendo dicha opción
 */
import java.util.Scanner;

public class MainObjetos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declaramos los objetos y variables que necesitaremos
        Scanner leer = new Scanner(System.in);
        Cuadrado cuadrado = new Cuadrado();
        Cubo cubo = new Cubo();
        boolean b = false, b2 = true;
        String opc = "";
        double lado = 0;
        
        do{ //Ciclo para pedir el lado de la figura las veces que el usuario necesite
            try{ // Se utiliza este control de excepciones para evitar que el usuario capture un caracter no válido
                //Pedimos el valor del lado al usuario y lo asignamos a ambos objetos, cuadrado y cubo
                System.out.println("Ingrese el lado de la figura:");
                lado = Double.parseDouble(leer.nextLine());
                cuadrado.setLado(lado);
                cubo.setLado(lado);
                b = true; //Esta variable en true nos dice que podemos continuar con el menú
            } catch(Exception e){ //Cuando ingresa algo erroneo, se despliega un mensaje
                System.out.println("Por favor ingrese un número...");
                //Esta variable debe volverse false en un fallo, puesto que de volverse siempre true y 
                // ocurre un fallo después de una correcta captura, seguiria tomandola como correcta.
                b = false;
            }
            
            if(b){ //Cuando se capturó un número correctamente
                do{ //Ingresamos a un ciclo do while
                    //Desplegamos nuestro menú
                    System.out.println("----------------------------------");
                    System.out.println("Medida actual del lado: " + lado); 
                    System.out.println();
                    System.out.println("Elija una opción:");
                    System.out.println("1. Calcular área de un cuadrado.");
                    System.out.println("2. Calcular perímetro de un cuadrado.");
                    System.out.println("3. Calcular volumen de un cubo.");
                    System.out.println("4. Calcular perímetro de un cubo.");
                    System.out.println("5. Volver a ingresar el lado.");
                    System.out.println("Cualquier otro valor para salir.");
                    opc = leer.nextLine(); //Leemos la respuesta del usuario, en este caso, que cálculo u opción quiere
                    b2 = true; //Volvemos la variable b2 true, de lo contrario, después de cambiar el valor de lado una vez nos pediría cambiar siempre. 
                    switch(opc){ //Se realiza la acción correspondiente deacuerdo a la opción solicitada.
                        case "1":
                            System.out.println("El área del cuadrado es: " + cuadrado.CalcularArea());
                            break;
                        case "2":
                            System.out.println("El perímetro del cuadrado es: " + cuadrado.CalcularPerimetro());
                            break;
                        case "3":
                            System.out.println("El volumen del cubo es: " + cubo.CalcularVolumen());
                            break;
                        case "4":
                            System.out.println("El perímetro del cubo es: " + cubo.CalcularPerimetro());
                            break;
                        case "5":
                            //Cuando se quiere reingresar el lado, debemos salir del menú de cálculos, por lo tanto esta variable debe ser false.
                            b2 = false; 
                            break;
                        default:
                            //Cuando queremos salir del programa, volvemos ambas variables false, para salir de los ciclos y por tanto, del programa.
                            b2 = false;
                            b = false;
                            break;
                    }
                } while(b2);                
            } else
                b = true; //Cuando encontramos una excepcion b se vuelve falsa, peor necesitamos seguir ciclando, así que la volvemos true después evitando el menú de calculos
            
        } while(b);
        System.out.println("Saliendo del programa..."); //Cuando el usuario sale del sistema, se despliega un mensaje
    }
    
}
