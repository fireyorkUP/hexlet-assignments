package exercise;

// BEGIN
public class Segment {
    private Point BeginPoint;
    private Point EndPoint;

    public Segment(Point beginPoint, Point endPoint) {
        this.BeginPoint = beginPoint;
        this.EndPoint = endPoint;
    }

    public Point getBeginPoint() {
        return BeginPoint;
    }

    public Point getEndPoint() {
        return EndPoint;
    }

    public Point getMidPoint() {
        int midX = (BeginPoint.getX() + EndPoint.getX()) / 2;
        int midY = (BeginPoint.getY() + EndPoint.getY()) / 2;
        return new Point(midX, midY);
    }
}
// END
