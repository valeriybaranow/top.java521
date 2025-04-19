package lessons.ArrayList.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Ограниченный стек");
        StackFixed sf = new StackFixed();
        sf.printItems();
        sf.push(1);
        sf.printItems();
        sf.push(2);
        sf.printItems();
        sf.push(3);
        sf.printItems();
        System.out.println(sf.pop()); // 3
        sf.printItems();
        System.out.println(sf.seek()); // 2
        sf.printItems();
        System.out.println(sf.empty()); // false
        System.out.println(sf.full()); // true
        sf.clear();
        sf.printItems();
        System.out.println(sf.empty()); // true
        sf.push(1);
        System.out.println(sf.pop()); // 1
        sf.printItems();

        System.out.println();
        System.out.println("Обычный стек");
        StackSimple s = new StackSimple();
        s.printItems();
        s.push(1);
        s.printItems();
        s.push(2);
        s.printItems();
        s.push(3);
        s.printItems();
        System.out.println(s.pop()); // 3
        s.printItems();
        System.out.println(s.seek()); // 2
        s.printItems();
        System.out.println(s.empty()); // false
        System.out.println(s.full()); // true
        s.clear();
        s.printItems();
        System.out.println(s.empty()); // true
        s.push(1);
        s.printItems();
        System.out.println(s.pop()); // 1
        s.printItems();

        System.out.println();
        System.out.println("Параметризованный стек числа");
        StackWithParameters<Integer> swp = new StackWithParameters<>();
        swp.printItems();
        swp.push(1);
        swp.printItems();
        swp.push(2);
        swp.printItems();
        swp.push(3);
        swp.printItems();
        System.out.println(swp.pop()); // 3
        swp.printItems();
        System.out.println(swp.seek()); // 2
        swp.printItems();
        System.out.println(swp.empty()); // false
        System.out.println(swp.full()); // true
        swp.clear();
        swp.printItems();
        System.out.println(swp.empty()); // true
        swp.printItems();
        swp.push(1);
        swp.printItems();
        System.out.println(swp.pop()); // 1
        swp.printItems(); // []

        System.out.println();
        System.out.println("Параметризованный стек строки");
        StackWithParameters<String> swp1 = new StackWithParameters<>();
        swp1.printItems();
        swp1.push("one");
        swp1.printItems();
        swp1.push("two");
        swp1.printItems();
        swp1.push("three");
        swp1.printItems();
        System.out.println(swp1.pop()); // tree
        swp1.printItems();
        System.out.println(swp1.seek()); // two
        swp1.printItems();
        System.out.println(swp1.empty()); // false
        System.out.println(swp1.full()); // true
        swp1.clear();
        swp1.printItems();
        System.out.println(swp1.empty()); // true
        swp1.push("one");
        swp1.printItems();
        System.out.println(swp1.pop()); // 1
        swp1.printItems(); // []

    }
}
