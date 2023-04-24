package hw02;

public class EmptyStringException extends Exception {
    public EmptyStringException() {
        super("You shouldn't send an empty string");
    }
}
