/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;
import java.util.Date;
import Evento.*;

/**
 *
 * @author stefano
 */
public class Cliente extends Usuario{
    //private OrdenPago ordenPago;
    private Date fecha;
    private String correo;
    private String telefono;
     
    public void realizarSolicitud(Evento evento, Date fecha){
        System.out.println("/***************Nueva Solicitud****************/\n"
                          +"/*                                            */\n"
                          +"/**********************************************/\n"
        );
        System.out.println("Bienvenid@ ");
        System.out.println("TIPO DE EVENTO (Elija)\n"
                          +"1. Boda\n"
                          +"2. Fiesta Infantil\n"
                          +"3. Fiesta Empresarial\n"
        );
        System.out.println("Seleccione:");
        
    }
    
    private void validarTiempo(Evento evento, Date fecha){
        
    }
    
    //Metodos getters y setters
    public Date getFecha(){
        return this.fecha;
    }
    
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    
    public String getCorreo(){
        return this.correo;
    }
    
    public void setCorreo(String correo){
        this.correo = correo;
    }
    
    public String getTelefono(){
        return this.telefono;
    }
    
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
}
