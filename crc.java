
import java.util.Arrays;
import java.util.Scanner;

public class crc{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the equation: ");
        String equation=sc.nextLine();
        System.out.print("Enter the bits to be send: ");
        String bitsToBeSend=sc.nextLine();
        

        int exponents[]=new int[equation.length()];
        int numOfDigit=0;
        for(int i=0;i<equation.length();i++){
            int multiple=0;
            int value=0;
            if(equation.charAt(i)=='^'){
                int j=i+1;
                while(j!=equation.length() && equation.charAt(j)!='+'  ){
                    j++;
                    multiple++;
                    numOfDigit++;
                }
                    int k=i+1;
                while(j-1!=i){
                    j--;
                    multiple--;
                    value+=Character.getNumericValue(equation.charAt(k))*(Math.pow(10,multiple));
                    k++;
                }
                exponents[numOfDigit]=value;

                
            }
            else if(equation.charAt(i)=='+' && Character.isDigit(equation.charAt(i+1))){
                numOfDigit++;
                exponents[numOfDigit]=0;
            }
        }
        Arrays.sort(exponents);
        int position=equation.length()-1;
        int maxValue=(exponents[position]);
        String divider="1";
        System.out.println("No of Digits: "+numOfDigit);
        

        for(int i=maxValue-1;i>=0;i--){
            if(i==exponents[position-1]){
                position--;
                divider+="1";
            }
            else{
                divider+="0";
            }
        }
        String value="";
        for(int i=0;i<maxValue;i++){
            value+="0";
        }

        String modifiedGivenBits=Suffix(bitsToBeSend,value);
        String valueToBeAddedInReceiverSide=findRemainder(modifiedGivenBits,divider);
        System.out.println("Remainder to be added: "+valueToBeAddedInReceiverSide);

        // System.out.println("\nActual String: "+bitsToBeSend);
        System.out.println("String being send: "+valueToBeAddedInReceiverSide);

        System.out.println("Receiver Side");
        String receiverString=Suffix("110010", valueToBeAddedInReceiverSide);
        System.out.println("Receiver String: " + receiverString);
        System.out.println("Verification: "+findRemainder(receiverString, divider));
    }
    public static String Suffix(String bitsToBeSend,String value){
        return bitsToBeSend+value;
    }
    public static String findRemainder(String dividend, String divisor) {
        // Convert strings to character arrays for easier manipulation
        char[] dividendArr = dividend.toCharArray();
        char[] divisorArr = divisor.toCharArray();
        
        // Create result array with size equal to divisor length - 1 (this will be our remainder)
        int resultSize = divisorArr.length - 1;
        char[] result = new char[dividendArr.length];
        
        // Copy dividend to result array
        System.arraycopy(dividendArr, 0, result, 0, dividendArr.length);
        
        // Perform division
        for (int i = 0; i <= dividendArr.length - divisorArr.length; i++) {
            // If current bit is 1, perform XOR with divisor
            if (result[i] == '1') {
                for (int j = 0; j < divisorArr.length; j++) {
                    // XOR operation
                    result[i + j] = (result[i + j] == divisorArr[j]) ? '0' : '1';
                }
            }
        }

        
        // Extract remainder (last divisor.length-1 bits)
        String remainder = new String(result).substring(result.length - resultSize);
        return remainder;
    }
}