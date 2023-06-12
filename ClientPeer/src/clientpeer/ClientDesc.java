/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientpeer;
import java.net.*; 
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author gerar
 */
public class ClientDesc {
       

    public String Preguntar(String datos, String IP) throws IOException, InterruptedException{
            
		Socket cliente = null; 
		PrintWriter escritor = null; 
		String DatosEnviados = null; 
		BufferedReader entrada=null;
		
		String maquina; 
		int puerto; 
		BufferedReader DatosTeclado = new BufferedReader ( new InputStreamReader (System.in)); 

		        
			maquina = IP; 
			puerto = 8080; 
			System.out.println ("Conectando a Peer: " + IP); 
		
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
		
		System.out.println("Conectado con el Servidor. Listo para enviar datos...");
                String reg= datos;
		escritor.println (reg);
                line = entrada.readLine();
	        System.out.println("Respuesta del Peer: " +line);
                System.out.println("Descarga terminada");
               
                escritor.println ("FIN");
	
		System.out.println ("Finalizada conexion con el servidor"); 
		try{ 
			escritor.close(); 
		}catch (Exception e){}
                return line;
}
}
