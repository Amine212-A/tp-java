import java.io.*;
import java.net.*;

public class ClientUDP
{
    public static void main(String[] args) throws Exception
    {
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("adresse=" + addr.getHostName());
        
        String s = "Hello World";
        byte[] data = s.getBytes();
        
        DatagramPacket packet = new DatagramPacket(data, data.length, addr, 1234);
        DatagramSocket sock = new DatagramSocket();
        
        sock.send(packet);
        
        // --- Ajout pour la Q2.3 : attendre et afficher la réponse du serveur ---
        DatagramPacket responsePacket = new DatagramPacket(new byte[1024], 1024);
        sock.receive(responsePacket);
        
        String str = new String(responsePacket.getData(), 0, responsePacket.getLength());
        System.out.println("Message reçu du serveur : " + str);
        
        sock.close();
    }
}

