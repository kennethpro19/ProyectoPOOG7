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
/**
 *
 * @author U_DoN_T_KnOw_Me
 */
public class Interfaz {
    Scanner sc= new Scanner(System.in);
    
    //Menú inicio de sesión
    public ArrayList<String> iniciarSesion(){
         System.out.println("++++++++++++++++++++++++++++++++\n\n"
                +          "      BIENVENIDO AL SISTEMA     \n\n"
                +          "++++++++++++++++++++++++++++++++" );
        
        System.out.print("USUARIO: ");
        String usuario=sc.nextLine();
        System.out.print("CONTRASEÑA: ");
        String contraseña=sc.nextLine();
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
        choice= sc.nextLine();
        switch(choice){
            case "1": solicitarPlanificacion();
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
    public void solicitarPlanificacion(){
        System.out.println("/**************NUEVA SOLICITUD********************/\n"+
                           "/*                                               */\n"+
                           "/*************************************************/");
        System.out.println("Bienvenido\n");
        String choice="";
        do{
        System.out.println("TIPO DE EVENTO (Elija)");
        System.out.println("1. Boda\n"
                +          "2. Fiesta infantil\n"
                +          "3. Fiesta empresarial");
        System.out.println("Seleccione:");
        choice=sc.nextLine();
        switch(choice){
            case "1": eventoBoda();
                break;
            case "2": eventoFiestaInfantil();
                break;
            case "3": eventoFiestaEmpresarial();
                break;
            default: System.out.println("Opción inválida!");
        }
            
        }while(!choice.equals("1")||!choice.equals("2")||!choice.equals("3"));
    }
    public void eventoBoda(){
        
        
        ArrayList <String> infor=new ArrayList<String>();
        generarArchivo("Solicitud",infor);
    }
    public void eventoFiestaInfantil(){
        
        ArrayList <String> infor=new ArrayList<String>();
        generarArchivo("Solicitud",infor);
    }
    public void eventoFiestaEmpresarial(){
        
        ArrayList <String> infor=new ArrayList<String>();
        generarArchivo("Solicitud",infor);
    }
    public void registrarPagoEvento(Cliente cliente){
        System.out.println("/****************REGISTRO PAGO*****************/\n"
                +          "/*                                            */\n"
                +          "/**********************************************/");
    ArrayList <OrdenPago> a= cliente.getOrden();
    for (OrdenPago element: a){
	String choice ="";
	System.out.println("Su orden con código "+ (element.getCodigo()) +" está pendiente de pago.\n"
		          +"¿Desea registrar pago ahora? (S/N):");
 	choice= sc.nextLine();
	while (!choice.equals("N") && !choice.equals("S")){
		System.out.println("Ingrese una opción válida");
		choice = sc.nextLine();
		}
	if (choice.equals('S')){
		System.out.println("Ingrese el código de la transacción: ");
		int codtrans= sc.nextInt();
		element.setCodTrans(codtrans);
		} 
	}            
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
            case "1": consultarSolicitudesPendientes(a.solicitudespendientes);
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


public void consultarSolicitudesPendientes(ArrayList <String> solicitudespendientes){
System.out.println("/******************SOLICITUDES PENDIENTES*******************/\n"
+	       "/*                                                         */\n"+
	       "/***********************************************************/");   		
	//Leer archivos rey
        
        for(int i=0;i<solicitudespendientes.size()-1;i++){
            
            String [] partes=solicitudespendientes.get(i+1).split(",");
            if(partes.length>1){
            System.out.println(i+1+".  "+partes[0]+" - "+partes[3]);}
            else{System.out.println("No hay solicitudes pendientes");}
 }
}




public void registrarEvento(ArrayList <Solicitud> solicitudes){
System.out.println("/*********************REGISTRAR EVENTOS*********************/\n"
+	       "/*                                                         */\n"+
	       "/***********************************************************/");   		
System.out.print("Ingrese el id de la solicitud: "); 
int cod=sc.nextInt();
sc.nextLine();
Evento evento=null;
ArrayList <Solicitud> a=solicitudes;
Solicitud solicitud=null;
for (int i=0;i<a.size();i++){
	if ((a.get(i).getCod())==cod){
		 solicitud= a.get(i);
		System.out.println("asdsa"); //imprime datos
	}else{System.out.println("No existe una solicitud de evento con el código ingresado");}
	}

System.out.println("/**************REGISTRO DE DATOS DEL EVENTO*************/");
System.out.println("Hora inicio: ");
////
System.out.println("Hora fin: ");
/////
System.out.println("Capacidad: ");
int capacidad= sc.nextInt();
sc.nextLine();
evento.setCapacidad(capacidad);
System.out.println("¿Desea registrar elementos adicionales? (S/N)");
String choice= sc.nextLine();
	while (!choice.equals("S") && !choice.equals("N")){
		System.out.println("Ingrese una opción válida");
		choice= sc.nextLine();
		}
	if (choice.equals('S')){
		 Scanner sc = new Scanner(System.in);
        char elementoAd='S';

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
                comida.setTipoElementoAdicional(TipoElementoAdicional.COMIDA);
                double total1 = precioComida * cantidad1;
                System.out.println("Total:" + total1);
                char agg1 = 'A';
                System.out.println("Agregar(S/N):");
                agg1 = sc.next().charAt(0);
                if(agg1=='S'){
                    //listadeEvento.add(comida);
                    System.out.println("Se ha agregado su elección.");
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
                    char agg = 'A';
                    System.out.println("Agregar(S/N):");
                    agg = sc.next().charAt(0);
                    if(agg=='S'){
                        //listadeEvento.add(bocaditos);
                        System.out.println("Se ha agregado su elección.");
                    } else {
                        System.out.println("No se ha agregado su elección.");
                    }
                }else{
                    double precioBocadito=0.25;
                    double total2 = precioBocadito * cantidad2;
                    System.out.println("Total:" + total2);
                    char agg = 'A';
                    System.out.println("Agregar(S/N):");
                    agg = sc.next().charAt(0);
                    if(agg=='S'){
                        //listadeEvento.add(bocaditos);
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
                int uno3=0;
                int dos3=0;
                int cantidad3=1;
                switch(opcion3){
                    case "1":
                        if (uno3==0){
                            ElementoAdicional dj=new ElementoAdicional();
                            dj.setTipoElementoAdicional(TipoElementoAdicional.MUSICA);
                            dj.setPrecio(precioDj);
                            dj.setCantidad(cantidad3);
                            double total3 = precioDj * cantidad3;
                            System.out.println("Total:" + total3);
                            char agg3 = 'A';
                            System.out.println("Agregar(S/N):");
                            agg3 = sc.next().charAt(0);
                            if (agg3 == 'S') {
                                //listadeEvento.add(dj);
                                System.out.println("Se ha agregado su elección.");
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
                            double total3 = precioBanda * cantidad3;
                            System.out.println("Total:" + total3);
                            char agg3 = 'A';
                            System.out.println("Agregar(S/N):");
                            agg3 = sc.next().charAt(0);
                            if (agg3 == 'S') {
                                //listadeEvento.add(banda);
                                System.out.println("Se ha agregado su elección.");
                                dos3++;
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
                double total4 = precioFotografia * cantidad4;
                System.out.println("Total:" + total4);
                char agg4 = 'A';
                System.out.println("Agregar(S/N):");
                agg4 = sc.next().charAt(0);
                if (agg4 == 'S') {
                    //listadeEvento.add(fotografia);
                    System.out.println("Se ha agregado su elección.");
                   
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
                int uno=0;
                int dos=0;
                int tres=0;
                int cuatro=0;
                switch(opcion5){
                    case "1":
                        if (uno==0){
                            System.out.println("Cantidad de whiskys:");
                            int cantidad=sc.nextInt();
                            ElementoAdicional whisky=new ElementoAdicional();
                            whisky.setCantidad(cantidad);
                            whisky.setPrecio(precioWhisky);
                            whisky.setTipoElementoAdicional(TipoElementoAdicional.BEBIDA);
                            double total=precioWhisky*cantidad;
                            System.out.println("Total:"+total);
                            char agg='A';
                            System.out.println("Agregar(S/N):");
                            agg=sc.next().charAt(0);
                            if(agg=='S'){
                               //listadeEvento.add(whisky);
                                 System.out.println("Se ha agregado su elección.");
                                 uno++;
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
                            vodka.setTipoElementoAdicional(TipoElementoAdicional.BEBIDA);
                            double total=precioVodka*cantidad;
                            System.out.println("Total:"+total);
                            char agg='A';
                            System.out.println("Agregar(S/N):");
                            agg=sc.next().charAt(0);
                            if(agg=='S'){
                               //listadeEvento.add(vodka);
                                 System.out.println("Se ha agregado su elección.");
                                 dos++;
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
                            cerveza.setTipoElementoAdicional(TipoElementoAdicional.BEBIDA);
                            double total=precioCerveza*cantidad;
                            System.out.println("Total:"+total);
                            char agg='A';
                            System.out.println("Agregar(S/N):");
                            agg=sc.next().charAt(0);
                            if(agg=='S'){
                               //listadeEvento.add(cerveza);
                                 System.out.println("Se ha agregado su elección.");
                                 tres++;
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
                            double total=precioRefrescos*cantidad;
                            System.out.println("Total:"+total);
                            char agg='A';
                            System.out.println("Agregar(S/N):");
                            agg=sc.next().charAt(0);
                            if(agg=='S'){
                               //listadeEvento.add(refrescos);
                                 System.out.println("Se ha agregado su elección.");
                                 cuatro++;
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
        System.out.println("El costo total del evento sera de:"+"dólares.");
        System.out.println("¿Desea generar orden de pago(S/N)?");
        char generarOrden=sc.next().charAt(0);
        if(generarOrden=='S'){
            solicitud.setEstadoSol(EstadoSolicitud.APROBADO);
            ArrayList <String> infor= new ArrayList <String>();
            generarArchivo("OrdenPago",infor);
            System.out.println("Se ha generado su orden de pago.");
        }else{
            System.out.println("No se ha generado su orden de pago.");
            
        }
        //crearCodigos
        
    }
		
System.out.println("¿Desea generar su orden de pago? (S/N)");
String choice2= sc.nextLine();
	while (!choice2.equals("S") && !choice2.equals("N")){
		System.out.println("Ingrese una opción válida");
		choice2 = sc.nextLine();
		}
	if (choice2.equals('S')){
		generarOrdenPago(evento);
		
		} 
}

public void generarOrdenPago(Evento evento){
	System.out.println("/**************ORDEN DE PAGO***************/\n"
	+		   "/*                                        */\n"
	+		   "/******************************************/");
}

public void registrarElementosAdicionales(){
    
    
         
       
//REGISTRO DE ELEMENTOS ADICIONALES PARA EL EVENTO
        
        Scanner sc = new Scanner(System.in);
        char elementoAd='S';
        String entrada;
        do{
        entrada="";
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
                comida.setTipoElementoAdicional(TipoElementoAdicional.COMIDA);
                double total1 = precioComida * cantidad1;
                System.out.println("Total:" + total1);
                char agg1 = 'A';
                System.out.println("Agregar(S/N):");
                agg1 = sc.next().charAt(0);
                if(agg1=='S'){
                    //listadeEvento.add(comida);
                    System.out.println("Se ha agregado su elección.");
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
                    char agg = 'A';
                    System.out.println("Agregar(S/N):");
                    agg = sc.next().charAt(0);
                    if(agg=='S'){
                        //listadeEvento.add(bocaditos);
                        System.out.println("Se ha agregado su elección.");
                    } else {
                        System.out.println("No se ha agregado su elección.");
                    }
                }else{
                    double precioBocadito=0.25;
                    double total2 = precioBocadito * cantidad2;
                    System.out.println("Total:" + total2);
                    char agg = 'A';
                    System.out.println("Agregar(S/N):");
                    agg = sc.next().charAt(0);
                    if(agg=='S'){
                        //listadeEvento.add(bocaditos);
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
                int uno3=0;
                int dos3=0;
                int cantidad3=1;
                switch(opcion3){
                    case "1":
                        if (uno3==0){
                            ElementoAdicional dj=new ElementoAdicional();
                            dj.setTipoElementoAdicional(TipoElementoAdicional.MUSICA);
                            dj.setPrecio(precioDj);
                            dj.setCantidad(cantidad3);
                            double total3 = precioDj * cantidad3;
                            System.out.println("Total:" + total3);
                            char agg3 = 'A';
                            System.out.println("Agregar(S/N):");
                            agg3 = sc.next().charAt(0);
                            if (agg3 == 'S') {
                                //listadeEvento.add(dj);
                                System.out.println("Se ha agregado su elección.");
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
                            double total3 = precioBanda * cantidad3;
                            System.out.println("Total:" + total3);
                            char agg3 = 'A';
                            System.out.println("Agregar(S/N):");
                            agg3 = sc.next().charAt(0);
                            if (agg3 == 'S') {
                                //listadeEvento.add(banda);
                                System.out.println("Se ha agregado su elección.");
                                dos3++;
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
                double total4 = precioFotografia * cantidad4;
                System.out.println("Total:" + total4);
                char agg4 = 'A';
                System.out.println("Agregar(S/N):");
                agg4 = sc.next().charAt(0);
                if (agg4 == 'S') {
                    //listadeEvento.add(fotografia);
                    System.out.println("Se ha agregado su elección.");
                   
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
                int uno=0;
                int dos=0;
                int tres=0;
                int cuatro=0;
                switch(opcion5){
                    case "1":
                        if (uno==0){
                            System.out.println("Cantidad de whiskys:");
                            int cantidad=sc.nextInt();
                            ElementoAdicional whisky=new ElementoAdicional();
                            whisky.setCantidad(cantidad);
                            whisky.setPrecio(precioWhisky);
                            whisky.setTipoElementoAdicional(TipoElementoAdicional.BEBIDA);
                            double total=precioWhisky*cantidad;
                            System.out.println("Total:"+total);
                            char agg='A';
                            System.out.println("Agregar(S/N):");
                            agg=sc.next().charAt(0);
                            if(agg=='S'){
                               //listadeEvento.add(whisky);
                                 System.out.println("Se ha agregado su elección.");
                                 uno++;
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
                            vodka.setTipoElementoAdicional(TipoElementoAdicional.BEBIDA);
                            double total=precioVodka*cantidad;
                            System.out.println("Total:"+total);
                            char agg='A';
                            System.out.println("Agregar(S/N):");
                            agg=sc.next().charAt(0);
                            if(agg=='S'){
                               //listadeEvento.add(vodka);
                                 System.out.println("Se ha agregado su elección.");
                                 dos++;
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
                            cerveza.setTipoElementoAdicional(TipoElementoAdicional.BEBIDA);
                            double total=precioCerveza*cantidad;
                            System.out.println("Total:"+total);
                            char agg='A';
                            System.out.println("Agregar(S/N):");
                            agg=sc.next().charAt(0);
                            if(agg=='S'){
                               //listadeEvento.add(cerveza);
                                 System.out.println("Se ha agregado su elección.");
                                 tres++;
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
                            double total=precioRefrescos*cantidad;
                            System.out.println("Total:"+total);
                            char agg='A';
                            System.out.println("Agregar(S/N):");
                            agg=sc.next().charAt(0);
                            if(agg=='S'){
                               //listadeEvento.add(refrescos);
                                 System.out.println("Se ha agregado su elección.");
                                 cuatro++;
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
        if(!entrada.equals("6")){
            System.out.println("¿Desea registrar elementos adicionales(S/N)?");
            elementoAd=sc.next().charAt(0);
        } else{
            elementoAd='N';
        
        }
        
        }while(elementoAd!='N');
        System.out.println("Ha concluido el ingreso de los datos del evento.");
        System.out.println("El costo total del evento sera de:"+" dólares.");
        System.out.println("¿Desea generar orden de pago(S/N)?");
        char generarOrden=sc.next().charAt(0);
        if(generarOrden=='S'){
            //solicitud.setEstadoSol(EstadoSol.APROBADA)
            System.out.println("Se ha generado su orden de pago.");
        }else{
            System.out.println("No se ha generado su orden de pago.");
            
        }
}


public void confirmarEvento(){
	System.out.println("/*************CONFIRMAR EVENTO*************/\n"
	+		   "/*                                        */\n"
	+		   "/******************************************/");
	System.out.println("Ingrese el id de la orden de pago: ");
	int id=sc.nextInt();
	sc.nextLine();
	ArrayList <OrdenPago> listaa=Sistema.ordenpag;
	for (int i=0;i<listaa.size();i++){
		if(listaa.get(i).getCodigo()==id){

			if (!listaa.get(i).getFechaRegistro().equals(00/00/00)){
				System.out.println("El pago de este evento se ha realizado el "+listaa.get(1).getFechaRegistro());
				System.out.println("¿Desea aprobar este pago? (S/N)");
				String choice= sc.nextLine();
				while (!choice.equals("S") && !choice.equals("N")){
				System.out.println("Ingrese una opción válida");
				choice = sc.nextLine();
						}
				if (choice.equals('S')){
					System.out.println("El pago se ha aprobado.\nEl evento se ha confirmado para la fecha establecida");
					listaa.get(i).getEvento().setEstadoEvento(EstadoEvento.CONFIRMADO);	
				}else{System.out.println("El pago no se ha aprobado. El evento está a espera para su confirmacion");}
                        }else{System.out.println("El pago aun no ha sido realizado. El evento no puede confirmarse");}
					
		}
	}
}


public void consultarEvento(Planificador planificador){
	ArrayList <Evento> lista= planificador.getEventos();

	System.out.println("/*************CONSULTAR EVENTO*************/\n"
	+		   "/*                                        */\n"
	+		   "/******************************************/");	
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
        for (int i=0;i<partes.length;i++){
            if ((partes.length>1) && partes[2].equals(nombreusuario)){         
                if(partes[i].indexOf(",")!= -1){
                    String [] partes2=partes[i].split(",");
                    resultado=partes2[1];
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
    for(int k=0;k<lineas.size()-1;k++){
    String [] partes=lineas.get(k+1).split(";");
    for (int i=0;i<partes.length;i++){
        if ((partes.length>1)&&clienteOPlanificador(lineas,partes[2],partes[3]).equals("C")){
            ArrayList <String[]> infoClientes=getInfoCliente(clientes);

            if(partes[i].indexOf(",")!= -1){
                            for (int j=0;j<(infoClientes.size());j++){
                   if(infoClientes.size()>1&&infoClientes.get(j)[0].equals(partes[2])){
                    telefono=infoClientes.get(j)[1];
                    correo=infoClientes.get(j)[2];}
            }
                    String [] partes2=partes[i].split(",");
             Cliente c=new Cliente(partes[0],partes[1],partes[2],partes2[1],'C',correo,telefono);
            Sistema.clientes.add(c);}else{
            Cliente c=new Cliente(partes[0],partes[1],partes[2],partes[3],'C',correo,telefono);
            Sistema.clientes.add(c);}
            }
         if((partes.length>1)&&clienteOPlanificador(lineas,partes[2],partes[3]).equals("P")){
            if(partes[i].indexOf(",")!= -1){
                    String [] partes2=partes[i].split(",");
            Planificador p= new Planificador(partes[0],partes[1],partes2[0],partes2[1],'P');
            Sistema.planificadores.add(p);
            }else{ Planificador p= new Planificador(partes[0],partes[1],partes[2],partes[3],'P');
            Sistema.planificadores.add(p);
            }
         }
        }
    }
    }
       public ArrayList <String []> getInfoCliente(ArrayList <String> clientes){
    ArrayList <String []> info= new ArrayList <String[]>();
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
    
    public void generarArchivo(String tipo, ArrayList<String> informacion){
        String linea="";
        if (tipo.equals("Solicitud")){
            for(String element:informacion){
            linea=linea+","+element;
            }
            ManejoArchivos.EscribirArchivo("solicitudes.txt", linea);
        }
        if (tipo.equals("OrdenPago")){
            for(String element:informacion){
                linea=linea+","+element;
            }ManejoArchivos.EscribirArchivo("ordenPago.txt", linea);
        }if (tipo.equals("Evento")){
            for(String element:informacion){
                linea=linea+","+element;
            }
            ManejoArchivos.EscribirArchivo("evento.txt", linea);
        }
        
    }
    
}
    
 


    

