import java.net.*;
import java.util.Enumeration;
public class localHost {
    public static void main(String args[]) {
        try {
        // Get the network interfaces on the machine
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterface = networkInterfaces.nextElement();
            System.out.println("Network Interface: " + networkInterfaces.nextElement().getName());
        }
        } 
        catch (SocketException e) {
            System.out.println("Error");
        }
    }
}