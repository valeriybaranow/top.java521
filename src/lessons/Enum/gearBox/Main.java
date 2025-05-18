package lessons.Enum.gearBox;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GearBox gearBox1 = new GearBox(GearBoxType.ROBOT);
        GearBox gearBox = new GearBox(GearBoxType.valueOf("ROBOT"));

        // ENUM - enumitarion - перечисление
        System.out.println(gearBox.getType());
        // получить массив всех констант этого enum
        System.out.println(Arrays.toString(GearBoxType.values()));

        // перевести название константы в String
        System.out.println(GearBoxType.MANUAL.name());

        // узнать порядковый номер конкретной константы
        System.out.println(GearBoxType.MANUAL.ordinal());
    }
}
