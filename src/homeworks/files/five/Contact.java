package homeworks.files.five;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Contact {
    private final String firstName;
    private final String lastName;
    private final String nickname;
    private final int yearOfBirth;
    private List<String> emails;
    private Map<PhoneNumber.PhoneType, PhoneNumber> phones = new EnumMap<>(PhoneNumber.PhoneType.class);
    ;

    public Contact(String firstName, String lastName, String nickname, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.yearOfBirth = yearOfBirth;
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

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public List<String> getEmails() {
        return emails;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", emails=" + emails +
                ", phoneNumbers=" + phones +
                '}';
    }

    public void addPhone(PhoneNumber phone) {
        phones.put(phone.getType(), phone);
    }

    public PhoneNumber getPhoneNumber(PhoneNumber.PhoneType phoneType) {
        return phones.get(phoneType);
    }

    public List<PhoneNumber> getAllPhoneNumbers() {
        return new ArrayList<>(phones.values());
    }
}
