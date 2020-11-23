/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import java.util.List;

/**
 *
 * @author Kenneth
 */
public class TestTodo {

    public static void main(String args[]) {
        Evento evento=new Evento();
        Evento evento1=new Evento();
        int a=evento.generarCodigo();
        System.out.println(a);
        System.out.println(evento.getCodigo());
        System.out.println(evento1.getCodigo());
    }
    
}
