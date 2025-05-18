package homeworks.Lambda;

/*
    Задание 1. Реализовать класс Robot

    Задание 2*.
    Дополнительный метод к Роботу. Статический.
    Принимает на вход 3 аргумента int toX, int toY, Robot robot

    Пример:
    В метод передано: toX == 3, toY == 0; начальное состояние робота такое: robot.getX() == 0, robot.getY() == 0, robot.getDirection() == Direction.UP

    Чтобы привести робота в указанную точку (3, 0), метод должен вызвать у робота следующие методы:
    robot.turnRight();
    robot.stepForward();
    robot.stepForward();
    robot.stepForward();
 */
public class Robot {
    int x;
    int y;
    Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    // текущее направление взгляда
    public Direction getDirection() {
        return direction;
    }

    // текущая координата X
    public int getX() {
        return x;
    }

    // текущая координата Y
    public int getY() {
        return y;
    }

    // повернуться на 90 градусов против часовой стрелке
    public void turnLeft() {
       direction =  switch (direction) {
           case UP -> Direction.LEFT;
           case RIGHT -> Direction.UP;
           case DOWN -> Direction.RIGHT;
           case LEFT -> Direction.DOWN;
       };
    }

    // повернуться на 90 градусов по часовой стрелке
    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
        direction =  switch (direction) {
            case UP -> Direction.RIGHT;
            case RIGHT -> Direction.DOWN;
            case DOWN -> Direction.LEFT;
            case LEFT -> Direction.UP;
        };
    }

    // шаг в направлении взгляда
    // за один шаг робот изменяет одну свою координату на единицу
    public void stepForward() {
        x = switch (direction) {
            case RIGHT -> x + 1;
            case LEFT -> x - 1;
            case UP, DOWN -> x;
        };
        y = switch (direction) {
            case UP -> y + 1;
            case DOWN -> y - 1;
            case RIGHT, LEFT -> y;
        };
    }

    private static void turn(Direction direction, Robot robot) {
        while (robot.direction != direction) {
            if (getTurnOptions(direction, robot) == TurnOptions.RIGHT) {
                robot.turnRight();
            } else if (getTurnOptions(direction, robot) == TurnOptions.LEFT) {
                robot.turnLeft();
            }
        }
    }

    private static TurnOptions getTurnOptions(Direction direction, Robot robot) {
        return switch (direction) {
            case UP -> switch (robot.direction) {
                case UP -> TurnOptions.NONE;
                case LEFT -> TurnOptions.RIGHT;
                case RIGHT, DOWN -> TurnOptions.LEFT;
            };
            case RIGHT -> switch (robot.direction) {
                case RIGHT -> TurnOptions.NONE;
                case UP -> TurnOptions.RIGHT;
                case DOWN, LEFT -> TurnOptions.LEFT;
            };
            case DOWN -> switch (robot.direction) {
                case DOWN -> TurnOptions.NONE;
                case UP, RIGHT -> TurnOptions.RIGHT;
                case LEFT -> TurnOptions.LEFT;
            };
            case LEFT -> switch (robot.direction) {
                case LEFT -> TurnOptions.NONE;
                case UP -> TurnOptions.LEFT;
                case RIGHT, DOWN -> TurnOptions.RIGHT;
            };
        };
    }

    public static void move(int toX, int toY, Robot robot) {
        int diffX = toX - robot.getX();
        int diffY = toY - robot.getY();
        System.out.println(diffX + " " + diffY);

        if(diffX < 0) {
            turn(Direction.DOWN, robot);
            System.out.println(robot);
        } else if(diffX > 0) {
            turn(Direction.UP, robot);
            System.out.println(robot);
        }
        for(int i = 0; i < Math.abs(diffX); i++) {
            robot.stepForward();
            System.out.println(robot);
        }
        if(diffY < 0) {
            turn(Direction.LEFT, robot);
            System.out.println(robot);
        } else if(diffY > 0) {
            turn(Direction.RIGHT, robot);
            System.out.println(robot);
        }
        for(int i = 0; i <  Math.abs(diffX); i++) {
            robot.stepForward();
            System.out.println(robot);
        }
    }

    @Override
    public String toString() {
        return "Robot{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }
}
