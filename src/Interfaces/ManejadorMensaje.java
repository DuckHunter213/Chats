/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author DARKENSES
 */
public interface ManejadorMensaje extends Remote{
    public void recibirMensaje(String usuarioOrigen, String salaDestino, String mensaje) throws RemoteException;

    public void enviarMensaje(String usuarioOrigen, String usuarioDestino, String mensaje) throws RemoteException;

}
