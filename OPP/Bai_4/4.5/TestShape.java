public class TestShape {
    public static void main(String[] args) {
        // Test Shape
        Shape shape = new Shape("blue", false);
        System.out.println(shape);
        shape.setColor("green");
        System.out.println("Color changed to: " + shape.getColor());

        // Test Circle
        Circle circle = new Circle(2.5, "yellow", true);
        System.out.println(circle);
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimeter: " + circle.getPerimeter());

        // Test Rectangle
        Rectangle rectangle = new Rectangle(3.0, 4.0, "purple", false);
        System.out.println(rectangle);
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter());

        // Test Square
        Square square = new Square(5.0, "orange", true);
        System.out.println(square);
        square.setSide(6.0);
        System.out.println("After setSide: " + square);
        square.setWidth(7.0);
        System.out.println("After setWidth: " + square);
        System.out.println("Area: " + square.getArea());
        System.out.println("Perimeter: " + square.getPerimeter());
    }
}