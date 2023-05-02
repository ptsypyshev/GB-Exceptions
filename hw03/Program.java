package hw03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Program {
    static final String FIELD_SEPARATOR = "";
    static final String WELCOME_MESSAGE = "Welcome to PersonBook App!";
    static final String ADDING_MESSAGE = "Adding new person... Input data sepatated by space.";
    static final String CONTINUE_OR_EXIT_MESSAGE = "Input 'q' to exit or any another character to continue: ";
    static final String BYE_MESSAGE = "Bye!";
    static final String ADDING_HELP_MESSAGE = "'LastName FirstName MiddleName Birthday(format dd.mm.yyyy) PhoneNumber(digits only) Sex(f or m)': ";
    static final String DATE_EXCEPTION_MESSAGE = "Bad birthday, you should enter the date in format dd.mm.yyyy";
    static final String PHONE_EXCEPTION_MESSAGE = "Phone number should contain only digits";

    public static void main(String[] args) {
        System.out.println(WELCOME_MESSAGE);
        
        Scanner iScanner = new Scanner(System.in);        
        String answer = "";

        while (!answer.equals("q")) {
            System.out.println(ADDING_MESSAGE);
            Person newPerson = getPerson(iScanner);
            try {
                writeToFile(newPerson);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
                      
            System.out.print(CONTINUE_OR_EXIT_MESSAGE);
            answer = iScanner.nextLine();
        }
        System.out.println(BYE_MESSAGE);
        iScanner.close();
    }

    public static Person getPerson(Scanner iScanner) {
        String[] userInput;
        while (true) {
            System.out.print(ADDING_HELP_MESSAGE);
            userInput = iScanner.nextLine().split(" ");
            try {
                return new Person(userInput);
            } catch (InvalidPersonParameters e) {
                System.out.println(e.getMessage());
                continue;
            } catch (InvalidSexException e) {
                System.out.println(e.getMessage());
                continue;
            } catch (InvalidStringException e) {
                System.out.println(e.getMessage());
                continue;
            } catch (DateTimeParseException e) {
                System.out.println(DATE_EXCEPTION_MESSAGE);
                continue;
            } catch (NumberFormatException e) {
                System.out.println(PHONE_EXCEPTION_MESSAGE);
                continue;
            }     
        }
    }

    public static void writeToFile(Person person) throws IOException{
        Path fullFileName = Paths.get(System.getProperty("user.dir"), person.getLastName() + ".txt");

        // This try construction will automatically close bw after all operations will be finished
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fullFileName.toFile(), true))) {
            bw.write(person.toFile(FIELD_SEPARATOR));
        }
    }
}
