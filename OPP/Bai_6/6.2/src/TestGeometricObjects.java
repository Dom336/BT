public class TestGeometricObjects {
    public static void main(String[] args) {
        GeometricObject circle = new Circle(5.0);
        System.out.println(circle);
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimeter: " + circle.getPerimeter());

        GeometricObject rectangle = new Rectangle(4.0, 6.0);
        System.out.println("\n" + rectangle);
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter());

        // Polymorphic behavior demonstration
        GeometricObject[] shapes = {
            new Circle(3.0),
            new Rectangle(2.0, 5.0)
        };

        System.out.println("\nProcessing shapes polymorphically:");
        for (GeometricObject shape : shapes) {
            System.out.println(shape);
            System.out.println("Area: " + shape.getArea());
            System.out.println("Perimeter: " + shape.getPerimeter() + "\n");
        }
    }
}