package homeworks.Polymorphism.task1;

public class BusinessContact extends Contact {
    private String companyName;

    public BusinessContact(String name, String phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.print( ", компания='" + getCompanyName() + '\'');
        System.out.println();
    }
}
