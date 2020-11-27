/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;
import java.util.Date;
/**
 *
 * @author stefano
 */
public class Cliente extends Usuario{
    //private OrdenPago ordenPago;
    private Date fecha;
    
    public Date getFecha(){
        return this.fecha;
    }
    
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
}
