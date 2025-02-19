import java.net.*;
    public class printIPAddress {
        public static void main(String[] args) {
        singleIPAddress("www.vit.ac.in");
        singleIPAddress("www.google.com");
        AllIPAddress("www.microsoft.com");
        }


    public static void singleIPAddress(String domainName) {
    try {
        InetAddress inetAddress = InetAddress.getByName(domainName);
        System.out.println("IP address of " + domainName + ": " + inetAddress.getHostAddress());
    } catch (Exception e) {
        System.out.println("Error" + domainName);
    }
    }


    public static void AllIPAddress(String domainName) {
    try {
        InetAddress[] inetAddresses = InetAddress.getAllByName(domainName);
        
            System.out.print("All IP addresses of " + domainName + ": ");
        for (InetAddress inetAddress : inetAddresses) {
            System.out.print(inetAddress.getHostAddress() + " ");
        }
        System.out.println();
        } 
        catch (UnknownHostException e) {
            System.out.println("Error: " + domainName);
        }
    }
}