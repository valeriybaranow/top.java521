package homeworks.Recursive;


import java.util.Arrays;

// TODO: Разобраться, что такое Ханойская башня, написать метод решения и смочь объяснить. Число колец – 5, число столбиков – посмотрите сами по найденному вами решению. И понять, как они стеком перекладывают и конечно продебажить. Дебаг показывать в скринах не нужно.
/**
 Input : 3
 Output :
 Move disk 1 from rod A to rod B
 Move disk 2 from rod A to rod C
 Move disk 3 from rod A to rod D
 Move disk 2 from rod C to rod D
 Move disk 1 from rod B to rod D
 */
public class Task02 {

    // стержни для хранения дисков
    static int[][] columns = new int[3][];
    // массив с дисками, значения это расмер диска
    static int[] rings = {3,2,1};


    public static void main(String[] args) {

        // стрержни пронумерованы 0, 1, 2
        // количество дисков
        int count = 3;
        // индекс стрерженя с которого перемещаем
        int from = 0;
        // индекс стрерженя не который перемещаем
        int to = 1;
        // индекс стрерженя который используется как буфер
        int buf = 2;
        // нанизываем диски на стержень с которого будем перемещать
        columns[from] = rings;
        // смотрим
        System.out.println(Arrays.deepToString(columns));
        // запускаем алгоритм
        towerOfHanoi(5,0,1,2);
    }

    public static void towerOfHanoi(int count, int from, int to, int buf)
    {
        if (count == 0) {
            return;
        }
        count--;
        // Перекладывание стека из n-1 дисков на независимую ось
        towerOfHanoi(count, from, buf, to);
        // Перекладывание самого большого диска на нужную нам ось
        movement(from, to);
//        // Перекладывание стека из n-1 дисков на нужнную ось
//        towerOfHanoi(count, from, to, buf);
    }

    public static void movement(int from, int to) {

        if (columns[to] == null) {
            int[] ringTo = {columns[from][columns[from].length-1]};
            columns[to] =  ringTo;
        } else {
            int length = columns[to].length;
            int[] ringTo = new int[length];

            ringTo = Arrays.copyOf(columns[to], length-1);
            ringTo[length-1] = columns[from][columns[from].length-1];
            columns[to] = ringTo;
        }
        columns[from] = Arrays.copyOf(columns[from], columns[from].length-1);

        System.out.println(Arrays.deepToString(columns));
    }
}
