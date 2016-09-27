/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorusuario;

import Servidor.ServidorUsuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DARKENSES
 */
public class ServidorUsuarioTest{
    
    public ServidorUsuarioTest(){
    }
    
    @BeforeClass
    public static void setUpClass(){
    }
    
    @AfterClass
    public static void tearDownClass(){
    }
    
    @Before
    public void setUp(){
    }
    
    @After
    public void tearDown(){
    }


    /**
     * Test of usuarioValido method, of class ServidorUsuario.
     */
    @Test
    public void testUsuarioValido() throws Exception{
        System.out.println("usuarioValido");
        String usuario = "";
        String contra = "";
        ServidorUsuario instance = new ServidorUsuario();
        boolean expResult = false;
        boolean result = instance.usuarioValido(usuario, contra);
        assertEquals(expResult, result);
    }

    /**
     * Test of nuevoUsuario method, of class ServidorUsuario.
     */
    @Test
    public void testNuevoUsuario() throws Exception{
        System.out.println("nuevoUsuario");
        String usuario = "Marcos";
        String contra = "12345";
        ServidorUsuario instance = new ServidorUsuario();
        boolean expResult = true;
        boolean result = instance.nuevoUsuario(usuario, contra);
        assertEquals(expResult, result);
    }
    
}
