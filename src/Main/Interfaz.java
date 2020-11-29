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
    public void iniciarSesion(){
         System.out.println("++++++++++++++++++++++++++++++++\n\n"
                +          "      BIENVENIDO AL SISTEMA     \n\n"
                +          "++++++++++++++++++++++++++++++++" );
        
        System.out.print("USUARIO: ");
        String usuario=sc.nextLine();
        System.out.print("CONTRASEÑA: ");
        String contraseña=sc.nextLine();
        
    }
    //Menú para los clientes
    public void seccionCliente(){
        String choice="";
        do{
        System.out.println("1. Solicitar planificacion de evento.\n"
                +          "2. Registrar pago evento\n"+
                           "3. Salir");
        System.out.println("Elija una opción:");
        choice= sc.nextLine();
        switch(choice){
            case "1":
                break;
            case "2":
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
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            default: System.out.println("Opción inválida!");
        }
            
        }while(!choice.equals("1")||!choice.equals("2")||!choice.equals("3"));
    }
    public void eventoBoda(){
        
    }
    public void eventoFiestaInfantil(){
        
    }
    public void eventoFiestaEmpresarial(){
        
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
    public void seccionPlanificador(){
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
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
	    case "4":
		break;
	    case "5":
		break;
            default: System.out.println("Opción inválida!");
        }
            
        }while(!choice.equals("5"));
}


public void consultarSolicitudesPendientes(){
System.out.println("/******************SOLICITUDES PENDIENTES*******************/\n"
+	       "/*                                                         */\n"+
	       "/***********************************************************/");   		
	//Leer archivos rey
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
for (int i=0;i<a.size();i++){
	if ((a.get(i).getCod())==cod){
		Solicitud solicitud= a.get(i);
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
		registrarElementosAdicionales();	
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

public void confirmarEvento(){
	System.out.println("/*************CONFIRMAR EVENTO*************/\n"
	+		   "/*                                        */\n"
	+		   "/******************************************/");
	System.out.println("Ingrese el id de la orden de pago: ");
	int id=sc.nextInt();
	sc.nextLine();
	ArrayList <OrdenPago> listaa=Planificador.getOrdenesPago();
	for (int i=0;i<listaa.size();i++){
		if(listaa.get(i).getCod()==id){
			if (!listaa.get(i).getFechaReg().equals(00/00/00)){
				System.out.println("El pago de este evento se ha realizado el "+listaa.get(1).getFechaReg());
				System.out.println("¿Desea aprobar este pago? (S/N)");
				String choice= sc.nextLine();
				while (!choice.equals("S") && !choice.equals("N")){
				System.out.println("Ingrese una opción válida");
				choice = sc.nextLine();
						}
				if (choice.equals('S')){
					System.out.println("El pago se ha aprobado.\nEl evento se ha confirmado para la fecha establecida");
					listaa.get(i).getEvento().setEstadoEvento("CONFIRMADO");	
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
}
    

