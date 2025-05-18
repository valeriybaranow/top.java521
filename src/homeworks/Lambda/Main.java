package homeworks.Lambda;

public class Main {

    public static void main(String[] args) {
        Robot robot = new Robot(0, 0, Direction.UP);
        Robot.move(-3,-5, robot);

        System.out.println(robot);
    }
}
