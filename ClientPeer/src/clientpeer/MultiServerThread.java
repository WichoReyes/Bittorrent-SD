/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientpeer;

import java.net.*;
import java.io.*;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MultiServerThread extends Thread {

    private Socket socket = null;
    Socket cliente = null;
    PrintWriter escritor = null;
    String DatosEnviados = null;
    BufferedReader entrada = null;

    public MultiServerThread(Socket socket) {
        super("MultiServerThread");
        this.socket = socket;
        Multiservers.NoClients++;
    }

    public void EnviarArchivo(String Destino, String Archivo) throws IOException {
        DataInputStream input;
        BufferedInputStream bis;
        BufferedOutputStream bos;
        int in;
        byte[] byteArray;
        //Fichero a transferir
        final String filename = "C:/Users/luigi/OneDrive/Desktop/ProyectoSD" + Archivo;

        try {
            final File localFile = new File(filename);
            Socket client = new Socket(Destino, 5000);
            bis = new BufferedInputStream(new FileInputStream(localFile));
            bos = new BufferedOutputStream(client.getOutputStream());
            //Enviamos el nombre del fichero
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
// dos.size();
            int Tam = (int) localFile.length();
            System.out.println(Tam);
            String TamA = Integer.toString(Tam);
            FileInputStream Fichero = new FileInputStream(localFile);
            Byte contenido = new Byte((byte) (int) localFile.length());

            dos.writeUTF(localFile.getName());
            dos.writeUTF(TamA);
            //Enviamos el fichero
            byteArray = new byte[8192];
            int y = 0;
            while ((in = bis.read(byteArray)) != -1) {
                y++;
                System.out.println(y);
                bos.write(byteArray, 0, in);
                Thread.sleep(500);
            }
            bis.close();
            bos.close();

        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public String conexion(String maquina, int puerto, String peticion) throws IOException {

        try {
            cliente = new Socket(maquina, puerto);
        } catch (Exception e) {
            System.out.println("Fallo : " + e.toString());
            System.exit(0);
        }
        try {
            escritor = new PrintWriter(cliente.getOutputStream(), true);
            entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

        } catch (Exception e) {
            System.out.println("Fallo : " + e.toString());
            cliente.close();
            System.exit(0);
        }
        String line;
        DatosEnviados = peticion;
        escritor.println(DatosEnviados);
        line = entrada.readLine();
        try {
            escritor.close();
        } catch (Exception e) {
        }
        System.out.println("Respuesta obtenida");
        return line;
    }

    public void run() {

        try {
            PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String lineIn, lineOut;

            while ((lineIn = entrada.readLine()) != null) {
                System.out.println("Received: " + lineIn);
                escritor.flush();
                if (lineIn.equals("FIN")) {
                    Multiservers.NoClients--;
                    break;
                } else if (lineIn.equals("#")) {
                    escritor.println(Multiservers.NoClients);
                    escritor.flush();

                } else if (lineIn.equals("Actualizar")) {
                    String UpdateA = "";
                    String UpdateP = "";
                    String Update;
                    if (!ClientPeer.Archivos.isEmpty()) {
                        for (Map.Entry<String, Integer> entry : ClientPeer.Archivos.entrySet()) {
                            UpdateA = UpdateA + entry.getKey() + "/";
                            UpdateP = UpdateP + entry.getValue() + "/";
                        }
                        Update = UpdateA + UpdateP;
                        Update = Update.substring(0, Update.length() - 1);
                        System.out.println(Update);
                        escritor.println(Update);
                        escritor.flush();
                    } else {
                        escritor.println("Vacio");
                        escritor.flush();
                    }
                } else if (lineIn.startsWith("Descarga")) {

                    String[] parts = lineIn.split(" ");
                    String Destino = parts[1];
                    String Archivo = parts[2];
                    System.out.println("Ontencion de datos");
                    System.out.println("Iniciando peticion");
                    this.EnviarArchivo(Destino, Archivo);
                    System.out.println("Acabando de enviar");
                    
                    // O AQUI QUE SE ACTUALICE EN LA BD
                    // EnviarArchivo(Destino, Archivo);
                    //escritor.println("Descarga Terminada");
                    //escritor.flush();
                    if(clientpeer.DecriptAES.descifrar("C:/Users/luigi/OneDrive/Desktop/ProyectoFinal_SD-main/ClientPeer+" + Archivo, "C:/Users/luigi/Downloads" + Archivo, "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "1", "2", "3", "4", "5", "6")){
                        System.out.println("Desencriptado correctamente");
                        System.out.println("Desencriptado correctamente");
                    }
                } else {
                    escritor.println(lineIn);
                    escritor.flush();
                }
            }
            try {
                entrada.close();
                escritor.close();
                socket.close();
            } catch (Exception e) {
                System.out.println("Error : " + e.toString());
                socket.close();
                System.exit(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Throwable ex) {
            Logger.getLogger(MultiServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
