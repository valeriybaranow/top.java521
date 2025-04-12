package homeworks.Incaptulation;

public class Country {
    private String name;
    private int populationSize;
    private double square;
    private String capital;
    private boolean isAccessToSea;

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public boolean isAccessToSea() {
        return isAccessToSea;
    }

    public void setAccessToSea(boolean accessToSea) {
        isAccessToSea = accessToSea;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", populationSize=" + populationSize +
                ", square=" + square +
                ", capital='" + capital + '\'' +
                ", isAccessToSea=" + isAccessToSea +
                '}';
    }
}
