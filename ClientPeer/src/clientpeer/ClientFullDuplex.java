package clientpeer;

import java.net.*; 
import java.io.*; 
public class ClientFullDuplex { 
	
public String Preguntar(String datos) throws IOException{
            
		Socket cliente = null; 
		PrintWriter escritor = null; 
		String DatosEnviados = null; 
		BufferedReader entrada=null;
		
		String maquina; 
		int puerto; 
		BufferedReader DatosTeclado = new BufferedReader ( new InputStreamReader (System.in)); 

		
			maquina = ClientPeer.IP2; 
			puerto = 12345; 
			System.out.println ("Conectando al Tracker:\nEQUIPO = " + ClientPeer.IP2 + "\nPORT = 12345"); 
		
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
	        System.out.println("Respuesta del Tracker: " + line);
                escritor.println ("FIN");
	
		System.out.println ("Finalizada conexion con el servidor"); 
		try{ 
			escritor.close(); 
		}catch (Exception e){}
                return line;
}
} 

