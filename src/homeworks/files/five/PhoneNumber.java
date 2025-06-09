package homeworks.files.five;

import java.util.Objects;

public class PhoneNumber {
    private final String number;
    private final PhoneType type;

    public PhoneNumber(String number, PhoneType type) {
        this.number = validate(number);
        this.type = type;
    }

    private String validate(String number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("Номер телефона не может быть пустым");
        }

        String cleanedNumber = number.replaceAll("[^0-9]", "");

        if (cleanedNumber.length() > 6) {
            throw new IllegalArgumentException("Номер телефона должен быть не менее 6-ти символов");
        }

        return cleanedNumber;
    }

    public String getNumber() {
        return number;
    }

    public PhoneType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return type.name() + ": " + getNumber();
    }

    public enum PhoneType {
        MOBILE, HOME, WORK, FAX
    }
}
