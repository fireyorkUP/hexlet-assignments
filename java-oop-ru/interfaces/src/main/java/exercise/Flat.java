package exercise;

// BEGIN
public class Flat implements Home{

    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return area + balconyArea;
    }

    @Override
    public int compareTo(Home another) {
        double anotherArea = another.getArea();
        if (this.getArea() > anotherArea) {
            return 1;
        } else if (this.getArea() < anotherArea) {
            return -1;
        } else {
            return 0;
        }
    }


    public double getBalconyArea() {
        return balconyArea;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public String toString() {
        return "Квартира площадью " + getArea() + " метров на " + getFloor() + " этаже";
    }

}
// END
