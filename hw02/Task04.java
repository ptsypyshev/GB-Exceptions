package hw02;

import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Enter something: ");

        try {
            String userInput = getString(iScanner);
            System.out.printf("User input is %s\n", userInput);    
        } catch (EmptyStringException e) {
            System.out.println(e);
        }
        
        iScanner.close();
    }

    public static String getString(Scanner iScanner) throws EmptyStringException{
        String userInput = iScanner.nextLine();
        if (userInput.isEmpty()) throw new EmptyStringException();
        return userInput;
    }
}
