package lessons.Generics;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){
        Box<String> box = new Box<>();
        box.setContent("Andrey");
        System.out.println(box.getContent());

        Box<Integer> boxNumber = new Box<>();

        Pair<String, Integer> person = new Pair<>("Elena", 20);
        System.out.println(person);

    }
    public static <T> void reverseArray(T[] array){
        for (int i = 0, j = array.length - 1;  i < array.length/2; i++, j--){
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static <T> T concat(T[] array){
        if (array.length == 0) return null;
        if (array instanceof Number[]){
           double sum = 0;
           for (T num : array) {
               sum += ((Number) num).doubleValue();
           }
           return (T) Double.valueOf(sum);
        }
        StringBuilder sb = new StringBuilder();
        for (T element : array){
            sb.append(element + "\n");
        }
        return (T) sb.toString();
    }
}