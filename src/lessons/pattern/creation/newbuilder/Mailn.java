package lessons.pattern.creation.newbuilder;

class House {
    private int windows;
    private int doors;
    private int rooms;

    private boolean hasGarage;
    private boolean hasStatues;
    private boolean hasSwimPool;


    public House() {
    }

    public int getWindows() {
        return windows;
    }

    public House setWindows(int windows) {
        this.windows = windows;
        return this;
    }

    public int getDoors() {
        return doors;
    }

    public House setDoors(int doors) {
        this.doors = doors;
        return this;
    }

    public int getRooms() {
        return rooms;
    }

    public House setRooms(int rooms) {
        this.rooms = rooms;
        return this;
    }

    public boolean isHasGarage() {
        return hasGarage;
    }

    public House setHasGarage(boolean hasGarage) {
        this.hasGarage = hasGarage;
        return this;
    }

    @Override
    public String toString() {
        return "House{" +
                "windows=" + windows +
                ", doors=" + doors +
                ", rooms=" + rooms +
                ", hasGarage=" + hasGarage +
                ", hasStatues=" + hasStatues +
                ", hasSwimPool=" + hasSwimPool +
                '}';
    }
}

public class Mailn {
    public static void main(String[] args) {
        House house = new House();
        house.setDoors(2).setRooms(4);
        System.out.println(house);
    }
}
