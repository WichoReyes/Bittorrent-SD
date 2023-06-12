/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientpeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;

/**
 *
 * @author gerar
 */
public class ClientPeer {
   static HashMap <String, Integer> Archivos = new HashMap();
   static String IP;
   static String IP2;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
                    

       if (args.length == 3){
           IP = args[2];
           IP2=args[0];
       Socket cliente = null; 
		PrintWriter escritor = null; 
		String DatosEnviados = null; 
		BufferedReader entrada=null;
		
		String maquina; 
		int puerto; 
		BufferedReader DatosTeclado = new BufferedReader ( new InputStreamReader (System.in)); 
                maquina = args[0]; 
                puerto=12345;
                try{ 
			cliente = new Socket (maquina,puerto); 
		}catch (Exception e){ 
			System.out.println ("Fallo : "+ e.toString()); 
			System.exit (0); 
		}
		try{ 
			escritor = new PrintWriter(cliente.getOutputStream(), true);
			entrada=new BufferedReader(new InputStreamReader(cliente.getInputStream()));
 
		}catch (Exception e){ 
			System.out.println ("Fallo : "+ e.toString()); 
			cliente.close(); 
			System.exit (0); 
		} 
                String line;
                String reg= "Registro/" + IP + "/" + args[1];
		escritor.println (reg);
                line = entrada.readLine();
	        System.out.println(line);
                escritor.println ("FIN");
       Multiservers ClientServ = new Multiservers();
       ServerDes Srd= new ServerDes();
       Srd.start();
       ClientServ.start();
       Interfaz Inter = new Interfaz();
       Inter.show(true);
       }else{
           System.out.println("Argumentos [IP, Name]");
       }
    }
    
}
