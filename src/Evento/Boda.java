package Evento;


import Evento.Evento;
import Usuario.Cliente;
import Usuario.Planificador;
import java.util.Date;
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
     
     public Boda(String tipoDeVehiculo,Cliente cliente,Planificador planificador,Date fechaEvento,String horaDeInicio,
             String horaDeSalida,int capacidad){
         super(cliente,planificador,fechaEvento,horaDeInicio, horaDeSalida, capacidad);
         super.setValorTotal(precio+super.getValorTotal());
         this.tipoDeVehiculo=tipoDeVehiculo;
         

     }
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
