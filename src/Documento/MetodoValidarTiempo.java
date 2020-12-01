package Documento;


import Evento.*;
import Usuario.Cliente;
import Usuario.Planificador;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kenneth
 */
public class MetodoValidarTiempo {
     public static Date  validarTiempo(String tipoEvento){
        int fechaValida=0;
        System.out.println("Ingrese la fecha para su evento (Dia/Mes/Anio):");
        Scanner sc=new Scanner(System.in);
        String fechaEvento=sc.next();
        sc.nextLine();
         while (fechaValida == 0) {
             SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
             Date fechaHoy = new Date();
             String fechaActual = sdf.format(fechaHoy);
             String[] fechaLista = fechaEvento.split("/");
             int anio = Integer.valueOf(fechaLista[2]);
             int mes = Integer.valueOf(fechaLista[1]);
             int dia = Integer.valueOf(fechaLista[0]);

             String[] fechaActualLista = fechaActual.split("/");
             int anioActual = Integer.valueOf(fechaActualLista[2]);
             int mesActual = Integer.valueOf(fechaActualLista[1]);
             int diaActual = Integer.valueOf(fechaActualLista[0]);
             int mesNuevo = 0;
             int anioNuevo = 0;
             int diaNuevo = 0;

             if (tipoEvento =="Boda") {

                 mesActual += 10;
                 if (mesActual > 12) {
                     mesNuevo = mesActual - 12;
                     anioNuevo = anioActual + 1;
                     diaNuevo = diaActual;
                 } else {
                     mesNuevo = mesActual;
                     anioNuevo = anioActual;
                     diaNuevo = diaActual;
                 }
                 Date fecha10Meses = new Date(anioNuevo - 1900, mesNuevo - 1, diaNuevo);
                 Date fechaBodaIngresada = new Date(anio - 1900, mes - 1, dia);
                 if (fechaBodaIngresada.after(fecha10Meses)) {
                     System.out.println("¡Fecha Válida!\n"
                             + "Ha registrado todos los datos necesarios para la solicitud.");
                     fechaValida++;
                     return fechaBodaIngresada;

                 } else {
                     System.out.println("**La fecha es muy proxima.Para este tipo de eventos"
                            + " debemos tener por lo menos 10 meses para planificar.\n"
                             + "Ingrese nuevamente.");
                     System.out.println("Ingrese la fecha para su evento (Dia/Mes/Anio):");
                     String fecha = sc.nextLine();
                     fechaEvento=fecha;
                 }
             } else if (tipoEvento=="FiestaEmpresarial") {

                 mesActual += 2;
                 if (mesActual > 12) {
                     mesNuevo = mesActual - 12;
                     anioNuevo = anioActual + 1;
                     diaNuevo = diaActual;
                 }else {
                     mesNuevo = mesActual;
                     anioNuevo = anioActual;
                     diaNuevo = diaActual;
                 }
                 Date fecha2Meses = new Date(anioNuevo - 1900, mesNuevo - 1, diaNuevo);
                 Date fechaEmpresarialIngresada = new Date(anio - 1900, mes - 1, dia);
                 if (fechaEmpresarialIngresada.after(fecha2Meses)) {
                     System.out.println("¡Fecha Válida!\n"
                             + "Ha registrado todos los datos necesarios para la solicitud.");
                     fechaValida++;
                     return fechaEmpresarialIngresada;

                 } else {
                     System.out.println("**La fecha es muy proxima.Para este tipo de eventos"
                             + " debemos tener por lo menos 2 meses para planificar.\n"
                             + "Ingrese nuevamente.");
                     System.out.println("Ingrese la fecha para su evento (Dia/Mes/Anio):");
                     String fecha = sc.nextLine();
                     fechaEvento = fecha;

                 }

             } else if (tipoEvento=="FiestaInfantil") {

                 if (mesActual == 1 || mesActual == 3 || mesActual == 5 || mesActual == 7 || mesActual == 8
                         || mesActual == 10 || mesActual == 12) {
                     diaActual += 21;
                     if (diaActual > 31) {
                         diaNuevo = diaActual - 31;
                         mesNuevo = mesActual + 1;
                         anioNuevo = anioActual;
                         if (mesActual > 12) {
                             mesNuevo = 1;
                             anioNuevo = anioActual + 1;
                         }
                     }else{
                         diaNuevo=diaActual;
                         mesNuevo=mesActual;
                         anioNuevo=anioActual;
                     }
                     Date fecha3Semanas;
                     fecha3Semanas = new Date(anioNuevo - 1900, mesNuevo - 1, diaNuevo);
                     Date fechaInfantilIngresada;
                     fechaInfantilIngresada = new Date(anio - 1900, mes - 1, dia);
                     if (fechaInfantilIngresada.after(fecha3Semanas)) {
                         System.out.println("¡Fecha Válida!\n"
                                 + "Ha registrado todos los datos necesarios para la solicitud.");
                         fechaValida++;
                         return fechaInfantilIngresada;

                     } else {
                         System.out.println("**La fecha es muy proxima.Para este tipo de eventos"
                                 + " debemos tener por lo menos 3 semanas para planificar.\n"
                                 + "Ingrese nuevamente.");
                         System.out.println("Ingrese la fecha para su evento (Dia/Mes/Anio):");
                         String fecha = sc.nextLine();
                         fechaEvento = fecha;
                     }

                 } else if (mesActual == 4 || mesActual == 6 || mesActual == 9 || mesActual == 11) {
                     diaActual += 21;
                     if (diaActual > 30) {
                         diaNuevo = diaActual - 30;
                         mesNuevo = mesActual + 1;
                         anioNuevo = anioActual;
                         if (mesActual > 12) {
                             mesNuevo = 1;
                             anioNuevo = anioActual + 1;
                         }
                     }else{
                         diaNuevo=diaActual;
                         mesNuevo=mesActual;
                         anioNuevo=anioActual;
                     }
                     Date fecha3Semanas = new Date(anioNuevo - 1900, mesNuevo - 1, diaNuevo);
                     Date fechaInfantilIngresada = new Date(anio - 1900, mes - 1, dia);
                     if (fechaInfantilIngresada.after(fecha3Semanas)) {
                         System.out.println("¡Fecha Válida!\n"
                                 + "Ha registrado todos los datos necesarios para la solicitud.");
                         fechaValida++;
                         return fechaInfantilIngresada;

                     } else {
                         System.out.println("**La fecha es muy proxima.Para este tipo de eventos"
                                 + " debemos tener por lo menos 3 semanas para planificar.\n"
                                 + "Ingrese nuevamente.");
                         System.out.println("Ingrese la fecha para su evento (Dia/Mes/Anio):");
                         String fecha = sc.nextLine();
                         fechaEvento = fecha;
                     }

                 } else if (mesActual == 2) {
                     diaActual += 21;
                     if (diaActual > 28) {
                         diaNuevo = diaActual - 28;
                         mesNuevo = mesActual + 1;
                         anioNuevo = anioActual;
                         if (mesActual > 12) {
                             mesNuevo = 1;
                             anioNuevo = anioActual + 1;
                         }
                     }else{
                         diaNuevo=diaActual;
                         mesNuevo=mesActual;
                         anioNuevo=anioActual;
                     }
                     Date fecha3Semanas = new Date(anioNuevo - 1900, mesNuevo - 1, diaNuevo);
                     Date fechaInfantilIngresada = new Date(anio - 1900, mes - 1, dia);
                     if (fechaInfantilIngresada.after(fecha3Semanas)) {
                         System.out.println("¡Fecha Válida!\n"
                                 + "Ha registrado todos los datos necesarios para la solicitud.");

                         fechaValida++;
                         return fechaInfantilIngresada;

                     } else {
                         System.out.println("**La fecha es muy proxima.Para este tipo de eventos"
                                 + " debemos tener por lo menos 3 semanas para planificar.\n"
                                 + "Ingrese nuevamente.");
                         System.out.println("Ingrese la fecha para su evento (Dia/Mes/Anio):");
                         String fecha = sc.nextLine();
                         fechaEvento = fecha;
                     }

                 }

             }
         }

        return null;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hola mundo, soy el primer programa en Java");
       
      
        Cliente cliente=new Cliente( "nombre","String apellido","String usuario","String contraseña",'C',"String correo", "String telefono");
        Planificador planificador=new Planificador("nomrbre",  "apellido", "usuario", "contra",'P');
        //Boda tipoEvento=new Boda("Mazda", cliente, planificador,new Date(),"1 pm",
          //   "10am",100);

       //Date fechaIngresada=validarTiempo(boda);
         //     Date fechaIngresada=validarTiempo(boda);
       Date fechaIngresada=validarTiempo("Boda");

          //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //    Date fechaHoy = new Date();
      //      String fechaActual = sdf.format(fechaHoy);
    }
}
