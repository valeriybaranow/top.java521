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
        TurnOptions turnOptions = getTurnOptions(direction, robot);
        System.out.println(turnOptions);
        while (robot.direction != direction) {
            if (turnOptions == TurnOptions.RIGHT) {
                robot.turnRight();
            }
            if (turnOptions == TurnOptions.LEFT) {
                robot.turnLeft();
            }
            robot.showLocation();
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

        robot.showLocation();
        if(diffX < 0) {
            turn(Direction.LEFT, robot);
        } else if(diffX > 0) {
            turn(Direction.RIGHT, robot);
        }
        for(int i = 0; i < Math.abs(diffX); i++) {
            robot.stepForward();
            robot.showLocation();
        }
        if(diffY < 0) {
            turn(Direction.DOWN, robot);
        } else if(diffY > 0) {
            turn(Direction.UP, robot);
        }
        for(int i = 0; i <  Math.abs(diffY); i++) {
            robot.stepForward();
            robot.showLocation();
        }
    }

    private char getIcon() {
        return switch (direction) {
            case UP -> '⇈';
            case RIGHT -> '⇉';
            case DOWN -> '⇊';
            case LEFT -> '⇇';
        };
    }

    public void showLocation() {
        try {
            Thread.sleep( 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        System.out.println(this);
        for(int i = 9; i >= -2; i--) {
            for(int j = -1; j < 10; j++) {
                if(i == -2) {
                    if (j == -1) {
                        System.out.print("    ");
                    } else {
                        System.out.print(j + " ");
                    }
                } else if (i == -1) {
                    if (j == -1) {
                        System.out.print("    ");
                    } else {
                        System.out.print("--");
                    }
                }
                else {
                    if (j == -1) {
                        System.out.print(i + " | ");
                    } else {
                        if (x == j && y == i) {
                            char icon = getIcon();
                            System.out.print(icon + " ");
                        } else {
                            System.out.print("  ");
                        }
                    }
                }
                if (j == 9) {
                    System.out.println();
                }
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
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
