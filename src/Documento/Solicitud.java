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
    private Evento evento;
    
    public void crearCodigo(){
        codigo=codigo+1;
        
    }
    public Solicitud(Cliente cliente, Planificador planificador, Date fechaRegistro, Evento evento){
        this.cliente=cliente;
        this.planificador=planificador;
        this.evento=evento;
        this.fechaRegistro=fechaRegistro;
    }
}
