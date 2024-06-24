package exercise;

// BEGIN
public class Circle {
    public Point center ;
    public int radius;

    public Circle(Point center , int radius) {
        this.center  = center ;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        double square = Math.PI * Math.pow(this.radius, 2);
        if (radius < 0) {
            throw new NegativeRadiusException();
        }
        return square;
    }
}
// END
