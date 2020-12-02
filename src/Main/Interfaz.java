/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.util.ArrayList;
import java.util.Scanner;
import Documento.*;
import Evento.*;
import Usuario.*;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Date;
/**
 *
 * @author U_DoN_T_KnOw_Me
 */
public class Interfaz {
    Scanner sc= new Scanner(System.in);
    
    //Menú inicio de sesión
    public ArrayList<String> iniciarSesion(ArrayList<String>lineas){
        String usuario="";
        String contraseña="";
        System.out.println("++++++++++++++++++++++++++++++++\n\n"
                +          "      BIENVENIDO AL SISTEMA     \n\n"
                +          "++++++++++++++++++++++++++++++++" );
       do{
        System.out.print("USUARIO: ");
        usuario=sc.nextLine();
        System.out.print("CONTRASEÑA: ");
        contraseña=sc.nextLine();
        if(!clienteOPlanificador(lineas,usuario,contraseña).equals("C") && !clienteOPlanificador(lineas,usuario,contraseña).equals("P") ){
            System.out.println("Usuario o contraseña incorrectos. Ingrese nuevamente.");
        }
       }while(!clienteOPlanificador(lineas,usuario,contraseña).equals("C") && !clienteOPlanificador(lineas,usuario,contraseña).equals("P") );
        ArrayList <String> info= new ArrayList<String>();
        info.add(usuario);
        info.add(contraseña);
        return info;
    }
    //Menú para los clientes
    public void seccionCliente(Cliente cliente){
        String choice="";
        do{
        System.out.println("1. Solicitar planificacion de evento.\n"
                +          "2. Registrar pago evento\n"+
                           "3. Salir");
        System.out.println("Elija una opción:");
        choice= sc.next();
        sc.nextLine();
        switch(choice){
            case "1": solicitarPlanificacion(cliente);
                break;
            case "2": registrarPagoEvento(cliente);
                break;
            case "3":
                break;
            default: System.out.println("Opción invalida!");
                break;
        }
        }while(!choice.equals("3"));
    }
    
