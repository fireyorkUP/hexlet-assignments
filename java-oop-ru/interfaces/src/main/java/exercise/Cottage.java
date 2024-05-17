package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
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

    public int getFloorCount() {
        return floorCount;
    }

    @Override
    public String toString() {
        return getFloorCount() + " этажный коттедж площадью " + getArea() + " метров";
    }

}
// END
