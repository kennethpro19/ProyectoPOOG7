/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Documento;
import Main.*; 
/**
 *
 * @author U_DoN_T_KnOw_Me
 */
public class NewClass {
    public static void main(String args[]){
        Interfaz i=new Interfaz();
        Archivo a=new Archivo();
       System.out.println(i.getInfoCliente(a.clientes).get(1)[1]);
       i.clienteOPlanificador(a.lineas,"randres","Andres123");
       System.out.println(i.clienteOPlanificador(a.lineas,"randres","Andres123"));
    }
    
}
