package Evento;


import Evento.Evento;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kenneth
 */
public class Boda extends Evento{
     private static double precio=3500;
     private String tipoDeVehiculo;
     
       public void  setTipoDeVehiculo(String tipoDeVehiculo){
        this.tipoDeVehiculo=tipoDeVehiculo;
    }
     public String getTipoDeVehiculo(){
        return this.tipoDeVehiculo;
    } 
     
     @Override
    public void mostrarMensaje(){

    System.out.println("Los novios tendrán un 25% de descuento si compran sus tickets de luna de miel en la aerolínea LATAM.");
    }
}
