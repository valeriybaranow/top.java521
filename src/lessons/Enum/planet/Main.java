package lessons.Enum.planet;

public class Main {
    public static void main(String[] args) {
        // S = 4πR², площадь сферы
        double square = 4 * Math.PI * Math.pow(Planet.EARTH.getRadius(), 2);
        System.out.println(square);
    }
}
