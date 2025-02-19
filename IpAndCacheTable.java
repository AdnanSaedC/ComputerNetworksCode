import java.io.*;
import java.net.*;
public class IpAndCacheTable {
        public static void main(String[] args) {
        try {              

            InetAddress host = InetAddress.getLocalHost();
            System.out.println("Host IP Address: " + host.getHostAddress());

        if (System.getProperty("os.name").toLowerCase().contains("win")) {

            Process process = Runtime.getRuntime().exec("nslookup www.google.com");
            BufferedReader reader = new BufferedReader(new
            InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } 
        else {
            
            Process process = Runtime.getRuntime().exec("nslookup www.google.com");
            BufferedReader reader = new BufferedReader(new
            InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            }
        } 
        catch (IOException e) {
            System.out.println("Error retrieving IP addresses or ARP cache.");
        }
    }
}