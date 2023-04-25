package hw02;

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        Float userFloat = getFloat(iScanner);
        System.out.printf("User float value is %f\n", userFloat);
        iScanner.close();
    }

    public static Float getFloat(Scanner iScanner) {        
        while (true) {
            System.out.print("Enter float value: ");
            String inputString = iScanner.next();
            try {
                return Float.parseFloat(inputString);
            } catch (NumberFormatException e) {
                System.out.println("You should enter digits only! Try again.");
            }
        }
    }
}
