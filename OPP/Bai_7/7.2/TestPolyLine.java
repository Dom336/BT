import java.util.ArrayList;
import java.util.List;

public class TestPolyLine {
    public static void main(String[] args) {
        // Test default constructor and toString()
        PolyLine l1 = new PolyLine();
        System.out.println(l1);  // {}
        System.out.println("Length: " + l1.getLength());  // 0.0

        // Test appendPoint()
        l1.appendPoint(new Point(1, 2));
        l1.appendPoint(3, 4);
        l1.appendPoint(5, 6);
        System.out.println(l1);  // {(1,2)(3,4)(5,6)}
        System.out.println("Length: " + l1.getLength());  // ~5.656

        // Test constructor with List
        List<Point> points = new ArrayList<Point>();
        points.add(new Point(11, 12));
        points.add(new Point(13, 14));
        PolyLine l2 = new PolyLine(points);
        System.out.println(l2);  // {(11,12)(13,14)}
        System.out.println("Length: " + l2.getLength());  // ~2.828

        // Test longer polyline
        PolyLine l3 = new PolyLine();
        l3.appendPoint(0, 0);
        l3.appendPoint(3, 0);
        l3.appendPoint(3, 4);
        System.out.println(l3);  // {(0,0)(3,0)(3,4)}
        System.out.println("Length: " + l3.getLength());  // 7.0 (3 + 4)

        // Test single point
        PolyLine l4 = new PolyLine();
        l4.appendPoint(5, 5);
        System.out.println(l4);  // {(5,5)}
        System.out.println("Length: " + l4.getLength());  // 0.0
    }
}