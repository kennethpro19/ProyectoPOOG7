/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

/**
 *
 * @author stefano
 */
public class Usuario {
    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasena;
    private char tipoUsuario;
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getApellido(){
        return this.apellido;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    
    public String getUsuario(){
        return this.usuario;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public String getContrasena(){
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }
    
    public char getTipoUsuario(){
        return this.tipoUsuario;
    }
    
    public void setTipoUsuario(char tipoUsuario){
        this.tipoUsuario = tipoUsuario;
    }
}
    
