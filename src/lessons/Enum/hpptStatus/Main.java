package lessons.Enum.hpptStatus;

public class Main {
    public static void main(String[] args) {
        int code = HttpStatus.OK.getCode();
        System.out.println(code);

        String desc = HttpStatus.OK.getDescription();
        System.out.println(desc);
    }
}
