/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Documento;
import Main.*;
import java.util.ArrayList;
/**
 *
 * @author U_DoN_T_KnOw_Me
 */
public class Archivo {
    Interfaz i= new Interfaz();
    public ArrayList<String> lineas= ManejoArchivos.LeeFichero("usuarios.txt");
    public ArrayList<String> clientes= ManejoArchivos.LeeFichero("clientes.txt");
    public ArrayList<String> solicitudespendientes= ManejoArchivos.LeeFichero("solicitudes.txt");              
    }

