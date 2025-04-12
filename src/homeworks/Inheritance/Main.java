package homeworks.Inheritance;

public class Main {

    public static void main(String[] args) {

//        BankAccount cardAccount = new CardAccount();
//        cardAccount.put(100);
//        System.out.println(cardAccount.getAmount());
//        cardAccount.take(10);
//        System.out.println(cardAccount.getAmount());

        DepositAccount bankAccount = new DepositAccount();
        bankAccount.put(10);
        System.out.println(bankAccount.getAmount());
        bankAccount.take(1);
        System.out.println(bankAccount.getAmount());
    }
}
