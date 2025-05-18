package lessons.Enum.deliveryOrder;

public class Main {
    public static void main(String[] args) {
        DeliveryOrder deliveryOrder = new DeliveryOrder(DeliveryType.PEDESTRIAN, Fragile.YES, Cold.NO);
        DeliveryType typeOne = DeliveryType.AUTO;
        DeliveryType typeTwo = DeliveryType.AUTO;
        if (typeTwo == typeTwo) {
            System.out.println("typeTwo == typeTwo)");
        }
        if (typeOne.equals(typeTwo)) {
            System.out.println("typeTwo == typeTwo)");
        }
    }
}
