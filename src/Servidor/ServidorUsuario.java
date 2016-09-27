/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Interfaces.Autentificar;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DARKENSES
 */
public class ServidorUsuario implements Autentificar{

    ResultSet resultados;
    /**
     * @param args the command line arguments
     * @throws java.rmi.RemoteException
     * @throws java.rmi.AlreadyBoundException
     */
    public static void main(String[] args) throws RemoteException, AlreadyBoundException{
        
        ServidorUsuario servidor = new ServidorUsuario();
        Autentificar autentificarProxy = (Autentificar) UnicastRemoteObject.exportObject(servidor, 0);
        Registry registro = LocateRegistry.getRegistry("");
        registro.bind("Autenticar", autentificarProxy);
        System.out.println("Corriendo...");
        
        while(true){
            
            (new Thread(new HiloPortero())).start();
            (new Thread(new HiloCartero())).start();
            
        }
    }

    @Override
    public boolean usuarioValido(String usuario, String contra) throws RemoteException{
        Conexion conexion = new Conexion();
        Connection connection;
        try{
            connection = conexion.obtenerConexion();
            PreparedStatement sentenciaSQL = connection.prepareStatement("SELECT * FROM usuarios Where nombre= ? and contrasenia = ?");
            sentenciaSQL.setString(1, usuario);
            sentenciaSQL.setString(2, contra);
            resultados = sentenciaSQL.executeQuery();
            while (resultados.next()){
                return true;
            }
        }catch (SQLException ex){

            Logger.getLogger(ServidorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                conexion.desconecta();
            }catch (SQLException ex){
                Logger.getLogger(ServidorUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean nuevoUsuario(String usuario, String contra) throws RemoteException{
        Conexion conexion = new Conexion();
        Connection connection;
        try{
            connection=conexion.obtenerConexion();
            PreparedStatement sentenciaSQL = connection.prepareStatement("INSERT INTO usuarios VALUES (?,?)");
            sentenciaSQL.setString(1, usuario);
            sentenciaSQL.setString(2, contra);
            sentenciaSQL.executeUpdate();
            return true;
        }catch (SQLException ex){
            Logger.getLogger(ServidorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                conexion.desconecta();
            }catch (SQLException ex){
                Logger.getLogger(ServidorUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

}
