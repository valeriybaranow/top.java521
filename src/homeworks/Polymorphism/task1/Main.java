package homeworks.Polymorphism.task1;

/*
    Задача 1: Управление телефонной книгой
    Создайте систему для управления контактами в телефонной книге, используя наследование и полиморфизм.
        1. Создайте базовый класс Contact, который будет представлять общие характеристики для всех контактов в телефонной книге, такие как name, phoneNumber, email. Этот класс должен иметь метод displayInfo(), который выводит информацию о контакте.
        2. Унаследуйте от Contact несколько подклассов, например, PersonalContact и BusinessContact. Каждый из этих классов должен представлять контакт определенного типа - личный или деловой, содержащий уникальные характеристики, такие как address для PersonalContact и companyName для BusinessContact.
        3. Переопределите метод displayInfo() в каждом подклассе, чтобы он выводил информацию о контакте соответствующего типа.
        4. Создайте объекты PersonalContact и BusinessContact и продемонстрируйте полиморфизм, вызывая метод displayInfo() для каждого контакта.
 */
public class Main {

    public static void main(String[] args) {
        Contact[] contacts = {
            new PersonalContact("Федор Конюхов", "+7911918234754", "sdfsdf@sdfs.sdf", "Садовническая ул., 77, стр. 4, Москва"),
            new BusinessContact("Джеймс Кук", "+7911912448475", "dgeymskuk@gmail.com", "Пемброк"),
        };
        
        for (int i = 0; i < contacts.length; i++) {
            contacts[i].displayInfo();
        }
    }
}
