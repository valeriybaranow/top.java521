package lessons.Abstraction.home;

public class SmartKettle implements HomeAppliance {
    private int temperature;

    @Override
    public void powerOn() {
        System.out.println("Kettle  switched off start hot woter");
    }

    @Override
    public void powerOff() {
        System.out.println("Тест");
        this.temperature = 0;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("The kettle is heating up " + temperature + " C");
    }
}
