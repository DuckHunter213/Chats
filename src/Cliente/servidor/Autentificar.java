/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author gerar
 */
public interface Autentificar extends Remote{
    public boolean usuarioValido(String usuario, String contra) throws RemoteException;
    public boolean nuevoUsuario(String usuario, String contra) throws RemoteException;
}
