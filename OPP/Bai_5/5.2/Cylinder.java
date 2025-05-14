public class Cylinder {
    private Circle base;
    private double height;

    public Cylinder() {
        this.base = new Circle();
        this.height = 1.0;
    }

    public Cylinder(double height) {
        this.base = new Circle();
        this.height = height;
    }

    public Cylinder(double radius, double height) {
        this.base = new Circle(radius);
        this.height = height;
    }

    public Cylinder(double radius, double height, String color) {
        this.base = new Circle(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Circle getBase() {
        return base;
    }

    public void setBase(Circle base) {
        this.base = base;
    }

    public double getVolume() {
        return base.getArea() * height;
    }

    public double getBaseArea() {
        return base.getArea();
    }

    @Override
    public String toString() {
        return "Cylinder[base=" + base + ",height=" + height + "]";
    }
}