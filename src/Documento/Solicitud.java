package Documento;


import Usuario.*;
import Evento.*;
import java.util.Date;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author U_DoN_T_KnOw_Me
 */
public class Solicitud {
        //EstadoSol estado;
    private static int codigo1=1000;
    private static int codigo2=2000;
    private static int codigo3=3000;
    private int codigo;
    private Cliente cliente;
    private Planificador planificador;
    private Date fechaRegistro;
    private Date fechaEvento;
    private String tipoEvento;
    private EstadoSolicitud estadoSol;
    
 
    public Solicitud(Cliente cliente, Planificador planificador, Date fechaRegistro, Date fechaEvento, String tipoEvento){
        this.cliente=cliente;
        this.planificador=planificador;
        this.tipoEvento=tipoEvento;
        this.fechaRegistro=fechaRegistro;
        this.fechaEvento=fechaEvento;
        if(tipoEvento.equals("Boda")){
            this.codigo=codigo1+1;    
        }
        else if(tipoEvento.equals("Fiesta Empresarial")){
            this.codigo=codigo2+1;
        }
        else if(tipoEvento.equals("Fiesta Infantil")){
            this.codigo=codigo3+1;
        }
        
        this.estadoSol=EstadoSolicitud.PENDIENTE;
    }
    public Solicitud(int codigo,Cliente cliente, Planificador planificador, Date fechaRegistro, Date fechaEvento, EstadoSolicitud estadoSol){
        this.cliente=cliente;
        this.planificador=planificador;
        if (codigo>=1000 && codigo <2000){
            this.tipoEvento="Boda";
        }
        else if(codigo>=2000 && codigo < 3000){
            this.tipoEvento="Fiesta Empresarial";
        }else if(codigo>=3000 && codigo <4000){
            this.tipoEvento="Fiesta Infantil";
        }
        this.fechaRegistro=fechaRegistro;
        this.fechaEvento=fechaEvento;
        this.codigo=codigo;
        this.estadoSol=estadoSol;
    }
    public int getCod(){
    return this.codigo;
    }
    public void setEstadoSol(EstadoSolicitud estadoSol){
        this.estadoSol=estadoSol;
    }
    public String getTipoEvento(){
        return tipoEvento;
    }
    public Date getFechaEvento(){
        return this.fechaEvento;
    }
    
    public String getEstadoSol(){
        return this.estadoSol.name();
    }
    public Cliente getCliente(){
        return this.cliente;
    }
    public Planificador getPlanificador(){
        return this.planificador;
    }
    public Date getFechaRegistro(){
        return this.fechaRegistro;
    }
  
}