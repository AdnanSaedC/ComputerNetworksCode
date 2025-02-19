import java.util.Scanner;

public class paritycheck{
    public static void main(String args[]){
        System.out.print("Sender side\nPlease enter a bit: ");

        Scanner sc = new  Scanner(System.in);
        StringBuffer givenBits= new StringBuffer();
        givenBits.append(sc.nextLine());
        int noOfTimesOneAppeared=calculateNoOfOnes(givenBits);
        System.out.print("\nEven parity or odd parity(0-even and 1-odd): ");
        int parity=sc.nextInt();
        System.out.print("\nOriginal bits: "+givenBits);
        if(parity==0){
            if(noOfTimesOneAppeared%2==0){
                givenBits.append('0');
            }
            else{
                givenBits.append('1');
            }
        }
        else{
            if(noOfTimesOneAppeared%2==0){
                givenBits.append('1');
            }
            else{
                givenBits.append('0');
            }
        }
        System.out.println("\nBits send from sender side: "+givenBits);
        System.out.print("\n\nReceiver Side\n");
        System.out.println("Bits received by the receiver: "+givenBits);
        noOfTimesOneAppeared=calculateNoOfOnes(givenBits);
        if(parity==0){
            if(noOfTimesOneAppeared%2==0){
                System.out.print("\nNo error");
            }
            else{
                System.out.print("\nError");
            }
        }
        else{
            if(noOfTimesOneAppeared%2!=0){
                System.out.print("\nNo error");
            }
            else{
                System.out.print("\nError");
            }
        sc.close();
        }
        
    }

    public static int calculateNoOfOnes(StringBuffer givenString){
        int noOfTimesOneAppeared=0;
        for (int i = 0; i < givenString.length(); i++) {
                    char charOfInterest=givenString.charAt(i);
                    if(charOfInterest=='1'){
                        noOfTimesOneAppeared++;
                    }
                } 
        return noOfTimesOneAppeared;  
    }
}