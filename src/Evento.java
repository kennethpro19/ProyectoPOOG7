/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Kenneth
 */
public class Evento {
    private EstadoEvento estadoEvento;
    private ArrayList<ElementoAdicional> elementosAdicionales;
    private int capacidad;
    private Date horaDeInicio;
    private Date horaDeSalida;
    private int codigo;
    //private char deseaAggEle;
    private double valorTotal;
    private static ArrayList<Integer> numbers;    
        
    public Evento(){
    this.numbers = new ArrayList<>(9999);
        for (int i = 1; i < 10000; i++) {
            numbers.add(i);
        }
    this.codigo=generarCodigo();    
    }
    public EstadoEvento getEstadoEvento(){
        return this.estadoEvento;
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
    public Date getHoraDeInicio(){
        return this.horaDeInicio;
    } 
    public void  setHoraDeInicio(Date horaDeInicio){
        this.horaDeInicio=horaDeInicio;
    }
    public Date getHoraDeSalida(){
        return this.horaDeSalida;
    } 
    public void  setHoraDeSalida(Date horaDeSalida){
        this.horaDeSalida=horaDeSalida;
    }
    public int getCodigo(){
        return this.codigo;
    } 
   //Codigo no tiene un Set puesto que el codigo se genera automaticamente y no cambia
    
    public int generarCodigo(){
        
        Random r = new Random();
        int b = numbers.size() - 999;

        int a = r.nextInt(b) + 999;

        return numbers.remove(a);
        
    }
    
}
