package homeworks.files.taskfive;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Contact implements Serializable {
    private final String firstName;
    private final String lastName;
    private final String nickname;
    private final String email;
    private final Map<PhoneNumber.PhoneType, PhoneNumber> phones = new EnumMap<>(PhoneNumber.PhoneType.class);
    ;

    public Contact(String firstName, String lastName, String nickname, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        try {
            this.email = validateEmail(email);
        } catch (IllegalEmailException e) {
            throw new IllegalEmailException(e.getMessage());
        }
    }

    private String validateEmail(String email) throws IllegalArgumentException {
        if (email == null || email.isEmpty()) {
            throw new IllegalEmailException("Email не может быть пустым");
        }

        String cleanedEmail = email.trim();

        String regex = "^[a-zA-Z0-9].[a-zA-Z0-9\\._%\\+\\-]{0,63}@[a-zA-Z0-9\\.\\-]+\\.[a-zA-Z]{2,30}$";
        if (!Pattern.matches(regex, cleanedEmail)) {
            throw new IllegalEmailException("Некорректный email");
        }

        return cleanedEmail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmails() {
        return email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email=" + email +
                ", phoneNumbers=" + phones +
                '}';
    }

    public void addPhone(String phone, PhoneNumber.PhoneType phoneType) {
        PhoneNumber number = new PhoneNumber(phone, phoneType);
        phones.put(number.type(), number);
    }

    public PhoneNumber getPhoneNumber(PhoneNumber.PhoneType phoneType) {
        return phones.get(phoneType);
    }

    public List<PhoneNumber> getAllPhoneNumbers() {
        return new ArrayList<>(phones.values());
    }
}
