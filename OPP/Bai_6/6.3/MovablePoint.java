public class MovablePoint implements Movable {
    int x;
    int y;
    int xSpeed;
    int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() {
        y -= ySpeed;  // y decreases when moving up
    }

    @Override
    public void moveDown() {
        y += ySpeed;  // y increases when moving down
    }

    @Override
    public void moveLeft() {
        x -= xSpeed;  // x decreases when moving left
    }

    @Override
    public void moveRight() {
        x += xSpeed;  // x increases when moving right
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ") speed=(" + xSpeed + ", " + ySpeed + ")";
    }
}