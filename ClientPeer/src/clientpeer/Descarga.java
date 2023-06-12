/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientpeer;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gerar
 */
public class Descarga  extends Thread{
    public void run (){
         ClientDesc Cliente = new ClientDesc();
     String Descarga= "Descarga";
   
     Descarga = Descarga + " " + Interfaz.Ipp + " " + Interfaz.Archiv;
        System.out.println(Descarga);
     String Resultado = null;
        if(!Interfaz.Archiv.equals("")){
       
             try {
                 Resultado=Cliente.Preguntar(Descarga, Interfaz.Direccion);
             } catch (IOException ex) {
                 Logger.getLogger(Descarga.class.getName()).log(Level.SEVERE, null, ex);
             } catch (InterruptedException ex) {
                 Logger.getLogger(Descarga.class.getName()).log(Level.SEVERE, null, ex);
             }
       
        }else{
            
        }
    }
}
