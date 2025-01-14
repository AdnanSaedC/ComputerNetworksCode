import java.io.*;
import java.net.*;
public class contentAssociatedWithHttpUrl {
        public static void main(String args[]) {
        String urlString = "https://www.example.com";
        String fiename = "downloaded_fie.html";
        try (
                BufferedInputStream in = new BufferedInputStream(
                    new URL(urlString).openStream());
        FileOutputStream fieOutputStream = new FileOutputStream(fiename)) {
            byte dataBuffr[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffr, 0, 1024)) != -1) {
                fieOutputStream.write(dataBuffr, 0, bytesRead);
        }
        System.out.println("File downloaded successfully: " + fiename);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}