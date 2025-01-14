import java.io.*;
    public class activeTCPConnection {
        public static void main(String[] args) {
        try {
            String command = "netstat -an | fidstr ESTABLISHED"; 
            Process process = Runtime.getRuntime().exec(command);
            // Capture standard output
            BufferedReader reader = new BufferedReader(new
            InputStreamReader(process.getInputStream()));
            String line;
            System.out.println("Actie TCP Connectins ('ESTABLISHED'):");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            // Capture error output
            BufferedReader errorReader = new BufferedReader(new
            InputStreamReader(process.getErrorStream()));
            System.out.println("Error: ");
            while ((line = errorReader.readLine()) != null) {
                System.out.println(line);
        }
        } 
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}