public class TestResizableCircle {
    public static void main(String[] args) {
        ResizableCircle resCircle = new ResizableCircle(10.0);
        System.out.println("Original: " + resCircle);
        System.out.println("Area: " + resCircle.getArea());
        
        resCircle.resize(50); // Reduce to 50% of original size
        System.out.println("\nAfter 50% resize: " + resCircle);
        System.out.println("New area: " + resCircle.getArea());
        
        resCircle.resize(200); // Increase to 200% of current size
        System.out.println("\nAfter 200% resize: " + resCircle);
        System.out.println("New area: " + resCircle.getArea());
        
        // Test multiple interfaces
        GeometricObject geoObj = resCircle;
        Resizable resizeObj = resCircle;
        
        System.out.println("\nAs GeometricObject: " + geoObj.getArea());
        resizeObj.resize(50);
        System.out.println("After resize through interface: " + geoObj.getArea());
    }
}