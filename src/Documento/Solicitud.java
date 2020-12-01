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
    static int codigo=1000;
    private Cliente cliente;
    private Planificador planificador;
    private Date fechaRegistro;
    private Date fechaEvento;
    private String tipoEvento;
    private EstadoSolicitud estadoSol;
    
    public int crearCodigo(){
        codigo=codigo+1;
        return codigo;
        
    }
    public Solicitud(Cliente cliente, Planificador planificador, Date fechaRegistro, Date fechaEvento, String tipoEvento){
        this.cliente=cliente;
        this.planificador=planificador;
        this.tipoEvento=tipoEvento;
        this.fechaRegistro=fechaRegistro;
        this.fechaEvento=fechaEvento;
        this.codigo=crearCodigo();
        this.estadoSol=EstadoSolicitud.PENDIENTE;
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
    
  
}
