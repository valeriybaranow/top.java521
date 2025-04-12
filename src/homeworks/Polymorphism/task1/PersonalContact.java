package homeworks.Polymorphism.task1;

public class PersonalContact extends Contact {
    private String address;

    public PersonalContact(String name, String phoneNumber, String email, String addressl) {
        super(name, phoneNumber, email);
        this.address = addressl;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.print( ", адрес='" + getAddress() + '\'');
        System.out.println();
    }
}
