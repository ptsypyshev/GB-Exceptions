package hw03;

public class InvalidStringException extends Exception{
    public InvalidStringException() {
        super("Name should contain only letters");
    }
}
