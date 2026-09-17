import java.io.*;
import java.net.*;

public class ServeurUDP
{
    public static void main(String[] args) throws Exception
    {
        DatagramSocket sock = new DatagramSocket(1234);
        while (true)
        {
            System.out.println("-Waiting data");
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
            sock.receive(packet);
            
            String str = new String(packet.getData(), 0, packet.getLength());
            System.out.println("str=" + str);
            
            // --- Ajout pour la Q2.3 : renvoyer la chaîne au client ---
            InetAddress clientAddr = packet.getAddress();
            int clientPort = packet.getPort();
            
            DatagramPacket responsePacket = new DatagramPacket(packet.getData(), packet.getLength(), clientAddr, clientPort);
            sock.send(responsePacket);
        }
    }
}

