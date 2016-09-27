/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.cliente;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author gerar
 */
public class Chat {
    private String nombreChat;
    private String identificador;
    
    public Chat(String nombreUsuarioLocal, String nombreUsuarioRemoto){
        identificador = generadorNombreSala(nombreUsuarioLocal, nombreUsuarioRemoto);
    }
    public Chat(){
        identificador = "principal";
        nombreChat = "principal";
    }
    public Chat(String identificador){
        this.identificador = identificador;
    }
    
    public Chat crearNuevaSala(){
        nombreChat = identificador;
        return this;
    }
    public String getNombreChat(){
        return this.nombreChat;
    }
    public void setNombreChat(String nuevoNombre){
        this.nombreChat = nuevoNombre;
    }
    
    private static String generadorNombreSala(String nombreUsuarioLocal, String nombreUsuarioRemoto){
        String nombre = nombreUsuarioLocal.substring(0, 3);
        nombre += "-" + nombreUsuarioRemoto.subSequence(0, 3);
        return nombre;
    }
    
}
