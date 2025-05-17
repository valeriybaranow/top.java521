package lessons.Exeption;

public class MyException extends Exception {
    public MyException() {
        super("Moe исключение");
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}
