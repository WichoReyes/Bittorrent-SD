/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientpeer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gerar
 */
public class prueba extends Thread{
    public void run(){
         for(int a=0; a <10; a++){
        System.out.println("tiempo a: " + a);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    
}
