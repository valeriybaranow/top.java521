package homeworks.files.taskfive;

import java.io.Serializable;
import java.util.Objects;

public record PhoneNumber(String number, homeworks.files.taskfive.PhoneNumber.PhoneType type) implements Serializable {
    public PhoneNumber(String number, PhoneType type) {
        this.number = validate(number);
        this.type = type;
    }

    private String validate(String number) throws IllegalPhoneException {
        if (number == null || number.isEmpty()) {
            throw new IllegalPhoneException("Номер телефона не может быть пустым");
        }

        String cleanedNumber = number.replaceAll("[^0-9]", "");

        if (cleanedNumber.length() < 6) {
            throw new IllegalPhoneException("Номер телефона должен быть не менее 6-ти символов");
        }

        return cleanedNumber;
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
        return type.name() + ": " + number();
    }

    public enum PhoneType {
        MOBILE, HOME, WORK, FAX
    }
}
