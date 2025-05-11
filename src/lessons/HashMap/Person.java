package lessons.HashMap;

import java.util.Objects;

public class Person {
    String name;
    String surname;
    String passport;
    String email;

    public Person(String name, String surname, String password, String email) {
        this.name = name;
        this.surname = surname;
        this.passport = password;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return Objects.equals(passport, person.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(passport);
    }
}
