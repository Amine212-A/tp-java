import java.io.*;
import java.net.*;

public class Clienthttp
{
    public static void main(String[] args)
    {
        try
        {
            // Connexion au serveur sur le port 80 en utilisant args[0] comme nom d'hôte
            Socket socket = new Socket(args[0], 80);
            
            // Flux pour envoyer la requête HTTP
            BufferedWriter bOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            // Flux pour lire la réponse
            BufferedReader bIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            // Envoi de la requête HTTP GET
            bOut.write("GET / HTTP/1.1\r\n");
            bOut.write("Host: " + args[0] + "\r\n");
            bOut.write("Connection: close\r\n");
            bOut.write("\r\n"); // Ligne vide obligatoire
            bOut.flush();
            
            // Lecture et affichage de la page HTML reçue
            String line;
            while ((line = bIn.readLine()) != null)
            {
                System.out.println(line);
            }
            
            socket.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}