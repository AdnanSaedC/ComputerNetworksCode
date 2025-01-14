import java.io.*;
public class nslookup {
        public static void main(String args[]) {
        String doaminName = "www.google.com";
        try {
        // the below is the command which is going to execute
        ProcessBuilder processBuilder = new ProcessBuilder("nslookup", doaminName);
        Process process = processBuilder.start();

        BufferedReader reader = new BufferedReader(new
        InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
        System.out.println(line);
        }
        } catch (IOException e) {
        System.out.println("Error");
        }
    }
}