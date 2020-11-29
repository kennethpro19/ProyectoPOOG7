package Documento;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Evento.*;
import Usuario.*;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author U_DoN_T_KnOw_Me
 */
public class OrdenPago {
    private EstadoOrdenDePago estado;
    private Cliente cliente;
    private Evento evento;
    private int codigo;
    private int codTrans;
    public OrdenPago(Evento evento,Cliente cliente,EstadoOrdenDePago estado,int codigo, int codTrans){
       this.evento=evento;
       this.cliente=cliente;
       this.estado= estado;
       this.codigo=codigo;
       this.codTrans=codTrans;
    }
    public void crearCodigo(ArrayList<Integer> numeros){
        Random r = new Random();
        int b = numeros.size() - 999;

        int a = r.nextInt(b) + 999;

        this.codigo=numeros.remove(a);
    }
    }

        
  
            

