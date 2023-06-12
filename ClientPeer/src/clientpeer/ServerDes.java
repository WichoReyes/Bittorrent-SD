/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientpeer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gerar
 */
public class ServerDes extends Thread{
     static int NoClients=0; 
   static int NoRegistro=1;
   
   public void run(){ 
	ServerSocket socketServidor = null; 
	Socket socketCliente = null;

	try{ 
	   socketServidor = new ServerSocket (5000); 
	}catch (Exception e){ 
	   System.out.println ("Error : "+ e.toString()); 
	   System.exit (0); 
	} 
		
	System.out.println ("Server started... (Socket TCP) **Servidor de descarga iniciado**");	
	int enproceso=1;
	while(enproceso==1){ 
		try{ 
	   		socketCliente = socketServidor.accept();
			ProcesoDesc controlThread=new ProcesoDesc(socketCliente);
			controlThread.start();
	   	}catch (Exception e){ 
	    	System.out.println ("Error : " + e.toString()); 
                    try { 
                        socketServidor.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Multiservers.class.getName()).log(Level.SEVERE, null, ex);
                    }
			System.exit (0); 
	   	} 
	}
	System.out.println("Finalizando Servidor...");

   } 
}
