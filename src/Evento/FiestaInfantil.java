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
//Herencia
public class FiestaInfantil extends Evento{
     private static double precio=300;
     private int cantPerDis;
     private int cantSorp;
     private boolean incJuego;
     
     public FiestaInfantil(int cantPerDis,int cantSorp,boolean incJuego,Cliente cliente,Planificador planificador,Date fechaEvento,String horaDeInicio,
         String horaDeSalida,int capacidad){
         super(cliente,planificador,fechaEvento,horaDeInicio, horaDeSalida, capacidad);
         super.setValorTotal(precio+super.calcularCostoTotal());
         this.cantPerDis=cantPerDis;
         this.cantSorp=cantSorp;
         this.incJuego=incJuego;
     }
     public FiestaInfantil(){
         
     }
     public void  setCantPerDis(int cantPerDis){
        this.cantPerDis=cantPerDis;
    }
     public int getCantPerDis(){
        return this.cantPerDis;
    } 
     
      public void  setCantSorp(int cantSorp){
        this.cantSorp=cantSorp;
    }
     public int getCantSorp(){
        return this.cantSorp;
    }  
       public void  setIncJuego(boolean incJuego){
        this.incJuego=incJuego;
    }
     public boolean getIncJuego(){
        return this.incJuego;
    } 

    @Override
    public void mostrarMensaje(){

    System.out.println("Si realizan un próximo evento en las mismas instalaciones en un plazo de 6 meses se les otorgará en servicio de música gratuito.");
    }
     
    @Override
    public double getPrecio(){
        return precio;
    }
}