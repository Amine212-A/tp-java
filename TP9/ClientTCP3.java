import java.io.*;
import java.net.*;

public class ClientTCP3
{
    public static void main(String[] args)
    {
        try
        {
            Socket socket = new Socket("localhost", 2016);
            
            // Envoi du message passé en paramètre
            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
            dOut.writeUTF(args[0]);
            
            // Réception de la réponse inversée du serveur
            DataInputStream dIn = new DataInputStream(socket.getInputStream());
            String response = dIn.readUTF();
            System.out.println("Réponse du serveur : " + response);
            
            socket.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}