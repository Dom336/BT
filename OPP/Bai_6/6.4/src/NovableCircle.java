public class NovableCircle implements Novable {
    private int radius;
    private NovablePoint center;

    public NovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        this.center = new NovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    @Override
    public void moveUp() {
        center.moveUp();
    }

    @Override
    public void moveDown() {
        center.moveDown();
    }

    @Override
    public void moveLeft() {
        center.moveLeft();
    }

    @Override
    public void moveRight() {
        center.moveRight();
    }

    @Override
    public String toString() {
        return center.toString() + ",radius=" + radius;
    }
}