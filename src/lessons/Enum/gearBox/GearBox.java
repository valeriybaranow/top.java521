package lessons.Enum.gearBox;

public class GearBox {

    public static final int MIN_GEAR = 1;
    public static final int MAX_GEAR = 5;
    private final GearBoxType type;
    private int gear = 0;

    public GearBox(GearBoxType type) {
        this.type = type;
    }

    public void shiftUp() {
        gear = gear < MAX_GEAR ? gear + 1 : gear;
    }

    public void shiftDown() {
        gear = gear > MIN_GEAR ? gear - 1 : gear;
    }

    public void switchRear() {
        gear = gear > 1 ? gear : -1;
    }

    public void switchNeutral() {
        gear = 0;
    }

    public int getCurrentGear() {
        return gear;
    }

    public GearBoxType getType() {
        return type;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }
}
