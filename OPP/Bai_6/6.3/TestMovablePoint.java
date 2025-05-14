public class TestMovablePoint {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(0, 0, 1, 1);
        
        System.out.println("Initial position: " + point);
        
        point.moveUp();
        System.out.println("After moving up: " + point);
        
        point.moveRight();
        System.out.println("After moving right: " + point);
        
        point.moveDown();
        System.out.println("After moving down: " + point);
        
        point.moveLeft();
        System.out.println("After moving left: " + point);
        
        // Testing through interface reference
        Movable movable = new MovablePoint(5, 5, 2, 2);
        System.out.println("\nMovable object initial position: " + movable);
        movable.moveDown();
        movable.moveRight();
        System.out.println("After moving down and right: " + movable);
    }
}