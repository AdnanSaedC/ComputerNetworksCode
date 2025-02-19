import java.util.Arrays;
import java.util.Scanner;

public class HamingCode {
    public static void main(String[] args) {
        System.out.println("Sender Side");
        System.out.print("Please enter the given bits: ");
        Scanner sc = new Scanner(System.in);
        StringBuffer givenBits = new StringBuffer(sc.nextLine());
        System.out.print("\nGiven bits: " + givenBits);

        int noOfBitsToBeAdded = bitsFinder(givenBits);
        System.out.println("\nNo of bits to be added: " + noOfBitsToBeAdded);
        int length = noOfBitsToBeAdded + givenBits.length();
        System.out.println("Combined Length: " + length);

        int bitsCount = 0;
        int matrix[][] = matrixFinder(length, noOfBitsToBeAdded);
        int count = 0;

        char modifiedString[] = redundantString(givenBits, length, count, bitsCount);
        count = 0;
        System.out.print("\noriginal String: " + givenBits);
        System.out.print("\nmodified String: ");
        for (int i = 0; i < length; i++) {
            System.out.print(modifiedString[i]);
        }
        System.out.println("");

        for (int i = 0; i < noOfBitsToBeAdded; i++) {
            int noOfOnes = 0;
            int position = noOfBitsToBeAdded - i - 1;
            for (int k = 1; k <= length; k++) {
                if (matrix[k][position] == '1' && modifiedString[length - k] == '1') {
                    noOfOnes++;
                }
            }
            for (int j = 1; j <= length; j++) {
                if (j == Math.pow(2, count) && modifiedString[length - j] == 'R') {
                    if (noOfOnes % 2 == 0) {
                        modifiedString[length - j] = '0';
                    } else if (noOfOnes % 2 != 0) {
                        modifiedString[length - j] = '1';
                    }
                }
            }
            count++;
        }

        System.out.print("\nString From the sender side: ");
        for (int i = 0; i < length; i++) {
            System.out.print(modifiedString[i]);
        }

        System.out.print("\nReceiver Side: ");
        char[] bitsReceived = Arrays.copyOf(modifiedString, modifiedString.length);
        System.out.println(bitsReceived);

        int noOfRedundantBits = redundantBitsFinder(bitsReceived);
        System.out.println("\n\nRedundant bits: " + (int) noOfRedundantBits);

        System.out.print("Do you want error\n1-yes,0-No: ");
        int error = sc.nextInt();
        int noOfOnes = 0;
        boolean errorOccured = false;
        if (error == 0) {
            for (int i = 0; i < noOfRedundantBits; i++) {
                noOfOnes=0;
                for (int j = 1; j <= length; j++) {
                    if (matrix[j][noOfRedundantBits - i - 1] == '1') {
                        if (bitsReceived[length-j] == '1') {
                            noOfOnes++;
                        }
                    }
                }
                if (noOfOnes % 2 != 0) {
                    System.out.println("Error at " + (i + 1) + " Redundant bit position");
                    errorOccured = true;
                }
            }
            if (!errorOccured) {
                System.out.println("No error");
            }
        } else {
            System.out.println("Total length: " + length);
            System.out.print("\nBit position where you want error: ");
            int bitposition = length - (sc.nextInt());
            if (bitsReceived[bitposition] == '0') {
                bitsReceived[bitposition] = '1';
            } else {
                bitsReceived[bitposition] = '0';
            }

            System.out.print("new String: ");
            System.out.println(bitsReceived);

            String errorBitPosition = new String();
            for (int i = 0; i < noOfRedundantBits; i++) {
                noOfOnes = 0;
                for (int j = 1; j <= length; j++) {
                    if (matrix[j][noOfRedundantBits - i - 1] == '1') {
                        if (bitsReceived[length - j] == '1') {
                            noOfOnes++;
                        }
                    }
                }
                errorBitPosition = (noOfOnes % 2) + errorBitPosition;
            }
            System.out.println("Binary version: "+errorBitPosition);
            System.out.print("Error in bit position: " + (Integer.parseInt(Integer.valueOf(errorBitPosition).toString(), 2)));
        }
    }

    public static int redundantBitsFinder(char bitsgiven[]) {
        int length = bitsgiven.length;
        int noOfRedundantBits = 0;
        loop:
        for (int i = 0; i < length; i++) {
            if (Math.pow(2, i) >= (length + 1)) {
                noOfRedundantBits = i;
                break loop;
            }
        }
        return noOfRedundantBits;
    }

    public static int bitsFinder(StringBuffer givenBits) {
        int noOfBitsToBeAdded = 0;
        loop:
        for (int i = 0; i < givenBits.length(); i++) {
            if (Math.pow(2, i) >= (givenBits.length() + i + 1)) {
                noOfBitsToBeAdded = i;
                break loop;
            }
        }
        return noOfBitsToBeAdded;
    }

    public static int[][] matrixFinder(int length, int noOfBitsToBeAdded) {
        int matrix[][] = new int[length + 1][noOfBitsToBeAdded];
        for (int i = 1; i <= length; i++) {
            String binary = Integer.toBinaryString(i);
            while (binary.length() < noOfBitsToBeAdded) {
                binary = '0' + binary;
            }
            for (int k = 0; k < noOfBitsToBeAdded; k++) {
                matrix[i][k] = binary.charAt(k);
            }
        }
        return matrix;
    }

    public static char[] redundantString(StringBuffer givenBits, int length, int count, int bitsCount) {
        char modifiedString[] = new char[length];

        for (int i = 1; i <= length; i++) {
            if (i == Math.pow(2, count)) {
                modifiedString[length - i] = 'R';
                count++;
            } else {
                modifiedString[length - i] = givenBits.charAt(givenBits.length() - bitsCount - 1);
                bitsCount++;
            }
        }
        return modifiedString;
    }
}