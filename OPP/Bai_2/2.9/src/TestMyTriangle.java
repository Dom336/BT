class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;
    
    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        v1 = new MyPoint(x1, y1);
        v2 = new MyPoint(x2, y2);
        v3 = new MyPoint(x3, y3);
    }
    
    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }
    
    public String toString() {
        return "MyTriangle[v1=(" + v1.getX() + "," + v1.getY() + 
               "),v2=(" + v2.getX() + "," + v2.getY() + 
               "),v3=(" + v3.getX() + "," + v3.getY() + ")]";
    }
    
    public double getPerimeter() {
        double side1 = v1.distance(v2);
        double side2 = v2.distance(v3);
        double side3 = v3.distance(v1);
        
        return side1 + side2 + side3;
    }
    
    public String getType() {
        double side1 = v1.distance(v2);
        double side2 = v2.distance(v3);
        double side3 = v3.distance(v1);
        
        if (side1 == side2 && side2 == side3) {
            return "equilateral";
        } else if (side1 == side2 || side2 == side3 || side1 == side3) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
}

public class TestMyTriangle {
    public static void main(String[] args) {
        MyTriangle t1 = new MyTriangle(0, 0, 3, 0, 0, 4);
        System.out.println("Triangle t1: " + t1);
        System.out.println("Perimeter of t1: " + t1.getPerimeter());
        System.out.println("Type of t1: " + t1.getType());
        
        MyPoint p1 = new MyPoint(1, 1);
        MyPoint p2 = new MyPoint(1, 4);
        MyPoint p3 = new MyPoint(5, 1);
        MyTriangle t2 = new MyTriangle(p1, p2, p3);
        System.out.println("\nTriangle t2: " + t2);
        System.out.println("Perimeter of t2: " + t2.getPerimeter());
        System.out.println("Type of t2: " + t2.getType());
        
        // Fixed: using integer value instead of double for y3
        MyTriangle t3 = new MyTriangle(0, 0, 10, 0, 5, 9);
        System.out.println("\nTriangle t3: " + t3);
        System.out.println("Perimeter of t3: " + t3.getPerimeter());
        System.out.println("Type of t3: " + t3.getType());
        
        // Create an equilateral triangle with integer coordinates
        MyTriangle t4 = new MyTriangle(0, 0, 10, 0, 5, 8);
        System.out.println("\nTriangle t4: " + t4);
        System.out.println("Perimeter of t4: " + t4.getPerimeter());
        System.out.println("Type of t4: " + t4.getType());
        
        // Create an isosceles triangle
        MyTriangle t5 = new MyTriangle(0, 0, 8, 0, 4, 4);
        System.out.println("\nTriangle t5: " + t5);
        System.out.println("Perimeter of t5: " + t5.getPerimeter());
        System.out.println("Type of t5: " + t5.getType());
    }
}