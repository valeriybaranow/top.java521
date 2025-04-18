package homeworks.Generics2.task2;

import java.nio.CharBuffer;
import java.util.Random;

public class RandomWords implements Readable {
    private static Random rand = new Random(47);
    private static final char[] capitals =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] lowers =
            "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] vowels =
            "aeiou".toCharArray();
    private int count;
    public RandomWords(int count) { this.count = count; }
    public int read(CharBuffer cb) {
        if(count-- == 0)
            return -1;
        cb.append(capitals[rand.nextInt(capitals.length)]);
        for(int i = 0; i<4; i++) {
            cb.append(capitals[rand.nextInt(vowels.length)]);
            cb.append(capitals[rand.nextInt(lowers.length)]);
        }
        cb.append(" ");
        return 10;
    }
}
