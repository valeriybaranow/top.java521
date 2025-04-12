package homeworks.Incaptulation;


/*
    Задание 1. Напишите код класса с применением принципа инкапсуляции
    Задание 2. Создайте класс для хранения данных о странах (POJO)
    Задание 3. Модифицируйте класс и добавьте в него неизменяемое поле

 */
public class Main {
    public static void main(String[] args) {
        ChildBankAccount account = new ChildBankAccount(10000);
        account.depositMoney(1000);
        account.depositMoney(2000);
        account.depositMoney(10000);
        account.depositMoney(-1000);
        System.out.println("Balance: " + account.getBalance());

        account.debitMoney(500);
        account.debitMoney(422.75);
        account.debitMoney(50000);
        account.debitMoney(-50);
        System.out.println("Balance: " + account.getBalance());

        System.out.println();
        Country country = new Country("France");
        country.setAccessToSea(true);
        country.setPopulationSize(20000);
        country.setCapital("Paris");
        country.setSquare(20000);
        System.out.println(country);

        System.out.println(country.getCapital());
        System.out.println(country.getSquare());

        System.out.println();
        Product product = new Product("чайник", "asdf");
        System.out.println(product.hashCode());
        System.out.println(product.getPrice());
    }
}
