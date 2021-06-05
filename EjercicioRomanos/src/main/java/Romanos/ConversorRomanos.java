/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Romanos;



/**
 *
 * @author PC
 */
public class ConversorRomanos {
    //Declaramos los números en una matriz para crear una relación entre decimal y romano
    //Algo importante a tomar en cuenta, es que los digitos de unidades comienzan en la posición 0
    //Los digitos de las decenas en la posición 2, los dígitos de las centenas en el 4, y el millar en la posición 6
    String [][] numeros = {{"1", "I"},{"5", "V"},{"10", "X"},{"50", "L"},{"100", "C"},{"500", "D"},{"1000", "M"}};
    
    //Función encargada de devolver el número en romano
    public String Convertir(int numeroDecimal){ // Solo recibe números del 1 al 1000
        String numeroRomano = ""; // Declaramos la variable que contendrá el número romano
        //Cuando el número es menor a 1000 y mayor a 0, entonces podemos realizar las operaciones correspondientes
        if(numeroDecimal < 1000 && numeroDecimal > 0){ 
            //Si el número está dentro del rango definido, entonces descomponemos el número en unidades, decenas y centenas.
            //Ejemplo numero = 234 
            int numero = numeroDecimal; // numero = 234
            int unidad = numero % 10; // unidad = 234 % 10 = 4
            int decena = (numero/10) % 10; // decena = (234/10) % 10 = (23) % 10 = 3
            int centena = numero/100; // centena = 234/100 = 2

            /* Llamamos a la función Digito para que nos regrese la equivalencia de un dígito en número romano.
            * Esta función nos regresa el digito en romano según su posición en la matriz.
            * Esto nos permite utilizar una misma función para las unidades, decenas y centenas
            * 0 = unidad, 2 = decena, 4 = centena, ** 6 = millar 
            * Después solo concatenamos los dígitos en romano y formamos el número completo
            */
            numeroRomano = Digito(centena, 4) + Digito(decena, 2) + Digito(unidad, 0);
        } else if(numeroDecimal == 1000){ //Cuando el número es igual a 1000, entonces asignamos directamente el valor de M
            numeroRomano = "M";
        } else { //Cuando el número no está en el rango definido en las instrucciones, entonces desplegamos un mensaje.
            numeroRomano = "Fuera de rango...";
        }        
        return numeroRomano;
    }
    
    // Esta función regresa el número romano correspondiente al dígito, recibe como parámetro el dígito y la posición en el array
    String Digito(int digito, int posicion){
        String digitoRomano = ""; //Declaramos la variable que necesitaremos
        if(digito == 9){ //Cuando el digito es 9, tenemos un caso especial
            //Regresamos la posición en el array para el digito adjunto de la posición en el siguiente nivel
            // Ejemplo: I + X = IX --- I =  posicion 0, V = posicion 1, X = posicion 2
            digitoRomano = numeros[posicion][1] + numeros[posicion + 2][1];
        } else if(digito >= 5){ //Cuando el digito esta entre 5 y 8, entonces debemos imprimir el numero correspondiente al digito 5, más la diferencia con el 5.
            //Ejemplo, si el digito es 6, entonces imprimimos V + I = VI
            digitoRomano = numeros[posicion + 1][1]; //Imprimo el valor correspondiente al digito 5
            if(digito - 5 > 0){
                for(int i = 0; i < digito - 5; i++){ //Imprimo el valor correspondiente al digito las veces que sea necesario.
                   digitoRomano += numeros[posicion][1]; 
                }
            }
        } else if(digito == 4){ //En 4 también es un caso especial. Aquí directamente imprimimos la posición de digito actual + el digito siguiente
            digitoRomano = numeros[posicion][1] + numeros[posicion + 1][1];
        } else if(digito > 0){ //Cuando el digito es menor que 4 pero mayor que 0, entonces imprimimos el valor en romano del digito las veces que se deba repetir
            for(int i = 0; i < digito; i++){
                digitoRomano += numeros[posicion][1];
            }
        }        
        return digitoRomano; //Regresamos el valor correspondiente al digito y posicion recibido.
    }
}
