package Evento;


import Evento.TipoElementoAdicional;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kenneth
 */
public class ElementoAdicional {
    private int cantidad;
    private double precio;
    private TipoElementoAdicional tipoElementoAdicional;
            
    
    public int getCantidad(){
        return this.cantidad;
    } 
    public void  setCantidad(int cantidad){
        this.cantidad=cantidad;
    }
      
   public double getPrecio(){
        return this.precio;
    } 
    public void  setPrecio(double precio){
        this.precio=precio;
    }
      
   public TipoElementoAdicional getTipoElementoAdicional(){
        return this.tipoElementoAdicional;
    } 
    public void  setTipoElementoAdicional(TipoElementoAdicional tipoElementoAdicio){
        this.tipoElementoAdicional=tipoElementoAdicional;
    }
    

    
}
