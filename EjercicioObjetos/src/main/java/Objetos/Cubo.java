/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author PC
 */
public class Cubo extends Cuadrado { //Clase hija de Cuadrado
    //Sobre escribimos la función CalcularPerimetro para que funcione con el cubo
    @Override
    public double CalcularPerimetro(){
        return lado * 12;
    }
    //Esta función regresa el valor del volumen del cubo
    public double CalcularVolumen(){
        return lado * lado * lado;
    }    
    
}
