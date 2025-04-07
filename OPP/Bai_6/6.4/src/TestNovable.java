public class TestNovable {
    public static void main(String[] args) {
        NovablePoint point = new NovablePoint(0, 0, 1, 1);
        System.out.println("Point: " + point);
        point.moveUp();
        point.moveRight();
        System.out.println("After moving up and right: " + point);

        NovableCircle circle = new NovableCircle(5, 5, 2, 2, 3);
        System.out.println("\nCircle: " + circle);
        circle.moveDown();
        circle.moveLeft();
        System.out.println("After moving down and left: " + circle);

        Novable[] movables = {point, circle};
        System.out.println("\nMoving all objects:");
        for (Novable movable : movables) {
            movable.moveRight();
            movable.moveUp();
            System.out.println(movable);
        }
    }
}