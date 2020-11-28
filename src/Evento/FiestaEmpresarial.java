package Evento;


import Evento.Evento;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kenneth
 */
public class FiestaEmpresarial extends Evento {

    private static double precio = 2000;
    private boolean transporte;
    private int personas;

    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }

    public boolean getTransporte() {
        return this.transporte;
    }

    public void setPersonas(int personas) {
        this.personas = personas;
    }

    public int getPersonas() {
        return this.personas;
    }

}
