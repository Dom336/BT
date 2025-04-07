import java.util.List;
import java.util.ArrayList;

public class PolyLine {
    private List<Point> points;

    public PolyLine() {
        points = new ArrayList<Point>();
    }

    public PolyLine(List<Point> points) {
        this.points = points;
    }

    public void appendPoint(int x, int y) {
        points.add(new Point(x, y));
    }

    public void appendPoint(Point point) {
        points.add(point);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Point point : points) {
            sb.append(point.toString());
        }
        sb.append("}");
        return sb.toString();
    }

    public double getLength() {
        double length = 0.0;
        if (points.size() <= 1) {
            return length;
        }
        
        Point prev = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            Point current = points.get(i);
            length += prev.distance(current);
            prev = current;
        }
        return length;
    }
}