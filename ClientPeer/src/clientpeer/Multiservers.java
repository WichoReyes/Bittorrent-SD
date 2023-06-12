/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientpeer;

import java.net.*; 
import java.io.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
public class Multiservers extends Thread{
   static int NoClients=0; 
   static int NoRegistro=1;
   
   public void run(){ 
	ServerSocket socketServidor = null; 
	Socket socketCliente = null;

	try{ 
	   socketServidor = new ServerSocket (8080); 
	}catch (Exception e){ 
	   System.out.println ("Error : "+ e.toString()); 
	   System.exit (0); 
	} 
		
	System.out.println ("Server started... (Socket TCP) **Iniciado servidor PEER**");	
	int enproceso=1;
	while(enproceso==1){ 
		try{ 
	   		socketCliente = socketServidor.accept();
			MultiServerThread controlThread=new MultiServerThread(socketCliente);
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
