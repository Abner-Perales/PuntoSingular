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
public class Cuadrado { //Clase cuadrado
    double lado; //Contiene una variable que guarda el lado
    
    //Esta función regresa el área del cuadrado
    public double CalcularArea(){
        return lado * lado;
    }
    
    //Esta función regresa el perímetro del cuadrado
    public double CalcularPerimetro(){
        return lado * 4;
    }    
    
    //Este método nos permite asignar el valor de lado
    public void setLado(double l){
        lado = l;
    }
    
    //Este método nos permite obtener el lado
    public double getLado(){
        return lado;
    }
}
