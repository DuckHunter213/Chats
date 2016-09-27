/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.cliente;

import cliente.servidor.Autentificar;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import cliente.servidor.Autentificar;

/**
 *
 * @author gerar
 */
public class Cliente {
    private String nombreUsuario;
    private String contraseniaUsuario;

    public Cliente(String nombreUsuario, String contraseniaUsuario) {
        this.nombreUsuario = nombreUsuario;
        try{
            this.contraseniaUsuario = volverHash(contraseniaUsuario);            
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Error en la matrix");
        }
    }
    private static String volverHash(String string) throws NoSuchAlgorithmException{
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hash=messageDigest.digest(string.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        
        for(int i=0; i<hash.length;i++){
                stringBuilder.append(Integer.toString((hash[i]&0xff)+0x100,16).substring(1));
        }        
        return  stringBuilder.toString();
}
    
    public boolean validarUsuario() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("192.168.43.194");
        Autentificar stubAutenticacion = (Autentificar)registry.lookup("Autenticar");
        boolean respuesta  =  stubAutenticacion.usuarioValido(nombreUsuario, contraseniaUsuario);
        System.out.println("Respuesta: " + stubAutenticacion.toString());
        if (respuesta)
            return true;
        else
            return false;
    }
    
    public boolean registrarUsuario() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("192.168.43.194");
        Autentificar stubAutenticacion = (Autentificar)registry.lookup("Autenticar");
        //Usa el método del servidor
        boolean respuesta  =  stubAutenticacion.nuevoUsuario(nombreUsuario, contraseniaUsuario);
        System.out.println("Respuesta: " + stubAutenticacion.toString());
        if (respuesta)
            return true;
        else
            return false;
    }
}
