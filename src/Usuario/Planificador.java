/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;
import java.util.ArrayList;
import Documento.OrdenPago;
import Evento.Evento;
/**
 *
 * @author stefano
 */
public class Planificador extends Usuario{

   private static ArrayList<OrdenPago> ordenesPago;
     private static ArrayList<Evento> eventos;

   public static ArrayList<OrdenPago> getOrdenesPago() {
       return ordenesPago;
   }   
   public static ArrayList<Evento> getEventos() {
       return eventos;
   }   
}

