package lessons.Abstraction.home;

public interface HomeAppliance {
    // у интерфейса есть только константы
    String DEFAULT_MANUFACTURE = "SmartHome Inc=."; // public static final по умолчанию

    // все методы public писать не нужно abstract писать не нужно
    void powerOn();

    default void powerOff() {
        System.out.println("the device is switched off in the standard way");
    }

    static void checkVoltage() {
        System.out.println("checkVoltagey");
    }

    default void displayManufacturer() {
        System.out.println("the device is switched off in the standard way");
    }
}
