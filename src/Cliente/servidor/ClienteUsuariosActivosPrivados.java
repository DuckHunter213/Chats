/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.servidor;

import cliente.interfaces.ListaUsuariosActivos;
import java.rmi.RemoteException;

/**
 *
 * @author gerar
 */
public class ClienteUsuariosActivosPrivados implements usuariosActivosChatsPrivados, Runnable {
    ListaUsuariosActivos listaUsuarios;
    
    public ClienteUsuariosActivosPrivados(ListaUsuariosActivos listaUsuarios){
        this.listaUsuarios = listaUsuarios;
    }
    
    @Override
    public void run() {

    }

    @Override
    public void nuevoUsuarioConectado(String nombreUsuario) throws RemoteException {
        listaUsuarios.setNuevoUsuarioConectado(nombreUsuario);
    }

    @Override
    public void usuarioDesconectado(String nombreUsuario) throws RemoteException {
        listaUsuarios.quitarUsuarioConectado(nombreUsuario);
    }

    @Override
    public void crearChatPrivado(int index) throws RemoteException {
        listaUsuarios.agregarChatPrivado(index);
    }

    @Override
    public void borrarChatPrivado(int index) throws RemoteException {
        listaUsuarios.quitarChatPrivado(index);
    }

    @Override
    public void cargarChatGeneral() throws RemoteException {
        listaUsuarios.cargarChatPrincipal();
    }

}
