/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;
import java.util.*;
import Evento.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import Documento.*;
/**
 *
 * @author stefano
 */
public class Cliente extends Usuario{
    private ArrayList<OrdenPago> orden=new ArrayList<OrdenPago>();
    private Date fecha;
    private String correo;
    private String telefono;
   
    public Cliente(String nombre,String apellido,String usuario,String contraseña,char TipoUsuario,String correo, String telefono){
       
        super(nombre,apellido,usuario,contraseña,TipoUsuario);
        this.correo=correo;
        this.telefono=telefono;
    }
    public Cliente(){
        
    }
    @Override
    public boolean equals(Object o){
        if (o instanceof Cliente){
            Cliente cliente=(Cliente) o;
            return super.getNombre()==cliente.getNombre();
        }
        else{
            return false;
        }
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


    public ArrayList<OrdenPago> getOrden() {
        return this.orden; 
    }
}
