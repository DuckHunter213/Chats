/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Interfaces.Autentificar;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Interfaces.ManejadorMensaje;
import Interfaces.RecibeMensajesPanel;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author DARKENSES
 */
public class ManejadorMensajes implements Runnable, ManejadorMensaje{

    private String usuarioOrigen;
    private String salaDestino;
    private String mensaje;

    @Override
    public void run(){
        try{
            recibirMensaje(usuarioOrigen, salaDestino, mensaje);
        }catch (RemoteException ex){
            Logger.getLogger(ManejadorMensajes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void recibirMensaje(String usuarioOrigen, String usuarioDestino, String mensaje) throws RemoteException{
        this.usuarioOrigen = usuarioOrigen;
        this.salaDestino = salaDestino;
        this.mensaje = mensaje;
    }

    @Override
    public void enviarMensaje(String usuarioOrigen, String usuarioDestino, String mensaje) throws RemoteException, AccessException{
        Registry registry = LocateRegistry.getRegistry("");
        RecibeMensajesPanel stubRecibeMensajesPanel = null;
        try{
            stubRecibeMensajesPanel = (RecibeMensajesPanel)registry.lookup("MensajeCliente");
        }catch (NotBoundException ex){
            Logger.getLogger(ManejadorMensajes.class.getName()).log(Level.SEVERE, null, ex);
        }
        stubRecibeMensajesPanel.recibirMensajes(usuarioOrigen, salaDestino, mensaje);
    }

}
