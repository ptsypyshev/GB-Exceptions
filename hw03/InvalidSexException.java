package hw03;

public class InvalidSexException extends Exception{
    public InvalidSexException() {
        super("Sex should be 'f' or 'm' only!");
    }
}
