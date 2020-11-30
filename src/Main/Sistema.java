/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.util.ArrayList;
import Usuario.*;
import java.util.Scanner;
import Documento.*;
import Evento.*;
/**
 *
 * @author U_DoN_T_KnOw_Me
 */
public class Sistema {

    public static ArrayList<Evento> eventos=new ArrayList <Evento>();
    public static ArrayList <OrdenPago> ordenpag= new ArrayList <OrdenPago>();
    public static ArrayList <Cliente> clientes= new ArrayList <Cliente>();
    public static ArrayList <Planificador> planificadores= new ArrayList <Planificador>();
    public static ArrayList <Solicitud> solicitudes = new ArrayList <Solicitud>();
    public static void main(String []args){
       
        ArrayList <Integer> numerosEvento= new ArrayList <Integer>(9999);
        ArrayList <Integer> numerosOrdenpago=new ArrayList <Integer>(9999);
       
        
        for (int i = 1; i < 10000; i++) {
            numerosEvento.add(i);
            numerosOrdenpago.add(i);
        }
        Interfaz i= new Interfaz();
     
        ArrayList <String> info = i.iniciarSesion();
        Archivo archivo= new Archivo();
        i.crearUsuarios(archivo.lineas,archivo.clientes);
        String cop=i.clienteOPlanificador(archivo.lineas,info.get(0),info.get(1));
        if (cop.equals("C")){
            Cliente c=(Cliente)(i.buscarUsuario(info.get(0),info.get(1)));
            i.seccionCliente(c);
        }
        if (cop.equals("P")){
            Planificador p=(Planificador)(i.buscarUsuario(info.get(0),info.get(1)));
            i.seccionPlanificador(p,archivo);
        }
    }   
}
