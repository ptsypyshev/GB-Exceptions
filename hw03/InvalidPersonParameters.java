package hw03;

public class InvalidPersonParameters extends Exception{
    public InvalidPersonParameters() {
        super("You should specify 6 parameters to create Person object.");
    }
}
