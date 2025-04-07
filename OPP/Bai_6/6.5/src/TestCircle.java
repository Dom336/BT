public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        System.out.println(circle);
        System.out.println("Perimeter: " + circle.getPerimeter());
        System.out.println("Area: " + circle.getArea());
        
        // Test polymorphism through interface
        GeometricObject geoObj = new Circle(3.0);
        System.out.println("\nGeometricObject: " + geoObj);
        System.out.println("Perimeter: " + geoObj.getPerimeter());
        System.out.println("Area: " + geoObj.getArea());
    }
}