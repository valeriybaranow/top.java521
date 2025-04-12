package homeworks.TernarOperator;

import java.util.Scanner;

public class Task02 {

    // TODO: �������� ���������, ������� ���������� ��� ��������� ����� � ������� ���������� �� ��� � �������������� ���������� ���������.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer number1;
        Integer number2;
        String manager = "y";
        do {
            System.out.print("������� ������ �����: ");
            if (scanner.hasNextInt()) {
                number1 = scanner.nextInt();
                scanner.nextLine(); // ������ �����
            } else {
                System.out.println("������! �� ����� ������������ ������.");
                scanner.nextLine(); // ������ �����
                continue;
            }

            System.out.print("������� ������ �����: ");
            if (scanner.hasNextInt()) {
                number2 = scanner.nextInt();
                scanner.nextLine(); // ������ �����
            } else {
                System.out.println("������! �� ����� ������������ ������.");
                scanner.nextLine(); // ������ �����
                continue;
            }

            System.out.print("���������� ����� ");
            System.out.print(number1 > number2 ? number1 : number2);
            System.out.println(".");

            System.out.print("�� ������ ���������� y\\n: ");
            manager = scanner.nextLine();
            while (!(manager.equals("y") || manager.equals("n"))) {
                System.out.print("����� ������� ������ �������� y\\n. ");
                System.out.print("�� ������ ���������� y\\n: ");
                manager = scanner.nextLine();
            }
        }
        while (manager.equals("y"));
        System.out.println("����� �� ���������");
        scanner.close();
    }
}
