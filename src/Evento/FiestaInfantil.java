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
public class FiestaInfantil extends Evento{
     private static double precio=300;
     private int cantPerDis;
     private int cantSorp;
     private boolean incJuego;
       
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
     public void mostrarMensaje(){
         System.out.println();
     }
}
