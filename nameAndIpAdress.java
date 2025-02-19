import java.net.*;
public class nameAndIpAdress {
    public static void main(String[] args) {
    try {
        //in order to get the host name
        String hostName = InetAddress.getLocalHost().getHostName();
        
        //in order to get the IP address
        String ipAddress = InetAddress.getLocalHost().getHostAddress();
        System.out.println("Device Name: " + hostName);
        System.out.println("IP Address: " + ipAddress);
    } catch (Exception e) {
    System.out.println("Unable to retrieve host informatin.");
    }
    }
}