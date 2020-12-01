package Evento;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import Usuario.Cliente;
import Usuario.Planificador;
import Main.*;
/**
 *
 * @author Kenneth
 */
public class Evento {
    private EstadoEvento estadoEvento=EstadoEvento.PENDIENTE;
    private ArrayList<ElementoAdicional> elementosAdicionales;
    private int capacidad;
    private String horaDeInicio;
    private String horaDeSalida;
    private int codigo;
    private Cliente cliente;
    private Planificador planificador;
    private double valorTotal;
    private Date fechaEvento;
    
        public Evento(Cliente cliente,Planificador planificador,Date fechaEvento,String horaDeInicio,String horaDeSalida,int capacidad){
        this.codigo = generarCodigo(Sistema.numerosEvento);
        this.capacidad=capacidad;
        this.cliente=cliente;
        this.planificador=planificador;
        this.horaDeInicio=horaDeInicio;
        this.horaDeSalida=horaDeSalida;
        this.valorTotal=calcularCostoTotal();
        this.fechaEvento=fechaEvento;
    }
    

    public void setCodigo(ArrayList<Integer> numbers){
        this.codigo=generarCodigo(numbers);
        
    }

    public String getEstadoEvento(){
        return this.estadoEvento.name();
    } 
    public void  setEstadoEvento(EstadoEvento estadoEvento){
        this.estadoEvento=estadoEvento;
    }
     public ArrayList<ElementoAdicional> getElementosAdicionales(){
        return this.elementosAdicionales;
    } 
    public void  setElementosAdicionales(ArrayList<ElementoAdicional> elementosAdicionales){
        this.elementosAdicionales=elementosAdicionales;
    }
    public int getCapacidad(){
        return this.capacidad;
    } 
    public void  setCapacidad(int capacidad){
        this.capacidad=capacidad;
    }
    public String getHoraDeInicio(){
        return this.horaDeInicio;
    } 
    public void  setHoraDeInicio(String horaDeInicio){
        this.horaDeInicio=horaDeInicio;
    }
    public String getHoraDeSalida(){
        return this.horaDeSalida;
    } 
    public void  setHoraDeSalida(String horaDeSalida){
        this.horaDeSalida=horaDeSalida;
    }
    public int getCodigo(){
        return this.codigo;
    } 
   //Codigo no tiene un Set puesto que el codigo se genera automaticamente y no cambia
    
      public Cliente getCliente(){
        return this.cliente;
    } 
    public void  setCliente(Cliente cliente){
        this.cliente=cliente;
    }
      public Planificador getPlanificador(){
        return this.planificador;
    } 
    public void  setPlanificador(Planificador planificador){
        this.planificador=planificador;
    }
    
    public  void mostrarMensaje(){
        
    }
    public int generarCodigo(ArrayList<Integer> numbers){
        
        Random r = new Random();
        int b = numbers.size() - 999;

        int a = r.nextInt(b) + 999;

        return numbers.remove(a);
        
    }
    
    public void agregarElementoAdicional(ElementoAdicional elementoAdicional){
        this.elementosAdicionales.add(elementoAdicional);
   
    }
    
    public double getValorTotal(){
        return this.valorTotal;
    }
    public void setValorTotal(double valorTotal){
        this.valorTotal=valorTotal;
    }
    public double calcularCostoTotal(){
        double total=0.0; 
        for(ElementoAdicional elementoAdicional:elementosAdicionales){
            total+=elementoAdicional.getTotal();
         }
     return total;
    }
    
    public Date getFechaEvento(){
        return this.fechaEvento;
    }

    public double getPrecio() {
        return 0;
    }
    public Evento(){
    
}

}
