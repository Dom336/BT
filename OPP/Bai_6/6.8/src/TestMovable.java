public class TestMovable {
    public static void main(String[] args) {
        // Test MovablePoint
        Movable m1 = new MovablePoint(5, 6, 10, 15);
        System.out.println(m1);
        m1.moveLeft();
        System.out.println(m1);

        // Test MovableCircle
        Movable m2 = new MovableCircle(1, 2, 3, 4, 20);
        System.out.println(m2);
        m2.moveRight();
        System.out.println(m2);

        // Test MovableRectangle
        Movable m3 = new MovableRectangle(0, 0, 10, 5, 2, 2);
        System.out.println("\n" + m3);
        m3.moveUp();
        System.out.println("After moving up: " + m3);
        m3.moveRight();
        System.out.println("After moving right: " + m3);
    }
}