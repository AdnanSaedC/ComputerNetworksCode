import java.io.*;
import java.net.*;

public class socket {
    public static void main(String s[]) {
        String hostname = "localhost";
        if (s.length > 0)
            hostname = s[0];

        for (int i = 1; i < 1024; i++) {
            Socket socket = null;
            try {
                socket = new Socket(hostname, i);
                System.out.println("There is a server running on port " + i + " of " + hostname);
            } catch (UnknownHostException e) {
                System.out.println("Unknown host: " + hostname);
                break;
            } catch (IOException e) {
                // Ignore, as an exception means the port is closed
            }
        }
    }
}