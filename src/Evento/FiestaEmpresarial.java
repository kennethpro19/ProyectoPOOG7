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
public class FiestaEmpresarial extends Evento {
    
    private static double precio = 2000;
    private boolean transporte;
    private int personas;

    public FiestaEmpresarial(boolean transporte,int personas,Cliente cliente,Planificador planificador,Date fechaEvento,String horaDeInicio,
             String horaDeSalida,int capacidad){
        super(cliente,planificador,fechaEvento,horaDeInicio, horaDeSalida, capacidad);
        super.setValorTotal(precio+super.calcularCostoTotal());
        this.transporte=transporte;
        this.personas=personas;
    }
    public FiestaEmpresarial(){
        
    }
    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }

    public boolean getTransporte() {
        return this.transporte;
    }

    public void setPersonas(int personas) {
        this.personas = personas;
    }

    public int getPersonas() {
        return this.personas;
    }
    @Override
    public void mostrarMensaje(){

    System.out.println("El transporte al lugar del evento es gratuito en un próximo evento, si lo organizan con el mismo planificador.");
    }
     
    @Override
    public double getPrecio(){
        return precio;
    }
    
}