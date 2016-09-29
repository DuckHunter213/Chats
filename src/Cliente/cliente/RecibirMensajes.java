/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.cliente;

import Interfaces.Autentificar;
import Interfaces.RecibeMensajesPanel;
import Servidor.ManejadorMensajes;
import Servidor.ServidorUsuario;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DARKENSES
 */
public class RecibirMensajes implements RecibeMensajesPanel{
    @Override
    public void recibirMensajes(String usuarioOrigen, String chatDestino, String mensaje) throws RemoteException, AccessException{
        ServidorUsuario servidor = new ServidorUsuario();
        ManejadorMensajes manejadorMensajesProxy = (ManejadorMensajes) UnicastRemoteObject.exportObject(servidor, 0);
        Registry registro = LocateRegistry.getRegistry("");
        try{
            registro.bind("MensajesCliente", manejadorMensajesProxy);
            System.out.println(manejadorMensajesProxy.getClass());
        }catch (AlreadyBoundException ex){
            Logger.getLogger(RecibirMensajes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
