import java.io.*;
public class tracert {
        public static void main(String[] args) {
        try {
            // Execute tracert with a maximum of 30 hops
            String prompt = "tracert -h 30 www.google.com";
            Process process = Runtime.getRuntime().exec(prompt);
            BufferedReader reader = new BufferedReader(new
            InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
        }
        } 
        catch (IOException e) {
            System.out.println("Error executig traceroute.");
        }
    }
}