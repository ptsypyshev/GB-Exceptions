package hw01;

public class DifferentLengthException extends Exception {
    public DifferentLengthException() {
        super("Arrays lengths are different");
    }
}
