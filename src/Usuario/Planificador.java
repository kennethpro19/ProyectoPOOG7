/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;
import java.util.ArrayList;

import Evento.*;
import Main.*;

import Documento.OrdenPago;
import Evento.Evento;

/**
 *
 * @author stefano
 */
public class Planificador extends Usuario{

    public Planificador(String nombre, String apellido,String usuario,String contrasena,char tipoUsuario){
        super( nombre, apellido,usuario,contrasena,tipoUsuario);
    }
    ArrayList <Evento> eventos= Sistema.eventos;
    //public Solicitud solicitud;
    //public ArrayList<Evento> evento;
    public ArrayList <Evento> getEventos(){
        return this.eventos;
    }


   private static ArrayList<OrdenPago> ordenesPago;


   public static ArrayList<OrdenPago> getOrdenesPago() {
       return ordenesPago;
   }
}


