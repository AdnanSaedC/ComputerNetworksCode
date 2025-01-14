import java.net.*;
public class loopback {
        public static void main(String args[]) {
        try {
            InetAddress loopback = InetAddress.getByName("127.0.0.1");
            System.out.println("Loopback address: " + loopback.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Error resolving loopback address.");
        }
    }
}