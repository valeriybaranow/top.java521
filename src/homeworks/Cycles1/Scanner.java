package homeworks.Cycles1;

public class Scanner {
    public void wrapper() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String result = "y";
        do {



            scanner.nextLine();
            do {
                System.out.print("�� ������ ���������� y/n: ");
                result = scanner.nextLine();
            } while (!(result.equals("y") || result.equals("n")));
        }
        while (!result.equals("n"));
        System.out.println("����� �� ���������");
        scanner.close();
    }
}
