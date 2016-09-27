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
 * @author gerar
 */
public interface usuariosActivosChatsPrivados extends Remote{
    public void nuevoUsuarioConectado(String nombreUsuario) throws RemoteException;
    public void usuarioDesconectado(String usuario) throws RemoteException;
    public void cargarChatGeneral() throws RemoteException;
    public void crearChatPrivado(int index) throws RemoteException;
    public void borrarChatPrivado(int index) throws RemoteException;
}
