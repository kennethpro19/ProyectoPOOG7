package Documento;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Evento.*;
import Usuario.*;
import java.util.ArrayList;

import java.util.Random;
import java.util.Date;
import Main.*;
import java.text.SimpleDateFormat;
/**
 *
 * @author U_DoN_T_KnOw_Me
 */
public class OrdenPago {
    private EstadoOrdenDePago estado;
    private Cliente cliente;
    private Evento evento;
    private int codigo;
    private int codTrans;
    private Date fechaReg;
    private double valorTotal;
    private Date fechaHoy;

    public OrdenPago(Evento evento,Cliente cliente){
        this.evento=evento;
        this.cliente=cliente;
        Interfaz i=new Interfaz();
        this.codigo=i.crearCodigos();
        this.valorTotal=evento.getValorTotal();
        this.estado=EstadoOrdenDePago.PENDIENTEPAGO;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
             Date fechaHoy = new Date();
    
        this.fechaHoy=fechaHoy;
    }
  
  

    public OrdenPago(Evento evento,Cliente cliente,EstadoOrdenDePago estado,int codigo, int codTrans){
        Interfaz i=new Interfaz();
        
       this.evento=evento;
       this.cliente=cliente;
       this.estado= estado;
       this.codigo=codigo;
       this.codTrans=codTrans;
       this.valorTotal=evento.getValorTotal();
    }
    
    public void setCodTrans(int codTrans){
            this.codTrans=codTrans;
        }
    public int getCodTrans(){
        return this.codTrans;
    }
    public Evento getEvento(){
        return this.evento;
    }
    public void setEvento(Evento evento){
        this.evento=evento;
    }
    
    public Cliente getCliente(){
        return this.cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente=cliente;
    }
    public int getCodigo(){
        return this.codigo;
    }
    public void setCodigo(int codigo){
        this.codigo=codigo;
    }
        
    public String getEstadoOrdenDePago(){
        return this.estado.name();
    }
    public void setEstadoOrdenDePago(EstadoOrdenDePago estado){
        this.estado=estado;
    }
    
    public Date getFechaReg(){
        return this.fechaReg;
    }
    
    public void setFechaReg(Date fechaRegistro){
        this.fechaReg=fechaRegistro;
    }
    public Date getFechaHoy(){
        return this.fechaHoy;
    }
    public double getValorTotal(){
        return this.valorTotal;
    }
    
    public void setValorTotal(double valortotal){
        this.valorTotal=valortotal;
    }



   
    }