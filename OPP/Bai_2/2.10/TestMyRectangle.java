class MyRectangle {
    private MyPoint topLeft;
    private MyPoint bottomRight;
    
    public MyRectangle(int x1, int y1, int x2, int y2) {
        this.topLeft = new MyPoint(x1, y1);
        this.bottomRight = new MyPoint(x2, y2);
    }
    
    public MyRectangle(MyPoint topLeft, MyPoint bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }
    
    public MyPoint getTopLeft() {
        return topLeft;
    }
    
    public MyPoint getBottomRight() {
        return bottomRight;
    }
    
    public void setTopLeft(MyPoint topLeft) {
        this.topLeft = topLeft;
    }
    
    public void setBottomRight(MyPoint bottomRight) {
        this.bottomRight = bottomRight;
    }
    
    @Override
    public String toString() {
        return "MyRectangle[topLeft=" + topLeft + ",bottomRight=" + bottomRight + "]";
    }
    
    public int getWidth() {
        return bottomRight.getX() - topLeft.getX();
    }
    
    public int getHeight() {
        return topLeft.getY() - bottomRight.getY();
    }
    
    public double getArea() {
        return Math.abs(getWidth() * getHeight());
    }
    
    public double getPerimeter() {
        return 2 * (Math.abs(getWidth()) + Math.abs(getHeight()));
    }
}

public class TestMyRectangle {
    public static void main(String[] args) {
        MyRectangle r1 = new MyRectangle(0, 5, 5, 0);
        System.out.println("Rectangle r1: " + r1);
        System.out.println("Width: " + r1.getWidth());
        System.out.println("Height: " + r1.getHeight());
        System.out.println("Area: " + r1.getArea());
        System.out.println("Perimeter: " + r1.getPerimeter());
        
        MyPoint p1 = new MyPoint(2, 8);
        MyPoint p2 = new MyPoint(10, 2);
        MyRectangle r2 = new MyRectangle(p1, p2);
        System.out.println("\nRectangle r2: " + r2);
        System.out.println("Top-left corner: " + r2.getTopLeft());
        System.out.println("Bottom-right corner: " + r2.getBottomRight());
        System.out.println("Area: " + r2.getArea());
        System.out.println("Perimeter: " + r2.getPerimeter());
        
        r2.setTopLeft(new MyPoint(1, 9));
        r2.setBottomRight(new MyPoint(11, 1));
        System.out.println("\nModified r2: " + r2);
        System.out.println("New area: " + r2.getArea());
        System.out.println("New perimeter: " + r2.getPerimeter());
        
        MyRectangle r3 = new MyRectangle(-3, 4, 2, -1);
        System.out.println("\nRectangle r3 with negative coordinates: " + r3);
        System.out.println("Width: " + r3.getWidth());
        System.out.println("Height: " + r3.getHeight());
        System.out.println("Area: " + r3.getArea());
        System.out.println("Perimeter: " + r3.getPerimeter());
    }
}