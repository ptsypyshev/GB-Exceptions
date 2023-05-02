package hw03;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthday;
    private Integer phoneNumber;
    private Boolean sex;

    public Person(String... params) throws InvalidStringException, DateTimeParseException, NumberFormatException,
            InvalidSexException, InvalidPersonParameters {
        if (params.length != 6) {
            throw new InvalidPersonParameters();
        }
        this.setLastName(params[0]);
        this.setFirstName(params[1]);
        this.setMiddleName(params[2]);
        this.setBirthday(params[3]);
        this.setPhoneNumber(params[4]);
        this.setSex(params[5]);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) throws InvalidStringException {
        this.firstName = Person.checkString(firstName);
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) throws InvalidStringException {
        this.lastName = Person.checkString(lastName);
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) throws InvalidStringException {
        this.middleName = Person.checkString(middleName);
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) throws DateTimeParseException {
        this.birthday = checkDate(birthday);
    }

    public Integer getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws NumberFormatException {
        this.phoneNumber = checkInteger(phoneNumber);
    }

    public Boolean getSex() {
        return this.sex;
    }

    public void setSex(String sex) throws InvalidSexException {
        this.sex = checkSex(sex);
    }

    @Override
    public String toString() {
        return String.format(
                "Person\nLastName: %s\nFirstName: %s\nMiddleName: %s\nBirthdate: %s\nPhoneNumber: %d\nSex: %s\n",
                this.lastName, this.firstName, this.middleName,
                this.birthday.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), this.phoneNumber,
                this.sex ? "m" : "f");
    }

    public String toFile(String sep) {
        return String.format("%s%s%s%s%s%s%s%s%d%s%s\n",
                this.lastName, sep,
                this.firstName, sep,
                this.middleName, sep,
                this.birthday.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), sep,
                this.phoneNumber, sep,
                this.sex ? "m" : "f");
    }

    private static String checkString(String s) throws InvalidStringException {
        if (s.chars().allMatch(Character::isLetter))
            return s;
        throw new InvalidStringException();
    }

    private static LocalDate checkDate(String d) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(d, formatter);
    }

    private static Integer checkInteger(String i) throws NumberFormatException {
        return Integer.parseInt(i);
    }

    private static Boolean checkSex(String s) throws InvalidSexException {
        switch (s) {
            case "f":
                return false;
            case "m":
                return true;
            default:
                throw new InvalidSexException();
        }
    }
}
