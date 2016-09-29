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
public interface RecibeMensajesPanel extends Remote{
    public void recibirMensajes(String usuarioOrigen,String chatDestino,String mensaje) throws RemoteException;
}
