package lessons.Abstraction.home;

public class RobotVacuum implements HomeAppliance {

    private boolean isCleaning;


    @Override
    public void powerOn() {
        System.out.println("RobotVacuum is started is cleaning started");
    }

    public void returnToBase() {
        System.out.println("Return to base for charging");
    }
}