    //Métdo para solicitar planificacion
    public void solicitarPlanificacion(Cliente c){
        System.out.println("/*****NUEVA SOLICITUD*******/\n"+
                           "/*                                               */\n"+
                           "/*****************/");
        System.out.println("Bienvenido\n");
        String choice="";
        do{
        System.out.println("TIPO DE EVENTO (Elija)");
        System.out.println("1. Boda\n"
                +          "2. Fiesta infantil\n"
                +          "3. Fiesta empresarial");
        System.out.println("Seleccione:");
        choice=sc.next();
        sc.nextLine();
        switch(choice){
            case "1": eventoBoda(c);
                break;
            case "2": eventoFiestaInfantil(c);
                break;
            case "3": eventoFiestaEmpresarial(c);
                break;
            default: System.out.println("Opción inválida!");
        }
            
        }while(!choice.equals("1")&&!choice.equals("2")&&!choice.equals("3"));
    }
    public void eventoBoda(Cliente c){
        Planificador p=asignarPlanificador();
        Date fechaRegistro=new Date(); //VALIDARTIEMPO
        Date fechaEvento=validarTiempo("Boda"); //VALIDARTIEMPO
        Solicitud s= new Solicitud(c,p,fechaRegistro,fechaEvento,"Boda");
        
        System.out.println("¿Desea registrar su solicitud? (S/N) ");
        char choice=sc.next().charAt(0);
        if(choice=='S'){
            
        
        p.getSolicitudesAsignadas().add(s);
        Sistema.solicitudes.add(s);  
        ArrayList<String> info=new ArrayList <String>();
        info.add(String.valueOf(s.getCod()));
        info.add(c.getNombre());
        info.add(p.getNombre());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
 
        info.add(sdf.format(fechaRegistro));
        
        info.add(sdf.format(fechaEvento));
        info.add(s.getEstadoSol());
        generarArchivo("Solicitud",info);
         System.out.println("Se ha registrado la solicitud.");
            
        }else if(choice=='N'){
            System.out.println("No se ha registrado la solicitud.");
            
        }else{
            System.out.println("!Opción Inválida!\n"
                    + "Intentelo de nuevo.");
        }
        
        
    }
    public void eventoFiestaInfantil(Cliente c){
        Planificador p=asignarPlanificador();
        
        Date fechaRegistro=new Date();//VALIDARTIEMPO
        Date fechaEvento=validarTiempo("FiestaInfantil");//VALIDARTIEMPO
        
        Solicitud s= new Solicitud(c,p,fechaRegistro,fechaEvento,"Fiesta Infantil");
    System.out.println("¿Desea registrar su solicitud? (S/N) ");
        char choice=sc.next().charAt(0);
        if(choice=='S'){
            
        
        p.getSolicitudesAsignadas().add(s);
        Sistema.solicitudes.add(s);  
        ArrayList<String> info=new ArrayList <String>();
        info.add(String.valueOf(s.getCod()));
        info.add(c.getNombre());
        info.add(p.getNombre());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
 
        info.add(sdf.format(fechaRegistro));
        
        info.add(sdf.format(fechaEvento));
        info.add(s.getEstadoSol());
        generarArchivo("Solicitud",info);
         System.out.println("Se ha registrado la solicitud.");
            
        }else if(choice=='N'){
            System.out.println("No se ha registrado la solicitud.");
            
        }else{
            System.out.println("!Opción Inválida!\n"
                    + "Intentelo de nuevo.");
        }
    }
    public void eventoFiestaEmpresarial(Cliente c){
        Planificador p=asignarPlanificador();
        
        Date fechaRegistro=new Date();//VALIDARTIEMPO
        Date fechaEvento=validarTiempo("FiestaEmpresarial");//VALIDARTIEMPO
        
        Solicitud s= new Solicitud(c,p,fechaRegistro,fechaEvento,"Fiesta Empresarial");
 System.out.println("¿Desea registrar su solicitud? (S/N) ");
        char choice=sc.next().charAt(0);
        if(choice=='S'){
            
        
        p.getSolicitudesAsignadas().add(s);
        Sistema.solicitudes.add(s);  
        ArrayList<String> info=new ArrayList <String>();
        info.add(String.valueOf(s.getCod()));
        info.add(c.getNombre());
        info.add(p.getNombre());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
 
        info.add(sdf.format(fechaRegistro));
        
        info.add(sdf.format(fechaEvento));
        info.add(s.getEstadoSol());
        generarArchivo("Solicitud",info);
         System.out.println("Se ha registrado la solicitud.");
            
        }else if(choice=='N'){
            System.out.println("No se ha registrado la solicitud.");
            
        }else{
            System.out.println("!Opción Inválida!\n"
                    + "Intentelo de nuevo.");
        }
    }
    
    
    public  Date  validarTiempo(String tipoEvento){
        int fechaValida=0;
        System.out.println("Ingrese la fecha para su evento (Dia/Mes/Año):");
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
    
    
    public void registrarPagoEvento(Cliente cliente){
        System.out.println("/**********REGISTRO PAGO***********/\n"
                +          "/*                                */\n"
                +          "/**********************************/");
    ArrayList <OrdenPago> a= cliente.getOrden();
    if(!a.isEmpty()){
    for (OrdenPago element:a){
        if(element.getEstadoOrdenDePago().equals("PENDIENTEPAGO")){
	String choice ="";
	System.out.println("Su orden con código "+ (element.getCodigo()) +" está pendiente de pago.\n"
		          +"¿Desea registrar pago ahora? (S/N):");
 	choice= sc.next();
        sc.nextLine();
	while (!choice.equals("N") && !choice.equals("S")){
		System.out.println("Ingrese una opción válida");
		choice = sc.nextLine();
		}
	if (choice.equals("S")){
		System.out.println("Ingrese el código de la transacción: ");
		int codtrans= sc.nextInt();
		element.setCodTrans(codtrans);
               // SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
                element.setFechaReg(new Date());
                element.setEstadoOrdenDePago(EstadoOrdenDePago.APROBADO);
                actualizartxt();
		} 
	}
    }
    
    }
    else{System.out.println("No tiene ordenes de pago pendientes.");}
    }
    public void seccionPlanificador(Planificador planificador,Archivo a){
	System.out.println("Bienvenid@");
	String choice="";
        do{
        System.out.println("1. Consultar solicitudes pendientes\n"
                +          "2. Registrar Evento\n"
                +          "3. Confirmar Evento\n"
		+	   "4. Consultar Evento\n"
		+	   "5. Salir");
        System.out.println("Seleccione:");
        choice=sc.nextLine();
        switch(choice){
            case "1": consultarSolicitudesPendientes(planificador.getSolicitudesAsignadas());
                break;
            case "2": registrarEvento(Sistema.solicitudes);
                break;
            case "3": confirmarEvento();
                break;
	    case "4": consultarEvento(planificador); 
		break;
	    case "5":
		break;
            default: System.out.println("Opción inválida!");
        }
            
        }while(!choice.equals("5"));
}


public void consultarSolicitudesPendientes(ArrayList <Solicitud> solicitudespendientes){
System.out.println("/*******SOLICITUDES PENDIENTES******/\n"
+	       "/*                                     */\n"+
	       "/***************************************/");   		
	//Leer archivos rey
    if(!solicitudespendientes.isEmpty()){
        
        for(int i=0;i<solicitudespendientes.size();i++){
            ///////////////////////////////////////////////////////////////////
            if(solicitudespendientes.get(i).getEstadoSol().equals("PENDIENTE")){
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
            System.out.println((i+1)+". "+solicitudespendientes.get(i).getCod()+" - "+sdf.format(solicitudespendientes.get(i).getFechaEvento()));
            }else{System.out.println("No hay solicitudes pendientes");}
            }
        }
    else{System.out.println("No hay solicitudes pendientes");}
}




public void registrarEvento(ArrayList <Solicitud> solicitudes){
System.out.println("/********REGISTRAR EVENTOS********/\n"
+	           "/*                               */\n"+
	           "/******************************* */");   		
System.out.print("Ingrese el id de la solicitud: "); 
SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
int cod=sc.nextInt();
sc.nextLine();
ArrayList <Solicitud> a=solicitudes;
Solicitud solicitud=new Solicitud();
for (int i=0;i<a.size();i++){
    
	if ((a.get(i).getCod())==cod ){
            if(a.get(i).getEstadoSol().equals("PENDIENTE")){
		 solicitud= a.get(i);
		System.out.println("DATOS: \nCLIENTES: "+solicitud.getCliente().getNombre()+" "+solicitud.getCliente().getApellido()+"\nPLANIFICADOR"
                        + " ASIGNADO: "+solicitud.getPlanificador().getNombre()+" "+solicitud.getPlanificador().getApellido()+"\n"
                                + "\nFECHA DE REGISTRO: "+sdf.format(solicitud.getFechaRegistro())+"\nTIPO EVENTO: "+solicitud.getTipoEvento()+
                        "\nFECHA DEL EVENTO: "+sdf.format(solicitud.getFechaEvento())); //imprime datos
               if(solicitud.getTipoEvento().equals("Boda"))
                System.out.println("PRECIO BASE: "+ 3500);
               else if(solicitud.getTipoEvento().equals("Fiesta Infantil")){
                   System.out.println("PRECIO BASE: "+ 300);
               }else if(solicitud.getTipoEvento().equals("Fiesta Empresarial")){
                   System.out.println("PRECIO BASE: "+2000);
               }
               System.out.println("¿Desea continuar? (S/N)");
               String elcc=sc.nextLine();
               while(!elcc.equals("S")&&!elcc.equals("N")){
                   System.out.println("¿Desea continuar? (S/N)");
                   elcc=sc.nextLine();
               }if (elcc.equals("S")){
                   System.out.println("/*****REGISTRO DE DATOS DEL EVENTO****/");
System.out.println("Hora inicio: ");
String horaIn=sc.nextLine();
System.out.println("Hora fin: ");
String horaFin=sc.nextLine();
System.out.println("Capacidad: ");
int capacidad= sc.nextInt();
sc.nextLine();
Evento ev= new Evento();
if(solicitud.getTipoEvento().equals("Boda")){
    System.out.println("Ingrese el tipo de vehículo para el transporte de los novios. En caso de que no se requiera, ingrese NO APLICA");
    String boleano=sc.nextLine();

    ev=new Boda(boleano,solicitud.getCliente(),solicitud.getPlanificador(),solicitud.getFechaEvento(),horaIn,horaFin,capacidad);
    ev.setTipo("Boda");
}
else if(solicitud.getTipoEvento().equals("Fiesta Infantil")){
    System.out.println("Ingrese la cantidad de personajes disfrazados que desea para su evento. \n"
            + "En caso de que no se requiera, ingrese 0");
    int cantdis=sc.nextInt();
    sc.nextLine();
    System.out.println("Ingrese la cantidad de sorpresas para los niños.");
    int cantsorp = sc.nextInt();
    sc.nextLine();
    String juegos="";
    boolean b=false;
    do{
    System.out.println("¿Desea incluir juegos en el evento? (S/N)");
    juegos= sc.nextLine();
    b=false;
    
    if (juegos.equals("S")){
        b=true;
    }else{b=false;}
    }while(!juegos.equals("S")&&!juegos.equals("N"));
    
    ev=new FiestaInfantil(cantdis,cantsorp,b,solicitud.getCliente(),solicitud.getPlanificador(),solicitud.getFechaEvento(),horaIn,horaFin,capacidad);
    ev.setTipo("Fiesta Infantil");
} 
else if (solicitud.getTipoEvento().equals("Fiesta Empresarial")){
    System.out.println("¿Desea transporte para los invitados? (S/N)");
    String trans=sc.nextLine();
    boolean z=false;
    int cantpers=0;
    if (trans.equals("S")){
       z=true;
       System.out.println("Ingrese la cantidad de personas que se transportarían: ");
       cantpers=sc.nextInt();
       sc.nextLine();
    }
    ev= new FiestaEmpresarial(z,cantpers,solicitud.getCliente(),solicitud.getPlanificador(),solicitud.getFechaEvento(),horaIn,horaFin,capacidad);
    ev.setTipo("Fiesta Empresarial");
}
ArrayList <String> informacion=new ArrayList <String>();
informacion.add(String.valueOf(ev.getCodigo()));
informacion.add(ev.getCliente().getNombre());
informacion.add(solicitud.getTipoEvento());

 

informacion.add(sdf.format(ev.getFechaEvento()));
informacion.add(ev.getHoraDeInicio());
informacion.add(ev.getHoraDeSalida());
informacion.add(String.valueOf(ev.getCapacidad()));
informacion.add(ev.getPlanificador().getNombre());
informacion.add(ev.getEstadoEvento());

System.out.println("¿Desea registrar elementos adicionales? (S/N)");
String choice= sc.next();
sc.nextLine();
	while (!choice.equals("S") && !choice.equals("N")){
		System.out.println("Ingrese una opción válida");
		choice= sc.nextLine();
		}
	if (choice.equals("S")){
		 Scanner sc = new Scanner(System.in);
        char elementoAd='S';

        int uno3=0;
        int dos3=0;
        int uno=0;
        int dos=0;
        int tres=0;
        int cuatro=0;
        ArrayList <ElementoAdicional> elementos=new ArrayList<>();
        do{
        String entrada="";
        System.out.println("Las opciones son:\n"
                + "1. Comida\n"
                + "2. Bocaditos\n"
                + "3. Música\n"
                + "4. Fotografía\n"
                + "5. Bebida\n"
                + "6. Regresar al menú anterior\n");

        System.out.println("Elija elemento a adicionar:");
        entrada=sc.next();
        
        switch (entrada) {

            case "1":
                //COMIDA
                double precioComida=15;
                System.out.println("Cantidad de platos:");
                int cantidad1=sc.nextInt();
                ElementoAdicional comida=new ElementoAdicional();
                comida.setCantidad(cantidad1);
                comida.setPrecio(precioComida);
                comida.setTotal(comida.calcularCosto());
                comida.setTipoElementoAdicional(TipoElementoAdicional.COMIDA);
                double total1 = precioComida * cantidad1;
                System.out.println("Total:" + total1);
                char agg1 = 'A';
                System.out.println("Agregar(S/N):");
                agg1 = sc.next().charAt(0);
                if(agg1=='S'){
                    elementos.add(comida);
                    System.out.println("Se ha agregado su elección.");
                    ArrayList <String> info=new ArrayList<String>();
                    info.add(String.valueOf(ev.getCodigo()));
                    info.add(TipoElementoAdicional.COMIDA.name());
                    info.add(String.valueOf(cantidad1));
                    info.add(String.valueOf(precioComida));
                    info.add(String.valueOf(total1));
                    generarArchivo("Adicionales", info);
                } else {
                    System.out.println("No se ha agregado su elección.");
                        }
                
          
                break;
            case "2":
                
                //BOCADITOS
                
                System.out.println("Cantidad de bocaditos:");
                int cantidad2=sc.nextInt();
                ElementoAdicional bocaditos=new ElementoAdicional();
                bocaditos.setCantidad(cantidad2);
                
                bocaditos.setTipoElementoAdicional(TipoElementoAdicional.BOCADITOS);
                if (cantidad2>150){
                    double precioBocadito=0.10;
                    double total2 = precioBocadito * cantidad2;
                    System.out.println("Total:" + total2);
                    bocaditos.setTotal(total2);
                    char agg = 'A';
                    System.out.println("Agregar(S/N):");
                    agg = sc.next().charAt(0);
                    if(agg=='S'){
                        elementos.add(bocaditos);
                        System.out.println("Se ha agregado su elección.");
                        ArrayList <String> info=new ArrayList<String>();
                        info.add(String.valueOf(ev.getCodigo()));
                        info.add(TipoElementoAdicional.BOCADITOS.name());
                        info.add(String.valueOf(cantidad2));
                        info.add(String.valueOf(precioBocadito));
                        info.add(String.valueOf(total2));
                        generarArchivo("Adicionales", info);
                    } else {
                        System.out.println("No se ha agregado su elección.");
                    }
                }else{
                    double precioBocadito=0.25;
                    double total2 = precioBocadito * cantidad2;
                    System.out.println("Total:" + total2);
                    bocaditos.setTotal(total2);
                    char agg = 'A';
                    System.out.println("Agregar(S/N):");
                    agg = sc.next().charAt(0);
                    if(agg=='S'){
                        elementos.add(bocaditos);
                         ArrayList <String> info=new ArrayList<String>();
                        info.add(String.valueOf(ev.getCodigo()));
                        info.add(TipoElementoAdicional.BOCADITOS.name());
                        info.add(String.valueOf(cantidad2));
                        info.add(String.valueOf(precioBocadito));
                        info.add(String.valueOf(total2));
                        generarArchivo("Adicionales", info);
                        System.out.println("Se ha agregado su elección.");
                    } else {
                        System.out.println("No se ha agregado su elección.");
                    }
               
                }
                       
                break;
                
            case "3":
                
                //MUSICA
                double precioDj=300;
                double precioBanda=2000;
                System.out.println("Para la musica se presentan las opciones de:\n"
                        + "1. Dj($300)\n"
                        + "2. Banda($2000)\n"
                        + "¿Qué prefiere?");
                String opcion3=sc.next();
                sc.nextLine();
               
                int cantidad3=1;
                switch(opcion3){
                    case "1":
                        if (uno3==0){
                            ElementoAdicional dj=new ElementoAdicional();
                            dj.setTipoElementoAdicional(TipoElementoAdicional.MUSICA);
                            dj.setPrecio(precioDj);
                            dj.setCantidad(cantidad3);
                            dj.setTotal(dj.calcularCosto());
              
                            double total3 = precioDj * cantidad3;
                            System.out.println("Total:" + total3);
                            char agg3 = 'A';
                            System.out.println("Agregar(S/N):");
                            agg3 = sc.next().charAt(0);
                            if (agg3 == 'S') {
                                elementos.add(dj);
                                System.out.println("Se ha agregado su elección.");
                                    ArrayList <String> info=new ArrayList<String>();
                                    info.add(String.valueOf(ev.getCodigo()));
                                    info.add(TipoElementoAdicional.MUSICA.name());
                                    info.add(String.valueOf(cantidad3));
                                    info.add(String.valueOf(precioDj));
                                    info.add(String.valueOf(total3));
                                    generarArchivo("Adicionales", info);
                                uno3++;
                            } else {
                            System.out.println("No se ha agregado su elección.");
                            }
                        } else{
                            System.out.println("YA HA AGREGADO ESTE ELEMENTO A SU LISTA ELIJA OTRO.");
                        }
                        break;
                    case "2":
                        if (dos3==0){
                            ElementoAdicional banda=new ElementoAdicional();
                            banda.setTipoElementoAdicional(TipoElementoAdicional.MUSICA);
                            banda.setPrecio(precioBanda);
                            banda.setCantidad(cantidad3);
                            banda.setTotal(banda.calcularCosto());
                            double total3 = precioBanda * cantidad3;
                            System.out.println("Total:" + total3);
                            char agg3 = 'A';
                            System.out.println("Agregar(S/N):");
                            agg3 = sc.next().charAt(0);
                            if (agg3 == 'S') {
                                elementos.add(banda);
                                System.out.println("Se ha agregado su elección.");
                                dos3++;
                                    ArrayList <String> info=new ArrayList<String>();
                                    info.add(String.valueOf(ev.getCodigo()));
                                    info.add(TipoElementoAdicional.MUSICA.name());
                                    info.add(String.valueOf(cantidad3));
                                    info.add(String.valueOf(precioBanda));
                                    info.add(String.valueOf(total3));
                                    generarArchivo("Adicionales", info);
                            } else {
                            System.out.println("No se ha agregado su elección.");
                            }
                            
                        } else{
                            System.out.println("YA HA AGREGADO ESTE ELEMENTO A SU LISTA ELIJA OTRO.");
                        }
                        
                        break;
                    
                    default :
                            System.out.println("Opcion Inválida.\n");
                            break;
                }
                break;
            case "4":
                
                //FOTOGRAFIA
                int cantidad4=1;
                double precioFotografia=500;
                ElementoAdicional fotografia=new ElementoAdicional();
                fotografia.setTipoElementoAdicional(TipoElementoAdicional.FOTOGRAFIA);
                fotografia.setCantidad(cantidad4);
                fotografia.setPrecio(precioFotografia);
                fotografia.setTotal(fotografia.calcularCosto());
                double total4 = precioFotografia * cantidad4;
                System.out.println("Total:" + total4);
                char agg4 = 'A';
                System.out.println("Agregar(S/N):");
                agg4 = sc.next().charAt(0);
                if (agg4 == 'S') {
                    elementos.add(fotografia);
                    System.out.println("Se ha agregado su elección.");
                                    ArrayList <String> info=new ArrayList<String>();
                                    info.add(String.valueOf(ev.getCodigo()));
                                    info.add(TipoElementoAdicional.FOTOGRAFIA.name());
                                    info.add(String.valueOf(cantidad4));
                                    info.add(String.valueOf(precioFotografia));
                                    info.add(String.valueOf(total4));
                                    generarArchivo("Adicionales", info);
                } else {
                    System.out.println("No se ha agregado su elección.");
                }
                
                break;
            case "5":
                //BEBIDA
                double precioWhisky = 50;
                double precioVodka = 25;
                double precioCerveza = 3;
                double precioRefrescos = 1;
                System.out.println("Para la bebida se presentan las opciones de:\n"
                        + "1. Whisky($50 c/u)\n"
                        + "2. Vodka($25 c/u)\n"
                        + "3. Cerveza($3 c/u)\n"
                        + "4. Refrescos($1 c/u)\n"
                        + "¿Qué prefiere?");
                String opcion5=sc.next();
                sc.nextLine();
        
                switch(opcion5){
                    case "1":
                        if (uno==0){
                            System.out.println("Cantidad de whiskys:");
                            int cantidad=sc.nextInt();
                            ElementoAdicional whisky=new ElementoAdicional();
                            whisky.setCantidad(cantidad);
                            whisky.setPrecio(precioWhisky);
                            whisky.setTipoElementoAdicional(TipoElementoAdicional.BEBIDA);
                            whisky.setTotal(whisky.calcularCosto());
                            double total=precioWhisky*cantidad;
                            System.out.println("Total:"+total);
                            char agg='A';
                            System.out.println("Agregar(S/N):");
                            agg=sc.next().charAt(0);
                            if(agg=='S'){
                               elementos.add(whisky);
                                 System.out.println("Se ha agregado su elección.");
                                 uno++;
                                    ArrayList <String> info=new ArrayList<String>();
                                    info.add(String.valueOf(ev.getCodigo()));
                                    info.add(TipoElementoAdicional.BEBIDA.name());
                                    info.add(String.valueOf(cantidad));
                                    info.add(String.valueOf(precioWhisky));
                                    info.add(String.valueOf(total));
                                    generarArchivo("Adicionales", info);
                            }else{
                                  System.out.println("No se ha agregado su elección.");
                            }
                        } else {
                              System.out.println("YA HA AGREGADO ESTE ELEMENTO A SU LISTA ELIJA OTRO.");
                        }
                        break;
                    case "2":
                        if(dos==0){
                            System.out.println("Cantidad de vodkas:");
                            int cantidad=sc.nextInt();
                            ElementoAdicional vodka=new ElementoAdicional();
                            vodka.setCantidad(cantidad);
                            vodka.setPrecio(precioVodka);
                            vodka.setTotal(vodka.calcularCosto());
                            vodka.setTipoElementoAdicional(TipoElementoAdicional.BEBIDA);
                            double total=precioVodka*cantidad;
                            System.out.println("Total:"+total);
                            char agg='A';
                            System.out.println("Agregar(S/N):");
                            agg=sc.next().charAt(0);
                            if(agg=='S'){
                               elementos.add(vodka);
                                 System.out.println("Se ha agregado su elección.");
                                 dos++;
                                 
                                    ArrayList <String> info=new ArrayList<String>();
                                    info.add(String.valueOf(ev.getCodigo()));
                                    info.add(TipoElementoAdicional.BEBIDA.name());
                                    info.add(String.valueOf(cantidad));
                                    info.add(String.valueOf(precioVodka));
                                    info.add(String.valueOf(total));
                                    generarArchivo("Adicionales", info);
                            }else{
                                  System.out.println("No se ha agregado su elección.");
                            }
                        } else {
                              System.out.println("YA HA AGREGADO ESTE ELEMENTO A SU LISTA ELIJA OTRO.");
                        }
                        break;
                    case "3":
                        if (tres==0){
                            System.out.println("Cantidad de cervezas:");
                            int cantidad=sc.nextInt();
                            ElementoAdicional cerveza=new ElementoAdicional();
                            cerveza.setCantidad(cantidad);
                            cerveza.setPrecio(precioCerveza);
                            cerveza.setTotal(cerveza.calcularCosto());
                            cerveza.setTipoElementoAdicional(TipoElementoAdicional.BEBIDA);
                            double total=precioCerveza*cantidad;
                            System.out.println("Total:"+total);
                            char agg='A';
                            System.out.println("Agregar(S/N):");
                            agg=sc.next().charAt(0);
                            if(agg=='S'){
                               elementos.add(cerveza);
                                 System.out.println("Se ha agregado su elección.");
                                 tres++;
                                 
                                    ArrayList <String> info=new ArrayList<String>();
                                    info.add(String.valueOf(ev.getCodigo()));
                                    info.add(TipoElementoAdicional.BEBIDA.name());
                                    info.add(String.valueOf(cantidad));
                                    info.add(String.valueOf(precioCerveza));
                                    info.add(String.valueOf(total));
                                    generarArchivo("Adicionales", info);
                            }else{
                                  System.out.println("No se ha agregado su elección.");
                            }
                        } else {
                              System.out.println("YA HA AGREGADO ESTE ELEMENTO A SU LISTA ELIJA OTRO.");
                        }
                        break;
               
                    case "4":
                        if (cuatro==0){
                            System.out.println("Cantidad de refrescos:");
                            int cantidad=sc.nextInt();
                            ElementoAdicional refrescos=new ElementoAdicional();
                            refrescos.setCantidad(cantidad);
                            refrescos.setPrecio(precioRefrescos);
                            refrescos.setTipoElementoAdicional(TipoElementoAdicional.BEBIDA);
                            refrescos.setTotal(refrescos.calcularCosto());
                            double total=precioRefrescos*cantidad;
                            System.out.println("Total:"+total);
                            char agg='A';
                            System.out.println("Agregar(S/N):");
                            agg=sc.next().charAt(0);
                            if(agg=='S'){
                               elementos.add(refrescos);
                                 System.out.println("Se ha agregado su elección.");
                                 cuatro++;
                                 
                                    ArrayList <String> info=new ArrayList<String>();
                                    info.add(String.valueOf(ev.getCodigo()));
                                    info.add(TipoElementoAdicional.BEBIDA.name());
                                    info.add(String.valueOf(cantidad));
                                    info.add(String.valueOf(precioRefrescos));
                                    info.add(String.valueOf(total));
                                    generarArchivo("Adicionales", info);
                            }else{
                                  System.out.println("No se ha agregado su elección.");
                            }
                        } else {
                              System.out.println("YA HA AGREGADO ESTE ELEMENTO A SU LISTA ELIJA OTRO.");
                        }
                        
                        break;
                    
                    default :
                             System.out.println("Opcion Inválida.\n");
                             break;
             
                }
                break;
            case "6":
                
                break;
            default :
                System.out.println("Opcion Inválida.\n"
                        + "Por favor digite otra opción.");
                break;
            } 
        
        System.out.println("¿Desea registrar elementos adicionales(S/N)?");
        elementoAd=sc.next().charAt(0);
        
        }while(elementoAd!='N');
        
        System.out.println("Ha concluido el ingreso de los datos del evento.");

        double g=0.0;
        for (ElementoAdicional element: ev.getElementosAdicionales()){
            g=g+element.getTotal();
        }
        ev.setValorTotal(ev.getValorTotal()+g);
        System.out.println("El costo total del evento sera de:"+ev.getValorTotal()+" dólares.");
        System.out.println("¿Desea generar orden de pago(S/N)?");
        char generarOrden=sc.next().charAt(0);
        if(generarOrden=='S'){
            Sistema.eventos.add(ev);
            generarArchivo("Evento",informacion);
            solicitud.setEstadoSol(EstadoSolicitud.APROBADO);
            actualizartxt();
            OrdenPago op=new OrdenPago(ev, ev.getCliente());
            ArrayList <String> infor= new ArrayList <String>();
            infor.add(String.valueOf(op.getCodigo()));
            infor.add(String.valueOf(ev.getCodigo()));
            infor.add(String.valueOf(ev.getValorTotal()));
            infor.add(op.getEstadoOrdenDePago());
            infor.add(String.valueOf(op.getCodTrans()));
            
            infor.add("sf");
            generarArchivo("OrdenPago",infor);
            System.out.println("Se ha generado su orden de pago.");
            generarOrdenPago(op,ev);
            
        }else{
            System.out.println("No se ha generado su orden de pago.");
            
        }
        
        
    }else{System.out.println("¿Desea generar orden de pago(S/N)?");
        char generarOrden=sc.next().charAt(0);
        if(generarOrden=='S'){
            solicitud.setEstadoSol(EstadoSolicitud.APROBADO);
            Sistema.eventos.add(ev);
            generarArchivo("Evento",informacion);
            solicitud.setEstadoSol(EstadoSolicitud.APROBADO);
            actualizartxt();
            OrdenPago op=new OrdenPago(ev, ev.getCliente());
            ArrayList <String> infor= new ArrayList <String>();
            infor.add(String.valueOf(op.getCodigo()));
            infor.add(String.valueOf(ev.getCodigo()));
            infor.add(String.valueOf(ev.getValorTotal()));
            infor.add(op.getEstadoOrdenDePago());
            infor.add(String.valueOf(op.getCodTrans()));
            
            infor.add("sf");
            generarArchivo("OrdenPago",infor);
            System.out.println("Se ha generado su orden de pago.");
            generarOrdenPago(op,ev);
            
        }else{
            System.out.println("No se ha generado su orden de pago.");
            
        }
            
        }
               }
            }else{System.out.println("Esta solicitud ya ha sido aprobada.");}
	}else{System.out.println("No existe una solicitud de evento con el código ingresado");}
	}sc.nextLine();
        //System.out.println("Presione Enter para continuar:");


		
}
 
public void generarOrdenPago(OrdenPago op,Evento ev){
	System.out.println("/*****ORDEN DE PAGO******/\n"
	+		   "/*                      */\n"
	+		   "/***********************/");
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");        
System.out.println("CÓDIGO PAGO: "+op.getCodigo()+"\nFECHA: "+sdf.format(op.getFechaHoy())+"\nCLIENTE: "+op.getCliente().getNombre()
+ " "+op.getCliente().getApellido()+"\nEVENTO: "+op.getEvento().getTipo()+"\nFECHA EVENTO: "+sdf.format(op.getEvento().getFechaEvento()));
System.out.println("\nADICIONALES");
System.out.println(op.getEvento().getElementosAdicionales().size());
Boda b= (Boda) ev;
for (ElementoAdicional element: b.getElementosAdicionales()){
    System.out.println(element.getTipoElementoAdicional());
     
}
System.out.println("TOTAL A PAGAR: "+op.getValorTotal());


        
}

public void confirmarEvento(){
	System.out.println("/****CONFIRMAR EVENTO****/\n"
	+		   "/*                                        */\n"
	+		   "/**************/");
	System.out.println("Ingrese el id de la orden de pago: ");
        
	int id=sc.nextInt();
        sc.nextLine();
	
        ArrayList <OrdenPago> listaa=Sistema.ordenpag;  
        
        int n=0;
	for (int i=0;i<listaa.size();i++){
		if(listaa.get(i).getCodigo()==id){
                        n=n+1;
			if (!listaa.get(i).getFechaReg().equals(stringtoDate("00/00/00"))){
                                SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
				System.out.println("El pago de este evento se ha realizado el "+sdf.format(listaa.get(i).getFechaReg()));
				System.out.println("¿Desea aprobar este pago? (S/N)");
				String choice= sc.nextLine();
				while (!choice.equals("S") && !choice.equals("N")){
				System.out.println("Ingrese una opción válida");
				choice = sc.nextLine();
						}
				if (choice.equals("S")){
					System.out.println("El pago se ha aprobado.\nEl evento se ha confirmado para la fecha establecida");
					listaa.get(i).getEvento().setEstadoEvento(EstadoEvento.CONFIRMADO);
                                        actualizartxt();
				}else{System.out.println("El pago no se ha aprobado. El evento está a espera para su confirmacion");}
                        }else{System.out.println("El pago aun no ha sido realizado. El evento no puede confirmarse");}
					
		}
	}if(n==0){
            System.out.println("No existe una orden de pago con el id ingresado");
        }
}


public void consultarEvento(Planificador planificador){
	ArrayList <Evento> lista= planificador.getEventos();

	System.out.println("/****CONSULTAR EVENTO****/\n"
	+		   "/*                                        */\n"
	+		   "/**************/");	
        String choice="";
        do{
        System.out.println("TIPO DE EVENTO (Elija)");
        System.out.println("1. Boda\n"
                +          "2. Fiesta infantil\n"
                +          "3. Fiesta empresarial");
        System.out.println("Elija el tipo de evento que quiere consultar: ");
        choice=sc.nextLine();
        int n=0;
	switch(choice){
            case "1":
		
		for(int i=0;i<lista.size();i++){
		if (lista.get(i) instanceof Boda ){
			n=n+1;}
		System.out.println("Tiene un total de "+"bodas asignadas");
		lista.get(i).toString();
		}
                break;
            case "2":
                for(int i=0;i<lista.size();i++){
		if(lista.get(i) instanceof FiestaEmpresarial){
		n=n+1;
		System.out.println("Tiene un total de "+"fiestas empresariales asignadas");
		lista.get(i).toString();}
		}
		break;
            case "3":
		for(int i=0;i<lista.size();i++){
		if(lista.get(i) instanceof FiestaInfantil){
		n=n+1;
		System.out.println("Tiene un total de "+"fiestas infantiles asignadas");
		lista.get(i).toString();		
		}
		}
                break;
            default: System.out.println("Opción inválida!");
        } 
        }while(!choice.equals("1")||!choice.equals("2")||!choice.equals("3"));
	

}
public String clienteOPlanificador(ArrayList <String> lineas,String nombreusuario,String contraseña){
    String resultado="a";
    for(String elemento: lineas){
        String [] partes=elemento.split(";");
        for (int i=0;i<partes.length;i++) {
            if(partes[i].indexOf(",")!=-1){
                String [] partes2=partes[i].split(",");
                
                if((partes.length>1) && partes[2].equals(nombreusuario)&& partes2[0].equals(contraseña)){
                    resultado=partes2[1];
                }    
            }
            else if ((partes.length>1) && partes[2].equals(nombreusuario)&& partes[3].equals(contraseña)){         
                if(partes[i].indexOf(",")!= -1){
                    
                }else{int n=partes.length;
                      resultado=partes[n-1];}
                }
            }      
        }  
   return resultado;
}

   public void crearUsuarios(ArrayList <String> lineas,ArrayList <String> clientes){
    String correo="";
    String telefono="";
    for(int i=0;i<lineas.size()-1;i++){
        String [] partes=lineas.get(i+1).split(";");
        ArrayList <String[]> infoClientes=getInfoCliente(clientes);
        if(partes[partes.length-1].indexOf(",")!=-1){
            String [] partes2=partes[partes.length-1].split(",");
            if(partes2[1].equals("C")){
                    for(String [] element:infoClientes){
                        if(partes[2].equals(element[0])){
                            correo=element[2];
                            telefono=element[1];
                            Cliente c= new Cliente(partes[0],partes[1],partes[2],partes2[0],'C',correo,telefono);
                            Sistema.clientes.add(c);               
                        }
                        
                    }
                
            }else if(partes2[1].equals("P")){
                Planificador p= new Planificador(partes[0],partes[1],partes[2],partes2[0],'P');
                Sistema.planificadores.add(p);
            }
        }else{
            if(partes[partes.length-1].equals("C")){
                for(String [] element:infoClientes){
                        if(partes[2].equals(element[0])){
                            correo=element[2];
                            telefono=element[1];
                            Cliente c= new Cliente(partes[0],partes[1],partes[2],partes[3],'C',correo,telefono);
                            Sistema.clientes.add(c);     
                        }
                }
            }else if(partes[partes.length-1].equals("P")){
                Planificador p= new Planificador(partes[0],partes[1],partes[2],partes[3],'P');
                Sistema.planificadores.add(p);
            }
        }
    }
}
    
    
    
public ArrayList <String []> getInfoCliente(ArrayList <String> clientes){
    ArrayList <String []> info= new ArrayList <>();
    for(String elemento:clientes){
        
        String [] partes=elemento.split(";");
        info.add(partes);
    }
    return info;}
    
    public Usuario buscarUsuario(String usuario,String contraseña){
        Usuario usuari =null;
        for (Cliente element: Sistema.clientes){
            if(element.getUsuario().equals(usuario)&&element.getContrasena().equals(contraseña)){
                usuari=element;
            }
        }for (Planificador element: Sistema.planificadores){
            if (element.getUsuario().equals(usuario)&&element.getContrasena().equals(contraseña)){
                usuari=element;
            }
        }
        
        
    return usuari;}
    
    public Usuario buscarUsuario(String nombre,int n){
     Usuario usuario=null;   
        if(n==1){
            for(Cliente element: Sistema.clientes){
                if(element.getNombre().equals(nombre)){
                    usuario=element;
                }
            }
        }else if(n==2){

            for(Planificador element: Sistema.planificadores){
                if(element.getNombre().equals(nombre)){
                    usuario=element;
                }
            }
        }
        return usuario;}
    
    public void generarArchivo(String tipo, ArrayList<String> informacion){
        String linea="";
        if (tipo.equals("Solicitud")){
            for(String element:informacion){
            if(linea.equals("")){
                linea=element;
            }else{linea=linea+","+element;}
            }
            
            ManejoArchivos.EscribirArchivo("solicitudes.txt", linea);
        }
        if (tipo.equals("OrdenPago")){
        
        for(String element:informacion){
            if(linea.equals("")){
                linea=element;
            }else{linea=linea+","+element;}
            
            
            }
            ManejoArchivos.EscribirArchivo("ordenPago.txt", linea);
        }
            
            if (tipo.equals("Evento")){
            for(String element:informacion){
            if(linea.equals("")){
                linea=element;
            }else{linea=linea+","+element;}
            
            }
            ManejoArchivos.EscribirArchivo("evento.txt", linea);
            }
         if (tipo.equals("Adicionales")){
             for(String element:informacion){
            if(linea.equals("")){
                linea=element;
            }else{linea=linea+","+element;}
            
             }
             ManejoArchivos.EscribirArchivo("adicionales.txt",linea);
            }
            }
        
        
    
    public Planificador asignarPlanificador(){
      int n=Sistema.planificadores.size();
      Random r=new Random();
      int index= r.nextInt(n);
      Planificador p=Sistema.planificadores.get(index);
     return p;}
    
    public void actualizartxt(){
        ManejoArchivos.EliminarArchivo("solicitudes.txt");
        ManejoArchivos.EliminarArchivo("ordenPago.txt");
        ManejoArchivos.EliminarArchivo("evento.txt");
        ArrayList <String> info=new ArrayList<String>();
         SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
        ///////////////////SOLICITUDES/////////////////////
        ManejoArchivos.EscribirArchivo("solicitudes.txt","id_solicitud,nombre_cliente,nombre_planificador,fecha_solicitud,fecha_evento,estado");
        
        for(Solicitud element:Sistema.solicitudes){
        info.add(String.valueOf(element.getCod()));
        info.add(element.getCliente().getNombre());
        info.add(element.getPlanificador().getNombre());
       
        info.add(sdf.format(element.getFechaRegistro()));
        info.add(sdf.format(element.getFechaEvento()));
        info.add(element.getEstadoSol());
        generarArchivo("Solicitud",info);
        info.clear();
        }
        
        //////////////////ORDENPAGO///////////////////
        ManejoArchivos.EscribirArchivo("ordenPago.txt","Código_pago,Código_evento,total_pagar,estado,Código_transacción,fecha_registro");
        
        for(OrdenPago element: Sistema.ordenpag){
            info.add(String.valueOf(element.getCodigo()));
            info.add(String.valueOf(element.getEvento().getCodigo()));
            info.add(String.valueOf(element.getEvento().getValorTotal()));
            info.add(element.getEstadoOrdenDePago());
            info.add(String.valueOf(element.getCodTrans()));
            info.add(sdf.format(element.getFechaReg())  );
            generarArchivo("OrdenPago",info);        
            info.clear();
        }
        ///////////////EVENTO//////////////////
         ManejoArchivos.EscribirArchivo("evento.txt","codigo,nombre_cliente,tipo,fecha,hora_inicio,hora_fin,capacidad,planificador,estado");
         
         for(Evento element: Sistema.eventos){
             info.add(String.valueOf(element.getCodigo()));
             info.add(element.getCliente().getNombre());
             info.add(element.getTipo());
             info.add(sdf.format(element.getFechaEvento()));    
             info.add(element.getHoraDeInicio());
             info.add(element.getHoraDeSalida());
             info.add(String.valueOf(element.getCapacidad()));
             info.add(element.getPlanificador().getNombre());
             info.add(element.getEstadoEvento());
             generarArchivo("Evento",info);        
             info.clear();
         }
    
   
    }
    
    public void llenarSistema(ArrayList <String> info,ArrayList <String> ordenPago,ArrayList <String> elementAd,ArrayList <String> eventos){
        
        //////////////LLENADO LISTA SOLICITUDES//////////
        for (int i=0;i<info.size()-1;i++){
            String []partes= info.get(i+1).split(",");
            if(partes.length>=1){
                String cod= partes[0];
                int codigo=Integer.valueOf(cod);
                String nomCliente=partes[1];
                Cliente cliente=(Cliente) buscarUsuario(nomCliente,1);
                String nomPlanificador=partes[2];
                Planificador planificador= (Planificador) buscarUsuario(nomPlanificador,2);
                String fecha_sol=partes[3];
                System.out.println(fecha_sol);
                Date fecha_solicitud=stringtoDate(fecha_sol);
                String fecha_ev=partes[4];
                System.out.println(fecha_ev);
                Date fecha_evento=stringtoDate(fecha_ev);
                String estado=partes[5];
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Solicitud soli= new Solicitud(codigo,cliente,planificador,fecha_solicitud,fecha_evento,EstadoSolicitud.valueOf(estado));
                System.out.println(sdf.format(soli.getFechaRegistro()));
                Sistema.solicitudes.add(soli);
                }
            }
        ////////////LLENADO EVENTOS////////////////////
        for(int i=0;i<eventos.size()-1;i++){
            Evento ev= new Evento();
            String [] partes2=eventos.get(i+1).split(",");
            if (partes2.length>=1){
                int codigo= Integer.valueOf(partes2[0]);
                String nombre_Cliente= partes2[1];
                Cliente cliente= (Cliente) buscarUsuario(nombre_Cliente,1);
                String tipo= partes2[2];
                
                Date fecha= stringtoDate(partes2[3]);
                String hora_in=partes2[4];
                String hora_fin=partes2[5];
                int capacidad= Integer.valueOf(partes2[6]);
         
                String nombrePlan= partes2[7];                                             
                Planificador plan= (Planificador) buscarUsuario(nombrePlan,2);
                EstadoEvento estado= EstadoEvento.valueOf(partes2[8]);
                if (tipo.equals("Boda")){
                    ev = new Boda("",cliente,plan,fecha,hora_in,hora_fin,capacidad);
                    ev.setCodigo(codigo);
                    ev.setEstadoEvento(estado);
                    
                }
                else if(tipo.equals("Fiesta Empresarial")){
                    ev= new FiestaEmpresarial(false,0,cliente,plan,fecha,hora_in,hora_fin,capacidad);
                    ev.setCodigo(codigo);
                    ev.setEstadoEvento(estado);
                    
                }
                else if(tipo.equals("Fiesta Infantil")){
                    ev= new FiestaInfantil(0,0,false,cliente,plan,fecha,hora_in,hora_fin,capacidad);
                    ev.setCodigo(codigo);
                    ev.setEstadoEvento(estado);
                    
                }
                
            }
            Sistema.eventos.add(ev);
        }
        ////////////LLENADO LISTA ADICIONALES PARA CADA EVENTO//////
        for(int i=0;i<elementAd.size()-1;i++){
            
            String [] partes=elementAd.get(i+1).split(",");
            if(partes.length>=1){
                int codEv=Integer.valueOf(partes[0]);
                for(Evento element: Sistema.eventos){
                    ElementoAdicional el=new ElementoAdicional();
                    el.setTipoElementoAdicional(TipoElementoAdicional.valueOf(partes[1]));
                    el.setCantidad(Integer.valueOf(partes[2]));
                    el.setPrecio(Double.valueOf(partes[3]));
                    el.setTotal(Double.valueOf(partes[4]));
                    if (element.getCodigo()==codEv){
                        element.getElementosAdicionales().add(el);
                        element.setValorTotal(element.getValorTotal()+element.calcularCostoTotal());
                    }
                }
            }
        }
        ////////////LLENADO LISTA ORDENPAGO////////////
        for(int i=0;i<ordenPago.size()-1;i++){
            String []partes2=ordenPago.get(i+1).split(",");
            if (partes2.length>=1){
                int codigo_pago= Integer.valueOf(partes2[0]);
                
                int codigo_evento= Integer.valueOf(partes2[1]);
                Evento ev= new Evento();
                for (Evento element: Sistema.eventos){
               
                    if(element.getCodigo()==codigo_evento){
                        ev=element;
                    }
                }
                double total_pagar= Double.valueOf(partes2[2]);
                
                EstadoOrdenDePago estado= EstadoOrdenDePago.valueOf(partes2[3]);
                
                int codigo_transaccion= Integer.valueOf(partes2[4]);
                Date fecha_registro=null;
                if(partes2[5].equals("sf")){
                    fecha_registro=stringtoDate("00/00/0000");    
                }else{fecha_registro=stringtoDate(partes2[5]);}
                
                Cliente c= ev.getCliente();
                
                OrdenPago op=new OrdenPago(ev,c,estado,codigo_pago,codigo_transaccion);
                op.setFechaReg(fecha_registro);
                op.setValorTotal(total_pagar);
                Sistema.ordenpag.add(op);
                
            }   
        }
        /////////////CLIENTES ORDENPAGO//////
        
        for(OrdenPago element:Sistema.ordenpag){
            
            for(Cliente elemento: Sistema.clientes){
            
                //System.out.println(elemento.getNombre());
                if(element.getCliente().equals(elemento)){
                    elemento.getOrden().add(element);
                    System.out.println("asd");
                    System.out.println(elemento.getOrden());
                }
            }
            
        }
        }
    
    
    public Date stringtoDate(String fecha){        
            String[] fechaLista=fecha.split("/");
            int anio=Integer.valueOf(fechaLista[2]);
            int mes=Integer.valueOf(fechaLista[1]);
            int dia=Integer.valueOf(fechaLista[0]);

            Date fechaDate= new Date(anio - 1900, mes - 1, dia);
        return fechaDate;
    }
    
    public void archivos(ArrayList<String> a,ArrayList<String> b,ArrayList<String> c,ArrayList<String> d){
        if(a.isEmpty()){
        ManejoArchivos.EscribirArchivo("solicitudes.txt","id_solicitud,nombre_cliente,nombre_planificador,fecha_solicitud,fecha_evento,estado");
        }
        if(b.isEmpty()){
        ManejoArchivos.EscribirArchivo("ordenPago.txt","Código_pago,Código_evento,total_pagar,estado,Código_transacción,fecha_registro");
            
        }
        if(c.isEmpty()){
        ManejoArchivos.EscribirArchivo("adicionales.txt","Código_evento,tipo,cantidad,precio,total");
        }    
        if(d.isEmpty()){
         ManejoArchivos.EscribirArchivo("evento.txt","codigo,nombre_cliente,tipo,fecha,hora_inicio,hora_fin,capacidad,planificador,estado");     
        }
        }
    public void culoabierto(Planificador planificador){
        for(Solicitud element: Sistema.solicitudes){
            if(element.getPlanificador().getNombre().equals(planificador.getNombre())){
                planificador.getSolicitudesAsignadas().add(element);
            }
        }
    }
    
    public int crearCodigos(){
        ////Para Evento
      
        for(Evento element: Sistema.eventos){
            Sistema.numerosEvento.add(element.getCodigo());
        }
        Random rd=new Random();
        int numA=rd.nextInt(9000);
        int numero=1000+numA;
        while(Sistema.numerosEvento.contains(numero)){
            numero=0;
            numA=rd.nextInt(9000);
            numero=1000+numA;
        }
        
        
    return numero;}
}